package trm.requestor;

import trm.dao.trainingrequest.TrainingRequest;

public class PMRequestInfo
{
	private TrainingRequest request;
	private String spocName;
	private String spocEmail;
	private int status;
	private String trainerName;
	private String trainerEmail;
	
	public PMRequestInfo(TrainingRequest request, String spocName, String spocEmail, int status, String trainerName, String trainerEmail)
	{
		this.request = request;
		this.spocName = spocName;
		this.spocEmail = spocEmail;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
	}

	public TrainingRequest getRequest() {
		return request;
	}

	public void setRequest(TrainingRequest request) {
		this.request = request;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
