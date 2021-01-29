package com.endava.itext.tutorial;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) {
        String currentEmployer;
        String coreSkills;
        String currentJobTitle;
        Integer totalYearsOfExperience;

        try {
            LinkedInPDFReader pdfReader = new LinkedInPDFReader("/pdfs/BogdanBengaProfile.pdf");
//            pdfReader.readPdf();

            //set current Employer
            currentEmployer = pdfReader.getCurrentEmployer();
            //set core Skills
            coreSkills = pdfReader.getCoreSkills();
            //set currentJob Title
            currentJobTitle = pdfReader.getCurrentJobTitle();
            //set total years of experience
            totalYearsOfExperience = pdfReader.getTotalYearsOfExperience();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
