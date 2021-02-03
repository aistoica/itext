package com.endava.itext.tutorial;



import com.itextpdf.kernel.pdf.PdfReader;

import java.io.IOException;

public class LinkedInPDFReader {

    PdfReader pdfReader;

    public LinkedInPDFReader(String filePath) throws IOException {
        this.pdfReader = new PdfReader(filePath);
    }

    public String getCurrentEmployer() throws IOException {


        return null;
    }

    public <ITextExtractionStrategy> String getCoreSkills() {
        return null;
    }

    public <ITextExtractionStrategy> String getCurrentJobTitle() {
        return null;
    }

    public Integer getTotalYearsOfExperience() {
        return null;
    }


    public void readPdf() throws IOException {


    }


}