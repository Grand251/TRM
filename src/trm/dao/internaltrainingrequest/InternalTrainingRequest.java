package trm.dao.internaltrainingrequest;

import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.employee.Employee;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;


public class InternalTrainingRequest {
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
	
	private int itrId;
	private TrainingRequest itrTrainingRequest;
	private TrainingSchedule itrSchedule;
	private Employee itrTrainer;
	private Employee itrExecutive;
	private int itrStatus;
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

