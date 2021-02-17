package com.endava.itext.tutorial;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CandidateDetails {
    private String name;
    private String email;
    private String linkedInProfile; //url
    private Set<String> topSkills;  //set de stringuri
    private Set<String> languages; //set de string-uri
    private Set<String> certifications; //set de string-uri
    private double yearsOfExperience;
    private String currentCompany;
    private String currentJobTitle;
    private List<String> education;


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

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public List<String> getEducation() {
        return education;
    }

    CandidateDetails(CandidateDetailsBuilder builder) {
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

    public static class CandidateDetailsBuilder {

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

        public void setTopSkills(String topSkills) {
            this.topSkills = topSkills;
        }

        public String getLanguages() {
            return languages;
        }

        public void setLanguages(String languages) {
            this.languages = languages;
        }

        public String getCertifications() {
            return certifications;
        }

        public void setCertifications(String certifications) {
            this.certifications = certifications;
        }

        public int getYearsOfExperience() {
            return yearsOfExperience;
        }

        public void setYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
        }

        public String getCurrentCompany() {
            return currentCompany;
        }

        public void setCurrentCompany(String currentCompany) {
            this.currentCompany = currentCompany;
        }

        public String getCurrentJobTitle() {
            return currentJobTitle;
        }

        public void setCurrentJobTitle(String currentJobTitle) {
            this.currentJobTitle = currentJobTitle;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public CandidateDetailsBuilder(String name, String email, String linkedInProfile) {
            this.name = name;
            this.email = email;
            this.linkedInProfile = linkedInProfile;
        }

        public CandidateDetails build() {
            return new CandidateDetails(this);
        }

    }
}
