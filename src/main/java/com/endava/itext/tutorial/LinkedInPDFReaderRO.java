package com.endava.itext.tutorial;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.IOException;

public class LinkedInPDFReaderRO extends LinkedInPDFReader {
    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";
    private static String pdfAuthor;
    private static PdfDocument pdfDocument;


    public LinkedInPDFReaderRO(String filePath) throws IOException {
        super(filePath);
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
        this.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();
    }

    public static Set<String> getEducation() {

        if (isLinkedInPdf()) {
            return getLinkedInEducation();
        }
        return null;
    }

    public static Set <String> getTopSkills() {

        if (isLinkedInPdf()) {
            return getLinkedInTopSkills();
        }
        return null;
    }

    private static Set<String> extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");


        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Aptitudini principale")) {
                Set<String> topSkills = new HashSet<String>();
                for (int j = i + 1; j < i + 4; j++) {
                 //   topSkills += " " + textLines[j] + "\n";
                 topSkills.add(textLines[j]);
                }

                return topSkills;
            }
        }
        return null;
    }
    public static String getCandidate() {

        if (isLinkedInPdf()) {
            return getLinkedInCandidate();
        }
        return null;
    }
    private static String getLinkedInCandidate()  {
        String actualText = getActualText(1, true);
        return extractCandidate(actualText);

    }
    private static String extractCandidate(String actualText) {
        String name = "";
        Set<String> educationSet = new HashSet<String>();
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");
            for (int i = 0; i< textLines.length; i++){
                String line = textLines[i];
                if (line.contains("Rezumat")){
                    name=textLines[i-2];
                    return name;
                }
else
                {
                    return "N/A";
                }
            }
        }


        return null;
    }

    public static double getTotalYearsOfExperience() {

        double years = 0;
        double months = 0;
        for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {
            final String textOnPage = getActualText(page, false);
            String[] linesOnPage = textOnPage.split("\n");
            for (String line : linesOnPage) {
                years += getYearsForLine(line);
                months += getMonthsForLine(line);
            }
        }

        years += months / 12;

        return Math.round(years);


    }

    private static double getMonthsForLine(String line) {
        double months = 0;
        String regex = "\\d+ lun.\\)";

        Pattern monthPattern = Pattern.compile(regex);   // the pattern to search for
        Matcher monthMatcher = monthPattern.matcher(line);

        // now try to find at least one match
        if (monthMatcher.find()) {
            int startIndex = monthMatcher.start();
            int endIndex = monthMatcher.end();
            months = Integer.valueOf(line.substring(startIndex, endIndex - 6));

        }
        return months;
    }

    private static double getYearsForLine(String line) {
        int years = 0;
        String regex = "\\(\\d+ an";

        Pattern yearPattern = Pattern.compile(regex);   // the pattern to search for
        Matcher yearMatcher = yearPattern.matcher(line);

        // now try to find at least one match
        if (yearMatcher.find()) {
            int startIndex = yearMatcher.start();
            int endIndex = yearMatcher.end();
            years = Integer.valueOf(line.substring(startIndex + 1, endIndex - 3));
        }
        return years;
    }

    private static Set<String> extractEducation() {
        Set<String> educationSet = new HashSet<String>();
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");

            for (int i = 0; i < textLines.length; i++) {
                String line = textLines[i];

                    for (int j = i+1; j < textLines.length; j++){
                        if(textLines[j].contains("Universit")) {

                            educationSet.add(textLines[j]);
                        }

                    }
                    // education = education.substring(0, education.lastIndexOf("Page"));
            }
            return educationSet;
        }
        return null;
    }

    private static Set<String> getLinkedInEducation() {
        // Get the resultant text after applying the custom filter
        return extractEducation();

    }

    private static Set <String> getLinkedInTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractTopSkills(actualText);

    }


    private static boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }
}
