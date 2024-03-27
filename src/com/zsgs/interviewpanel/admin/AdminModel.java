package com.zsgs.interviewpanel.admin;
import com.zsgs.interviewpanel.datalayer.InterviewPanelData;
import com.zsgs.interviewpanel.interviewer.InterviewerModel;
import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.model.Interviewer;
import com.zsgs.interviewpanel.validator.Validator;

public class AdminModel {
    private AdminView adminView;
    private Validator validator;
    public AdminModel(){

    }
    public AdminModel(AdminView adminView){
        this.adminView=adminView;
    }
    public void setUpAdmin(String username,String password){
        InterviewPanelData.getInstance().removeDefault(username,password);
    }
    public void onDefaultSuccess(String message){
        adminView=new AdminView();
        adminView.defaultRemoved(message);
    }
    public void defaultWrongUsername(String message){
        adminView.defaultWrongUsername(message);
    }
    public void defaultWrongPassword(String message){
        adminView.defaultWrongPassword(message);
    }
    public void adminAccountCreate(String username,String password){
        validator=new Validator();
        if(validator.usernameVerify(username)){
            if(validator.passwordVerify(password)){
                adminValidated(username, password);
            }else {
                adminInvalidPassword("Please enter a valid password");
            }
        }else {
            adminInvalidUsername("Please enter a valid username.");
        }
    }
    public void adminValidated(String username,String password){
        InterviewPanelData.getInstance().setAdmin(username,password);
        InterviewPanelData.getInstance().serializeAdminLoginDetails();
        adminView.accountCreationSuccess(username+" Account created successfully");
    }
    public void adminInvalidUsername(String message){
        adminView.invalidUsername(message);
    }
    public void adminInvalidPassword(String message){
        adminView.invalidPassword(message);
    }
    public void numberOfCandidates(int totalCandidates){
        for(int i=1;i<=totalCandidates;i++){
            adminView.candidateDetails(i);
        }
        adminView.candidatesDetailsAdded();
    }
    public void addToQueue(int candidateNumber,String candidateName,String candidatePhoneNumber,String candidateEmailId, int candidateAge, String candidateDegree, String candidateSkills) {
        Candidates candidates = new Candidates(candidateNumber, candidateName, candidatePhoneNumber, candidateEmailId, candidateAge, candidateDegree, candidateSkills);
        InterviewPanelData.getInstance().setCandidatesList(candidates);
        InterviewPanelData.getInstance().serializeCandidatesList();
        System.out.println("Candidates added");
        InterviewPanelData.getInstance().addCandidates(candidates);
    }
    public void addInterviewer(String interviewerName,String role){
        Interviewer interviewer=new Interviewer(interviewerName,role);
        InterviewPanelData.getInstance().addInterviewer(interviewer);
        adminView.startInterview();
    }
    public void removeCandidates(int option){
        InterviewerModel interviewerModel=new InterviewerModel();
        if(option==11) {
            Candidates candidates=InterviewPanelData.getInstance().getCandidatesQueue().poll();
            InterviewPanelData.getInstance().getInterviewers().get(0).setCandidatesArrayList(candidates);
            interviewerModel.startInterview();
            InterviewPanelData.getInstance().setSelectedCandidates(candidates);
            InterviewPanelData.getInstance().serializedSelectedCandidates();
        }else if(option==1){
            InterviewPanelData.getInstance().getCandidatesQueue().poll();
            interviewerModel.startInterview();
        }
    }
    public void exit(int option){
        if(option==1){
            adminView.logOff();
        }
        else{
            adminView.exit();
        }
    }
        //    }

//    public void interviewOver() {

 //   public void interviewedCount(int interviewerCount){
//        for(int i=0;i<interviewerCount;i++){
//            adminView.addInterviewerDetails();
//        }
   //     adminView.startInterview();
    }
//    public void setInterviewerDetails( String interviewerName,String interviewerRole) {
//        Interviewer interviewer = new Interviewer(interviewerName, interviewerRole);
//        InterviewPanelData.getInstance().addInterviewer(interviewer);
//    }
////    }
//    public void addNextCandidate(int index,int option){
//        Candidates candidates=InterviewPanelData.getInstance().getCandidatesQueue().remove();
//        if(option==11) {
//            InterviewPanelData.getInstance().getInterviewers().get(index).setAvailable(true);
//            InterviewPanelData.getInstance().getInterviewers().get(index).setCandidatesArrayList(candidates);
//
//            InterviewPanelData.getInstance().setSelectedCandidates(candidates);
//            nextInterviewer(index);
//        }
//        else if(option==1){
//            InterviewPanelData.getInstance().getInterviewers().get(index).setAvailable(true);
//            InterviewPanelData.getInstance().getInterviewers().get(index).setCandidatesArrayList(candidates);
//        }
//    }
//
//    }
//    public void viewResults(){
//        adminView.viewResults(InterviewPanelData.getInstance().getSelectedCandidates());
//    }

