package trm.dao.trainerrequest;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

public class TrainerRequestCRUD
{
    private JdbcTemplate jTemp = new DAOJDBCTemplate().getJdbcTemplate();
    
    public int insertTrainerRequest(TrainerRequest trainerRequest)
    {
	int numberOfRowsEffected = jTemp.update("Insert into trainer_request values(trainer_request_id_seq.nextval, ?, ?, ?, ?, ?, ?)",
						new Object[] {trainerRequest.getRequestSentDate(), trainerRequest.getTrainer().getEmployee_id(),
							      trainerRequest.getTrainingSchedule().getTraining_schedule_id(), trainerRequest.getTopic(),
							      trainerRequest.getComments(), trainerRequest.getResponse()});
	return numberOfRowsEffected;
    }
    
    public int deleteTrainerRequest(int trainerRequestId)
    {
	int numberOfRowsEffected = jTemp.update("Update trainer_request set active_status = -1 where trainer_request_id = ?",
						new Object[] {trainerRequestId});
	return numberOfRowsEffected;
    }
    
    public int updateTrainerRequest(TrainerRequest trainerRequest)
    {
	int numberOfRowsEffected = jTemp.update("Update trainer_request set request_sent_date = ?, trainer_id = ?, schedule_id = ?, topic = ?,"
						+ " comments = ?, response = ?, active_status = ? where trainer_request_id = ?",
						new Object[] {trainerRequest.getRequestSentDate(), trainerRequest.getTrainer().getEmployee_id(),
						trainerRequest.getTrainingSchedule().getTraining_schedule_id(), trainerRequest.getTopic(),
						trainerRequest.getComments(), trainerRequest.getResponse(), trainerRequest.getActiveStatus(),
						trainerRequest.getTrainerRequestId()});
	return numberOfRowsEffected;
    }
    
    public TrainerRequest getTrainerRequestById(int trainerRequestId)
    {
	TrainerRequest trainerRequest = jTemp.queryForObject("Select * from trainer_request where active_status = 1 AND trainer_request_id = ?", 
							     new Object[] {trainerRequestId}, new TrainerRequestMapper());
	return trainerRequest;
    }
    
    public List<TrainerRequest> getAllTrainerRequest()
    {
	List<TrainerRequest> trainerRequestList = jTemp.query("Select * from trainer_request where active_status = 1", new TrainerRequestMapper());
        return trainerRequestList;
    }
    
    public List<TrainerRequest> getAllTrainerRequestForTrainer(Employee trainer)
    {
	List<TrainerRequest> trainerRequestList = jTemp.query("Select * from trainer_request where trainer_id = ?",
							 new Object[] {trainer.getEmployee_id()}, new TrainerRequestMapper());
	return trainerRequestList;
    }
    
    public List<TrainerRequest> getAllTrainerRequestByResponse(int response)
    {
	List<TrainerRequest> trainerRequestList = jTemp.query("Select * from trainer_request where response = ?",
							      new Object[] {response}, new TrainerRequestMapper());
	return trainerRequestList;
    }
    
    public static void main(String[] args)
    {
	TrainerRequestCRUD crud = new TrainerRequestCRUD();
	
	
	TrainerRequest trainerRequest = new TrainerRequest();
	
	Timestamp st = Timestamp.valueOf("2019-01-19 10:30:00");
	trainerRequest.setRequestSentDate(st);
	
	Employee trainer = new EmployeeCRUDService().getEmployeeById(1000020);
	trainerRequest.setTrainer(trainer);
	
	TrainingSchedule trainingSchedule = new TrainingScheduleCRUDService().getTrainingScheduleById("10114");
	trainerRequest.setTrainingSchedule(trainingSchedule);
	
	trainerRequest.setTopic("Topics for training");
	trainerRequest.setComments("Comments about trainer");
	trainerRequest.setResponse("1");
	trainerRequest.setActiveStatus(1);
	
	//System.out.println(crud.insertTrainerRequest(trainerRequest));
	//crud.deleteTrainerRequest(10020);
	
	trainerRequest.setTrainerRequestId(10020);
	crud.updateTrainerRequest(trainerRequest);
    }
}
