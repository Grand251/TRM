package trm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;
import trm.executive.ExecWorkflowDTO;
import trm.dao.employee.Employee;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatusCRUD;
import trm.dao.internaltrainingrequest.*;

@Controller
public class ExecController 
{
	@RequestMapping(value="/execdashboard")
	public String index(ModelMap model)
	{
		InternalTrainingCRUD itrSvc = new InternalTrainingCRUD();
		List<ExecWorkflowDTO> trainings = new ArrayList<ExecWorkflowDTO>();
		
		for (ExecutiveWorkflowStatus status: new ExecutiveWorkflowStatusCRUD().getAllExecutiveWorkflowStatusByExec(1000044))
		{
			try
			{
				trainings.add(new ExecWorkflowDTO(status, itrSvc.getItrByTrainingRequest(status.getTrainingRequest()).getItrSchedule()));
			}
			catch (EmptyResultDataAccessException e)
			{
				System.out.println(status.getExecutiveWorkflowStatusId() + " : " + e.getMessage());
			}
		}
		
		model.addAttribute("trainings", trainings);
		
		return "execdashboard";
	}
	
	@RequestMapping(value="/execdashboard/{id}")
	public String updateStatus(HttpServletRequest request, @PathVariable int id, ModelMap modelW)
	{
		ExecutiveWorkflowStatusCRUD svc = new ExecutiveWorkflowStatusCRUD();
		int ret = svc.updateExecutiveWorkflowStatus(Map(request, svc.getExecutiveWorkflowStatusById(id)));
		
		if (ret > 0)
			return "redirect:/execdashboard";
		
		return "error";
	}
	
	public ExecutiveWorkflowStatus Map(HttpServletRequest request, ExecutiveWorkflowStatus status)
	{
		status.setInvitationsSent(Convert.ToInt(request.getParameter("email")));
		status.setSkillportEnrollmentsCompleted(Convert.ToInt(request.getParameter("enrollment")));
		status.setAssessmentsRecorded(Convert.ToInt(request.getParameter("assessment")));
		status.setVendorTrainingClearance(Convert.ToInt(request.getParameter("vendor")));
		status.setFeedbackCompleted(Convert.ToInt(request.getParameter("feedback")));
		status.setTrainingCompleted(Convert.ToInt(request.getParameter("completion")));

		return status;
	}
	
	static class Convert
	{
		static int ToInt(String checkboxValue)
		{
			if (checkboxValue != null && (checkboxValue.equalsIgnoreCase("on") || checkboxValue.equalsIgnoreCase("checked")))
				return 1;
			else 
				return 0;
		}
	}
}