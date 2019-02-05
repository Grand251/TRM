package trm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.employee.Employee;
import trm.dao.internaltrainingrequest.*;

@Controller
public class ExecController 
{
	@RequestMapping(value="/execdashboard")
	public String index(ModelMap model)
	{
//		ExecCRUD svc = new ExecCRUD();
		
//		List<InternalTrainingRequest> itrs = new InternalTrainingCRUDExt().getAllItrByExec();
//		List<InternalTraining> trainings = new ArrayList<InternalTraining>();
		
//		for (InternalTrainingRequest itr : itrs)
//		{
//			TrainingRequest req = itr.getItrTrainingRequest();
//			InternalTraining training = svc.GetTrainingByRequestId(req.getTrainingRequestId());
//			
//			trainings.add(training);
//		}
		
		List<InternalTraining> trainings = new ArrayList<InternalTraining>();
		InternalTraining training = new InternalTraining();
		training.setReqId(10000);
		trainings.add(training);
		
		model.addAttribute("trainings", trainings);
		
		return "execdashboard";
	}
	
	@RequestMapping(value="/exec/status{id}")
	public String updateStatus(HttpServletRequest request, @PathVariable int id, ModelMap model)
	{
		InternalTraining training = new ExecServices().Map(id, request);
		ExecCRUD svc = new ExecCRUD();
		
		svc.Update(training);
		
		return "execdashboard";
	}
	
	static class DataStore
	{
		static List<InternalTraining> trainings;
		
		static void Load()
		{
			trainings = new ArrayList<InternalTraining>();
			InternalTraining training = new InternalTraining();
			training.setReqId(10000);
			trainings.add(training);
		}
	}
}

class ExecServices
{
	InternalTraining Map(int id, HttpServletRequest request)
	{
		Boolean email = Boolean.parseBoolean(request.getParameter("email"));
		Boolean enrollment = Boolean.parseBoolean(request.getParameter("enrollment"));
		Boolean assessment = Boolean.parseBoolean(request.getParameter("assessment"));
		Boolean vendor = Boolean.parseBoolean(request.getParameter("vendor"));
		Boolean completion = Boolean.parseBoolean(request.getParameter("completion"));
		
		return new InternalTraining(id, email, enrollment, assessment, vendor, completion);
	}
}

class InternalTrainingCRUDExt extends InternalTrainingCRUD
{
	public List<InternalTrainingRequest> getAllItrByExec()
	{
		return new ArrayList<InternalTrainingRequest>();
	}
}

class ExecCRUD
{
	public InternalTraining GetTrainingByRequestId(int id)
	{
		return new InternalTraining();
	}
	
	public int Update(InternalTraining training)
	{
		return 1;
	}
}

class ParticipantCRUD
{
	public List<Participant> GetAllParticipantsForRequest(int id)
	{
		return new ArrayList<Participant>();
	}
}

class Participant
{
	public Employee employee;
	public TrainingRequest request;
}

class TrainingRequestEx extends TrainingRequest
{
	List<Participant> participants;
}
