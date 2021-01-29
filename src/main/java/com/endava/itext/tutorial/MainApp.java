package com.endava.itext.tutorial;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) {

        Integer totalYearsOfExperience;

        try {
            LinkedInPDFReader pdfReader = new LinkedInPDFReader("/pdfs/BogdanBengaProfile.pdf");
            pdfReader.readPdf();

            //set total years of experience
            totalYearsOfExperience = pdfReader.getTotalYearsOfExperience();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            pdfReader.readPdf("/pdfs/OteleaFelixProfile.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pdfReader.readPdf("/pdfs/AndreiStoicaProfile.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
