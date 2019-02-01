package trm.dao.internaltrainingrequest;


import java.util.List;

import trm.dao.employee.Employee;
import trm.dao.DAOJDBCTemplate;
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
	
	public List<InternalTrainingRequest> getAllItr(){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request",
				new InternalTrainingRequestMapper());
	}
	
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
	
	public InternalTrainingRequest getItrByTrainingRequest(TrainingRequest request){
		return getItrByTrainingRequest(request.getTrainingRequestId());
	}
	
	public InternalTrainingRequest getItrByTrainingRequest(int requestId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject(
				"SELECT * FROM internal_training_request WHERE training_request_id=?",
				new Object[] {requestId},
				new InternalTrainingRequestMapper());
	}
	
	
	public List<InternalTrainingRequest> getAllItrBySPOC(Employee spoc){
		return getAllItrBySPOC(spoc.getEmployee_id());
	}
	
	
	public List<InternalTrainingRequest> getAllItrBySPOC(int spocId){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_training_request "
				+ "WHERE training_spoc_id=?", new Object[]{spocId},
				new InternalTrainingRequestMapper());
	}
	
	public InternalTrainingRequest getItrBySchedule(TrainingSchedule schedule){
		return getItrBySchedule(schedule.getTraining_schedule_id());
	}
	
	public InternalTrainingRequest getItrBySchedule(String scheduleId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject(
				"SELECT * FROM internal_training_request WHERE schedule_id=?",
				new Object[] {scheduleId},
				new InternalTrainingRequestMapper());
	}
	
		
	public int insertItr(InternalTrainingRequest itr) {
		return DAOJDBCTemplate.getJdbcTemplate().update(
				"INSERT INTO internal_training_request VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] {itr.getItrId(), 
						      itr.getItrStatus(),
						      itr.getItrTrainer().getEmployee_id(),
						      itr.getItrTrainingRequest().getTrainingRequestId(),
						      itr.getItrSpoc().getEmployee_id(),
						      itr.getItrMode(),
						      itr.getItrSchedule().getTraining_schedule_id(),
						      itr.getItrStatusDescription()});
	}	
	
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
	
	
	public int deleteItr(InternalTrainingRequest itr) {
		return deleteItr(itr.getItrId());
	}
	
	
	public int deleteItr(int requestId) {
		return DAOJDBCTemplate.getJdbcTemplate().update("DELETE FROM internal_training_request"
				+ " WHERE internal_training_id=?",
				new Object[] {requestId});
				
	}
	
	/*
	 * 
	 * TEST SCRIPT
	 * public static void main(String[] args) {
	 
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
	}*/
}
