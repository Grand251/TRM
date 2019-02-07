package trm.dao.executiveworkflowstatus;

import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;

public class ExecutiveWorkflowStatus {

	/*
	 *  CREATE TABLE EXECUTIVE_WORKFLOW_STATUS ( 
	   	executive_workflow_status_id number(5) primary key, 
	   	training_request_id number(5) CONSTRAINT ews_tr_fk references training_request(training_request_id) unique not null, 
	   	sent_invitations number(2), 
	   	completed_skillport_enrollment number(2), 
		assessments_recorded number(2), 
		vendor_training_clearance number(2), 
		completed_feedback number(2), 
		training_completed number(2) );
	 */
	
	int executiveWorkflowStatusId;
	TrainingRequest trainingRequest;
	int invitationsSent;
	int skillportEnrollmentsCompleted;
	int assessmentsRecorded;
	int vendorTrainingClearance;
	int feedbackCompleted;
	int trainingCompleted;
	Employee executiveWorkflowStatusExecutive;
	
	
	public int getExecutiveWorkflowStatusId() {
		return executiveWorkflowStatusId;
	}
	public void setExecutiveWorkflowStatusId(int executiveWorkflowStatusId) {
		this.executiveWorkflowStatusId = executiveWorkflowStatusId;
	}
	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
	}
	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
	}
	public int getInvitationsSent() {
		return invitationsSent;
	}
	public void setInvitationsSent(int invitationsSent) {
		this.invitationsSent = invitationsSent;
	}
	public int getSkillportEnrollmentsCompleted() {
		return skillportEnrollmentsCompleted;
	}
	public void setSkillportEnrollmentsCompleted(int skillportEnrollmentsCompleted) {
		this.skillportEnrollmentsCompleted = skillportEnrollmentsCompleted;
	}
	public int getAssessmentsRecorded() {
		return assessmentsRecorded;
	}
	public void setAssessmentsRecorded(int assessmentsRecorded) {
		this.assessmentsRecorded = assessmentsRecorded;
	}
	public int getVendorTrainingClearance() {
		return vendorTrainingClearance;
	}
	public void setVendorTrainingClearance(int vendorTrainingClearance) {
		this.vendorTrainingClearance = vendorTrainingClearance;
	}
	public int getFeedbackCompleted() {
		return feedbackCompleted;
	}
	public void setFeedbackCompleted(int feedbackCompleted) {
		this.feedbackCompleted = feedbackCompleted;
	}
	public int getTrainingCompleted() {
		return trainingCompleted;
	}
	public void setTrainingCompleted(int trainingCompleted) {
		this.trainingCompleted = trainingCompleted;
	}
	public Employee getExecutiveWorkflowStatusExecutive() {
		return executiveWorkflowStatusExecutive;
	}
	public void setExecutiveWorkflowStatusExecutive(Employee executiveWorkflowStatusExecutive) {
		this.executiveWorkflowStatusExecutive = executiveWorkflowStatusExecutive;
	}
	
	
}
	
