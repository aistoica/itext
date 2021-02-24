package com.endava.itext.tutorial;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.IOException;
import java.net.URL;

import java.util.Set;

public class CandidateDetailsBuilder {

    private static  String candidate;
    private static String email;
    private  static URL linkedInProfile;
    private  static Set<String> topSkills;
    private static Set<String> languages;
    private static Set<String> certifications;
    private static double yearsOfExperience;
    private static String currentCompany;
    private static String currentJobTitle;
    private static Set<String> education;
    private static String LINKEDIN_type_NAME = "LinkedIn";
    private static PdfDocument pdfDocument;


    public static String getCandidate() {
        return candidate;
    }

    public void setCandidate(String filepath) throws IOException {
        String type=pdfType(filepath);
        String language=new LinkedInPDFReader(filepath).getPDFLanguage();
        if(type.equals("LinkedIn") && language.equals("English"))
        {
            candidate=new LinkedInPDFReaderENG(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("Romanian"))
        {
            candidate=new LinkedInPDFReaderRO(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("Danish"))
        {
            candidate=new LinkedInPDFReaderDAN(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("French"))
        {
            candidate=new LinkedInPDFReaderFR(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("German"))
        {
            candidate=new LinkedInPDFReaderGER(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("Russian"))
        {
            candidate=new LinkedInPDFReaderRUS(filepath).getCandidate();
        }
        else if(type.equals("LinkedIn") && language.equals("Spanish"))
        {
            candidate=new LinkedInPDFReaderSPA(filepath).getCandidate();
        } else
        {
           candidate=null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String filepath) throws IOException {
       email= new LinkedInPDFReader(filepath).getEmail();
    }

    public URL getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(URL linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public static Set<String> getTopSkills() {
        return topSkills;
    }

    public void setTopSkills(Set<String> topSkills, String filepath) throws IOException {
        String type=pdfType(filepath);
        String language=new LinkedInPDFReader(filepath).getPDFLanguage();
        if(type.equals("LinkedIn") && language.equals("English"))
        {
            topSkills=new LinkedInPDFReaderENG(filepath).getTopSkills();
        }
       else if(type.equals("LinkedIn") && language.equals("Romanian"))
        {
            this.topSkills=new LinkedInPDFReaderRO(filepath).getTopSkills();
        }
        else if(type.equals("LinkedIn") && language.equals("Danish"))
        {
            this.topSkills= new LinkedInPDFReaderRO(filepath).getTopSkills();
        }
        else if(type.equals("LinkedIn") && language.equals("French"))
        {
            this.topSkills= new LinkedInPDFReaderFR(filepath).getTopSkills();
        }
        else if(type.equals("LinkedIn") && language.equals("German"))
        {
            this.topSkills= new LinkedInPDFReaderGER(filepath).getTopSkills();
        }
        else if(type.equals("LinkedIn") && language.equals("Russian"))
        {
            this.topSkills= new LinkedInPDFReaderRUS(filepath).getTopSkills();
        }
        else if(type.equals("LinkedIn") && language.equals("Spanish"))
        {
            this.topSkills= new LinkedInPDFReaderSPA(filepath).getTopSkills();
        } else
        {
            this.topSkills= null;
        }
    }

    public static Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String filepath) throws IOException {
        String type = pdfType(filepath);
        if (type.equals("LinkedIn")) {
            this.languages = new LinkedInPDFReader(filepath).getLanguages();
        }
        else
        {
            this.languages=null;
        }
    }
    public static Set<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(String filepath) throws IOException {

        String type = pdfType(filepath);
        if (type.equals("LinkedIn")) {
            this.certifications = new LinkedInPDFReader(filepath).getCertifications();
        }
        else
        {
            this.certifications=null;
        }
    }

    public static double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String filepath) throws IOException {
        String type=pdfType(filepath);
        String language=new LinkedInPDFReader(filepath).getPDFLanguage();
        if(type.equals("LinkedIn") && language.equals("English"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderENG(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("Romanian"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderRO(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("Danish"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderDAN(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("French"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderFR(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("German"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderGER(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("Russian"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderRUS(filepath).getTotalYearsOfExperience();
        }
        else if(type.equals("LinkedIn") && language.equals("Spanish"))
        {
            this.yearsOfExperience=new LinkedInPDFReaderRUS(filepath).getTotalYearsOfExperience();
        } else
        {
            this.yearsOfExperience=0;
        }
    }

    public static String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String filepath) throws IOException {
        String type = pdfType(filepath);
        if (type.equals("LinkedIn")) {
            this.currentCompany = new LinkedInPDFReader(filepath).getCurrentEmployer();

        }
        else
        {
            this.currentCompany=null;
        }
    }

    public static String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String filepath) throws IOException {
        String type = pdfType(filepath);
        if (type.equals("LinkedIn")) {
            currentJobTitle = new LinkedInPDFReader(filepath).getCurrentJobTitle();
        }
        else
        {
            currentJobTitle="N/A";
        }
    }
    public static Set <String> getEducation() {
        return education;
    }

    public void setEducation(String filepath) throws IOException {
        String type=pdfType(filepath);
        String language=new LinkedInPDFReader(filepath).getPDFLanguage();
        if(  type.equals("LinkedIn") &&  language.equals("English"))
        {
            education=new LinkedInPDFReaderENG(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("Romanian"))
        {
            education=new LinkedInPDFReaderRO(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("Danish"))
        {
            education=new LinkedInPDFReaderDAN(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("French"))
        {
            education=new LinkedInPDFReaderFR(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("German"))
        {
            education=new LinkedInPDFReaderGER(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("Russian"))
        {
            education=new LinkedInPDFReaderRUS(filepath).getEducation();
        }
        else if(type.equals("LinkedIn") && language.equals("Spanish"))
        {
            education=new LinkedInPDFReaderSPA(filepath).getEducation();
        } else
        {
            education=null;
        }
    }

    public CandidateDetailsBuilder(String filePath) throws IOException {

        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
    }

    public String pdfType( String filePath) throws IOException {

       String linkedInAuthor= pdfDocument.getDocumentInfo().getAuthor();
       String europassTitle=pdfDocument.getDocumentInfo().getTitle();
       if(linkedInAuthor.equals("LinkedIn"))
       { return "LinkedIn";
       }
       else if(europassTitle.equals("Europass"))
       {
           return "EuroPass" ;
       }
       return "N/A";
    }


    public CandidateDetails build () {
        return new CandidateDetails(this);
    }

}