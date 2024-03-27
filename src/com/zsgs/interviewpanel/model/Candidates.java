package com.zsgs.interviewpanel.model;

public class Candidates {

    private  int candidateNumber;
    private String candidateName;
    private String candidatePhoneNumber;
    private int candidateAge;
    private String candidateEmailId;

    private String candidateDegree;
    private String candidateSkills;
    private String interviewStatus;


    public Candidates(int candidateNumber,String candidateName,String candidatePhoneNumber,String candidateEmailId, int candidateAge, String candidateDegree, String candidateSkills) {
        this.candidateNumber=candidateNumber;
        this.candidateName = candidateName;
        this.candidatePhoneNumber=candidatePhoneNumber;
        this.candidateEmailId=candidateEmailId;
        this.candidateAge = candidateAge;
        this.candidateDegree = candidateDegree;
        this.candidateSkills = candidateSkills;
    }

    public int getCandidateNumber() {
        return candidateNumber;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getCandidateAge() {
        return candidateAge;
    }

    public String getCandidateDegree() {
        return candidateDegree;
    }

    public String getCandidateSkills() {
        return candidateSkills;
    }
    public String getInterviewStatus() {
        return interviewStatus;
    }

    public String getCandidatePhoneNumber() {
        return candidatePhoneNumber;
    }

    public void setCandidatePhoneNumber(String candidatePhoneNumber) {
        this.candidatePhoneNumber = candidatePhoneNumber;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
    public String toString(){
        return "Candidate Number: "+ getCandidateNumber()+ "\n"+"Candidates Name: "+getCandidateName() + "\n" + "Candidate Age: " + getCandidateAge() + "\n"+ "Candidate Degree: "+getCandidateDegree()+ "\n"+ "Candidate's Skill: "+getCandidateSkills()+"\n";
    }




}
