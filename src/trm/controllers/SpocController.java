package trm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.*;
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
	
	@RequestMapping(value="allrequests")
	public String showAllRequests(ModelMap model) {
		
		return "allrequests";
	}
	// Controllers for ClassroomTrainingMode
	@RequestMapping(value="CRTMode")
	public String SelectedCRTMode(ModelMap map, @ModelAttribute("trainingRequest") TrainingRequest training_request)
	{
		//Get updated internal_training_request
		//map training_request to command to be passed 
		map.addAttribute("command", training_request);
		return "crtmodeform";
	}
	
	@RequestMapping(value="ConfirmCRTMode")
	public String ConfirmCRTMode(ModelMap map, @ModelAttribute("trainingRequest") TrainingRequest trainingRequest)
	{
		//Save updated request model from spring form
		int ret = new TrainingRequestCRUD().updateTrainingRequest(trainingRequest);
		//if updated, redirect to viewAllRequests
		//else go to error
		if (ret > 0)
			return "spocdashboard";
		else
			return "error";
	}
	
	//Controllers for WebTrainingMode
	@RequestMapping(value="WTMode")
	public String SelectedWTMode(ModelMap map, @ModelAttribute("trainingRequest") TrainingRequest trainingRequest)
	{
		//Get updated internal_training_request
		//map training_request to command to be passed 
		map.addAttribute("command", trainingRequest);

		return "wtmodeform";
	}
	
	@RequestMapping(value="ConfirmWTMode")
	public String ConfirmWTMode(ModelMap map, @ModelAttribute("trainingRequest") TrainingRequest trainingRequest)
	{
		//Save updated request model from spring form
		int ret = new TrainingRequestCRUD().updateTrainingRequest(trainingRequest);
		//if updated, redirect to viewAllRequests
		//else go to error
		if (ret > 0)
			return "spocdashboard";
		else
			return "error";
	}
	
}
