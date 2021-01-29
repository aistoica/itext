package com.endava.itext.tutorial;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) {
        LinkedInPDFReader pdfReader = LinkedInPDFReader.getInstance();

        try {
            pdfReader.readPdf("/pdfs/BogdanBengaProfile.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
