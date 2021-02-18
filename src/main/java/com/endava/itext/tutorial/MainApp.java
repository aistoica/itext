package com.endava.itext.tutorial;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
//        System.out.println("For Bogdan Benga");
//        try {
//            LinkedInPDFReaderENG linkedInPDFReader = new LinkedInPDFReaderENG("/pdfs/BogdanBengaProfile.pdf");
//            String topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//            String education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//
//            String languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            String certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//            String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
//            System.out.println("Current JobTitle is:");
//            System.out.println(currentJobTitle);
//
//            String currentEmployer = linkedInPDFReader.getCurrentEmployer();
//            System.out.println("Current Employer is:");
//            System.out.println(currentEmployer);
//
//            Integer yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//            System.out.println("Years of Experience is:");
//            System.out.println(yearsOfExperience);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        System.out.println("\nFor Andrei Stoica");
//        try {
//            LinkedInPDFReaderRO linkedInPDFReader = new LinkedInPDFReaderRO("/pdfs/AndreiStoicaProfile.pdf");
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
//            System.out.println("Education: ");
//            System.out.println(education);
//
//            String certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//
////            int months = linkedInPDFReader.getMonthsOfExperience();
////            System.out.println("Months of xp are: ");
//////            System.out.println(months);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////
//        System.out.println("\nFor Felix Otelea");
//        try {
//            LinkedInPDFReaderRO linkedInPDFReader = new LinkedInPDFReaderRO("/pdfs/FelixOteleaProfile.pdf");
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

//            CandidateDetails cddtls = new CandidateDetails.CandidateDetailsBuilder(
//                    "500 GB", "2 GB","sadsadsadsadas","500 GB", "2 GB","sadsadsadsadas",2 , "2 GB","sadsadsadsadas","yes").build();
//

//           LinkedInPDFReader linkedInPDFReader = new LinkedInPDFReader ("/pdfs/FelixOteleaGermanProfile.pdf");
//           String lidre = linkedInPDFReader.getPDFLanguage();
//
//          System.out.println(lidre);


//        System.out.println("\nFor Felix Otelea-Spanish");
//        try {
//            LinkedInPDFReaderSPA linkedInPDFReader = new LinkedInPDFReaderSPA("/pdfs/FelixOteleaSpanishProfile.pdf");
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


//        System.out.println("\nFor Felix Otelea-Danish");
//       try {
//          LinkedInPDFReaderDAN linkedInPDFReader = new LinkedInPDFReaderDAN("/pdfs/FelixOteleaDanishProfile.pdf");
//           String topSkills = linkedInPDFReader.getTopSkills();
//           System.out.println("Top SKills are: ");
//           System.out.println(topSkills);
//
//
//          String languages = linkedInPDFReader.getLanguages();
//           System.out.println("Languages are: ");
//          System.out.println(languages);
//
//          Integer yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//          System.out.println("Years of Experience is:");
//          System.out.println(yearsOfExperience);
//           String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
//           System.out.println("Current JobTitle is:");
//           System.out.println(currentJobTitle);
//
//           String currentEmployer = linkedInPDFReader.getCurrentEmployer();
//          System.out.println("Current Employer is:");         System.out.println(currentEmployer);
//
//            String education = linkedInPDFReader.getEducation();
//          System.out.println("Education : ");
//           System.out.println(education);
//
//           String certifs = linkedInPDFReader.getCertifications();
//           System.out.println("Certifications : ");
//           System.out.println(certifs);
//
//       } catch (IOException e) {
//           e.printStackTrace();
//       }



//
//        System.out.println("\nFor Felix Otelea-French");
//        try {
//            LinkedInPDFReaderFR linkedInPDFReader = new LinkedInPDFReaderFR("/pdfs/FelixOteleaFrenchProfile.pdf");
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


//        System.out.println("\nFor Felix Otelea-German");
//        try {
//            LinkedInPDFReaderGER linkedInPDFReader = new LinkedInPDFReaderGER("/pdfs/FelixOteleaGermanProfile.pdf");
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

//        PdfDocument pdf =new PdfDocument(new PdfReader("/pdfs/Cv_1.pdf"));
//       String   pdfAuthor = pdf.getDocumentInfo().getTitle();
//       System.out.println(pdfAuthor);
////
//
//        System.out.println("\nFor Felix Otelea-RUSKY");
//        try {
//            LinkedInPDFReaderRUS linkedInPDFReader = new LinkedInPDFReaderRUS("/pdfs/FelixOteleaRussianProfile.pdf");
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


CandidateDetailsBuilder cdb1= new CandidateDetailsBuilder("Bogdan Benga","oteleafelix@gmail.com","adsadsadsadsadsada","/pdfs/BogdanBengaProfile.pdf");

System.out.println(CandidateDetails.getCurrentCompany());
    }
}
