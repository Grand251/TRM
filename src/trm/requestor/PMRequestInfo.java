package trm.requestor;

import java.sql.Date;
import java.sql.Timestamp;

import trm.dao.employee.Employee;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;

public class PMRequestInfo
{
	private int id;
	private int participants;
	private int status;
	private boolean isItr;
	
	private String type;
	private String module;
	private String scope;
	private String mode;
	private String location;
	private String timeZone;
	private String requestedTimeZone;
	private String spocName;
	private String spocEmail;
	private String trainerName;
	private String trainerEmail;
	
	private Date startTime;
	private Date endTime;
	private Timestamp requestedStartTime;
	private Timestamp requestedEndTime;
	
	
	public PMRequestInfo(TrainingRequest request, InternalTrainingRequest itr, TrainingSchedule schedule, Employee trainer, Employee spoc)
	{
		id = request.getTrainingRequestId();
		participants = request.getApproxNumberOfParticipants();
		type = request.getRequestTrainingType();
		module = request.getRequestTrainingModule();
		scope = request.getRequestTrainingModuleScope();
		mode = request.getRequestTrainingMode();
		location = request.getRequestLocation();
		timeZone = request.getRequestTimeZone();
		requestedStartTime = request.getRequestStartTime();
		requestedEndTime = request.getRequestEndTime();
		
		if (itr != null && itr.getItrStatus() > 0)
		{
			isItr = true;
			status = itr.getItrStatus();
			requestedTimeZone = schedule.getTraining_time_zone();
			spocName = spoc.getFirst_name() + " " + spoc.getLast_name();
			spocEmail = spoc.getEmail();
			trainerName = trainer.getFirst_name() + " " + trainer.getLast_name();
			trainerEmail = trainer.getEmail();
			startTime = schedule.getTraining_start_date();
			endTime = schedule.getTraining_end_date();
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getParticipants() {
		return participants;
	}


	public void setParticipants(int participants) {
		this.participants = participants;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getTimeZone() {
		return timeZone;
	}


	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	public String getRequestedTimeZone() {
		return requestedTimeZone;
	}


	public void setRequestedTimeZone(String requestedTimeZone) {
		this.requestedTimeZone = requestedTimeZone;
	}


	public String getSpocName() {
		return spocName;
	}


	public void setSpocName(String spocName) {
		this.spocName = spocName;
	}


	public String getSpocEmail() {
		return spocEmail;
	}


	public void setSpocEmail(String spocEmail) {
		this.spocEmail = spocEmail;
	}


	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public String getTrainerEmail() {
		return trainerEmail;
	}


	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public Timestamp getRequestedStartTime() {
		return requestedStartTime;
	}


	public void setRequestedStartTime(Timestamp requestedStartTime) {
		this.requestedStartTime = requestedStartTime;
	}


	public Timestamp getRequestedEndTime() {
		return requestedEndTime;
	}


	public void setRequestedEndTime(Timestamp requestedEndTime) {
		this.requestedEndTime = requestedEndTime;
	}


	public boolean getIsItr() {
		return isItr;
	}


	public void setIsItr(boolean isItr) {
		this.isItr = isItr;
	}
}
