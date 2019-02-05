package trm.dao.executiveworkflowstatus;

import java.util.List;

import trm.dao.DAOJDBCTemplate;
import trm.dao.internaltrainer.InternalTrainer;
import trm.dao.internaltrainer.InternalTrainerMapper;


public class ExecutiveWorkflowStatusCRUD {

	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatus(){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM executive_workflow_status", new ExecutiveWorkflowStatusMapper());
	}
	
	public ExecutiveWorkflowStatus getInternalTrainerById(int executiveWorkflowStatusId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM executive_workflow_status "
				+ "WHERE executive_workflow_status_id=?", 
				new Object[]{executiveWorkflowStatusId}, new ExecutiveWorkflowStatusMapper());
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
	
	public int deleteExecutiveWorkflowStatus(int executiveWorkflowStatusId) {
		return DAOJDBCTemplate.getJdbcTemplate().update("DELETE FROM executive_workflow_status"
				+ " WHERE executive_workflow_status_id=?",
				new Object[] {executiveWorkflowStatusId});
	}
}
