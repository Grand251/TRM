package trm.executive;

import java.util.List;

import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingparticipant.TrainingParticipant;
import trm.dao.trainingparticipant.TrainingParticipantCRUD;
import trm.dao.trainingschedule.TrainingSchedule;

public class ExecWorkflowFormDTO 
{
	ExecutiveWorkflowStatus workflow;
	TrainingSchedule schedule;
	List<TrainingParticipant> participants;
	String trainerName;
	
	public ExecWorkflowFormDTO(ExecutiveWorkflowStatus workflow, InternalTrainingRequest itr)
	{
		this.workflow = workflow;
		this.schedule = itr.getItrSchedule();
		trainerName = itr.getItrTrainer().getFirst_name() + " " + itr.getItrTrainer().getLast_name();
		
		TrainingParticipantCRUD svc = new TrainingParticipantCRUD();
		participants = svc.getAllParticipantsByRequest(workflow.getTrainingRequest().getTrainingRequestId());
		
		if (schedule.getTraining_location() == null || schedule.getTraining_location().isEmpty())
			schedule.setTraining_location("Not Provided");
	}

	public ExecutiveWorkflowStatus getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ExecutiveWorkflowStatus workflow) {
		this.workflow = workflow;
	}

	public TrainingSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(TrainingSchedule schedule) {
		this.schedule = schedule;
	}

	public List<TrainingParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<TrainingParticipant> participants) {
		this.participants = participants;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
}
