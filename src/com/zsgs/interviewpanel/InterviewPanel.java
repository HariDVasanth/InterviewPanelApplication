package com.zsgs.interviewpanel;
import com.zsgs.interviewpanel.admin.AdminView;
import com.zsgs.interviewpanel.datalayer.InterviewPanelData;
public class InterviewPanel {
    private String appName="Interview Panel Application";
    private   String appVersion="0.0.1";
    private static InterviewPanel interviewPanel;

    public static InterviewPanel getInstance(){
        if(interviewPanel==null){
            interviewPanel=new InterviewPanel();
        }
        return interviewPanel;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void init(){
        AdminView adminView=new AdminView();
        adminView.adminInit();
    }

    public static void main(String[] args) {
        InterviewPanelData.getInstance().deserializeAdminLoginDetails();
        InterviewPanelData.getInstance().deserializedCandidatesList();
        InterviewPanelData.getInstance().deserializedSelectedCandidatesList();
      //  InterviewPanelData.getInstance().setDefault();
        InterviewPanel.getInstance().init();
    }
}
