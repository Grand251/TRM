package trm.dao.trainingparticipant;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

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
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	int numberOfRowsEffected = jTemp.update("Insert into training_participants values(training_participant_seq.nextval,?,?)" , 
											  new Object[] {trainingParticipant.getParticipantEmployee().getEmployee_id(),
												        trainingParticipant.getTrainingSessionAttended().getTrainingRequestId()});
	return numberOfRowsEffected;
    }
    
    public int deleteTrainingParticipant(int trainingParticipantId)
    {
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	int numberOfRowsEffected = jTemp.update("Delete from training_participants where training_participant_id = ?", 
											  new Object[] {trainingParticipantId});
	return numberOfRowsEffected;
    }
    
    public int updateTrainingParticipant(int trainingParticipantId, int newEmployeeId, int newTrainingRequestId)
    {
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	int numberOfRowsEffected = jTemp.update("Update training_participants set participant_employee_id = ?, training_session_attended = ? where training_participant_id = ?",
		  new Object[] {newEmployeeId, newTrainingRequestId, trainingParticipantId});
	
	return numberOfRowsEffected;

    }
    
   
    public TrainingParticipant getTrainingParticipantByEmployeeId(int trainingEmployeeId)
    {
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	TrainingParticipant trainingParticipant = jTemp.queryForObject("Select * from training_participants where participant_employee_id = ?",
											   				new Object[]{trainingEmployeeId}, new TrainingParticipantMapper());
	return trainingParticipant;
    }
    
    
    public List<TrainingParticipant> getAllTrainingParticipants()
    {
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	List<TrainingParticipant> trainingParticipantList = jTemp.query("Select * from training_participants" , new TrainingParticipantMapper());
	return trainingParticipantList;
    }
    
    
    public List<TrainingParticipant> getAllParticipantsByRequest(int trainingRequestId)
    {
	jTemp = DAOJDBCTemplate.getJdbcTemplate();
	List<TrainingParticipant> trainingParticipantList = jTemp.query("Select * from training_participants where training_session_attended = ?" , new Object[] {trainingRequestId}, new TrainingParticipantMapper());
	
	return trainingParticipantList;
    }
    
    
    public static void main(String[] args)
    {
	/*
	TrainingParticipantCRUD crud = new TrainingParticipantCRUD();
	
	TrainingParticipant participant = new TrainingParticipant();
	Employee employee = new EmployeeCRUDService().getEmployeeById(1000000);
	participant.setParticipantEmployee(employee);
	
	TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(10004);
	participant.setTrainingSessionAttended(trainingRequest);
	
	//crud.insertTrainingParticipant(participant);
	
	//crud.deleteTrainingParticipant(participant.getParticipantEmployee().getEmployee_id());
	
	//crud.updateTrainingParticipant(10000, 1000001, 10005);
	
	//System.out.println(crud.getAllTrainingParticipants().get(0).getParticipantEmployee().getEmployee_id());
	 */
    }
}
