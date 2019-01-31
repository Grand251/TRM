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
	
}
