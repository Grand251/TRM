package trm.requestor;

import java.sql.Date;
import java.sql.Timestamp;

import trm.dao.employee.Employee;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;

public class PMRequestInfo {
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
	private String spocName;
	private String spocEmail;
	private String trainerName;
	private String trainerEmail;
	private String requestedTimeZone;
	private String requestedStartDate;
	private String requestedEndDate;
	private String requestedStartTime;
	private String requestedEndTime;
	
	private String actualStartDate;
	private String actualEndDate;
	private InternalTrainingRequest itr;
	private Employee trainer;
	private Employee spoc;
	
	private String actualStartTime;
	private String actualEndTime;

	public PMRequestInfo(TrainingRequest request, InternalTrainingRequest itr, TrainingSchedule schedule,
			Employee trainer, Employee spoc) {
		id = request.getTrainingRequestId();
		participants = request.getApproxNumberOfParticipants();
		type = request.getRequestTrainingType();
		module = request.getRequestTrainingModule();
		scope = request.getRequestTrainingModuleScope();
		mode = request.getRequestTrainingMode();
		location = request.getRequestLocation();
		requestedTimeZone = request.getRequestTimeZone();
		requestedStartTime = getTimeString(request.getRequestStartTime().toString());
		requestedEndTime = getTimeString(request.getRequestEndTime().toString());
		this.itr = itr;
		requestedStartDate = getDateString(request.getRequestStartTime().toString());
		requestedEndDate = getDateString(request.getRequestEndTime().toString());

		if (itr != null && itr.getItrStatus() > 0) {
			isItr = true;
			status = itr.getItrStatus();
			timeZone = schedule.getTraining_time_zone();
			schedule.getTraining_start_date();
			spocName = spoc.getFirst_name() + " " + spoc.getLast_name();
			spocEmail = spoc.getEmail();
			trainerName = trainer.getFirst_name() + " " + trainer.getLast_name();
			trainerEmail = trainer.getEmail();
			actualStartTime = getTimeString(schedule.getTraining_start_date().toString());
			actualEndTime = getTimeString(schedule.getTraining_end_date().toString());
			actualStartDate = getDateString(schedule.getTraining_start_date().toString());
			actualEndDate = getDateString(schedule.getTraining_end_date().toString());
		}
	}

	private String getDateString(String datetime) {
		String date = datetime.substring(0, 10);
		return date;
	}

	private String getTimeString(String datetime) {
		String time = datetime.substring(11, 16);
		return time;
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

	public boolean isItr() {
		return isItr;
	}

	public void setItr(boolean isItr) {
		this.isItr = isItr;
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

	public String getRequestedTimeZone() {
		return requestedTimeZone;
	}

	public void setRequestedTimeZone(String requestedTimeZone) {
		this.requestedTimeZone = requestedTimeZone;
	}

	public String getRequestedStartDate() {
		return requestedStartDate;
	}

	public void setRequestedStartDate(String requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public String getRequestedEndDate() {
		return requestedEndDate;
	}

	public void setRequestedEndDate(String requestedEndDate) {
		this.requestedEndDate = requestedEndDate;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public InternalTrainingRequest getItr() {
		return itr;
	}

	public void setItr(InternalTrainingRequest itr) {
		this.itr = itr;
	}

	public Employee getTrainer() {
		return trainer;
	}

	public void setTrainer(Employee trainer) {
		this.trainer = trainer;
	}

	public Employee getSpoc() {
		return spoc;
	}

	public void setSpoc(Employee spoc) {
		this.spoc = spoc;
	}

	public void setActualEndTime(String actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public String getRequestedStartTime() {
		return requestedStartTime;
	}

	public void setRequestedStartTime(String requestedStartTime) {
		this.requestedStartTime = requestedStartTime;
	}

	public String getRequestedEndTime() {
		return requestedEndTime;
	}

	public void setRequestedEndTime(String requestedEndTime) {
		this.requestedEndTime = requestedEndTime;
	}

	public String getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(String actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public String getActualEndTime() {
		return actualEndTime;
	}
}
