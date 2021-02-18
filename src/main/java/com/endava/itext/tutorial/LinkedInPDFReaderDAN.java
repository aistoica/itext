package com.endava.itext.tutorial;

import com.itextpdf.kernel.pdf.PdfDocument;

import java.io.IOException;

public class LinkedInPDFReaderDAN extends LinkedInPDFReader {


    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";
    private static String pdfAuthor;
    private static PdfDocument pdfDocument;

    public LinkedInPDFReaderDAN(String filePath) throws IOException {
        super(filePath);
        this.pdfAuthor = pdfDocument.getDocumentInfo().getAuthor();

    }

    public static String getEducation() {

        if (isLinkedInPdf()) {
            return getLinkedInEducation();
        }
        return null;
    }


    public static String getTopSkills() {

        if (isLinkedInPdf()) {
            return getLinkedInTopSkills();
        }
        return null;
    }

    private static String extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = 0; i < textLines.length; i++) {

            if (textLines[i].contains("kompetencer")) {
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


    public static Integer getTotalYearsOfExperience() {

        int years = 0;

        int months = 0;

        for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {

            final String textOnPage = getActualText(page, false);

            String[] linesOnPage = textOnPage.split("\n");

            for (String line : linesOnPage) {

                if (line.contains("year")) {

                    int yearIndex = line.indexOf("year");

                    int pIndex = line.indexOf("(");

                    years += Integer.valueOf(line.substring(pIndex + 1, yearIndex - 1).trim());

                    if (line.contains("måne")) {

                        int monthIndex = line.indexOf("måne");

                        months += Integer.valueOf(line.substring(yearIndex + 5, monthIndex - 1).trim());

                    }

                } else if (line.contains("måne")) {

                    int monthIndex = line.indexOf("måne");

                    int pIndex = line.indexOf("(");

                    months += Integer.valueOf(line.substring(pIndex + 1, monthIndex - 1).trim());

                }

            }

        }

        years += months / 12;

        return years;


    }

    private static String extractEducation() {
        String education = "";
        int noOfPages = pdfDocument.getNumberOfPages();
        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");
            for (int i = 0; i < textLines.length; i++) {
                String line = textLines[i];
                if (line.contains("Uddannelse")) {
                    for (int j = i + 1; j < textLines.length; j++) {
                        education += textLines[j]+"\n";

                    }
                    education = education.substring(0, education.lastIndexOf("Page"));
                    return education;
                }
            }

        }
        return "N/A";
    }

    private static String getLinkedInEducation() {
        // Get the resultant text after applying the custom filter
        return extractEducation();

    }


    private static String getLinkedInTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractTopSkills(actualText);

    }


    private static boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }
}
