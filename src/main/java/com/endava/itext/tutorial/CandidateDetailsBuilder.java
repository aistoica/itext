package com.endava.itext.tutorial;

import com.endava.itext.tutorial.CandidateDetails;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.File;
import java.io.IOException;

public class CandidateDetailsBuilder {

    private String name;
    private String email;
    private String linkedInProfile;
    private String topSkills;
    private String languages;
    private String certifications;
    private int yearsOfExperience;
    private String currentCompany;
    private String currentJobTitle;
    private String education;
    private static String pdfAuthor;
    private static PdfDocument pdfDocument;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(String linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public String getTopSkills() {
        return topSkills;
    }

    public void setTopSkills(String topSkills,String filepath) throws IOException {
        String author=pdfType(filepath);
        String language=LinkedInPDFReader.getPDFLanguage();
        if(author.equals("LinkedIn") && language.equals("English"))
        {
            this.topSkills=LinkedInPDFReaderENG.getTopSkills();
        }
       else if(author.equals("LinkedIn") && language.equals("Romanian"))
        {
            this.topSkills=LinkedInPDFReaderRO.getTopSkills();
        }
        else if(author.equals("LinkedIn") && language.equals("Danish"))
        {
            this.topSkills=LinkedInPDFReaderDAN.getTopSkills();
        }
        else if(author.equals("LinkedIn") && language.equals("French"))
        {
            this.topSkills=LinkedInPDFReaderFR.getTopSkills();
        }
        else if(author.equals("LinkedIn") && language.equals("German"))
        {
            this.topSkills=LinkedInPDFReaderGER.getTopSkills();
        }
        else if(author.equals("LinkedIn") && language.equals("Russian"))
        {
            this.topSkills=LinkedInPDFReaderRUS.getTopSkills();
        }
        else if(author.equals("LinkedIn") && language.equals("Spanish"))
        {
            this.topSkills=LinkedInPDFReaderSPA.getTopSkills();
        } else
        {
            this.topSkills="N/A";
        }
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String filepath) throws IOException {
        String author = pdfType(filepath);
        if (author.equals("LinkedIn")) {
            this.languages = LinkedInPDFReader.getLanguages();
        }
        else
        {
            this.languages="N/A";
        }
    }
    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String filepath) throws IOException {

        String author = pdfType(filepath);
        if (author.equals("LinkedIn")) {
            this.certifications = LinkedInPDFReader.getCertifications();
        }
        else
        {
            this.certifications="N/A";
        }
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String filepath) throws IOException {
        String author=pdfType(filepath);
        String language=LinkedInPDFReader.getPDFLanguage();
        if(author.equals("LinkedIn") && language.equals("English"))
        {
            this.yearsOfExperience=LinkedInPDFReaderENG.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("Romanian"))
        {
            this.yearsOfExperience=LinkedInPDFReaderRO.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("Danish"))
        {
            this.yearsOfExperience=LinkedInPDFReaderDAN.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("French"))
        {
            this.yearsOfExperience=LinkedInPDFReaderFR.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("German"))
        {
            this.yearsOfExperience=LinkedInPDFReaderGER.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("Russian"))
        {
            this.yearsOfExperience=LinkedInPDFReaderRUS.getTotalYearsOfExperience();
        }
        else if(author.equals("LinkedIn") && language.equals("Spanish"))
        {
            this.yearsOfExperience=LinkedInPDFReaderSPA.getTotalYearsOfExperience();
        } else
        {
            this.yearsOfExperience=0;
        }
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String filepath) throws IOException {
        String author = pdfType(filepath);
        if (author.equals("LinkedIn")) {
            this.currentCompany = LinkedInPDFReader.getCurrentEmployer();
        }
        else
        {
            this.currentCompany="N/A";
        }
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String filepath) throws IOException {
        String author = pdfType(filepath);
        if (author.equals("LinkedIn")) {
            this.currentJobTitle = LinkedInPDFReader.getCurrentJobTitle();
        }
        else
        {
            this.currentCompany="N/A";
        }
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String filepath) throws IOException {
        String author=pdfType(filepath);
        String language=LinkedInPDFReader.getPDFLanguage();
        if(author.equals("LinkedIn") && language.equals("English"))
        {
            this.education=LinkedInPDFReaderENG.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("Romanian"))
        {
            this.education=LinkedInPDFReaderRO.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("Danish"))
        {
            this.education=LinkedInPDFReaderDAN.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("French"))
        {
            this.education=LinkedInPDFReaderFR.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("German"))
        {
            this.education=LinkedInPDFReaderGER.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("Russian"))
        {
            this.education=LinkedInPDFReaderRUS.getEducation();
        }
        else if(author.equals("LinkedIn") && language.equals("Spanish"))
        {
            this.education=LinkedInPDFReaderSPA.getEducation();
        } else
        {
            this.education="N/A";
        }
    }

    public CandidateDetailsBuilder(String name, String email, String linkedInProfile ,String filePath) throws IOException {
        this.name = name;
        this.email = email;
        this.linkedInProfile = linkedInProfile;
        this.pdfDocument = new PdfDocument(new PdfReader(filePath));
    }

    public String pdfType( String filePath) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(filePath));
       String linkedInAuthor= pdfDocument.getDocumentInfo().getAuthor();
       String europassTitle=pdfDocument.getDocumentInfo().getTitle();
       if(linkedInAuthor.equals("LinkedIn"))
       {
            return "LinkedIn";
       }else if(europassTitle.equals("Europass"))
       {
           return "EuroPass" ;
       }
       return "N/A";
    }


    public CandidateDetails build (String filepath) {


        return new CandidateDetails(this,filepath);
    }

}