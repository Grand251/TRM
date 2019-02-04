package trm.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainer.InternalTrainer;
import trm.dao.internaltrainer.InternalTrainerCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.*;
import trm.requestor.PMRequestInfo;

@Controller
public class RequesterController 
{
	@RequestMapping(value = "/pmdashboard")
	public String openMainView(ModelMap map) 
	{
		TrainingRequestCRUD reqSvc = new TrainingRequestCRUD();
		InternalTrainingCRUD trainingSvc = new InternalTrainingCRUD();
		InternalTrainerCRUD trainerSvc = new InternalTrainerCRUD();
		EmployeeCRUDService empSvc = new EmployeeCRUDService();
		
		List<PMRequestInfo> requests = new ArrayList<PMRequestInfo>();
		
		for (TrainingRequest req : reqSvc.getAllTrainingRequest())
		{
			try
			{
				
				InternalTrainingRequest itr = trainingSvc.getItrByTrainingRequest(req.getTrainingRequestId());
				Employee trainer = trainerSvc.getInternalTrainerById(itr.getItrId()).getTrainer();
				Employee spoc = empSvc.getEmployeeById(req.getRequestProjectSpoc());
				requests.add(new PMRequestInfo(
						req,
						spoc.getFirst_name() + " " + spoc.getLast_name(),
						spoc.getEmail(),
						itr.getItrStatus(), 
						trainer.getFirst_name() + " " + trainer.getLast_name(), 
						trainer.getEmail()));
			}
			catch (Exception e)
			{
				System.out.println(req.getTrainingRequestId() + " : " + e.getMessage());
			}
			
		}
		
		//requests.add(new PMRequestInfo(createRequest(), "Rie Kumar", "rk@gmail.com", 1, "miley", "ml@gmail.com"));
		
		map.addAttribute("requests", requests);
		
		return "PMDashboard";
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
	@ModelAttribute("requestStartDate") String requestStartDate,
	@ModelAttribute("requestEndDate") String requestEndDate,
	@ModelAttribute("requestStartTime") String requestStartTime,
	@ModelAttribute("requestEndTime") String requestEndTime,
	@ModelAttribute("requestTimeZone") String requestTimeZone, 
	@ModelAttribute("approxNumberOfParticipants") int approxNumberOfParticipants) {
	TrainingRequest request = new TrainingRequest();
	request.setRequesterId(1000019);//Change to session Employee ID
	request.setRequestTrainingType(requestTrainingType);
	request.setRequestTrainingModule(requestTrainingModule);
	request.setRequestTrainingModuleScope(requestTrainingModuleScope);
	request.setRequestTrainingMode(requestTrainingMode);
	request.setRequestStartTime(stringToTimestamp(requestStartDate, requestStartTime));
	request.setRequestEndTime(stringToTimestamp(requestEndDate, requestEndTime));
	request.setRequestLocation(requestLocation);
	request.setRequestTimeZone(requestTimeZone);
	request.setApproxNumberOfParticipants(approxNumberOfParticipants);
	request.setRequestProjectSpoc(1000008 /*java.sql.Types.INTEGER*/);//Change to null when DAO team allows null
	request.setExecutiveId(1000017 /*java.sql.Types.INTEGER*/);//Change to null when DAO team allows null
	Timestamp requestTime = new Timestamp(System.currentTimeMillis());
	request.setTimeRequested(requestTime);
	request.setStatus(0);
	int ref = new TrainingRequestCRUD().insertTrainingRequest(request);
	if(ref > 0)
	return "redirect:/pmdashboard";
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
	public String saveUpdatedDetails(/*@ModelAttribute("request") TrainingRequest request, */ModelMap map) {
		//int ret = new TrainingRequestCRUD().updateTrainingRequest(request);
		int ret = 1;
		if (ret > 0)
			return "testMainMenu";
		else
			return "error";
	}
	
	
	@RequestMapping(value="requests/{id}/delete")
	public String deleteRequest(@PathVariable("id") int reqId)
	{
		int ret = new TrainingRequestCRUD().deleteTrainingRequest(reqId);
		
		if(ret > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value="requester/schedules/{id}/confirm", method=RequestMethod.PUT)
	public String confirmSchedule(@PathVariable("id") int scheduleId, ModelMap map)
	{
		TrainingRequestCRUD svc = new TrainingRequestCRUD();
		
		int ret = 0;
		
		if(ret>0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	private Timestamp stringToTimestamp(String date, String time) {
		LocalDate datePart = LocalDate.parse(date);
		    LocalTime timePart = LocalTime.parse(time+":00");
		    LocalDateTime dt = LocalDateTime.of(datePart, timePart);

		Timestamp timestamp = Timestamp.valueOf(dt);

		return timestamp;
		}
}