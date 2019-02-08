package trm.controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.*;
import trm.dao.trainingrequest.*;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;
import trm.editors.EmployeeEditor;
import trm.editors.TrainingRequestEditor;
import trm.editors.TrainingScheduleEditor;


@Controller
public class SpocController {
	/*
	@RequestMapping(value="showoneTR/{employee_id}")
	public String showOneTR(@ModelAttribute("trainingRequest") int trainer_id, ModelMap map)
	{
		InternalTrainer internalTrainer = new InternalTrainerCRUD().getInternalTrainerById(trainer_id);
		map.addAttribute("trainingRequest", internalTrainer);
		return "trbyid";
	}*/	
	
	
	@RequestMapping(value="viewspocdashboard")
	public String showDashboard(ModelMap map)
	{
		List<TrainingRequest> newTR = new TrainingRequestCRUD().getAllTrainingRequestByStatus(0);
		List<TrainingRequest> TR = new TrainingRequestCRUD().getAllTrainingRequestByStatus(1);
		List<TrainingRequest> inProgressTR = new TrainingRequestCRUD().getAllTrainingRequestByStatus(2);
		//List<TrainingRequest> pendingTR = new TrainingRequestCRUD().getAllTrainingRequestByStatus(3);
		List<TrainingRequest> trList = new ArrayList<TrainingRequest>();
		
		trList.addAll(TR);
		trList.addAll(inProgressTR);
		//trList.addAll(pendingTR);
		
		map.addAttribute("ntrList", newTR);
		map.addAttribute("trList", trList);
		
		return "spocdashboard";
	}
	
	@RequestMapping(value="selectNewRequest")
    public String selectedTrainingRequest(HttpServletRequest request, ModelMap map) 
	{
		String[] ids = request.getParameterValues(("trainingRequestId"));
        Boolean reqPassed = false;

        String prev = null;
		for(String curr : ids)
		{
			if(prev != null){
				if(curr.contains("on")) {
					System.out.println(prev);
		        	int ret = new TrainingRequestCRUD().updateTrainingRequestByAttribute(Integer.parseInt(prev), "status", 1);
		        	if (ret > 0)
		        		reqPassed = true;
		        	else
		        	{
		        		reqPassed = false;
		        		break;
		        	}
				}
			}
			prev = curr;
		}
        if (reqPassed==true)
        	return "redirect:/viewspocdashboard";
        else
        	return "error";
    }
	
	@RequestMapping(value="selectTrainingType/{trainingRequestId}")
	public String selectTrainingType(@PathVariable("trainingRequestId") int trId, ModelMap map)
	{
		System.out.println(trId);
		
		TrainingRequest treq = new TrainingRequestCRUD().getTrainingRequestById(trId);
		map.addAttribute("command", treq);
		
		return "spocrequesttype";
	}
	
	@RequestMapping(value="saveTrainingType")
	public String saveTrainingType(@ModelAttribute("treq") TrainingRequest treq, ModelMap map)
	{

		int type = new TrainingRequestCRUD().updateTrainingRequestByAttribute(treq.getTrainingRequestId(), 
				"request_training_type", treq.getRequestTrainingType());
		if(type > 0)
		{
			int status = new TrainingRequestCRUD().updateTrainingRequestByAttribute(treq.getTrainingRequestId(), "status", 2);
			if(status > 0)
				return "redirect:/viewspocdashboard";
			else
				return "error";
		}
		else
			return "error";
	}

	@RequestMapping(value="steponeform/{itrId}")
	public String stepOneForm(@PathVariable("itrId") int itrId, ModelMap map) {
		map.addAttribute("itrId", itrId);
		EmployeeCRUDService empCrud = new EmployeeCRUDService();
		List<Employee> trainers = empCrud.getAllEmployeeByTitle("Trainer");
		map.addAttribute("trainers", trainers);
		return "steponeform";
	}
	
	@RequestMapping(value="submitstepone/{itrId}")
	public String submitStepOne(@PathVariable("itrId") int itrId, HttpServletRequest request, ModelMap map) {
		map.addAttribute("itrId", itrId);
		InternalTrainingCRUD itrCrud = new InternalTrainingCRUD();
		InternalTrainingRequest itr = itrCrud.getItrById(itrId);
		TrainingScheduleCRUDService tsCrud = new TrainingScheduleCRUDService();
		//TrainingSchedule ts = tsCrud.getTrainingScheduleById(itr.get);
		TrainingSchedule ts = itr.getItrSchedule();
		
		itr.setItrMode(request.getParameter("mode"));
		int trainerId = Integer.parseInt(request.getParameter("trainerId"));
		Employee trainer = new EmployeeCRUDService().getEmployeeById(trainerId);
		itr.setItrTrainer(trainer);
		//Selected Trainer
		itrCrud.updateItr(itr);
		
		Date startDate = null;
		Date endDate = null;
		try {
			System.out.println(request.getParameter("startDate"));
			String temp;
			startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse((String)request.getParameter("startDate")).getTime());
			endDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String)request.getParameter("endDate")).getTime());
		} catch (Exception e) {System.out.println(e.getMessage()); return "error";}
		
		ts.setTraining_start_date(startDate);
		ts.setTraining_end_date(endDate);
		tsCrud.updateTrainingSchedule(ts.getTraining_schedule_id(), "", "", "", "", "", "", "", 
				ts.getTraining_start_date(), ts.getTraining_end_date());
		return "redirect:/edititr/" + itrId;
	}
	
	
	//initBinder allows Spring forms to map user input to attributes of type Employee, TrainingRequest, and TrainingSchedule
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder ) {

	        binder.registerCustomEditor(Employee.class, new EmployeeEditor(new EmployeeCRUDService()));
	        binder.registerCustomEditor(TrainingRequest.class, new TrainingRequestEditor(new TrainingRequestCRUD()));
	        binder.registerCustomEditor(TrainingSchedule.class, new TrainingScheduleEditor(new TrainingScheduleCRUDService()));
	  
	} 
	@RequestMapping(value="spocdashboard")
	public String viewSpocDashboard(HttpServletRequest request, ModelMap model) {
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		return "spocdashboard";
	}
	
		  
	@RequestMapping(value="showallitr")
	public String showallITRequests(ModelMap map) {
		List<InternalTrainingRequest> internalTrainingRequests = new InternalTrainingCRUD().getAllItr();
		map.addAttribute("internalTrainingRequests", internalTrainingRequests);
		
		return "allitrequests";
	}
	@RequestMapping(value="showallemployees")
	public String showallEmployees(ModelMap map) {
		List<Employee> employees = new EmployeeCRUDService().getAllEmployee();
		map.addAttribute("employees", employees);
		
		return "allemployees";
	}
	@RequestMapping(value="showalltr")
	public String showallTRequests(ModelMap map) {
		List<TrainingRequest> trainingRequests = new TrainingRequestCRUD().getAllTrainingRequest();
		map.addAttribute("trainingRequests", trainingRequests);
		
		return "alltrequests";
	}
	@RequestMapping(value="showallschedules")
	public String showallSchedules(ModelMap map) {
		List<TrainingSchedule> trainingSchedules = new TrainingScheduleCRUDService().getAllTrainingSchedule();
		map.addAttribute("trainingSchedules", trainingSchedules);
		
		return "allschedules";
	}
	@RequestMapping(value="insertitrform")
	public String insertITRequestForm(ModelMap map)
	{
		InternalTrainingRequest internalTrainingRequest = new InternalTrainingRequest();
		map.addAttribute("command", internalTrainingRequest);

		List<Employee> employees = new EmployeeCRUDService().getAllEmployee();
		List<TrainingRequest> trainingRequests = new TrainingRequestCRUD().getAllTrainingRequest();
		List<TrainingSchedule> schedules = new TrainingScheduleCRUDService().getAllTrainingSchedule();
		

		map.addAttribute("employees", employees);
		map.addAttribute("trainingRequests", trainingRequests);
		map.addAttribute("schedules", schedules);

		
		
		return "insertitr";
	}
	@RequestMapping(value="edititr/{itrId}")
	public String editiITRequest(@PathVariable("itrId") int itrId, ModelMap map)
	{
		//create Internal Training object here --->
		//change from internalTrainingRequest to InternalTraining
		InternalTrainingRequest itr = new InternalTrainingCRUD().getItrById(itrId);
		List<Employee> execList = new EmployeeCRUDService().getAllEmployeeByTitle("Executive");
		//------------Important code to be written---------------------
		//command is a keyword
		map.addAttribute("execList", execList);
		map.addAttribute("itrId", itrId);
		map.addAttribute("itr", itr);
		EmployeeCRUDService empCrud = new EmployeeCRUDService();
		List<Employee> trainers = empCrud.getAllEmployeeByTitle("Trainer");
		map.addAttribute("trainers", trainers);
		
		if (itr.getItrStatus() > 3)
			map.addAttribute("approvalStatus", "Confirmed");
		else
			map.addAttribute("approvalStatus", "Not Confirmed");

		
		return "edititrform";
	}
	@RequestMapping(value="saveUpdatedData")
	public String saveUpdatedDetails(@ModelAttribute("itr") InternalTrainingRequest itr)
	{
		itr.setItrStatus(3);
		itr.getItrTrainingRequest().setStatus(4);
		
		/*
		int ret = new InternalTrainingTableCRUD.insert();
		
		if(ret > 0)
			return "redirect:/showall";
		else
			return "error";
		*/
		return "redirect:/edititrform/1000000";
		
	}
	@RequestMapping(value="newitr")
	public String insertITRequest(@ModelAttribute("internalTrainingRequest") InternalTrainingRequest internalTrainingRequest)
	{
		
		System.out.println(internalTrainingRequest.getItrTrainer());
		//internalTrainingRequest.setItrId(99999);
		int ret = new InternalTrainingCRUD().insertItr(internalTrainingRequest);
		
		if(ret > 0)
			return "redirect:/showallitr";
		else
			return "error";
	}
	@RequestMapping(value="DT")
	public String showDTRequests(ModelMap model) {
		
		return "dtform";
	}
	@RequestMapping(value="VT")
	public String showVTRequests(ModelMap model) {
		
		return "vtform";
	}
	@RequestMapping(value="pmastatus")
	public String showPMAStatus(ModelMap model) {
		
		return "pmastatus";
	}
	
	@RequestMapping(value="confirmtrainingform")
	public String confirmTraining(ModelMap model) {
		
		return "confirmtrainingform";
	}
	
	@RequestMapping(value="requestoverview")
	public String editRequest(ModelMap model) {
		
		return "spocrequestoverview";
	}
	
}
