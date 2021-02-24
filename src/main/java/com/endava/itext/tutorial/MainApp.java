package com.endava.itext.tutorial;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

import static com.endava.itext.tutorial.CandidateDetails.*;

public class MainApp {

    public static void main(String[] args) throws IOException {
//        System.out.println("For Bogdan Benga");
//        try {
//            LinkedInPDFReaderENG linkedInPDFReader = new LinkedInPDFReaderENG("/pdfs/BogdanBengaProfile.pdf");
////           URL profile= LinkedInPDFReader.getProfile();
////            System.out.println("Profile : ");
////            System.out.println(profile);
//
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//            String name = linkedInPDFReader.getName();
//            System.out.println("Name is: ");
//            System.out.println(name);
//
//            String email = linkedInPDFReader.getEmail();
//            System.out.println("Email: ");
//            System.out.println(email);
//
//            Set <String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            Set <String> certifs = linkedInPDFReader.getCertifications();
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
//            Double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//            System.out.println("Years of Experience is:");
//            System.out.println(yearsOfExperience);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        System.out.println("\nFor Andrei Stoica");
//        try {
//            LinkedInPDFReaderRO linkedInPDFReader = new LinkedInPDFReaderRO("/pdfs/AndreiStoicaProfile.pdf");
//            String name = linkedInPDFReader.getCandidate();
//            System.out.println("Name is: ");
//            System.out.println(name);
//
//            String email = linkedInPDFReader.getEmail();
//            System.out.println("Email: ");
//            System.out.println(email);
//
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education: ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //            int months = linkedInPDFReader.getMonthsOfExperience();
//            System.out.println("Months of xp are: ");
////            System.out.println(months)
////
//        System.out.println("\nFor Felix Otelea");
//        try {
//            LinkedInPDFReaderRO linkedInPDFReader = new LinkedInPDFReaderRO("/pdfs/FelixOteleaProfile.pdf");
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
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
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        System.out.println("\nFor Felix Otelea-Danish");
//       try {
//          LinkedInPDFReaderDAN linkedInPDFReader = new LinkedInPDFReaderDAN("/pdfs/FelixOteleaDanishProfile.pdf");
//           Set<String> topSkills = linkedInPDFReader.getTopSkills();
//           System.out.println("Top SKills are: ");
//           System.out.println(topSkills);
//
//
//          Set<String> languages = linkedInPDFReader.getLanguages();
//           System.out.println("Languages are: ");
//          System.out.println(languages);
//
//          double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
//          System.out.println("Years of Experience is:");
//          System.out.println(yearsOfExperience);
//           String currentJobTitle = linkedInPDFReader.getCurrentJobTitle();
//           System.out.println("Current JobTitle is:");
//           System.out.println(currentJobTitle);
//
//           String currentEmployer = linkedInPDFReader.getCurrentEmployer();
//          System.out.println("Current Employer is:");         System.out.println(currentEmployer);
//
//            Set<String> education = linkedInPDFReader.getEducation();
//          System.out.println("Education : ");
//           System.out.println(education);
//
//           Set<String> certifs = linkedInPDFReader.getCertifications();
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
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        System.out.println("\nFor Felix Otelea-German");
//        try {
//            LinkedInPDFReaderGER linkedInPDFReader = new LinkedInPDFReaderGER("/pdfs/FelixOteleaGermanProfile.pdf");
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
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
////
//        System.out.println("\nFor Felix Otelea-RUSKY");
//        try {
//            LinkedInPDFReaderRUS linkedInPDFReader = new LinkedInPDFReaderRUS("/pdfs/FelixOteleaRussianProfile.pdf");
//            Set<String> topSkills = linkedInPDFReader.getTopSkills();
//            System.out.println("Top SKills are: ");
//            System.out.println(topSkills);
//
//
//            Set<String> languages = linkedInPDFReader.getLanguages();
//            System.out.println("Languages are: ");
//            System.out.println(languages);
//
//            double yearsOfExperience = linkedInPDFReader.getTotalYearsOfExperience();
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
//            Set<String> education = linkedInPDFReader.getEducation();
//            System.out.println("Education : ");
//            System.out.println(education);
//
//            Set<String> certifs = linkedInPDFReader.getCertifications();
//            System.out.println("Certifications : ");
//            System.out.println(certifs);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        URL myURL = new URL("http://example.com/");

//System.out.println(new LinkedInPDFReader("/pdfs/BogdanBengaProfile.pdf").getCurrentEmployer());
//
////        CandidateDetails cdb1= new CandidateDetails(builder);
////
////        System.out.println(cdb1);
//        CandidateDetailsBuilder builder=new CandidateDetailsBuilder("/pdfs/BogdanBengaProfile.pdf");
//     CandidateDetails candidateDetails=new CandidateDetails(builder);

        System.out.println("\nFor Claudia Panait");
       try {
          EuropassPDFReaderENG europassPDFReader = new EuropassPDFReaderENG("/pdfs/CV-Europass-20200206-Panait-EN+(2).pdf");
//           Set<String> topSkills = europassPDFReader.getTopSkills();
//           System.out.println("Top SKills are: ");
//           System.out.println(topSkills);
//

          String fullText = europassPDFReader.getActualText(1);
          System.out.println("Lines are: ");
          System.out.println(fullText);
//          String currentJobTitle = europassPDFReader.getCurrentJobTitle();
//           System.out.println("Current JobTitle is:");
//           System.out.println(currentJobTitle);

//
//           String currentJobTitle = europassPDFReader.getCurrentJobTitle();
//           System.out.println("Current JobTitle is:");
//           System.out.println(currentJobTitle);
//
//           String currentEmployer = europassPDFReader.getCurrentEmployer();
//          System.out.println("Current Employer is:");         System.out.println(currentEmployer);
//
//            Set<String> education = europassPDFReader.getEducation();
//          System.out.println("Education : ");
//           System.out.println(education);
//
           Set<String> certifs = europassPDFReader.getCertifications();
           System.out.println("Certifications : ");
           System.out.println(certifs);

           String candidate = europassPDFReader.getCandidate();
           System.out.println("Candidate : ");
           System.out.println(certifs);

//           double yearsOfExperience = europassPDFReader.getTotalYearsOfExperience();
//           System.out.println("Years of Experience is:");
//           System.out.println(yearsOfExperience);
           String lines="";


       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
