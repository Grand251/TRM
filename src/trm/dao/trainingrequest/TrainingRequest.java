package trm.dao.trainingrequest;

import java.sql.Timestamp;

/*
 * @author Ian Nielsen
 * Last changed: February 1st 2019 11:16PM
 */
public class TrainingRequest 
{
	//Training request instance variables. 
	//They refer to the attributes in the 
	//training_request table
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
	private int status;
	
	/*
	 * Gets the trainingRequestId
	 *
	 * @param  None.
	 * @return Returns the training request id as an integer
	 */
	public int getTrainingRequestId() 
	{
		return trainingRequestId;
	}
	
	/*
	 * Sets the trainingRequestId
	 *
	 * @param  The value the training request id will be set to.
	 * @return None.
	 */
	public void setTrainingRequestId(int trainingRequestId) 
	{
		this.trainingRequestId = trainingRequestId;
	}
	
	/*
	 * Gets the requesterId
	 *
	 * @param  None.
	 * @return Returns the requester id as an integer
	 */
	public int getRequesterId() 
	{
		return requesterId;
	}
	
	/*
	 * Sets the requesterId
	 *
	 * @param  The value the requester id will be set to.
	 * @return None.
	 */
	public void setRequesterId(int requesterId) 
	{
		this.requesterId = requesterId;
	}
	
	/*
	 * Gets the requestTrainingModule
	 *
	 * @param  None.
	 * @return Returns the request training module as a string.
	 */
	public String getRequestTrainingModule() 
	{
		return requestTrainingModule;
	}
	
	/*
	 * Sets the requestTrainingModule
	 *
	 * @param  The value the request training module will be set to.
	 * @return None.
	 */
	public void setRequestTrainingModule(String requestTrainingModule) 
	{
		this.requestTrainingModule = requestTrainingModule;
	}
	
	/*
	 * Gets the requestTrainingModuleScope
	 *
	 * @param  None.
	 * @return Returns the request training module scope as a string.
	 */
	public String getRequestTrainingModuleScope() 
	{
		return requestTrainingModuleScope;
	}
	
	/*
	 * Sets the requestTrainingModuleScope
	 *
	 * @param  The value the request training module scope will be set to.
	 * @return None.
	 */
	public void setRequestTrainingModuleScope(String requestTrainingModuleScope) 
	{
		this.requestTrainingModuleScope = requestTrainingModuleScope;
	}
	
	/*
	 * Gets the requestTrainingMode
	 *
	 * @param  None.
	 * @return Returns the request training mode as a string.
	 */
	public String getRequestTrainingMode() 
	{
		return requestTrainingMode;
	}
	
	/*
	 * Sets the requestTrainingMode
	 *
	 * @param  The value the request training mode will be set to.
	 * @return None.
	 */
	public void setRequestTrainingMode(String requestTrainingMode) 
	{
		this.requestTrainingMode = requestTrainingMode;
	}
	
	/*
	 * Gets the requestStartTime
	 *
	 * @param  None.
	 * @return Returns the request start time as a Timestamp.
	 */
	public Timestamp getRequestStartTime() 
	{
		return requestStartTime;
	}
	
	/*
	 * Sets the requestStartTime
	 *
	 * @param  The value the request start time will be set to.
	 * @return None.
	 */
	public void setRequestStartTime(Timestamp requestStartTime)
	{
		this.requestStartTime = requestStartTime;
	}
	
	/*
	 * Gets the requestEndTime
	 *
	 * @param  None.
	 * @return Returns the request end time as a Timestamp.
	 */
	public Timestamp getRequestEndTime() 
	{
		return requestEndTime;
	}
	
	/*
	 * Sets the requestEndTime
	 *
	 * @param  The value the request end time will be set to.
	 * @return None.
	 */
	public void setRequestEndTime(Timestamp requestEndTime) 
	{
		this.requestEndTime = requestEndTime;
	}
	
	/*
	 * Gets the requestLocation
	 *
	 * @param  None.
	 * @return Returns the request location as a String.
	 */
	public String getRequestLocation() 
	{
		return requestLocation;
	}
	
	/*
	 * Sets the requestLocation
	 *
	 * @param  The value the request location will be set to.
	 * @return None.
	 */
	public void setRequestLocation(String requestLocation)
	{
		this.requestLocation = requestLocation;
	}
	
	/*
	 * Gets the requestTimeZone
	 *
	 * @param  None.
	 * @return Returns the request time zone as a String.
	 */
	public String getRequestTimeZone() 
	{
		return requestTimeZone;
	}
	
	/*
	 * Sets the requestTimeZone
	 *
	 * @param  The value the request time zone will be set to.
	 * @return None.
	 */
	public void setRequestTimeZone(String requestTimeZone) 
	{
		this.requestTimeZone = requestTimeZone;
	}
	
	/*
	 * Gets the approxNumberOfParticipants
	 *
	 * @param  None.
	 * @return Returns the approximate number of participants as an integer.
	 */
	public int getApproxNumberOfParticipants() 
	{
		return approxNumberOfParticipants;
	}
	
	/*
	 * Sets the approxNumberOfParticipants
	 *
	 * @param  The value the approximate number of participants will be set to.
	 * @return None.
	 */
	public void setApproxNumberOfParticipants(int approxNumberOfParticipants) 
	{
		this.approxNumberOfParticipants = approxNumberOfParticipants;
	}
	
	/*
	 * Gets the requestProjectSpoc
	 *
	 * @param  None.
	 * @return Returns the id of the spoc as an integer.
	 */
	public int getRequestProjectSpoc() 
	{
		return requestProjectSpoc;
	}
	
	/*
	 * Sets the requestProjectSpoc
	 *
	 * @param  The value the spoc id will be set to.
	 * @return None.
	 */
	public void setRequestProjectSpoc(int requestProjectSpoc) 
	{
		this.requestProjectSpoc = requestProjectSpoc;
	}
	
	/*
	 * Gets the executiveId
	 *
	 * @param  None.
	 * @return Returns the id of the executive as an integer.
	 */
	public int getExecutiveId() 
	{
		return executiveId;
	}
	
	/*
	 * Sets the executiveId
	 *
	 * @param  The value the executive id will be set to.
	 * @return None.
	 */
	public void setExecutiveId(int executiveId) 
	{
		this.executiveId = executiveId;
	}
	
	/*
	 * Gets the timeRequested
	 *
	 * @param  None.
	 * @return Returns the time requested as a TimeStamp.
	 */
	public Timestamp getTimeRequested() 
	{
		return timeRequested;
	}
	
	/*
	 * Sets the timeRequested
	 *
	 * @param  The value the time requested will be set to.
	 * @return None.
	 */
	public void setTimeRequested(Timestamp timeRequested) 
	{
		this.timeRequested = timeRequested;
	}

	/*
	 * Gets the requestTrainingType
	 *
	 * @param  None.
	 * @return Returns the request training type as a string.
	 */
	public String getRequestTrainingType() 
	{
		return requestTrainingType;
	}

	/*
	 * Sets the requestTrainingType
	 *
	 * @param  The value the training type will be set to.
	 * @return None.
	 */
	public void setRequestTrainingType(String requestTrainingType) 
	{
		this.requestTrainingType = requestTrainingType;
	}

	/*
	 * Gets the status
	 *
	 * @param  None.
	 * @return Returns status as an integer.
	 */
	public int getStatus() 
	{
		return status;
	}

	/*
	 * Sets the status
	 *
	 * @param  The value the status will be set to.
	 * @return None.
	 */
	public void setStatus(int status) 
	{
		this.status = status;
	}
}
