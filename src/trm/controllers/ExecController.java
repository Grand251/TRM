package trm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.executive.ExecWorkflowDTO;
import trm.executive.ExecWorkflowFormDTO;
import trm.executive.ExecutiveUtilities;
import trm.dao.employee.Employee;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatusCRUD;

@Controller
public class ExecController 
{
	@RequestMapping(value="/execdashboard")
	public String index(HttpServletRequest request, ModelMap model)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		InternalTrainingCRUD itrSvc = new InternalTrainingCRUD();
		List<ExecWorkflowDTO> trainings = new ArrayList<ExecWorkflowDTO>();
		Employee executive = (Employee)request.getSession().getAttribute("user");
		
		for (ExecutiveWorkflowStatus status: new ExecutiveWorkflowStatusCRUD().getAllExecutiveWorkflowStatusByExec(executive.getEmployee_id()))
		{
			try
			{
				trainings.add(new ExecWorkflowDTO(status, itrSvc.getItrByTrainingRequest(status.getTrainingRequest()).getItrSchedule()));
			}
			catch (EmptyResultDataAccessException e)
			{
				System.out.println(status.getExecutiveWorkflowStatusId() + " : " + e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println(status.getExecutiveWorkflowStatusId() + " : " + e.getMessage());
			}
		}
		
		model.addAttribute("trainings", trainings);
		
		return "execdashboard";
	}
	
	@RequestMapping(value="/execdashboard/{id}")
	public String getWorkflowForm(HttpServletRequest request, @PathVariable int id, ModelMap model)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		ExecutiveWorkflowStatus workflow = new ExecutiveWorkflowStatusCRUD().getExecutiveWorkflowStatusById(id);
		InternalTrainingRequest itr = new InternalTrainingCRUD().getItrByTrainingRequest(workflow.getTrainingRequest());
		
		model.addAttribute("dto", new ExecWorkflowFormDTO(workflow, itr));
		
		return "executiveprogress";
	}
	
	@RequestMapping(value="/execdashboard/{id}", method = RequestMethod.POST)
	public String updateStatus(HttpServletRequest request, @PathVariable int id, ModelMap model)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";

		ExecutiveWorkflowStatusCRUD svc = new ExecutiveWorkflowStatusCRUD();
		
		int ret = svc.updateExecutiveWorkflowStatus(new ExecutiveUtilities().Map(request, svc.getExecutiveWorkflowStatusById(id)));
		
		if (ret > 0)
			return "redirect:/execdashboard";
		
		return "error";
	}
}