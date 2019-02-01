package trm.controllers;

import java.sql.Timestamp;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trm.dao.TrainingRequest;
import trm.dao.TrainingRequestCRUD;

@Controller
public class RequesterController {
	@RequestMapping(value = "/")
	public String openMainView() {
		return "testMainMenu";
	}

	@RequestMapping(value = "openmain")
	public String openMainView(@ModelAttribute("usertype") int userType, ModelMap map) {
		if (userType == 0)
			return "requestermain";
		if (userType == 1)
			return "SPOCmain";
		else
			return "execmain";
	}

	@RequestMapping(value = "createrequest")
	public String createNewRequests(ModelMap map) {
		return "testNewRequest";
	}

	@RequestMapping(value = "addnewrequest")
	public String addNewRequest(@ModelAttribute("requestTrainingType") String requestTrainingType, 
			@ModelAttribute("requestTrainingModule") String requestTrainingModule, 
			@ModelAttribute("requestTrainingModuleScope") String requestTrainingModuleScope, 
			@ModelAttribute("requestTrainingMode") String requestTrainingMode, 
			@ModelAttribute("requestLocation") String requestLocation, 
			@ModelAttribute("requestTimeZone") String requestTimeZone, 
			@ModelAttribute("approxNumberOfParticipants") String approxNumberOfParticipants, ModelMap map) {
		TrainingRequest request = new TrainingRequest();
		request.setRequestTrainingType(requestTrainingType);
		request.setRequestTrainingModule(requestTrainingModule);
		request.setRequestTrainingModuleScope(requestTrainingModuleScope);
		request.setRequestTrainingMode(requestTrainingMode);
		request.setRequestLocation(requestLocation);
		request.setRequestTimeZone(requestTimeZone);
		int nbOfParticipant = Integer.parseInt(approxNumberOfParticipants);
		request.setApproxNumberOfParticipants(nbOfParticipant);
		Timestamp requestTime = new Timestamp(System.currentTimeMillis());
		request.setTimeRequested(requestTime);
		//int ref = new TrainingRequestCRUD().insertTrainingRequest(request);
//----------TESTING-------------------		
		
		System.out.println(requestTrainingType);
		System.out.println(requestTrainingModule);
		System.out.println(requestTrainingModuleScope);
		System.out.println(requestTrainingMode);
		System.out.println(requestLocation);
		System.out.println(requestTimeZone);
		System.out.println(nbOfParticipant);
		System.out.println(requestTime.toString());
		int ref = 1;
		
//------------------------------------------
		if(ref>0)
		return "testMainMenu";
		else
			return "error";
	}

	@RequestMapping(value = "editrequest")
	public String editRequest(/*@PathVariable("trainingRequestId") int trainingRequestId,*/ ModelMap map) {
		//TrainingRequest request = new TrainingRequestCRUD().getTrainingRequestById(trainingRequestId);
		TrainingRequest request = createRequest();
		map.addAttribute("command", request);
		return "testEditRequest";
	}
	
//-------------HELPER METHOD FOR TESTING---------
	public TrainingRequest createRequest() {
		TrainingRequest r = new TrainingRequest();
		r.setTrainingRequestId(121212);
		r.setRequesterId(5056970);
		r.setRequestTrainingType("Internal Training");
		r.setRequestTrainingModule("Java");
		r.setRequestTrainingModuleScope("OOP, AOP, Spring");
		r.setRequestTrainingMode("Classroom");
		r.setRequestStartTime(new Timestamp(System.currentTimeMillis()+50000000));
		r.setRequestEndTime(new Timestamp(System.currentTimeMillis()+1000000000));
		r.setRequestLocation("Boston, MA");
		r.setRequestTimeZone("EST");
		r.setApproxNumberOfParticipants(12);
		r.setRequestProjectSpoc(5025649);
		r.setExecutiveId(5046879);
		r.setTimeRequested(new Timestamp(System.currentTimeMillis()-100000));
		return r;
		
	}

	@RequestMapping(value = "saveUpdateData")
	public String saveUpdatedCustomerDetails(/*@ModelAttribute("request") TrainingRequest request, */ModelMap map) {
		//int ret = new TrainingRequestCRUD().updateTrainingRequest(request);
		int ret = 1;
		if (ret > 0)
			return "testMainMenu";
		else
			return "error";
	}

	@RequestMapping(value = "requester/requests/{id}", method = RequestMethod.DELETE)
	public String deleteRequest(@PathVariable("id") int reqId) {
		int ret = new TrainingRequestCRUD().deleteTrainingRequest(reqId);

		if (ret > 0)
			return "redirect:/requester/dashboard";
		else
			return "error";
	}

	@RequestMapping(value = "requester/schedules/{id}/confirm", method = RequestMethod.PUT)
	public String confirmSchedule(@PathVariable("id") int scheduleId, ModelMap map) {
		// int ret = new RequestCRUDService().confirmSchedule(scheduleId);

//		if (ret > 0)
		return "redirect:/requester/dashboard";
//		else
//			return "error";
	}

}