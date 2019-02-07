package trm.dao.trainingrequestlog;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.springframework.validation.*;

/*
 * @author Ian Nielsen
 * Last changed: February 2nd 2019 5:50PM
 */
public class TrainingRequestLog 
{
        //Training request log instance variables. 
  	//They refer to the attributes in the 
  	//training_request_log table
    
    	//Unique id for each log. For RDBMS purposes only.
	private int requestLogId;
	
	//The training request the log is for.
	@NotNull
	private int trainingRequestId;
	
	//The status the request was changed to.
	@NotNull
	private String status;
	
	//The time at which the status of the request was changed.
	@NotNull
	private Timestamp statusChangeTime;
	
	//A description of the status, why the status was changed etc.
	private String description;
	
	/*
	 * Gets the requestLogId
	 * A unique id for each log.
	 * @param  None.
	 * @return Returns the training request log id as an integer
	 */
	public int getRequestLogId() 
	{
		return requestLogId;
	}
	
	/*
	 * Sets the requestLogId
	 * 
	 * @param  The value the training request log id will be set to.
	 * @return None.
	 */
	public void setRequestLogId(int requestLogId)
	{
		this.requestLogId = requestLogId;
	}
	
	/*
	 * Gets the trainingRequestId
	 * Refers to the training request that the log is for.
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
	 * Gets the status
	 * Refers to the status of the request at the particular 
	 * time the log was added.
	 * @param  None.
	 * @return Returns the status as a String.
	 */
	public String getStatus() 
	{
		return status;
	}
	
	/*
	 * Sets the status
	 *
	 * @param  The value the status will be set to.
	 * @return None.
	 */
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	/*
	 * Gets the statusChangeTime
	 * Refers to the time at which the status of the request was changed.
	 * @param  None.
	 * @return Returns the status change time as a Timestamp.
	 */
	public Timestamp getStatusChangeTime() 
	{
		return statusChangeTime;
	}
	
	/*
	 * Sets the statusChangeTime
	 *
	 * @param  The value the status change time will be set to.
	 * @return None.
	 */
	public void setStatusChangeTime(Timestamp statusChangeTime) 
	{
		this.statusChangeTime = statusChangeTime;
	}
	
	/*
	 * Gets the description
	 * Describes the reason for the status change, the status itself etc.
	 * @param  None.
	 * @return Returns the description as a String..
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/*
	 * Sets the description
	 *
	 * @param  The value the description will be set to.
	 * @return None.
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
}
