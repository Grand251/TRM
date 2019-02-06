package trm.dao.internaltrainingrequest;

import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.employee.Employee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class InternalTrainingRequest {
	/*CREATE TABLE INTERNAL_TRAINING_REQUEST
	(
	  internal_training_id number(5) primary key,
	  training_request_id number(5) CONSTRAINT itr_tr_fk references training_request(training_request_id) unique not null,
	  schedule_id number(5) CONSTRAINT itr_sched_fk references training_schedule(training_schedule_id) unique,
	  confirmed_trainer_id number(7) CONSTRAINT itr_train_fk references internal_trainer(it_trainer_id),
	  executive_id number(7) CONSTRAINT tr_exec_fk references employee(employee_id),
	  status number(2) not null,
	  description_of_status varchar(30)
	);*/
	
	public static void main(String[] args) {
		InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setItrId(-1);
	}
	
	@NotNull
	@Min(0)
	@Max(99999)
	private int itrId;
	
	@NotNull
	private TrainingRequest itrTrainingRequest;
	
	private TrainingSchedule itrSchedule;
	
	private Employee itrTrainer;
	
	private Employee itrExecutive;
	
	@NotNull
	@Min(-10)
	@Max(99)
	private int itrStatus;
	
	@Size(max=30) 
	private String itrStatusDescription;
	
	
	public int getItrId() 
	{
		return itrId;
	}
	
	public void setItrId(int itrId) 
	{
		this.itrId = itrId;
	}
	
	public int getItrStatus() 
	{
		return itrStatus;
	}
	
	public void setItrStatus(int itrStatus)
	{
		this.itrStatus = itrStatus;
	}
	
	public Employee getItrTrainer() 
	{
		return itrTrainer;
	}
	
	public void setItrTrainer(Employee itrTrainer) 
	{
		this.itrTrainer = itrTrainer;
	}
	
	public TrainingRequest getItrTrainingRequest() 
	{
		return itrTrainingRequest;
	}
	
	public void setItrTrainingRequest(TrainingRequest itrTrainingRequest) 
	{
		this.itrTrainingRequest = itrTrainingRequest;
	}
	
	public TrainingSchedule getItrSchedule() 
	{
		return itrSchedule;
	}
	
	public void setItrSchedule(TrainingSchedule itrSchedule) 
	{
		this.itrSchedule = itrSchedule;
	}
	
	public String getItrStatusDescription() 
	{
		return itrStatusDescription;
	}
	
	public void setItrStatusDescription(String itrStatusDescription) 
	{
		this.itrStatusDescription = itrStatusDescription;
	}
	
	public Employee getItrExecutive()
	{
	    return itrExecutive;
	}
	
	public void setItrExecutive(Employee itrExecutive)
	{
	    this.itrExecutive = itrExecutive;
	}
	
}

