package com.endava.itext.tutorial;


import java.io.IOException;

public class MainApp {

    public static void main(String[] args) {

        try {
            LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader("/pdfs/BogdanBengaProfile.pdf");
            String topSkills = linkedInPDFReader.getTopSkills();
            System.out.println(topSkills);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
