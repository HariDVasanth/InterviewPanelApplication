package com.zsgs.interviewpanel.datalayer;

import com.google.gson.reflect.TypeToken;
import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.model.Credentials;
import com.zsgs.interviewpanel.admin.AdminModel;
import com.zsgs.interviewpanel.model.Interviewer;
import com.zsgs.interviewpanel.serializer.JsonSerialize;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

public class InterviewPanelData {
    private static InterviewPanelData interviewPanelData;
    private ArrayList<Candidates>candidatesList=new ArrayList<>();
    private ArrayList<Credentials>adminLoginDetails=new ArrayList<>();
    private Queue<Candidates>candidatesQueue=new LinkedList<>();
    private ArrayList<Candidates>selectedCandidates=new ArrayList<>();

    private Credentials credentials;

    private ArrayList<Interviewer>interviewers=new ArrayList<>();
    public static InterviewPanelData getInstance(){
        if(interviewPanelData==null){
            interviewPanelData=new InterviewPanelData();
        }
        return interviewPanelData;
    }

    public ArrayList<Credentials> getLoginDetails() {
        return adminLoginDetails;
    }

    public void setDefault(){
        Credentials credentials=new Credentials();
        credentials.setUsername("ADMIN");
        credentials.setPassword("ADMIN");
        adminLoginDetails.add(credentials);
    }

    public void removeDefault(String username,String password){
        Credentials credentials=adminLoginDetails.get(0);
        String username1= credentials.getUsername();
        String password1= credentials.getPassword();
        AdminModel adminModel=new AdminModel();
        if(username.equals(username1)){
            if(password.equals(password1)){
                adminModel.onDefaultSuccess("Default account removed successful");
            }else {
                adminModel.defaultWrongPassword("Please enter the correct password");
            }
        }else {
            adminModel.defaultWrongUsername("Please enter the correct username");
        }
    }
    public void setAdmin(String username,String password){
        credentials=new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        adminLoginDetails.add(credentials);
    }
    public void addCandidates(Candidates candidates){
        candidatesQueue.add(candidates);
    }
    public Queue<Candidates> getCandidatesQueue() {
        return candidatesQueue;
    }
    public void addInterviewer(Interviewer interviewer){
        interviewers.add(interviewer);
    }
    public ArrayList<Interviewer> getInterviewers() {
        return interviewers;
    }

    public ArrayList<Candidates> getCandidatesList() {
        return candidatesList;
    }

    public void setCandidatesList(Candidates candidatesList) {
        this.candidatesList.add(candidatesList);
    }

    public ArrayList<Candidates> getSelectedCandidates() {
        return selectedCandidates;
    }


    public void setSelectedCandidates(Candidates selectedCandidates) {
        this.selectedCandidates.add(selectedCandidates);
    }
    public void serializeAdminLoginDetails(){
        JsonSerialize.getJsonSerialize().serialize(adminLoginDetails,"C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\AdminLoginDetails.json");
    }
    public void serializeCandidatesList(){
        JsonSerialize.getJsonSerialize().serialize(getCandidatesList(),"C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\CandidatesDetails.json");
    }
    public void serializedSelectedCandidates(){
        JsonSerialize.getJsonSerialize().serialize(getSelectedCandidates(),"C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\SelectedCandidates.json");
    }
    public void deserializeAdminLoginDetails(){
        JsonSerialize.getJsonSerialize();
        this.adminLoginDetails=JsonSerialize.getJsonSerialize().deserialize("C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\AdminLoginDetails.json",new TypeToken<ArrayList<Credentials>>(){});
    }
    public void deserializedCandidatesList(){
        JsonSerialize.getJsonSerialize();
        this.candidatesList=JsonSerialize.getJsonSerialize().deserialize("C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\CandidatesDetails.json", new TypeToken<ArrayList<Candidates>>(){});
    }
    public void deserializedSelectedCandidatesList(){
        JsonSerialize.getJsonSerialize();
        this.selectedCandidates=JsonSerialize.getJsonSerialize().deserialize("C:\\Users\\surya\\IdeaProjects\\InterviewPanelApplication\\src\\com\\zsgs\\interviewpanel\\data\\SelectedCandidates.json",new TypeToken<ArrayList<Candidates>>(){});
    }

}
