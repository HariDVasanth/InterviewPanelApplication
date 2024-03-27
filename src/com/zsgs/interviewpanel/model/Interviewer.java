package com.zsgs.interviewpanel.model;

import java.util.ArrayList;

public class Interviewer {
    private String interviewerName;
    private String role;
    private ArrayList<Candidates> candidatesArrayList=new ArrayList<>();
    private boolean isAvailable;


    public Interviewer(String interviewerName, String role) {
        this.interviewerName = interviewerName;
        this.role = role;
        this.isAvailable=true;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ArrayList<Candidates> getCandidatesArrayList() {
        return candidatesArrayList;
    }

    public void setCandidatesArrayList(Candidates candidates ) {
        candidatesArrayList.add(candidates);
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "interviewerName='" + interviewerName + '\'' +
                ", role='" + role + '\'' +
                ", candidatesArrayList=" + candidatesArrayList +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
