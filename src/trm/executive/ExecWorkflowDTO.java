package trm.executive;

import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;
import trm.dao.trainingschedule.TrainingSchedule;

public class ExecWorkflowDTO 
{
	ExecutiveWorkflowStatus workflow;
	TrainingSchedule schedule;
	
	public ExecWorkflowDTO(ExecutiveWorkflowStatus workflow, TrainingSchedule schedule)
	{
		this.workflow = workflow;
		this.schedule = schedule;
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
}
