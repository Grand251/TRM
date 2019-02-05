package trm.dao.executiveworkflowstatus;

import java.util.List;

import trm.dao.DAOJDBCTemplate;
import trm.dao.trainingrequest.TrainingRequest;


public class ExecutiveWorkflowStatusCRUD {

	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatus(){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status", new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusById(int executiveWorkflowStatusId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE executive_workflow_status_id=?", 
				new Object[]{executiveWorkflowStatusId}, new ExecutiveWorkflowStatusMapper());
	}
	
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
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByInvitationsSent(int invitationsSent){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE sent_invitations=?", 
				new Object[]{invitationsSent}, new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusByTrainingRequest(TrainingRequest trainingRequest){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE training_request_id=?", 
				new Object[]{trainingRequest.getTrainingRequestId()}, new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusByTrainingRequest(int trainingRequestId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE training_request_id=?", 
				new Object[]{trainingRequestId}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusBySkillportEnrollmentCompleted(int skillportEnrollmentCompleted){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE sent_invitations=?", 
				new Object[]{skillportEnrollmentCompleted}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByAssessmentsRecorded(int assessmentRecorded){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE assessments_recorded=?", 
				new Object[]{assessmentRecorded}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByVendorTrainingClearance(int vendorTrainingClearance){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE vendor_training_clearance=?", 
				new Object[]{vendorTrainingClearance}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByFeedbackCompleted(int feedbackCompleted){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE completed_feedback=?", 
				new Object[]{feedbackCompleted}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByTrainingCompleted(int trainingCompleted){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE training_completed=?", 
				new Object[]{trainingCompleted}, new ExecutiveWorkflowStatusMapper());
	}
		
	
	public int ExecutiveWorkflowStatus(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("INSERT INTO executive_workflow_status VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[]{"executive_workflow_status_seq.nextval",
						executiveWorkflowStatus.getTrainingRequest().getTrainingRequestId(),
						executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getTrainingCompleted(),
		});
	}
	
	public int updateExecutiveWorkflowStatus(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET sent_invitations=?, "
				+ "completed_skillport_enrollment=?, "
				+ "assessments_recorded=?, "
				+ "vendor_training_clearance=?, "
				+ "completed_feedback=?, "
				+ "training_completed=?, "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getTrainingCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateInvitationsSent(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET sent_invitations=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateSkillportEnrollment(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_skillport_enrollment=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateAssessmentsRecorded(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET assessments_recorded=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateVendorTrainingClearance(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET vendor_training_clearance=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateFeedbackCompleted(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_feedback=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateTrainingCompleted(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET training_completed=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getTrainingCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	

	
	public int deleteExecutiveWorkflowStatus(int executiveWorkflowStatusId) {
		return DAOJDBCTemplate.getJdbcTemplate().update("DELETE FROM executive_workflow_status"
				+ " WHERE executive_workflow_status_id=?",
				new Object[] {executiveWorkflowStatusId});
	}
}
