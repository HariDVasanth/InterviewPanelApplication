// InterviewerView.java
package com.zsgs.interviewpanel.interviewer;
import com.zsgs.interviewpanel.admin.AdminView;
import com.zsgs.interviewpanel.datalayer.InterviewPanelData;

import java.util.Scanner;

public class InterviewerView {
    Scanner scanner = new Scanner(System.in);
    private InterviewerModel interviewerModel;

    public InterviewerView() {
        interviewerModel = new InterviewerModel(this);
    }

    public void interviewInit() {
        System.out.println("Interview process has begun");
        interviewerModel.startInterview();
    }

    public void interviewPanel() {
        System.out.println("Is the interview over?");
        System.out.println("Press 11 if interview is over and candidate selected / 1 if interview over / 0 if not over");
        int option = scanner.nextInt();
        scanner.nextLine();
        AdminView adminView = new AdminView();
        if (option == 1 || option == 11) {
            System.out.println("Interview over");
            adminView.nextInterviewSchedule(option);
        } else if (option == 0) {
            System.out.println("on and on and on and on");
            interviewerModel.startInterview();
        }
        System.out.println();
    }
//    }
//    public void resultTest() {
//        System.out.println(InterviewPanelData.getInstance().getSelectedCandidates());
//    }
}
