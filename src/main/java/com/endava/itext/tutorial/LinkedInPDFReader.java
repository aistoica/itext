package com.endava.itext.tutorial;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class LinkedInPDFReader {

    PdfReader pdfReader;

    public LinkedInPDFReader(String filePath) throws IOException {
        this.pdfReader = new PdfReader(filePath);
    }

    public String getCurrentEmployer(){
        //TODO: implement get current employer
        return null;
    }

    public String getCoreSkills(){
        //TODO: implement get core skills
        return null;
    }

    public String getCurrentJobTitle(){
        //TODO: implement get current job title
        return null;
    }

    public Integer getTotalYearsOfExperience(){
        //TODO: implement get total years
        return null;
    }


    public void readPdf() throws IOException {

            //Get the number of pages in pdf.
            int pages = pdfReader.getNumberOfPages();

            //Iterate the pdf through pages.
            for (int i = 1; i <= pages; i++) {
                //Extract the page content using PdfTextExtractor.
                String pageContent =
                        PdfTextExtractor.getTextFromPage(pdfReader, i);

                //Print the page content on console.
                System.out.println("Content on Page "
                        + i + ": " + pageContent);
            }

            //Close the PdfReader.
            pdfReader.close();
    }
}