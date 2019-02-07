package trm.dao.trainingparticipant;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;

public class TrainingParticipantMapper implements RowMapper<TrainingParticipant>
{
        public  TrainingParticipant mapRow(ResultSet result, int arg1) throws SQLException 
	{
		TrainingParticipant participant = new TrainingParticipant();
		
		participant.setTrainingParticipantId(result.getInt(1));
		
		Employee participantEmployee = new EmployeeCRUDService().getEmployeeById(result.getInt(2));
		participant.setParticipantEmployee(participantEmployee);
		
		TrainingRequest trainingSession = new TrainingRequestCRUD().getTrainingRequestById(result.getInt(3));
		participant.setTrainingSessionAttended(trainingSession);
		
		return participant;
	}
}
