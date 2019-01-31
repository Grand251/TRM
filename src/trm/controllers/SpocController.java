package trm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


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
