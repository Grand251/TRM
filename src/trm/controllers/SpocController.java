package trm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.*;
import trm.dao.trainingrequest.*;

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
		
		return "requestoverview";
	}
	
	@RequestMapping(value="spocdashboard")
	public String showAllRequests(ModelMap model) {
		
		return "spocdashboard";
	}
	// Controllers for ClassroomTrainingMode
	@RequestMapping(value="crtmode")
	public String SelectedCRTMode(ModelMap map, @ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{
		TrainingSchedule schedule = new TrainingSchedule();
		ITRequest.setInternal_training_mode("CRT");
		map.addAttribute("command", ITRequest);
		map.addAttribute("command", schedule);
		return "crtmodeform";
	}
	
	@RequestMapping(value="confirmcrtMode")
	public String ConfirmCRTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule, 
			@ModelAttribute("ITRequest") trm.dao.internaltrainingrequest.InternalTrainingRequest ITRequest)
	{
		ITRequest.setItrId(schedule.getTraining_schedule_id());
		int ret = new InternalTrainingCRUD().updateItr(ITRequest);
		if (ret > 0)
			return "spocdashboard";
		else
			return "error";
	}
	
	//Controllers for WebTrainingMode
	@RequestMapping(value="wtmode")
	public String SelectedWTMode(ModelMap map, @ModelAttribute("ITRequest") InternalTrainingRequest ITRequest)
	{
		TrainingSchedule schedule = new TrainingSchedule();
		ITRequest.setInternal_training_mode("WT");
		map.addAttribute("command", ITRequest);
		map.addAttribute("command", schedule);
		return "crtmodeform";
	}
	
	@RequestMapping(value="confirmwtMode")
	public String ConfirmWTMode(ModelMap map, @ModelAttribute("schedule") TrainingSchedule schedule, 
			@ModelAttribute("ITRequest") trm.dao.internaltrainingrequest.InternalTrainingRequest ITRequest)
	{
		ITRequest.setItrId(schedule.getTraining_schedule_id());
		int ret = new InternalTrainingCRUD().updateItr(ITRequest);
		if (ret > 0)
			return "spocdashboard";
		else
			return "error";
	}
	
}
