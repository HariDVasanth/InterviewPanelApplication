package com.zsgs.interviewpanel.interviewer;

import com.zsgs.interviewpanel.admin.AdminView;
import com.zsgs.interviewpanel.datalayer.InterviewPanelData;


public class InterviewerModel {
    private InterviewerView interviewerView;

    public InterviewerModel() {
        interviewerView = new InterviewerView();
    }

    public InterviewerModel(InterviewerView interviewerView) {
        this.interviewerView = interviewerView;
    }
    public void startInterview(){
        while (!InterviewPanelData.getInstance().getCandidatesQueue().isEmpty()) {
            interviewerView.interviewPanel();
        }
        AdminView adminView=new AdminView();
        adminView.viewResults(InterviewPanelData.getInstance().getSelectedCandidates());
    }
}

//package com.zsgs.interviewpanel.interviewer;
//import com.zsgs.interviewpanel.admin.AdminModel;
//import com.zsgs.interviewpanel.admin.AdminView;
//import com.zsgs.interviewpanel.datalayer.InterviewPanelData;
//import com.zsgs.interviewpanel.model.Candidates;
//
//public class InterviewerModel {
//    private InterviewerView interviewerView;
//    public InterviewerModel(){
//        InterviewerModel interviewerModel=new InterviewerModel();
//    }
//    public InterviewerModel(InterviewerView interviewerView){
//        this.interviewerView=interviewerView;
//    }
//    public void initialProcess(){
//        for(int interviewer=0;interviewer<InterviewPanelData.getInstance().getInterviewers().size();interviewer++){
//            Candidates candidates= InterviewPanelData.getInstance().getCandidatesQueue().remove();
//            //String name=candidates.getCandidateName();
//            InterviewPanelData.getInstance().getInterviewers().get(interviewer).setCandidatesArrayList(candidates);
//            //String interviewerName=InterviewPanelData.getInstance().getInterviewers().get(i).getInterviewerName();
//            InterviewPanelData.getInstance().getInterviewers().get(interviewer).setAvailable(false);
//        }
//        interviewProcess(0);
//    }
//    public void interviewProcess(int interviewer){
//        while (!InterviewPanelData.getInstance().getCandidatesQueue().isEmpty()){
//            int i;
//            for( i=interviewer;i<InterviewPanelData.getInstance().getInterviewers().size();i++){
//                interviewerView.interviewPanel(InterviewPanelData.getInstance().getInterviewers().get(i),i);
//            }
//            if(interviewer==InterviewPanelData.getInstance().getInterviewers().size()-1){
//                interviewer=0;
//            }
//        }
//        AdminModel adminModel=new AdminModel();
//        adminModel.viewResults();
//    }
//
////    public void nextCandidate(int interviewer,int option){
////        if(option==11) {
////            for(Candidates candidates:InterviewPanelData.getInstance().getInterviewers().get(interviewer).getCandidatesArrayList()){
////                if(candidates.getInterviewStatus()==null){
////                    candidates.setInterviewStatus("Selected");
////                    InterviewPanelData.getInstance().setSelectedCandidates(candidates);
////                }
////            }
////            InterviewPanelData.getInstance().getInterviewers().get(interviewer).setAvailable(true);
////            interviewProcess(interviewer);
////        } else if (option==1) {
////
////            InterviewPanelData.getInstance().getInterviewers().get(interviewer).setAvailable(true);
////            interviewProcess(interviewer);
////        }else if(option==0){
////            if(interviewer==0 && InterviewPanelData.getInstance().getInterviewers().size()>2){
////                interviewProcess(interviewer+1);
////            } else if (interviewer==InterviewPanelData.getInstance().getInterviewers().size()-1) {
////                interviewProcess(0);
////            }
////        }
////    }
//}
