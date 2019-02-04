package trm.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
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
	//initBinder allows Spring forms to map user input to attributes of type Employee, TrainingRequest, and TrainingSchedule
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder ) {

	        binder.registerCustomEditor(Employee.class, new EmployeeEditor(new EmployeeCRUDService()));
	        binder.registerCustomEditor(TrainingRequest.class, new TrainingRequestEditor(new TrainingRequestCRUD()));
	        binder.registerCustomEditor(TrainingSchedule.class, new TrainingScheduleEditor(new TrainingScheduleCRUDService()));
	  
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
	@RequestMapping(value="newitr")
	public String insertITRequest(@ModelAttribute("internalTrainingRequest") InternalTrainingRequest internalTrainingRequest)
	{
		
		System.out.println(internalTrainingRequest.getItrTrainer());
		internalTrainingRequest.setItrId(99999);
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
		
		return "requestoverview";
	}
	
	@RequestMapping(value="allrequests")
	public String showAllRequests(ModelMap map) {
		
		List<TrainingRequest> trainingRequests = new TrainingRequestCRUD().getAllTrainingRequest();
		map.addAttribute("trainingRequests", trainingRequests);
		return "allrequests";
	}
	// Controllers for ClassroomTrainingMode
	@RequestMapping(value="CRTMode")
	public String SelectedCRTMode(ModelMap map)
	{
		//Get updated internal_training_request and save to temp
		//map temp to command to be passed 
		
		return "CRTModeForm";
	}
	
	@RequestMapping(value="ConfirmCRTMode")
	public String ConfirmCRTMode(ModelMap map)
	{
		//Save updated request model from spring form
		//-location, room booked
		//call service to update internal_training_req to database
		//if updated, redirect to viewAllRequests
		//else go to error
		
		return "";
	}
	
	//Controllers for WebTrainingMode
	@RequestMapping(value="WTMode")
	public String SelectedWTMode(ModelMap map)
	{
		//Get updated internal_training_request and save to temp
		//map temp to command to be passed 
		
		return "WTModeForm";
	}
	
	@RequestMapping(value="ConfirmWTMode")
	public String ConfirmWTMode(ModelMap map)
	{
		//Save updated request model from spring form
		//-web services chosen
		//call service to update internal_training_req to database
		//if updated, redirect to viewAllRequests
		//else go to error
		
		return "";
	}
	
}

