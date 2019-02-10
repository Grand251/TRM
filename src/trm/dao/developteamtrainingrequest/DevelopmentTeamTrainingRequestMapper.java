package trm.dao.developteamtrainingrequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

public class DevelopmentTeamTrainingRequestMapper implements RowMapper<DevelopmentTeamTrainingRequest>
{
    	public DevelopmentTeamTrainingRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException 
	{
    	    	DevelopmentTeamTrainingRequest request = new DevelopmentTeamTrainingRequest();
		
		request.setDttTrainingId(resultSet.getInt(1));
		
		TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(resultSet.getInt(2));
		request.setTrainingRequest(trainingRequest);
		
		Employee trainer = new EmployeeCRUDService().getEmployeeById(resultSet.getInt(3));
		request.setConfirmedTrainer(trainer);
		
		request.setTrainerApprovalMail(resultSet.getString(4));
		request.setTrainerManagerApprovalMail(resultSet.getString(5));
		
		TrainingSchedule schedule = new TrainingScheduleCRUDService().getTrainingScheduleById(resultSet.getString(6)); 
		request.setTrainingSchedule(schedule);
		
		Employee executive = new EmployeeCRUDService().getEmployeeById(resultSet.getInt(7));
		request.setExecutive(executive);
		
		request.setStatus(resultSet.getInt(8));
		request.setDescriptionOfStatus(resultSet.getString(9));
		
		return request;
	}
}
