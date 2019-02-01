package trm.dao.trainingrequestlog;

import java.sql.Timestamp;

public class TrainingRequestLog 
{
	private int requestLogId;
	private int trainingRequestId;
	private String status;
	private Timestamp statusChangeTime;
	private String description;
	
	public int getRequestLogId() 
	{
		return requestLogId;
	}
	
	public void setRequestLogId(int requestLogId)
	{
		this.requestLogId = requestLogId;
	}
	
	public String getStatus() 
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public Timestamp getStatusChangeTime() 
	{
		return statusChangeTime;
	}
	
	public void setStatusChangeTime(Timestamp statusChangeTime) 
	{
		this.statusChangeTime = statusChangeTime;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public int getTrainingRequestId() 
	{
		return trainingRequestId;
	}

	public void setTrainingRequestId(int trainingRequestId) 
	{
		this.trainingRequestId = trainingRequestId;
	}
}
