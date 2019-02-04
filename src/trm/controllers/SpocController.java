package trm.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainer.InternalTrainer;
import trm.dao.internaltrainer.InternalTrainerCRUD;
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
	//initBinder allows Spring forms to map user input to attributes of type Employee, TrainingRequest, and TrainingSchedule
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder ) {

	        binder.registerCustomEditor(Employee.class, new EmployeeEditor(new EmployeeCRUDService()));
	        binder.registerCustomEditor(TrainingRequest.class, new TrainingRequestEditor(new TrainingRequestCRUD()));
	        binder.registerCustomEditor(TrainingSchedule.class, new TrainingScheduleEditor(new TrainingScheduleCRUDService()));
	  
	} 
	@RequestMapping(value="spocdashboard")
	public String viewSpocDashboard(ModelMap model) {
		return "spocdashboard";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	  
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
		
		return "spocrequestoverview";
	}
	

	// Controllers for ClassroomTrainingMode
	@RequestMapping(value="crtmode")
	public String SelectedCRTMode(ModelMap map, @ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{
		ITRequest.setItrMode("CRT");
		map.addAttribute("command", ITRequest);
		return "crtmodeform";
	}
//	
//	@RequestMapping(value="confirmcrtMode")
//	public String ConfirmCRTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule,
//			@ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
//	{
//		ITRequest.setItrId(Integer.parseInt(schedule.getTraining_schedule_id()));
//		int ret = new InternalTrainingCRUD().updateItr(ITRequest);
//	}
	
	//Controller to get new training_req for internal_training_req to be initialized 
	/*
	@RequestMapping(value="newitr")
	public String SelectedITR(ModelMap map, RedirectAttributes redirectAttributes,
			@ModelAttribute("itr") InternalTrainingRequest itr)
	{	
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh24:mm:ss");
		Date date = new Date();
		map.addAttribute("currentTimestamp", date.toString());
		
		//set spoc as fixed data for testing
		Employee spoc = new EmployeeCRUDService().getEmployeeById(1000008);
		map.addAttribute("spoc", spoc);
		
		//temp request to add to new internal training
		TrainingRequest temp_req = new TrainingRequestCRUD().getTrainingRequestById(10000);
		
		if(itr.getItrStatus() == 0)
		{
			itr = new InternalTrainingRequest();
			itr.setItrSpoc(spoc);
			itr.setItrStatus(1);
			itr.setItrTrainingRequest(temp_req);
			itr.setItrStatusDescription("Request Started");
		}
		else
		{
			itr.getItrStatus();
			itr.setItrStatusDescription("Request In Progress");
		}
		
		List<Employee> trainers = new ArrayList<>();
		for (InternalTrainer temp: new InternalTrainerCRUD().getAllInternalTrainers()) {
			trainers.add(temp.getTrainer());
		}
		map.addAttribute("trainers", trainers);
		map.addAttribute("command", itr);
		redirectAttributes.addFlashAttribute("itr", itr);
		
		return "spocnewitrform";
	}
	*/
	@RequestMapping(value="newitr/itrschedule")
	public String InputSchedule(@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map)
	{	
		Date date = new Date();
		map.addAttribute("currentTimestamp", date.toString());
				
		TrainingSchedule schedule = new TrainingSchedule();
		itr.setItrSchedule(schedule);
		map.addAttribute("command", schedule);
		
		Employee spoc = new Employee();
		map.addAttribute("spoc", spoc);
		
		return "spocnewschedule";
	}
	
//	@RequestMapping(value="confirmschedule")
//	public String ConfirmSchedule(@ModelAttribute("schedule") TrainingSchedule schedule, ModelMap map)
//	{	
//		Date date = new Date();
//		map.addAttribute("currentTimestamp", date.toString());	
//		
//		Employee spoc = new Employee();
//		map.addAttribute("spoc", spoc);
//		
//		int ret = new TrainingScheduleCRUDService().insertTrainingSchedule(schedule);
//		
//
//		if (ret > 0)
//			return "redirect:/spocnewschedule";
//		else
//			return "error";	
//	}
	
	@RequestMapping(value="newitr/selectitrtrainer")
	public String SelectITRTrainer(@RequestParam("itrTrainer") Employee itrTrainer,
			@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map)
	{
//		itr.setItrTrainer(itrTrainer);
//		itr.setItrStatusDescription("Trainer Selected");
		map.addAttribute("command", itr);
		return "spocnewschedule";
	}
	/*
	@RequestMapping(value="newitr/selectitrmode")
	public String SelectITRMode(@RequestParam("itrMode") String itrMode, 
			@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map,
			RedirectAttributes redirectAttributes)
	{
		Date date = new Date();
		map.addAttribute("currentTimestamp", date.toString());
		
		if(itrMode.equals("CRT"))
		{
			itr.setItrMode(itrMode);
			itr.setItrStatusDescription("Training Mode Selected");
			map.addAttribute("command", itr);
			return "spoccrtmodeform";
		}
		else if (itrMode.equals("WT"))
		{
			itr.setItrMode(itrMode);
			itr.setItrStatusDescription("Training Mode Selected");
			map.addAttribute("command", itr);
			return "spocwtmodeform";
		}
		else
			return "error";
	}
	*/
	// Controllers for ClassroomTrainingMode
	/*
	@RequestMapping(value="crtmode")
	public String SelectedCRTMode(@ModelAttribute("itr") InternalTrainingRequest itr,
			@ModelAttribute("spoc") Employee spoc, ModelMap map)
	{
		map.addAttribute("spoc", spoc);
		map.addAttribute("command", itr);
		
		return "spoccrtmodeform";
	}
	
	*/
	@RequestMapping(value="confirmcrtmode")
	public String ConfirmCRTMode(@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map)
	{
		return "redirect:/newitr";
	}
	
	//Controllers for WebTrainingMode
	@RequestMapping(value="wtmode")
	public String SelectedWTMode(ModelMap map, @ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{

		ITRequest.setItrMode("WT");
		map.addAttribute("command", ITRequest);
		return "crtmodeform";
	}
	
	@RequestMapping(value="confirmwtMode")
	public String ConfirmWTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule,
			@ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{
		ITRequest.setItrId(Integer.parseInt(schedule.getTraining_schedule_id()));
		int ret = new InternalTrainingCRUD().updateItr(ITRequest);

		ITRequest.setItrMode("WT");
		map.addAttribute("command", schedule);
		return "spocwtmodeform";
	}
	
//	@RequestMapping(value="confirmwtmode")
//	public String ConfirmWTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule)
//	{
//		int ret = new TrainingScheduleCRUDService().updateTrainingSchedule(schedule.getTraining_schedule_id(), 
//				schedule.getTraining_city(), schedule.getTraining_state(), schedule.getTraining_country(), 
//				schedule.getTraining_zipcode(), schedule.getTraining_time_zone(), schedule.getTraining_location(), 
//				schedule.getTraining_room_number(), schedule.getTraining_start_date(), schedule.getTraining_end_date());
//
//		if (ret > 0)
//			return "spocdashboard";
//		else
//			return "error";
//	}
	
}
