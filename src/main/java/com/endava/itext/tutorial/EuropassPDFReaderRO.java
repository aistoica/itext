package com.endava.itext.tutorial;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EuropassPDFReaderRO extends EuropassPDFReader {
    private static String Europass_AUTHOR_NAME = "Europass";
    private static String pdfAuthor;
    private static PdfDocument pdfDocument;


    public EuropassPDFReaderRO(String filePath) throws IOException {
        super(filePath);
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
        this.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();
    }

    public static String getCurrentEmployer() {

        if (isEuropassPdf()) {
            return getEuropassCurrentEmployer();
        }
        return null;
    }



    public static String getCurrentJobTitle() {

        if (isEuropassPdf()) {
            return getEuropassCurrentJobTitle();
        }
        return null;
    }


    public static Set<String> getLanguages() {

        if (isEuropassPdf()) {
            return getEuropassLanguages();
        }
        return null;
    }

    public static Set<String> getCertifications() {

        if (isEuropassPdf()) {
            return getEuropassCertifications();
        }
        return null;
    }


    private static Set<String> getEuropassLanguages() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1);
        return extractLanguages(actualText);

    }


    private static Set<String> getEuropassCertifications() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1);
        return extractCertifications(actualText);

    }


    private static Set<String> extractLanguages(String actualText) {
        String[] textLines = actualText.split("\n");
        String stringsToRemove = "Certifications";

        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Languages"))  {
                String languages = "";
                Set<String> languagesSet = new HashSet<String>();
                for (int j = i+1; j < i+6; j++)
                {
                    languagesSet.add(textLines[j]);
                    if(textLines[j].equals("Certifications"))
                    {

                        languagesSet.removeAll(Collections.singleton(stringsToRemove));
                        break;
                    }

                }

                return languagesSet ;
            }
        }
        return null;
    }

    private static Set<String> extractCertifications(String actualText) {
        String[] textLines = actualText.split("\n");
        String certifs = "";
        Set<String> certifsSet = new HashSet<String>();
        for (int i = 0; i < textLines.length; i++) {
            System.out.println(textLines[i]);
            if (textLines[i].contains("Certifications") ) {
                i++;
//                    certifs += " " + textLines[i]+textLines[i+1] +"\n";
                certifsSet.add(textLines[i]+textLines[i+1]);

                return certifsSet ;
            }

        }
        return null;
    }

    private static String extractCurrentJobTitle(String actualText) {
        String[] textLines = actualText.split("\n");
        String currentJobTitle = "";
        currentJobTitle += " " + textLines[2];
        currentJobTitle= currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));
        return currentJobTitle.substring(0, currentJobTitle.lastIndexOf(" "));

    }


    private static String getEuropassCurrentJobTitle() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1);
        return extractCurrentJobTitle(actualText);

    }



    private static String extractCurrentEmployer(String actualText) {
        String[] textLines = actualText.split("\n");

        if (textLines[2].contains("la") || textLines[2].contains("at")) {
            String currentEmployer = "";


            currentEmployer += " " + textLines[2];

            return   currentEmployer.substring(currentEmployer.lastIndexOf(" ")+1);
        }

        return null;
    }
    private static String getEuropassCurrentEmployer() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1);
        return extractCurrentEmployer(actualText);

    }

    public static Set<String> getEducation() {

        if (isEuropassPdf()) {
            return getEuropassEducation();
        }
        return null;
    }

    public static Set <String> getTopSkills() {

        if (isEuropassPdf()) {
            return getEuropassTopSkills();
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


    public static double getTotalYearsOfExperience() {

        double years = 0;
        double months = 0;
        for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {
            final String textOnPage = getActualText(page);
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
            System.out.println("line = " + line);
            System.out.println("months = " + months);
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
            System.out.println("line = " + line);
            System.out.println("years = " + years);
        }
        return years;
    }

    private static Set<String> extractEducation() {
        Set<String> educationSet = new HashSet<String>();
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page);
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

    private static Set<String> getEuropassEducation() {
        // Get the resultant text after applying the custom filter
        return extractEducation();

    }

    private static Set <String> getEuropassTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1);
        return extractTopSkills(actualText);

    }


    private static boolean isEuropassPdf() {
        //TODO: implement this
        return pdfAuthor.equals(Europass_AUTHOR_NAME);
    }
}
