package trm.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequesterController {


	@RequestMapping(value = "/")
	public String openMainView() {
		return "mainview";
	}

	@RequestMapping(value = "createrequest")
	public String createNewRequests(ModelMap map) 
	{
		return "newrequestform";
	}
	
	@RequestMapping( value = "addnewrequest")
	public String addNewRequest(@ModelAttribute("request") Request request, ModelMap map) 
	{
		Timestamp requestTime = new Timestamp(System.currentTimeMillis());
		request.setRequestTimeStamp(requestTime);
//		Boolean bool = PMServices.addRequest(request)
//		if(bool)
			return "mainview";
//		else
//			return "error";
	}
	
	@RequestMapping(value = "editrequest/{requestId}")
	public String editCustomer(@PathVariable("requestId") int reqID, ModelMap map) {
//		Request request = new TRM.DAO.TrainingRequest().getRequestById(reqID);
//		map.addAttribute("command",request);
		return "editform";
	}
	
	@RequestMapping(value = "saveUpdateData")
	public String saveUpdatedCustomerDetails(@ModelAttribute("request") Request request, ModelMap map) {
//		boolean bool = new PMServices.updateRequest(request);
//		if (bool)
			return "mainview";
//		else
//			return "error";
	}
}

//dummy class
class Request{
	private Timestamp requestTimeStamp;

	public Timestamp getRequestTimeStamp() {
		return requestTimeStamp;
	}

	public void setRequestTimeStamp(Timestamp timestamp) {
		this.requestTimeStamp = timestamp;
	}
}