package trm.dao.trainingparticipant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.trainingrequest.TrainingRequestMapper;

public class TrainingParticipantCRUD
{
    private JdbcTemplate jTemp;
    
    public int insertTrainingParticipant(TrainingParticipant trainingParticipant)
    {
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	
		jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		
		NamedParameterJdbcTemplate j = new NamedParameterJdbcTemplate(jTemp);
		
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(
				"peid", trainingParticipant.getParticipantEmployee().getEmployee_id())
    			.addValue("tsa",trainingParticipant.getTrainingSessionAttended().getTrainingRequestId());
											
		
		j.update("Insert into training_participants(TRAINING_PARTICIPANT_ID,PARTICIPANT_EMPLOYEE_ID, TRAINING_SESSION_ATTENDED)"
				+ "  values(training_participant_seq.nextval,:peid,:tsa)" , 
				 parameters,
				  keyHolder, new String[]{"TRAINING_PARTICIPANT_ID"}
				 );
		
		int key = keyHolder.getKey().intValue();
		System.out.println(key);
		
		return key;
    }
    
    public int deleteTrainingParticipant(int trainingParticipantId)
    {
	jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	int numberOfRowsEffected = jTemp.update("Delete from training_participants where training_participant_id = ?", 
											  new Object[] {trainingParticipantId});
	return numberOfRowsEffected;
    }
    
    public int updateTrainingParticipant(int trainingParticipantId, int newEmployeeId, int newTrainingRequestId)
    {
	jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	int numberOfRowsEffected = jTemp.update("Update training_participants set participant_employee_id = ?, training_session_attended = ? where training_participant_id = ?",
		  new Object[] {newEmployeeId, newTrainingRequestId, trainingParticipantId});
	
	return numberOfRowsEffected;

    }
    
   
    public TrainingParticipant getTrainingParticipantByEmployeeId(int trainingEmployeeId)
    {
	jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	TrainingParticipant trainingParticipant = jTemp.queryForObject("Select * from training_participants where participant_employee_id = ?",
											   				new Object[]{trainingEmployeeId}, new TrainingParticipantMapper());
	return trainingParticipant;
    }
    
    
    public List<TrainingParticipant> getAllTrainingParticipants()
    {
	jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	List<TrainingParticipant> trainingParticipantList = jTemp.query("Select * from training_participants" , new TrainingParticipantMapper());
	return trainingParticipantList;
    }
    
    
    public List<TrainingParticipant> getAllParticipantsByRequest(int trainingRequestId)
    {
	jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	List<TrainingParticipant> trainingParticipantList = jTemp.query("Select * from training_participants where training_session_attended = ?" , new Object[] {trainingRequestId}, new TrainingParticipantMapper());
	
	return trainingParticipantList;
    }
    
    
    public static void main(String[] args)
    {

		TrainingParticipantCRUD crud = new TrainingParticipantCRUD();
		
		TrainingParticipant participant = new TrainingParticipant();
		Employee employee = new EmployeeCRUDService().getEmployeeById(1000000);
		participant.setParticipantEmployee(employee);
		
		TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(10004);
		participant.setTrainingSessionAttended(trainingRequest);
		
		crud.insertTrainingParticipant(participant);
	
	//crud.deleteTrainingParticipant(participant.getParticipantEmployee().getEmployee_id());
	
	//crud.updateTrainingParticipant(10000, 1000001, 10005);
	
	//System.out.println(crud.getAllTrainingParticipants().get(0).getParticipantEmployee().getEmployee_id());
    }
}
