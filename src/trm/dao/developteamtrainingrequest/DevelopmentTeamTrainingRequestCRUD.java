package trm.dao.developteamtrainingrequest;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

public class DevelopmentTeamTrainingRequestCRUD
{
    private JdbcTemplate jTemp = new DAOJDBCTemplate().getJdbcTemplate();
    
    public int insertDevelopmentTeamTrainingRequest(DevelopmentTeamTrainingRequest dttRequest)
    {
	int numberOfRowsEffected = jTemp.update("Insert into develop_team_training_request values(dev_team_training_req_seq.nextval,?,?,?,?,?,?,?,?)" , 
												  new Object[] {dttRequest.getTrainingRequest().getTrainingRequestId(),
													        dttRequest.getConfirmedTrainer().getEmployee_id(),
													        dttRequest.getTrainerApprovalMail(),
													        dttRequest.getTrainerManagerApprovalMail(),
													        dttRequest.getTrainingSchedule().getTraining_schedule_id(),
													        dttRequest.getExecutive().getEmployee_id(),
													        dttRequest.getStatus(),
													        dttRequest.getDescriptionOfStatus()});
	return numberOfRowsEffected;
	
    }
    
    public int deleteDevelopmentTeamTrainingRequest(int dttRequestId)
    {
	int numOfRowsEffected = jTemp.update("Update develop_team_training_request set status = -1 where dtt_training_id = ?", 
			new Object[] {dttRequestId});
	return numOfRowsEffected;
    }
    
    public int updateDTTStatusById(int dttRequestId, int newStatus)
    {
	int numOfRowsEffected = jTemp.update("Update develop_team_training_request set status = ? where dtt_training_id = ?",
					      new Object[] {newStatus, dttRequestId});
	return numOfRowsEffected;				      
    }
    
    public DevelopmentTeamTrainingRequest getDevelopmentTeamTrainingRequestById(int dttRequestId)
    {
	DevelopmentTeamTrainingRequest dttRequest = jTemp.queryForObject("Select * from develop_team_training_request where dtt_training_id = ? AND status >= 0",
								new Object[] {dttRequestId}, new DevelopmentTeamTrainingRequestMapper());
	return dttRequest;
    }
    
    public List<DevelopmentTeamTrainingRequest> getAllDTTRequestForExecutive(Employee executive)
    {
	List<DevelopmentTeamTrainingRequest> dttRequestList = jTemp.query("Select * from develop_team_training_request where esecutive_id = ? AND status >= 0",
								new Object[] {executive.getEmployee_id()}, new DevelopmentTeamTrainingRequestMapper());
	return dttRequestList;
    }
    
    public List<DevelopmentTeamTrainingRequest> getAllDTTRequestForSPOC(int spocId)
    {
	List<DevelopmentTeamTrainingRequest> dttRequestList = jTemp.query("Select * " + 
									  "from develop_team_training_request dr " + 
									  "join training_request tr " + 
									  "on tr.training_request_id = dr.training_request_id AND tr.status >= 0 AND tr.request_project_spoc = ?",
									  new Object[] {spocId}, new DevelopmentTeamTrainingRequestMapper());
	return dttRequestList;
	
    }
    
    public List<DevelopmentTeamTrainingRequest> getAllDTTRequestForPM(int projectManagerId)
    {
	List<DevelopmentTeamTrainingRequest> dttRequestList = jTemp.query("Select * " + 
		  							  "from develop_team_training_request dr " + 
		  							  "join training_request tr " + 
		  							  "on tr.training_request_id = dr.training_request_id AND tr.status >= 0 AND tr.requester_id = ?",
		  							  new Object[] {projectManagerId}, new DevelopmentTeamTrainingRequestMapper());
	return dttRequestList;
    }
    
    public List<DevelopmentTeamTrainingRequest> getAllDTTRequestBySPOCandStatus(int spocId, int status)
    {
	List<DevelopmentTeamTrainingRequest> dttRequestList = jTemp.query("Select * " + 
		  "from develop_team_training_request dr " + 
		  "join training_request tr " + 
		  "on tr.training_request_id = dr.training_request_id AND dr.status = ? AND tr.request_project_spoc = ?",
		  new Object[] {spocId}, new DevelopmentTeamTrainingRequestMapper());
	return dttRequestList;
    }
    
    public static void main(String[] args)
    {
	
	DevelopmentTeamTrainingRequestCRUD dttCRUD = new DevelopmentTeamTrainingRequestCRUD();
	List<DevelopmentTeamTrainingRequest> dttList = dttCRUD.getAllDTTRequestForPM(1000070);
	
	for(DevelopmentTeamTrainingRequest dttRequest : dttList)
	{
	    System.out.println(dttRequest.getDttTrainingId() + " " + dttRequest.getTrainingRequest().getTrainingRequestId() + " "
		    		+ dttRequest.getConfirmedTrainer().getEmployee_id() + " " + dttRequest.getTrainerApprovalMail() + " "
		    		+ dttRequest.getTrainerManagerApprovalMail() + " " + dttRequest.getTrainingSchedule().getTraining_schedule_id() + " "
		    		+ dttRequest.getExecutive().getEmployee_id() + " " + dttRequest.getStatus() + " " + dttRequest.getDescriptionOfStatus());
	    
	}
	
	/*
	DevelopmentTeamTrainingRequest request = new DevelopmentTeamTrainingRequest();
	
	TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(10094);
	request.setTrainingRequest(trainingRequest);
	
	Employee confirmedTrainer = new EmployeeCRUDService().getEmployeeById(1000031);
	request.setConfirmedTrainer(confirmedTrainer);
	
	request.setTrainerApprovalMail("Hello");
	request.setTrainerManagerApprovalMail("Hello");
	
	TrainingSchedule schedule = new TrainingScheduleCRUDService().getTrainingScheduleById(10114);
	request.setTrainingSchedule(schedule);
	
	Employee executive = new EmployeeCRUDService().getEmployeeById(1000039);
	request.setExecutive(executive);
	
	request.setStatus(0);
	request.setDescriptionOfStatus("Started");
	
	System.out.println(dttCRUD.insertDevelopmentTeamTrainingRequest(request));
	*/
	
	//System.out.println(dttCRUD.deleteDevelopmentTeamTrainingRequest(10000));
	
	//dttCRUD.updateDTTStatusById(10000, 1);
	
	//System.out.println(dttCRUD.getDevelopmentTeamTrainingRequestById(10000).getConfirmedTrainer().getFirst_name());
    }
}
