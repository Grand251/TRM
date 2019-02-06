package trm.controllers;

public class InternalTraining
{
	private int reqId;
	private Boolean sentEmail;
	private Boolean hasEnrolled;
	private Boolean hasRecorded;
	private Boolean verifiedVendor;
	private Boolean hasCompleted;
	private TrainingRequestEx request;
	
	InternalTraining()
	{}
	
	InternalTraining(int id, Boolean email, Boolean enrolled, Boolean recorded, Boolean verified, Boolean completed)
	{
		reqId = id;
		sentEmail = email;
		hasEnrolled = enrolled;
		hasRecorded = recorded;
		verifiedVendor = verified;
		hasCompleted = completed;
		request = new TrainingRequestEx();
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public Boolean getSentEmail() {
		return sentEmail;
	}

	public void setSentEmail(Boolean sentEmail) {
		this.sentEmail = sentEmail;
	}

	public Boolean getHasEnrolled() {
		return hasEnrolled;
	}

	public void setHasEnrolled(Boolean hasEnrolled) {
		this.hasEnrolled = hasEnrolled;
	}

	public Boolean getHasRecorded() {
		return hasRecorded;
	}

	public void setHasRecorded(Boolean hasRecorded) {
		this.hasRecorded = hasRecorded;
	}

	public Boolean getVerifiedVendor() {
		return verifiedVendor;
	}

	public void setVerifiedVendor(Boolean verifiedVendor) {
		this.verifiedVendor = verifiedVendor;
	}

	public Boolean getHasCompleted() {
		return hasCompleted;
	}

	public void setHasCompleted(Boolean hasCompleted) {
		this.hasCompleted = hasCompleted;
	}

	public TrainingRequestEx getRequest() {
		return request;
	}

	public void setRequest(TrainingRequestEx request) {
		this.request = request;
	}
}