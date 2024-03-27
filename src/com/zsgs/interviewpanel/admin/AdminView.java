package com.zsgs.interviewpanel.admin;
import com.zsgs.interviewpanel.InterviewPanel;
import com.zsgs.interviewpanel.datalayer.InterviewPanelData;
import com.zsgs.interviewpanel.interviewer.InterviewerView;

import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.serializer.JsonSerialize;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    Scanner scanner=new Scanner(System.in);
    private AdminModel adminModel;
    public AdminView(){
        adminModel=new AdminModel(this);
    }
    public void adminInit(){
        adminsetUp();
    }
    public void adminsetUp(){
        System.out.println(InterviewPanel.getInstance().getAppName());
        System.out.println(InterviewPanel.getInstance().getAppVersion());
        System.out.print("Enter the username(Default): ");
        String username=scanner.nextLine();
        System.out.print("Enter the password(Default): ");
        String password=scanner.nextLine();
        adminModel.setUpAdmin(username,password);
    }
    public void defaultRemoved(String message){
        System.out.println(message);
        adminAccountCreation();
    }
    public void defaultWrongPassword(String message){
        System.out.println(message);
        adminsetUp();
    }
    public void defaultWrongUsername(String message){
        System.out.println(message);
        adminsetUp();
    }
    public void adminAccountCreation(){
        System.out.println(InterviewPanel.getInstance().getAppName());
        System.out.println(InterviewPanel.getInstance().getAppVersion());
        System.out.println("Welcome to your account set up admin");
        System.out.print("Please enter your username: ");
        String username=scanner.nextLine();
        System.out.print("Please enter your password: ");
        String password=scanner.nextLine();
        adminModel.adminAccountCreate(username,password);
    }
    public void invalidUsername(String message){
        System.out.println(message);
        adminAccountCreation();
    }
    public void invalidPassword(String message){
        System.out.println(message);
        adminAccountCreation();
    }
    public void accountCreationSuccess(String message){
        System.out.println(message);
        addCandidates();
    }
    public void addCandidates(){
        System.out.println("Enter the number of candidates you want to add");
        int candidates= scanner.nextInt();
        scanner.nextLine();
        adminModel.numberOfCandidates(candidates);
    }
    public void candidateDetails(int candidateNumber){
        System.out.println("Enter the details of candidate "+candidateNumber+" ");
        System.out.print("Enter the candidate name: ");
        String candidateName=scanner.nextLine();
        System.out.print("Enter the candidate phone number: ");
        String candidatePhoneNumber=scanner.nextLine();
        System.out.print("Enter the email-id: ");
        String candidateEmailId=scanner.nextLine();
        System.out.print("Enter the candidate age: ");
        int candidateAge= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the candidate educational qualification: ");
        String candidateEducation= scanner.nextLine();
        System.out.print("Enter the candidates skill: ");
        String candidateSkill=scanner.nextLine();

        adminModel.addToQueue(candidateNumber,candidateName,candidatePhoneNumber,candidateEmailId,candidateAge,candidateEducation,candidateSkill);
    }
    public void candidatesDetailsAdded(){

        InterviewPanelData.getInstance().serializeCandidatesList();
        System.out.println(InterviewPanelData.getInstance().getCandidatesQueue());
        System.out.println("Candidates details added successfully");
        addInterviewerDetails();
    }

    public void addInterviewerDetails(){
        System.out.println("Interviewer details");
        System.out.print("Enter the name of the interviewer: ");
        String interviewerName=scanner.nextLine();
        System.out.print("Enter the role of the interviewer: ");
        String interviewerRole=scanner.nextLine();
        adminModel.addInterviewer(interviewerName,interviewerRole);
    }
    public void startInterview(){
        InterviewerView interviewerView=new InterviewerView();
        interviewerView.interviewInit();
    }
    public void nextInterviewSchedule(int option){
        adminModel.removeCandidates(option);
    }

    public void viewResults(ArrayList<Candidates>arrayList){
        System.out.println("Selected candidates are: ");
        System.out.println(arrayList);
    }
    public void exit(){
        System.out.println("Enter 1 to exit");
        int exit= scanner.nextInt();
        adminModel.exit(exit);
    }
    public void logOff(){
        System.out.println("Exiting...........");
    }
}
