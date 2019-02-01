package trm.dao.trainingrequest;

import java.sql.Timestamp;

public class TrainingRequest 
{
	private int trainingRequestId;
	private int requesterId;
	private String requestTrainingType;
	private String requestTrainingModule;
	private String requestTrainingModuleScope;
	private String requestTrainingMode;
	private Timestamp requestStartTime;
	private Timestamp requestEndTime;
	private String requestLocation;
	private String requestTimeZone;
	private int approxNumberOfParticipants;
	private int requestProjectSpoc;
	private int executiveId;
	private Timestamp timeRequested;
	
	public int getTrainingRequestId() 
	{
		return trainingRequestId;
	}
	
	public void setTrainingRequestId(int trainingRequestId) 
	{
		this.trainingRequestId = trainingRequestId;
	}
	
	public int getRequesterId() 
	{
		return requesterId;
	}
	
	public void setRequesterId(int requesterId) 
	{
		this.requesterId = requesterId;
	}
	
	public String getRequestTrainingModule() 
	{
		return requestTrainingModule;
	}
	
	public void setRequestTrainingModule(String requestTrainingModule) 
	{
		this.requestTrainingModule = requestTrainingModule;
	}
	
	public String getRequestTrainingModuleScope() 
	{
		return requestTrainingModuleScope;
	}
	
	public void setRequestTrainingModuleScope(String requestTrainingModuleScope) 
	{
		this.requestTrainingModuleScope = requestTrainingModuleScope;
	}
	
	public String getRequestTrainingMode() 
	{
		return requestTrainingMode;
	}
	
	public void setRequestTrainingMode(String requestTrainingMode) 
	{
		this.requestTrainingMode = requestTrainingMode;
	}
	
	public Timestamp getRequestStartTime() 
	{
		return requestStartTime;
	}
	
	public void setRequestStartTime(Timestamp requestStartTime)
	{
		this.requestStartTime = requestStartTime;
	}
	
	public Timestamp getRequestEndTime() 
	{
		return requestEndTime;
	}
	
	public void setRequestEndTime(Timestamp requestEndTime) 
	{
		this.requestEndTime = requestEndTime;
	}
	
	public String getRequestLocation() 
	{
		return requestLocation;
	}
	
	public void setRequestLocation(String requestLocation)
	{
		this.requestLocation = requestLocation;
	}
	
	public String getRequestTimeZone() 
	{
		return requestTimeZone;
	}
	
	public void setRequestTimeZone(String requestTimeZone) 
	{
		this.requestTimeZone = requestTimeZone;
	}
	
	public int getApproxNumberOfParticipants() 
	{
		return approxNumberOfParticipants;
	}
	
	public void setApproxNumberOfParticipants(int approxNumberOfParticipants) 
	{
		this.approxNumberOfParticipants = approxNumberOfParticipants;
	}
	
	public int getRequestProjectSpoc() 
	{
		return requestProjectSpoc;
	}
	
	public void setRequestProjectSpoc(int requestProjectSpoc) 
	{
		this.requestProjectSpoc = requestProjectSpoc;
	}
	
	public int getExecutiveId() 
	{
		return executiveId;
	}
	
	public void setExecutiveId(int executiveId) 
	{
		this.executiveId = executiveId;
	}
	
	public Timestamp getTimeRequested() 
	{
		return timeRequested;
	}
	
	public void setTimeRequested(Timestamp timeRequested) 
	{
		this.timeRequested = timeRequested;
	}

	public String getRequestTrainingType() 
	{
		return requestTrainingType;
	}

	public void setRequestTrainingType(String requestTrainingType) 
	{
		this.requestTrainingType = requestTrainingType;
	}
	
	
}
