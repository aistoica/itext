package com.endava.itext.tutorial;


import java.io.IOException;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("For Bogdan Benga");
        try {
            LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader("/pdfs/BogdanBengaProfile.pdf");
            String topSkills = linkedInPDFReader.getTopSkills();
            System.out.println("Top SKills are: ");
            System.out.println(topSkills);
            String education = linkedInPDFReader.getEducation();
            System.out.println("Education : ");
            System.out.println(education);


            String languages = linkedInPDFReader.getLanguages();
            System.out.println("Languages are: ");
            System.out.println(languages);

            String certifs = linkedInPDFReader.getCertifications();
            System.out.println("Certifications : ");
            System.out.println(certifs);

            String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
            System.out.println("Current JobTitle is:");
            System.out.println(currentJobTitle);

            String currentEmployer = linkedInPDFReader.getCurrentEmployer();
            System.out.println("Current Employer is:");
            System.out.println(currentEmployer);

            Integer yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
            System.out.println("Years of Experience is:");
            System.out.println(yearsOfExperience);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        System.out.println("\nFor Andrei Stoica");
//        try {
//            LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader("/pdfs/AndreiStoicaProfile.pdf");
//            String topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//            String languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            Integer yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//            System.out.println("Years of Experience is:");
//            System.out.println(yearsOfExperience);
//
//            String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
//            System.out.println("Current JobTitle is:");
//            System.out.println(currentJobTitle);
//
//            String currentEmployer = linkedInPDFReader.getCurrentEmployer();
//            System.out.println("Current Employer is:");
//            System.out.println(currentEmployer);
//
//            String education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            String certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nFor Felix Otelea");
//        try {
//            LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader("/pdfs/FelixOteleaProfile.pdf");
//            String topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            String languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            Integer yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//            System.out.println("Years of Experience is:");
//            System.out.println(yearsOfExperience);
//
//            String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
//            System.out.println("Current JobTitle is:");
//            System.out.println(currentJobTitle);
//
//            String currentEmployer = linkedInPDFReader.getCurrentEmployer();
//            System.out.println("Current Employer is:");
//            System.out.println(currentEmployer);
//
//            String education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            String certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    }
}
