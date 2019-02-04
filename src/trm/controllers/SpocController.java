package trm.controllers;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainer.InternalTrainer;
import trm.dao.internaltrainer.InternalTrainerCRUD;
import trm.dao.internaltrainingrequest.*;
import trm.dao.trainingrequest.*;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

@Controller
public class SpocController {
	
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
	
	@RequestMapping(value="spocdashboard")
	public String showAllRequests(ModelMap model) {
		
		return "spocdashboard";
	}
	
	//Controller to get new training_req for internal_training_req to be initialized
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
	
	@RequestMapping(value="confirmschedule")
	public String ConfirmSchedule(@ModelAttribute("schedule") TrainingSchedule schedule, ModelMap map)
	{	
		Date date = new Date();
		map.addAttribute("currentTimestamp", date.toString());	
		
		Employee spoc = new Employee();
		map.addAttribute("spoc", spoc);
		
		int ret = new TrainingScheduleCRUDService().insertTrainingSchedule(schedule);
		
		if (ret > 0)
			return "redirect:/spocnewschedule";
		else
			return "error";
	}
	
	@RequestMapping(value="newitr/selectitrtrainer")
	public String SelectITRTrainer(@RequestParam("itrTrainer") Employee itrTrainer,
			@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map)
	{
//		itr.setItrTrainer(itrTrainer);
//		itr.setItrStatusDescription("Trainer Selected");
		map.addAttribute("command", itr);
		return "spocnewschedule";
	}
	
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
	
	// Controllers for ClassroomTrainingMode
	@RequestMapping(value="crtmode")
	public String SelectedCRTMode(@ModelAttribute("itr") InternalTrainingRequest itr,
			@ModelAttribute("spoc") Employee spoc, ModelMap map)
	{
		map.addAttribute("spoc", spoc);
		map.addAttribute("command", itr);
		
		return "spoccrtmodeform";
	}
	
	
	@RequestMapping(value="confirmcrtmode")
	public String ConfirmCRTMode(@ModelAttribute("itr") InternalTrainingRequest itr, ModelMap map)
	{
		return "redirect:/newitr";
	}
	
	//Controllers for WebTrainingMode
	@RequestMapping(value="wtmode")
	public String SelectedWTMode(ModelMap map, @ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{
		
		TrainingSchedule schedule = ITRequest.getItrSchedule();
		ITRequest.setItrMode("WT");
		map.addAttribute("command", schedule);
		return "spocwtmodeform";
	}
	
	@RequestMapping(value="confirmwtmode")
	public String ConfirmWTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule)
	{
		int ret = new TrainingScheduleCRUDService().updateTrainingSchedule(schedule.getTraining_schedule_id(), 
				schedule.getTraining_city(), schedule.getTraining_state(), schedule.getTraining_country(), 
				schedule.getTraining_zipcode(), schedule.getTraining_time_zone(), schedule.getTraining_location(), 
				schedule.getTraining_room_number(), schedule.getTraining_start_date(), schedule.getTraining_end_date());
		if (ret > 0)
			return "spocdashboard";
		else
			return "error";
	}
	
}
