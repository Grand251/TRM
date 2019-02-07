package trm.executive;

import javax.servlet.http.HttpServletRequest;

import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;

public class ExecutiveUtilities 
{
	public ExecutiveWorkflowStatus Map(HttpServletRequest request, ExecutiveWorkflowStatus status)
	{
		status.setInvitationsSent(ToInt(request.getParameter("email")));
		status.setSkillportEnrollmentsCompleted(ToInt(request.getParameter("enrollment")));
		status.setAssessmentsRecorded(ToInt(request.getParameter("assessment")));
		status.setVendorTrainingClearance(ToInt(request.getParameter("vendor")));
		status.setFeedbackCompleted(ToInt(request.getParameter("feedback")));
		status.setTrainingCompleted(ToInt(request.getParameter("completion")));

		return status;
	}
	
	public int ToInt(String checkboxValue)
	{
		if (checkboxValue != null && (checkboxValue.equalsIgnoreCase("on") || checkboxValue.equalsIgnoreCase("checked")))
			return 1;
		else 
			return 0;
	}
}
