package trm.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.employee.Employee;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.*;
import trm.requestor.PMRequestInfo;

@Controller
public class RequesterController 
{
	@RequestMapping(value = "/pmdashboard")
	public String openMainView(HttpServletRequest request, ModelMap map) 
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		InternalTrainingCRUD trainingSvc = new InternalTrainingCRUD();
		
		List<PMRequestInfo> requests = new ArrayList<PMRequestInfo>();
		Employee pm = (Employee) request.getSession().getAttribute("user");
		
		for (TrainingRequest req : new TrainingRequestCRUD().getAllTrainingRequestForPM(pm.getEmployee_id()))
		{			
			if (req.getStatus() >= 0)
			{
				try
				{
					InternalTrainingRequest itr = trainingSvc.getItrByTrainingRequest(req.getTrainingRequestId());
					requests.add(new PMRequestInfo(req, itr, itr.getItrSchedule(), itr.getItrTrainer(), itr.getItrSpoc()));
				}
				catch (Exception e)
				{
					System.out.println(req.getTrainingRequestId() + " : " + e.getMessage());
					requests.add(new PMRequestInfo(req, null, null, null, null));
				}
			}
		}
		
		map.addAttribute("requests", requests);
		map.addAttribute("name", pm.getFirst_name() + " " + pm.getLast_name());
		
		return "pmdashboard";
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
		request.setRequesterId(1000019);// Change to session Employee ID
		request.setRequestTrainingType(requestTrainingType);
		request.setRequestTrainingModule(requestTrainingModule);
		request.setRequestTrainingModuleScope(requestTrainingModuleScope);
		request.setRequestTrainingMode(requestTrainingMode);
		request.setRequestStartTime(stringToTimestamp(requestStartDate, requestStartTime));
		request.setRequestEndTime(stringToTimestamp(requestEndDate, requestEndTime));
		request.setRequestLocation(requestLocation);
		request.setRequestTimeZone(requestTimeZone);
		request.setApproxNumberOfParticipants(approxNumberOfParticipants);
		Timestamp requestTime = new Timestamp(System.currentTimeMillis());
		request.setTimeRequested(requestTime);
		request.setStatus(0);
		int ref = new TrainingRequestCRUD().insertTrainingRequest(request);
		if (ref > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value = "editrequest/{trainingRequestId}")
	public String editRequest(@PathVariable("trainingRequestId") int trainingRequestId, ModelMap map) {
		TrainingRequest request = new TrainingRequestCRUD().getTrainingRequestById(trainingRequestId);
		map.addAttribute("command", request);
		return "editrequestscheduleform";
	}

	@RequestMapping(value = "editrequestschedule/{trainingRequestId}")
	public String editRequestSchedule(@PathVariable("trainingRequestId") int trainingRequestId, ModelMap map) {
		TrainingRequest request = new TrainingRequestCRUD().getTrainingRequestById(trainingRequestId);
		map.addAttribute("command", request);
		return "editrequestscheduleform";
	}
	
	@RequestMapping(value = "editrequesttraining/{trainingRequestId}")
	public String editRequestTraining(@PathVariable("trainingRequestId") int trainingRequestId, ModelMap map) {
		TrainingRequest request = new TrainingRequestCRUD().getTrainingRequestById(trainingRequestId);
		map.addAttribute("command", request);
		return "editrequesttrainingform";
	}

	

	@RequestMapping(value = "saveUpdateData")
	public String saveUpdatedDetails(@ModelAttribute("trainingRequestId") int trainingRequestId,
			@ModelAttribute("requestTrainingType") String requestTrainingType,
			@ModelAttribute("requestTrainingModule") String requestTrainingModule,
			@ModelAttribute("requestTrainingModuleScope") String requestTrainingModuleScope,
			@ModelAttribute("requestTrainingMode") String requestTrainingMode,
			@ModelAttribute("requestLocation") String requestLocation,
			@ModelAttribute("requestStartTime") String requestStartTime,
			@ModelAttribute("requestEndTime") String requestEndTime,
			@ModelAttribute("requestTimeZone") String requestTimeZone,
			@ModelAttribute("approxNumberOfParticipants") int approxNumberOfParticipants, ModelMap map) {

		int ret;
		ret = new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_Training_Type",
				requestTrainingType);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_Training_module",
				requestTrainingModule);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId,
				"request_Training_module_scope",

				requestTrainingModuleScope);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_Training_mode",
				requestTrainingMode);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_start_time",
				Timestamp.valueOf

				(requestStartTime));
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_end_time",
				Timestamp.valueOf

				(requestEndTime));
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_location",
				requestLocation);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId, "request_Time_zone",
				requestTimeZone);
		ret += new TrainingRequestCRUD().updateTrainingRequestByAttribute(trainingRequestId,
				"request_approx_participant",

				approxNumberOfParticipants);
		if (ret > 8)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	
	@RequestMapping(value = "saveScheduleUpdateData")
	public String saveScheduleUpdatedDetails(@ModelAttribute("trainingRequestId") int trainingRequestId,
			@ModelAttribute("requestLocation") String requestLocation,
			@ModelAttribute("requestStartTime") String requestStartTime,
			@ModelAttribute("requestEndTime") String requestEndTime,
			@ModelAttribute("requestTimeZone") String requestTimeZone,
			 ModelMap map) {

		int ret;
		ret = new TrainingRequestCRUD().updateTrainingRequestTimesTimezoneLocation(trainingRequestId, Timestamp.valueOf(requestStartTime), Timestamp.valueOf(requestEndTime), requestTimeZone, requestLocation);
		if (ret > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value = "saveTrainingUpdateData")
	public String saveTrainingUpdateDetails(@ModelAttribute("trainingRequestId") int trainingRequestId,
			@ModelAttribute("requestTrainingType") String requestTrainingType,
			@ModelAttribute("requestTrainingModuleScope") String requestTrainingModuleScope,
			@ModelAttribute("requestTrainingMode") String requestTrainingMode,
			@ModelAttribute("approxNumberOfParticipants") int approxNumberOfParticipants, ModelMap map) {

		int ret = new TrainingRequestCRUD().updateTrainingRequestScopeTypeModeParticip(trainingRequestId, requestTrainingModuleScope, requestTrainingType, requestTrainingMode, approxNumberOfParticipants);
		if (ret > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value="requests/{id}/delete")
	public String deleteRequest(HttpServletRequest request, @PathVariable("id") int reqId)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		int ret = new TrainingRequestCRUD().updateTrainingRequestByAttribute(reqId, "status", -1);
		
		if(ret > 0)
		{
			InternalTrainingCRUD svc = new InternalTrainingCRUD();
			InternalTrainingRequest itr = svc.getItrByTrainingRequest(reqId);
			
			if (itr != null)
			{
				itr.setItrStatus(-1);
				ret = svc.updateItr(itr);
				
				if (ret > 0)
				{
					return "redirect:/pmdashboard";
				}
			}
		}
		
		return "error";
	}
	
	@RequestMapping(value="approve/{id}")
	public String approveSchedule(HttpServletRequest request, @PathVariable("id") int reqId, ModelMap map)
	{
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		try
		{
			InternalTrainingCRUD svc = new InternalTrainingCRUD();
			InternalTrainingRequest itr = svc.getItrByTrainingRequest(reqId);
			itr.setItrStatus(itr.getItrStatus() + 1);
			svc.updateItr(itr);
		}
		catch (Exception e)
		{
			return "error";
		}
		
		return "redirect:/pmdashboard";
	}
	
	private Timestamp stringToTimestamp(String date, String time) {
		LocalDate datePart = LocalDate.parse(date);
		LocalTime timePart = LocalTime.parse(time+":00");
		LocalDateTime dt = LocalDateTime.of(datePart, timePart);

		Timestamp timestamp = Timestamp.valueOf(dt);

		return timestamp;
	}
}