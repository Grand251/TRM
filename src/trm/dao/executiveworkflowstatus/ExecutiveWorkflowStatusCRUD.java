package trm.dao.executiveworkflowstatus;

import java.util.List;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;


public class ExecutiveWorkflowStatusCRUD {

	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatus(){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status", new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusById(int executiveWorkflowStatusId){
		return new DAOJDBCTemplate().getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE executive_workflow_status_id=?", 
				new Object[]{executiveWorkflowStatusId}, new ExecutiveWorkflowStatusMapper());
	}
	

	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByInvitationsSent(int invitationsSent){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE sent_invitations=?", 
				new Object[]{invitationsSent}, new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusByTrainingRequest(TrainingRequest trainingRequest){
		return new DAOJDBCTemplate().getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE training_request_id=?", 
				new Object[]{trainingRequest.getTrainingRequestId()}, new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatusByTrainingRequest(int trainingRequestId){
		return new DAOJDBCTemplate().getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE training_request_id=?", 
				new Object[]{trainingRequestId}, new ExecutiveWorkflowStatusMapper());
	}
	
	
	
	
	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatusByExec(Employee exec){
		return getAllExecutiveWorkflowStatusByExec(exec.getEmployee_id());
	}
	
	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatusByExec(int execId){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE executive_id=?", new Object[]{execId},
				new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusBySkillportEnrollmentCompleted(int skillportEnrollmentCompleted){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE sent_invitations=?", 
				new Object[]{skillportEnrollmentCompleted}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByAssessmentsRecorded(int assessmentRecorded){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE assessments_recorded=?", 
				new Object[]{assessmentRecorded}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByVendorTrainingClearance(int vendorTrainingClearance){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE vendor_training_clearance=?", 
				new Object[]{vendorTrainingClearance}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByFeedbackCompleted(int feedbackCompleted){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE completed_feedback=?", 
				new Object[]{feedbackCompleted}, new ExecutiveWorkflowStatusMapper());
	}
	
	public List<ExecutiveWorkflowStatus> getExecutiveWorkflowStatusByTrainingCompleted(int trainingCompleted){
		return new DAOJDBCTemplate().getJdbcTemplate().query("SELECT * FROM executive_workflow_status "
				+ "WHERE training_completed=?", 
				new Object[]{trainingCompleted}, new ExecutiveWorkflowStatusMapper());
	}
		
	
	public int insertExecutiveWorkflowStatus(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		int executiveId = 0;
		int trainingRequestId = 0;
		
		if(executiveWorkflowStatus.getTrainingRequest()!=null)
			trainingRequestId = executiveWorkflowStatus.getTrainingRequest().getTrainingRequestId();
		
		if(executiveWorkflowStatus.getExecutiveWorkflowStatusExecutive()!=null)
			executiveId = executiveWorkflowStatus.getExecutiveWorkflowStatusExecutive().getEmployee_id();
		
		return new DAOJDBCTemplate().getJdbcTemplate().update("INSERT INTO executive_workflow_status VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[]{"executive_workflow_status_seq.nextval",
						(trainingRequestId!=0) ? trainingRequestId : null,
						executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getTrainingCompleted(),
						(executiveId!=0) ? executiveId : null
		});
	}
	
	public int updateExecutiveWorkflowStatus(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET sent_invitations=?, "
				+ "completed_skillport_enrollment=?, "
				+ "assessments_recorded=?, "
				+ "vendor_training_clearance=?, "
				+ "completed_feedback=?, "
				+ "training_completed=?, "
				+ "executive_id=?"
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getTrainingCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusExecutive().getEmployee_id(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateInvitationsSent(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET sent_invitations=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getInvitationsSent(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateSkillportEnrollment(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_skillport_enrollment=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getSkillportEnrollmentsCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateAssessmentsRecorded(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET assessments_recorded=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getAssessmentsRecorded(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateVendorTrainingClearance(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET vendor_training_clearance=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getVendorTrainingClearance(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateFeedbackCompleted(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_feedback=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getFeedbackCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateTrainingCompleted(ExecutiveWorkflowStatus executiveWorkflowStatus) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET training_completed=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{executiveWorkflowStatus.getTrainingCompleted(),
						executiveWorkflowStatus.getExecutiveWorkflowStatusId()});
	}
	
	public int updateInvitationsSent(int invitationsSent, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET sent_invitations=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{invitationsSent,	executiveWorkflowStatusId});
	}
	
	public int updateSkillportEnrollment(int skillportEnrollmentsCompleted, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_skillport_enrollment=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{skillportEnrollmentsCompleted,	executiveWorkflowStatusId});
	}
	
	public int updateAssessmentsRecorded(int assessmentsRecorded, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET assessments_recorded=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{assessmentsRecorded,	executiveWorkflowStatusId});
	}
	
	public int updateVendorTrainingClearance(int vendorClearanceTraining, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET vendor_training_clearance=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{vendorClearanceTraining,	executiveWorkflowStatusId});
	}
	
	public int updateFeedbackCompleted(int feedbackCompleted, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET completed_feedback=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{feedbackCompleted,	executiveWorkflowStatusId});
	}
	
	public int updateTrainingCompleted(int trainingCompleted, int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("UPDATE executive_workflow_status "
				+ "SET training_completed=? "
				+ " WHERE executive_workflow_status_id= ?",
				new Object[]{trainingCompleted,	executiveWorkflowStatusId});
	}
	

	
	public int deleteExecutiveWorkflowStatus(int executiveWorkflowStatusId) {
		return new DAOJDBCTemplate().getJdbcTemplate().update("DELETE FROM executive_workflow_status"
				+ " WHERE executive_workflow_status_id=?",
				new Object[] {executiveWorkflowStatusId});
	}
}
