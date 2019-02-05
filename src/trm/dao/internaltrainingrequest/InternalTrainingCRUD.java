package trm.dao.internaltrainingrequest;


import java.util.List;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;



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
				+ " WHERE internal_training_id=?", new Object[]{requestId},
				new InternalTrainingRequestMapper());
	}
	
	/**
	 * 
	 * @param trainingStatus 2 digit int containing target status code
	 * @return List<InternalTrainingRequest> containing all matching ITRs
	 */
	public List<InternalTrainingRequest> getAllItrByStatus(int trainingStatus){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request"
				+ " WHERE status=?", new Object[] {trainingStatus},
				new InternalTrainingRequestMapper());
	} 
	
	/**
	 * 
	 * @param trainingMode String of at most 10 characters containing target training mode
	 * @return List<InternalTrainingRequest> containing all matching ITRs
	 */
	public List<InternalTrainingRequest> getAllItrByMode(String trainingMode){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request"
				+ " WHERE internal_training_mode=?", new Object[] {trainingMode},
				new InternalTrainingRequestMapper());
	} 
	
	/**
	 * Get all itrs with the specified trainer
	 * 
	 * @param trainer Employee with 7 digit id specifying a trainer.
	 * @return
	 */
	public List<InternalTrainingRequest> getAllItrByTrainer(Employee trainer){
		return getAllItrByTrainer(trainer.getEmployee_id());
	}
	
	/**
	 * Get all itrs with the trainer with the specified employee id.
	 * @param trainerId - 7 digit employee id of a trainer
	 * @return
	 */
	public List<InternalTrainingRequest> getAllItrByTrainer(int trainerId){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request"
				+ " WHERE confirmed_trainer_id=?", new Object[] {trainerId},
				new InternalTrainingRequestMapper());
	}
	/**
	 * 
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
	
	public List<InternalTrainingRequest> getAllItrByExec(Employee exec){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request "
				+ "WHERE EXECUTIVE_ID=?", new Object[]{exec.getEmployee_id()},
				new InternalTrainingRequestMapper());
	}
	
	public List<InternalTrainingRequest> getAllItrByExec(int execId){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request "
				+ "WHERE EXECUTIVE_ID=?", new Object[]{execId},
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
	 * Training Request cannot be updated
	 * Spoc may contain an Employee object with a 7 digit id matching a SPOC
	 * Mode may contain a string of at most 10 characters
	 * Training Schedule may contain a TRAININGSCHEDULE object with a 5 digit schedule id
	 * Status Description may contain a string of at most 30 characters
	 * 
	 * @param itr TrainingRequest object with fields matching the above descriptions
	 */
	public int updateItr(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET status=?, "
												   + "confirmed_trainer_id=?, "
												   + "training_spoc_id=?, "
												   + "internal_training_mode=?, "
												   + "description_of_status=?, "
												   + "schedule_id = ? "
												   + "WHERE internal_training_id=?",
				new Object[] {itr.getItrStatus(),
					      	  itr.getItrTrainer().getEmployee_id(),
					      	  itr.getItrSpoc().getEmployee_id(),
					      	  itr.getItrMode(),
					      	  itr.getItrStatusDescription(),
					      	  itr.getItrSchedule().getTraining_schedule_id(),
					      	  itr.getItrId()});
	}
	
	/**
	 * Update an ITR status with an object containing updated value. Only updates
	 * status regardless of other changes to object variables.
	 * 
	 * @param itr 2 digit ITR status int
	 * @return Number of rows updated
	 */
	public int updateStatus(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET status=? WHERE internal_training_id=?",
				new Object[] {itr.getItrStatus(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's status with an ITR status int and ITR ID int.
	 * 
	 * @param status 2 digit ITR status int
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateStatus(int status, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET status=? WHERE internal_training_id=?",
				new Object[]{status, itrId});
	}
	
	/**
	 * Update an ITR trainer with an object containing updated value. Only updates
	 * trainer regardless of other changes to object variables.
	 * 
	 * @param itr ITR object containing reference to new confirmed trainer
	 * @return Number of rows updated
	 */
	public int updateTrainer(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET confirmed_trainer_id=? WHERE internal_training_id=?",
				new Object[] {itr.getItrTrainer().getEmployee_id(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's trainer with an ITR ID and Employee object containing new trainer's id.
	 * 
	 * @param trainer Employee object for new trainer which must contain trainer's 7 digit employee id.
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateTrainer(Employee trainer, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET confirmed_trainer_id=? WHERE internal_training_id=?",
				new Object[]{trainer.getEmployee_id(), itrId});
	}
	
	/**
	 * Update an ITR's trainer with new trainer's employee ID string and ITR ID.
	 * 
	 * @param trainerId 7 digit employee ID of trainer
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateTrainer(int trainerId, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET confirmed_trainer_id=? WHERE internal_training_id=?",
				new Object[]{trainerId, itrId});
	}
	
	/**
	 * Update an ITR spoc with an object containing updated value. Only updates
	 * spoc regardless of other changes to object variables.
	 * 
	 * @param itr Object containing reference to new ITR SPOC
	 * @return Number of rows updated
	 */
	public int updateSpoc(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET training_spoc_id=? WHERE internal_training_id=?",
				new Object[] {itr.getItrSpoc().getEmployee_id(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's SPOC with an ITR ID and Employee object containing new SPOC's id.
	 * 
	 * @param spoc Employee object for new SPOC which must contain SPOC's 7 digit employee id.
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateSpoc(Employee spoc, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET training_spoc_id=? WHERE internal_training_id=?",
				new Object[]{spoc.getEmployee_id(), itrId});
	}
	
	/**
	 * Update an ITR's SPOC with employee ID of target SPOC and ITR ID.
	 * 
	 * @param spocId 7 digit employee ID of new assigned SPOC
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateSpoc(int spocId, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET training_spoc_id=? WHERE internal_training_id=?",
				new Object[]{spocId, itrId});
	}
	
	/**
	 * Update an ITR training mode with an object containing updated value. Only updates
	 * training mode regardless of other changes to object variables.
	 * 
	 * @param itr Object containing updated training mode value.
	 * @return Number of rows updated
	 */
	public int updateItrMode(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET internal_training_mode=? WHERE internal_training_id=?",
				new Object[] {itr.getItrMode(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's trainingMode with a trainingMode string and ITR ID.
	 * 
	 * @param trainingMode String of at most 10 characters
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateItrMode(String trainingMode, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET internal_training_mode=? WHERE internal_training_id=?",
				new Object[]{trainingMode, itrId});
	}
	
	/**
	 * Update an ITR schedule with an object containing updated value. Only updates
	 * schedule regardless of other changes to object variables.
	 * 
	 * @param itr ITR object containing reference to new schedule
	 * @return Number of rows updated
	 */
	public int updateSchedule(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET schedule_id=? WHERE internal_training_id=?",
				new Object[] {itr.getItrSchedule().getTraining_schedule_id(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's schedule with an ITR ID and TrainingSchedule object containing new schedule's id.
	 * 
	 * @param trainingSchedule object for new schedule which must contain schedule's 5 digit id.
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateSchedule(TrainingSchedule trainingSchedule, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET schedule_id=? WHERE internal_training_id=?",
				new Object[]{trainingSchedule.getTraining_schedule_id(), itrId});
	}
	
	/**
	 * Update an ITR's status description with new schedule's ID string and ITR ID.
	 * 
	 * @param scheduleId 5 digit training schedule id
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateSchedule(int scheduleId, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET schedule_id=? WHERE internal_training_id=?",
				new Object[]{scheduleId, itrId});
	}
	
	/**
	 * Update an ITR status description with an object containing updated value. Only updates
	 * status description regardless of other changes to object variables.
	 * 
	 * @param itr Object containing new ITR status description of at most 30 characters
	 * @return Number of rows updated
	 */
	public int updateItrStatusDescription(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET description_of_status=? WHERE internal_training_id=?",
				new Object[] {itr.getItrStatusDescription(), itr.getItrId()});
	}
	
	/**
	 * Update an ITR's status description with a status description string and ITR ID.
	 * 
	 * @param itrStatusDescription New status description string of at most 30 characters
	 * @param itrId 7 digit ITR ID
	 * @return Number of rows updated
	 */
	public int updateItrStatusDescription(String itrStatusDescription, int itrId) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"UPDATE internal_training_request SET description_of_status=? WHERE internal_training_id=?",
				new Object[]{itrStatusDescription, itrId});
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
		/*InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setItrId(100);
		itr.setItrMode("test");
		itr.setItrSchedule(ts);
		itr.setItrSpoc(spoc);
		itr.setItrStatus(1);
		itr.setItrStatusDescription("good status");
		itr.setItrTrainer(trainer);
		itr.setItrTrainingRequest(tr);*/
		
		/*System.out.println("DELETE1 " + itCRUD.deleteItr(itr));
		System.out.println("INSERT1 " + itCRUD.insertItr(itr));
		System.out.println("DELETE2 " + itCRUD.deleteItr(100));
		System.out.println("INSERT2 " + itCRUD.insertItr(itr));*/
		
		InternalTrainingRequest itr = itCRUD.getItrById(1000015);
		itr.setItrMode("great test");
		System.out.println("mode: " + itCRUD.updateItrMode(itr));
		System.out.println("mode2: " + itCRUD.updateItrMode("greatest test", itr.getItrId()));
		itr.setItrStatus(2);
		System.out.println("Stat: " + itCRUD.updateStatus(itr));
		System.out.println("stat2: " + itCRUD.updateStatus(4, itr.getItrId()));
		itr.setItrStatusDescription("great status");
		System.out.println("desc: " + itCRUD.updateItrMode(itr));
		System.out.println("desc2: " + itCRUD.updateItrMode("what a description", itr.getItrId()));
		
		//System.out.println(itCRUD.updateItr(itr));
	}
}
