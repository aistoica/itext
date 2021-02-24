package com.endava.itext.tutorial;

import java.io.File;
import java.net.URL;
import java.util.Set;


public class CandidateDetails {
    private static double yearsOfExperience;
    private  static String candidate;
    private  static String email;
    private  static URL linkedInProfile; //url  url to string valid url
    private  static Set<String> topSkills;  //set de stringuri
    private  static  Set<String> languages; //set de string-uri
    private   static Set<String> certifications; //set de string-uri
    private static  String currentCompany;
    private  static String currentJobTitle;
    private  static  Set<String> education;




    public String getCandidate() {
        return candidate;
    }

    public String getEmail() {
        return email;
    }

    public URL getLinkedInProfile() {
        return linkedInProfile;
    }

    public Set<String> getTopSkills() {
        return getTopSkills();
    }

    public Set<String> getLanguages() {
        return getLanguages();
    }

    public Set<String> getCertifications() {
        return getCertifications();
    }

    public static double getYearsOfExperience() {
        return getYearsOfExperience();
    }

    public static String getCurrentCompany() {
        return getCurrentCompany();
    }

    public String getCurrentJobTitle() {
        return getCurrentJobTitle();
    }

    public static Set<String> getEducation() {
        return education;
    }

    CandidateDetails(CandidateDetailsBuilder builder) {
        this.candidate = builder.getCandidate();
        this.email = builder.getEmail();
        this.linkedInProfile = builder.getLinkedInProfile();
        this.topSkills = builder.getTopSkills();
        this.languages = builder.getLanguages();
        this.certifications = builder.getCertifications();
        this.yearsOfExperience = builder.getYearsOfExperience();
        this.currentCompany = builder.getCurrentCompany();
        this.currentJobTitle = builder.getCurrentJobTitle();
        this.education = builder.getEducation();
    }

    public Class<? extends CandidateDetails> getCandidateDetails(File file)
    {
        return this.getClass();

    }

}
