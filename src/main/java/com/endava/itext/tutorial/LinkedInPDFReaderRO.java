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
                for (int j = i+1; j < i+4; j++)
                {
                    topSkills += " " + textLines[j]+"\n";

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

                String regex = "\\(\\d+ an";
                String regex2 = "\\d+ luni\\)";
                String regex3 = "\\d+ lună\\)";
                Pattern p = Pattern.compile(regex);// the pattern to search for
                Pattern p1 = Pattern.compile(regex2);
                Pattern p2 = Pattern.compile(regex3);
                Matcher yearMatcherRo = p.matcher(line);
                Matcher yearMatcherRo2  = p1.matcher(line);
                Matcher yearMatcherRo3 = p2.matcher(line);

                if (yearMatcherRo.find()) {
                    System.out.println(line + " Is a match");

                    int yearIndex = line.indexOf(regex);

                    int pIndex = line.indexOf("(");
               //    years += Integer.valueOf(line.substring(pIndex + 1, yearIndex - 1).trim());

                    if (yearMatcherRo2.find()) {
                        int monthIndex = line.indexOf(regex2);
                        System.out.println(line + " Is a match");
                    //   months += Integer.valueOf(line.substring(yearIndex + 5, monthIndex - 1).trim());
                    }
                }
                else if (yearMatcherRo3.find()) {

                    int monthIndex = line.indexOf(regex3);

                    int pIndex = line.indexOf("(");
                    System.out.println(line + " Is a match");
             //      months += Integer.valueOf(line.substring(pIndex + 1, monthIndex - 1).trim());

                }

            }
            years += months / 12;

            return years;

        }
        return null;
    }

    private String extractEducation() {
        String education = "";
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");

            for (int i = 0; i< textLines.length; i++){
                String line = textLines[i];
                if (line.contains("Universitat")){
                    for (int j = i; j < textLines.length; j++){
                        education += textLines[j]+"\n";

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
