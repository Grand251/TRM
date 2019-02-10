package trm.dao.trainerrequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

public class TrainerRequestMapper implements RowMapper<TrainerRequest>
{
    public TrainerRequest mapRow(ResultSet resultSet, int arg1) throws SQLException
    {
	TrainerRequest trainerRequest = new TrainerRequest();
	
	trainerRequest.setTrainerRequestId(resultSet.getInt(1));
	trainerRequest.setRequestSentDate(resultSet.getTimestamp(2));
	
	Employee trainer = new EmployeeCRUDService().getEmployeeById(resultSet.getInt(3));
	trainerRequest.setTrainer(trainer);
	
	TrainingSchedule trainingSchedule = new TrainingScheduleCRUDService().getTrainingScheduleById(resultSet.getString(4));
	trainerRequest.setTrainingSchedule(trainingSchedule);
	
	trainerRequest.setTopic(resultSet.getString(5));
	trainerRequest.setComments(resultSet.getString(6));
	trainerRequest.setResponse(resultSet.getString(7));
	trainerRequest.setActiveStatus(resultSet.getInt(8));
	
	return trainerRequest;
    }
	
}
