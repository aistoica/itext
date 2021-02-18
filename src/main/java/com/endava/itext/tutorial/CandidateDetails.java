package com.endava.itext.tutorial;

import java.util.Collections;
import java.util.List;
import java.util.Set;


public class CandidateDetails {
    private static int yearsOfExperience;
    private  static String name;
    private  static String email;
    private  static String linkedInProfile; //url
    private  static Set<String> topSkills;  //set de stringuri
    private  static Set<String> languages; //set de string-uri
    private   static Set<String> certifications; //set de string-uri

    private static  String currentCompany;
    private  static String currentJobTitle;
    private  static  List<String> education;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public Set<String> getTopSkills() {
        return topSkills;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public Set<String> getCertifications() {
        return certifications;
    }

    public static int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public static String getCurrentCompany() {
        return currentCompany;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public List<String> getEducation() {
        return education;
    }

    CandidateDetails(CandidateDetailsBuilder builder, String filepath) {
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.linkedInProfile = builder.getLinkedInProfile();
        this.topSkills = Collections.singleton(builder.getTopSkills());
        this.languages = Collections.singleton(builder.getLanguages());
        this.certifications = Collections.singleton(builder.getCertifications());
        this.yearsOfExperience = builder.getYearsOfExperience();
        this.currentCompany = builder.getCurrentCompany();
        this.currentJobTitle = builder.getCurrentJobTitle();
        this.education = Collections.singletonList(builder.getEducation());
    }

}
