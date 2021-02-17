package com.endava.itext.tutorial;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.IOException;

public class LinkedInPDFReaderRO extends LinkedInPDFReaderENG {
    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";

    public LinkedInPDFReaderRO(String filePath) throws IOException {
        super(filePath);
        super.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();
    }

    public String getEducation() {

        if (isLinkedInPdf()) {
            return getLinkedInEducation();
        }
        return null;
    }

    public String getTopSkills() {

        if (isLinkedInPdf()) {
            return getLinkedInTopSkills();
        }
        return null;
    }

    private String extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");


        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Aptitudini principale")) {
                String topSkills = "";
                for (int j = i + 1; j < i + 4; j++) {
                    topSkills += " " + textLines[j] + "\n";

                }

                return topSkills;
            }
        }
        return null;
    }


    public Integer getTotalYearsOfExperience() {

        int years = 0;
        int months = 0;
        for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {
            final String textOnPage = getActualText(page, false);
            String[] linesOnPage = textOnPage.split("\n");
            for (String line : linesOnPage) {
                years += getYearsForLine(line);
                months += getMonthsForLine(line);
            }
        }

        years += months / 12;

        return years;


    }

    private int getMonthsForLine(String line) {
        int months = 0;
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

    private int getYearsForLine(String line) {
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

    private String extractEducation() {
        String education = "";
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");

            for (int i = 0; i < textLines.length; i++) {
                String line = textLines[i];
                if (line.contains("Universit")) {
                    for (int j = i; j < textLines.length; j++) {
                        education += textLines[j] + "\n";

                    }
                    education = education.substring(0, education.lastIndexOf("Page"));
                    return education;
                }
            }

        }
        return "N/A";
    }

    private String getLinkedInEducation() {
        // Get the resultant text after applying the custom filter
        return extractEducation();

    }

    private String getLinkedInTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractTopSkills(actualText);

    }


    private boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }
}
