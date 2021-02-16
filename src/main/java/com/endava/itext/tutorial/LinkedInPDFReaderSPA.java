package com.endava.itext.tutorial;

import java.io.IOException;

public class LinkedInPDFReaderSPA  extends LinkedInPDFReader{
    private static String LINKEDIN_AUTHOR_NAME = "LinkedIn";


    public LinkedInPDFReaderSPA(String filePath) throws IOException {
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

        if (isLinkedInPdf() ) {
            return getLinkedInTopSkills();
        }
        return null;
    }
    private String extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");


        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Aptitudes principales") ) {
                String topSkills = "";
                for (int j = i+1; j < i+4; j++)
                {
                    topSkills += " " + textLines[j++];
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

                if (line.contains("año")) {

                    int yearIndex = line.indexOf("año");

                    int pIndex = line.indexOf("(");

                    years += Integer.valueOf(line.substring(pIndex + 1, yearIndex - 1).trim());

                    if (line.contains("mes")) {

                        int monthIndex = line.indexOf("mes");

                        months += Integer.valueOf(line.substring(yearIndex + 5, monthIndex - 1).trim());

                    }

                } else if (line.contains("mes")) {

                    int monthIndex = line.indexOf("mes");

                    int pIndex = line.indexOf("(");

                    months += Integer.valueOf(line.substring(pIndex + 1, monthIndex - 1).trim());

                }

            }

        }

        years += months / 12;
        return years;


    }
    private String extractEducation() {
        String education = "";
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");

            for (int i = 0; i< textLines.length; i++){
                String line = textLines[i];
                if (line.contains("Educación")){
                    for (int j = i+1; j < textLines.length; j++){
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