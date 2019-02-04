package trm.dao.internaltrainingrequest;


import java.util.List;

import trm.dao.DAOJDBCTemplate;
<<<<<<< HEAD
import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
=======
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.employee.Employee;
>>>>>>> hueytemp


/*CREATE TABLE INTERNAL_TRAINING_REQUEST
(
  internal_training_id number(7) primary key,
  status number(2) not null,
  confirmed_trainer_id number(7) references internal_trainer(it_trainer_id),
  training_request_id number(5) references training_request(training_request_id) unique not null,
  training_spoc_id number(7) references employee(employee_id),
  internal_training_mode varchar(10),
  schedule_id varchar(10) references training_schedule(training_schedule_id),
  description_of_status varchar(30)
);*/

public class InternalTrainingCRUD {
	
	/**
		Get all InternalTrainingRequest objects in database
	*/
	public List<InternalTrainingRequest> getAllItr(){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request",
				new InternalTrainingRequestMapper());
	}
	
	/**
		Get InternalTrainingRequest object with matching id

		@param requestId 5 digit id to search database with
	*/
	public InternalTrainingRequest getItrById(int requestId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM internal_training_request"
				+ " WHERE internal_training_id=?", new Object[] {requestId},
				new InternalTrainingRequestMapper());
	}
	
	public List<InternalTrainingRequest> getAllItrByTrainer(Employee trainer){
		return getAllItrByTrainer(trainer.getEmployee_id());
	}
	
	public List<InternalTrainingRequest> getAllItrByTrainer(int trainerId){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request"
				+ " WHERE confirmed_trainer_id=?", new Object[] {trainerId},
				new InternalTrainingRequestMapper());
	}
	/*
	 * Get InternalTrainingRequest object with TrainingRequest object containing target requestId
	 * 
	 * @param request TrainingRequest object containing target requestId
	 */
	public InternalTrainingRequest getItrByTrainingRequest(TrainingRequest request){
		return getItrByTrainingRequest(request.getTrainingRequestId());
	}
	
	/*
	 * Get InternalTrainingRequest object with specified requestId
	 * 
	 * @param requestId 5 digit request id to search itrs with
	 */
	public InternalTrainingRequest getItrByTrainingRequest(int requestId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject(
				"SELECT * FROM internal_training_request WHERE training_request_id=?",
				new Object[] {requestId},
				new InternalTrainingRequestMapper());
	}
	
	/*
	 * Get list of InternalTrainingRequest objects with Employee object, which contains employee_id of a SPOC
	 * 
	 * @param spoc Employee object with 7 digit employee id to search itrs for
	 */
	public List<InternalTrainingRequest> getAllItrBySPOC(Employee spoc){
		return getAllItrBySPOC(spoc.getEmployee_id());
	}
	
	/*
	 * Get list of InternalTrainingRequest objects with specified spocId
	 * 
	 * @param spocId 7 digit Employee id to search itrs for
	 */
	public List<InternalTrainingRequest> getAllItrBySPOC(int spocId){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request "
				+ "WHERE training_spoc_id=?", new Object[]{spocId},
				new InternalTrainingRequestMapper());
	}
	
	/*
	 * Get list of InternalTrainingRequest objects with scheduleId contained in TrainingSchedule object
	 * 
	 * @param scheduleId TrainingSchedule object with 5 digit schedule id to search itrs for
	 */
	public InternalTrainingRequest getItrBySchedule(TrainingSchedule schedule){
		return getItrBySchedule(schedule.getTraining_schedule_id());
	}
	/*
	 * Get list of InternalTrainingRequest objects with specified scheduleId
	 * 
	 * @param scheduleId 5 digit schedule id to search itrs for
	 */
	public InternalTrainingRequest getItrBySchedule(String scheduleId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject(
				"SELECT * FROM internal_training_request WHERE schedule_id=?",
				new Object[] {scheduleId},
				new InternalTrainingRequestMapper());
	}
	
	/*
	 * Insert internal training request with object containing the desired values
	 * ITR ID cannot be inserted.
	 * Status must contain a number of at most two digits.
	 * Trainer may contain an employee object with a 7 digit id matching a trainer
	 * Training Request must contain a TrainingRequest with a unique 5 digit schedule id
	 * Spoc may contain an Employee object with a 7 digit id matching a SPOC
	 * Mode may contain a string of at most 10 characters
	 * Status Description may contain a string of at most 30 characters
	 * 
	 * @param itr TrainingRequest object with fields matching the above descriptions
	 */	
	public int insertItr(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"INSERT INTO internal_training_request VALUES(internal_training_id_seq.nextval, "
				+ "?, ?, ?, ?, ?, ?, ?)",
				new Object[] {itr.getItrStatus(),
						      itr.getItrTrainer().getEmployee_id(),
						      itr.getItrTrainingRequest().getTrainingRequestId(),
						      itr.getItrSpoc().getEmployee_id(),
						      itr.getItrMode(),
						      itr.getItrSchedule().getTraining_schedule_id(),
						      itr.getItrStatusDescription()});
	}
	
	
	/*
	 * Update internal training request with object containing the updated values.
	 * ITR ID cannot be updated.
	 * Status must contain a number of at most two digits.
	 * Trainer may contain an employee object with a 7 digit id matching a trainer
	 * Training Request must contain a TrainingRequest with a unique 5 digit schedule id
	 * Spoc may contain an Employee object with a 7 digit id matching a SPOC
	 * Mode may contain a string of at most 10 characters
	 * Status Description may contain a string of at most 30 characters
	 * 
	 * @param itr TrainingRequest object with fields matching the above descriptions
	 */
	public int updateItr(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET status=?, "
												   + "confirmed_trainer_id=?, "
												   + "training_request_id=?, "
												   + "training_spoc_id=?, "
												   + "internal_training_mode=?, "
												   + "schedule_id=?, "
												   + "description_of_status=? "
												   + "WHERE internal_training_id=?",
				new Object[] {itr.getItrStatus(),
					      	  itr.getItrTrainer().getEmployee_id(),
					      	  itr.getItrTrainingRequest().getTrainingRequestId(),
					      	  itr.getItrSpoc().getEmployee_id(),
					      	  itr.getItrMode(),
					      	  itr.getItrSchedule().getTraining_schedule_id(),
					      	  itr.getItrStatusDescription(),
					      	  itr.getItrId()});
	}
	
	/*
	 * Delete internal training request with an ITR object
	 * 
	 * @param requestId ITR object with ID of request to be deleted.
	 */
	public int deleteItr(InternalTrainingRequest itr) {
		return deleteItr(itr.getItrId());
	}
	
	/*
	 * Delete internal training request by ITR id.
	 * 
	 * @param requestId ITR ID which can be no greater than 7 digits.
	 */
	public int deleteItr(int requestId) {
		return DAOJDBCTemplate.getJdbcTemplate().update("DELETE FROM internal_training_request"
				+ " WHERE internal_training_id=?",
				new Object[] {requestId});
				
	}
	
	public static void main(String[] args) {
	 
		InternalTrainingCRUD itCRUD = new InternalTrainingCRUD();
		Employee spoc = new Employee();
		spoc.setEmployee_id(1000006);
		Employee trainer = new Employee();
		trainer.setEmployee_id(1000004);
		//System.out.println(itCRUD.getAllItr().size());
		//System.out.println(itCRUD.getItrById(1000000));
		//System.out.println(itCRUD.getAllItrBySPOC(1000006).size());
		//System.out.println(itCRUD.getAllItrBySPOC(spoc).size());
		//System.out.println(itCRUD.getAllItrByTrainer(1000004).size());
		//System.out.println(itCRUD.getAllItrByTrainer(trainer).size());
		TrainingRequest tr = new TrainingRequest();
		tr.setTrainingRequestId(10000);
		//System.out.println(itCRUD.getItrByTrainingRequest(tr));
		//System.out.println(itCRUD.getItrByTrainingRequest(10000));
		TrainingSchedule ts = new TrainingSchedule();
		ts.setTraining_schedule_id("10000");
		//System.out.println(itCRUD.getItrBySchedule(ts));
		//System.out.println(itCRUD.getItrBySchedule("10000"));
		InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setItrId(100);
		itr.setItrMode("test");
		itr.setItrSchedule(ts);
		itr.setItrSpoc(spoc);
		itr.setItrStatus(1);
		itr.setItrStatusDescription("good status");
		itr.setItrTrainer(trainer);
		itr.setItrTrainingRequest(tr);
		
		System.out.println(itCRUD.deleteItr(itr));
		System.out.println(itCRUD.insertItr(itr));
		System.out.println(itCRUD.deleteItr(100));
		System.out.println(itCRUD.insertItr(itr));
		itr.setItrMode("great test");
		itr.setItrStatus(2);
		itr.setItrStatusDescription("great status");
		System.out.println(itCRUD.updateItr(itr));
	}
}
