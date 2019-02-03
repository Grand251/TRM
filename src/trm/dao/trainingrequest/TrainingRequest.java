package trm.dao.trainingrequest;

import java.sql.Timestamp;

/*
 * @author Ian Nielsen
 * Last changed: February 2nd 2019 5:46PM
 */
public class TrainingRequest 
{
	//Training request instance variables. 
	//They refer to the attributes in the 
	//training_request table
        
    	//Unique ID for each request. For RDBMS purposes only.
	private int trainingRequestId;
	
	//The employee id of the project manager who made the request.
	private int requesterId;
	
	//Internal training, development team training, or vendor training.
	private String requestTrainingType;
	
	//The subject. Java, .NET, etc.
	private String requestTrainingModule;
	
	//What specifics the training could cover. Spring, Spring MVC etc.
	private String requestTrainingModuleScope;
	
	//Class room or web based.
	private String requestTrainingMode;
	
	//The time the PM wishes the training to start.
	private Timestamp requestStartTime;
	
	//The time the PM wished the training to end.
	private Timestamp requestEndTime;
	
	//The location the PM wishes the training to take place.
	private String requestLocation;
	
	//Time zone of the location.
	private String requestTimeZone;
	
	//Number of trainees that may attend.
	private int approxNumberOfParticipants;
	
	//If the PM has a team member in mind for a SPOC they can specify them here.
	private int requestProjectSpoc;
	
	//If the PM has an executive in mind they can specify them here.
	private int executiveId;
	
	//The time the request was made. Not when the training takes place.
	private Timestamp timeRequested;
	
	//The status of the request. 
	//Possible values: Request made, request being processed, 
	//type(IT or VT) being decided, type decided.
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
