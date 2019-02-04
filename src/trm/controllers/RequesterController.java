package trm.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		InternalTrainingCRUD trainingSvc = new InternalTrainingCRUD();
		
		List<PMRequestInfo> requests = new ArrayList<PMRequestInfo>();
		
		for (TrainingRequest req : new TrainingRequestCRUD().getAllTrainingRequestForPM(1000034))
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
		
		map.addAttribute("requests", requests);
		
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
//		TrainingRequest request = createRequest();
//		map.addAttribute("command", request);
		return "testEditRequest";
	}

//	@RequestMapping(value = "saveUpdateData")
//	public String saveUpdatedDetails(/*@ModelAttribute("request") TrainingRequest request, */ModelMap map) {
//		//int ret = new TrainingRequestCRUD().updateTrainingRequest(request);
//		int ret = 1;
//		if (ret > 0)
//			return "testMainMenu";
//		else
//			return "error";
//	}
	
	
	@RequestMapping(value="requests/{id}/delete")
	public String deleteRequest(@PathVariable("id") int reqId)
	{
		int ret = new TrainingRequestCRUD().deleteTrainingRequest(reqId);
		
		if(ret > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value="approve/{id}")
	public String approveSchedule(@PathVariable("id") int reqId, ModelMap map)
	{
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
	
	private Timestamp stringToTimestamp(String date, String time) 
	{
		LocalDate datePart = LocalDate.parse(date);
		LocalTime timePart = LocalTime.parse(time+":00");
		LocalDateTime dt = LocalDateTime.of(datePart, timePart);

		Timestamp timestamp = Timestamp.valueOf(dt);

		return timestamp;
	}
}