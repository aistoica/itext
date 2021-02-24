package com.endava.itext.tutorial;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

public class LinkedInPDFReaderENG extends  LinkedInPDFReader{
     static PdfDocument pdfDocument;
    static String LINKEDIN_AUTHOR_NAME = "LinkedIn";
    static String pdfAuthor;



    public LinkedInPDFReaderENG(String filePath) throws IOException {
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
    public static String getCandidate() {

        if (isLinkedInPdf()) {
            return getLinkedInCandidate();
        }
        return null;
    }


    public static Set<String> getTopSkills() {

        if (isLinkedInPdf() ) {
            return getLinkedInTopSkills();
        }
        return null;
    }
    private static  Set<String> extractTopSkills(String actualText) {
        String[] textLines = actualText.split("\n");
        for (int i = 0; i < textLines.length; i++) {
            if (textLines[i].contains("Top Skills") ) {
                Set<String> topSkills= new HashSet<String>();
                for (int j = i+1; j < i+4; j++)
                {
//                    topSkills += " " + textLines[j]+"\n";
                    topSkills.add(textLines[j]);
                }

                return topSkills;
            }
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
                if (line.contains("Summary")){

                       name=textLines[i-2];
                    return name;
                    }

                }
            }


        return null;
    }

    public static double getTotalYearsOfExperience() {

            int years = 0;

            double months = 0;

            for (int page = 1; page <= pdfDocument.getNumberOfPages(); page++) {

                final String textOnPage = getActualText(page, false);

                String[] linesOnPage = textOnPage.split("\n");

                for (String line : linesOnPage) {

                    if (line.contains("year")) {

                        int yearIndex = line.indexOf("year");

                        int pIndex = line.indexOf("(");

                        years += Integer.valueOf(line.substring(pIndex + 1, yearIndex - 1).trim());

                        if (line.contains("month")) {

                            int monthIndex = line.indexOf("month");

                            months += Integer.valueOf(line.substring(yearIndex + 5, monthIndex - 1).trim());

                        }

                    } else if (line.contains("month")) {

                        int monthIndex = line.indexOf("month");

                        int pIndex = line.indexOf("(");

                        months += Integer.valueOf(line.substring(pIndex + 1, monthIndex - 1).trim());

                    }

                }

            }

            years += months / 12;

        return Math.round(years);


    }
    private static Set<String> extractEducation() {
          String education = "";
        Set<String> educationSet = new HashSet<String>();
        int noOfPages = pdfDocument.getNumberOfPages();

        for (int page = 1; page <= noOfPages; page++) {
            String actualPageText = getActualText(page, false);
            String[] textLines = actualPageText.split("\n");
            for (int i = 0; i< textLines.length; i++){
                String line = textLines[i];
                if (line.contains("Education")){
                    for (int j = i+1; j < textLines.length; j++){
                      if(textLines[j].contains("Universit")) {

                          educationSet.add(textLines[j]);
                          j++;
                      }
                      else
                      {
                          j++;
                      }
                    }
                   // education = education.substring(0, education.lastIndexOf("Page"));

                    return educationSet;
                }
            }

        }
        return null;
    }
    private static Set<String> getLinkedInEducation() {
        // Get the resultant text after applying the custom filter
        return extractEducation();

    }
    private static Set<String> getLinkedInTopSkills() {
        // Get the resultant text after applying the custom filter
        String actualText = getActualText(1, true);
        return extractTopSkills(actualText);

    }



    private static boolean isLinkedInPdf() {
        //TODO: implement this
        return pdfAuthor.equals(LINKEDIN_AUTHOR_NAME);
    }


}
