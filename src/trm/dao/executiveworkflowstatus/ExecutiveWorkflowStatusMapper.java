package trm.dao.executiveworkflowstatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;

/*
 *  CREATE TABLE EXECUTIVE_WORKFLOW_STATUS
(
  executive_workflow_status_id number(5) primary key,
  training_request_id number(5) CONSTRAINT ews_tr_fk references training_request(training_request_id) unique not null,
  sent_invitations number(2),
  completed_skillport_enrollment number(2),
  assessments_recorded number(2),
  vendor_training_clearance number(2),
  completed_feedback number(2),
  training_completed number(2),
  executive_id number(7) CONSTRAINT ews_exec_fk references employee(employee_id)
);
 */


public class ExecutiveWorkflowStatusMapper implements RowMapper<ExecutiveWorkflowStatus>{

	@Override
	public ExecutiveWorkflowStatus mapRow(ResultSet ewfResultSet, int rowNum) throws SQLException {
		ExecutiveWorkflowStatus ewf = new ExecutiveWorkflowStatus();
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		
		ewf.setExecutiveWorkflowStatusId(ewfResultSet.getInt(1));
		
		TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(ewfResultSet.getInt(2));
		ewf.setTrainingRequest(trainingRequest);
		
		ewf.setInvitationsSent(ewfResultSet.getInt(3));
		ewf.setSkillportEnrollmentsCompleted(ewfResultSet.getInt(4));
		ewf.setAssessmentsRecorded(ewfResultSet.getInt(5));
		ewf.setVendorTrainingClearance(ewfResultSet.getInt(6));
		ewf.setFeedbackCompleted(ewfResultSet.getInt(7));
		ewf.setTrainingCompleted(ewfResultSet.getInt(8));
		
		Employee executive = eCRUD.getEmployeeById(ewfResultSet.getInt(9));
		ewf.setExecutiveWorkflowStatusExecutive(executive);
		
		return ewf;
	}

}
