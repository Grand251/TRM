package trm.controllers;

import java.sql.Timestamp;
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
import trm.dao.trainingrequest.*;

@Controller
public class RequesterController 
{
	@RequestMapping(value = "/pmdashboard")
	public String openMainView(ModelMap map) 
	{
		RequestCRUDService svc = new RequestCRUDService();
		DataStore.loadData();
		List<TrainingRequest> newReqs = svc.getITNewRequests();
		List<TrainingRequest> inProgressReqs = svc.getITInProgressRequests();
		List<TrainingRequest> doneReqs = svc.getITDoneRequests();
		
		map.addAttribute("newReq", newReqs);
		map.addAttribute("inProgressReqs", inProgressReqs);
		map.addAttribute("doneReqs", doneReqs);
		
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
//--------------------------------------
//		Boolean bool = PMServices.addRequest(request)
//		if(bool)
			return "mainview";
//		else
//			return "error";
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
		int ret = new RequestCRUDService().deleteTrainingRequest(reqId);
		
		if(ret > 0)
			return "redirect:/pmdashboard";
		else
			return "error";
	}
	
	@RequestMapping(value="requester/schedules/{id}/confirm", method=RequestMethod.PUT)
	public String confirmSchedule(@PathVariable("id") int scheduleId, ModelMap map)
	{
		int ret = new RequestCRUDService().confirmSchedule(scheduleId);
		
//------------------------------------------
		if(ret>0)
		return "testMainMenu";
		else
			return "error";
	}
	
	static class DataStore
	{
		static List<TrainingRequest> requests = new ArrayList<TrainingRequest>();
		static boolean hasLoaded = false;
		
		static void loadData()
		{
			if (!hasLoaded)
			{
				List<TrainingRequest> reqs = new ArrayList<TrainingRequest>();
				
				TrainingRequest req = new TrainingRequest();
				Random rand = new Random();
				
				req.setTrainingRequestId(rand.nextInt());
				reqs.add(req);
				
				req = new TrainingRequest();
				req.setTrainingRequestId(rand.nextInt());
				reqs.add(req);
				
				req = new TrainingRequest();
				req.setTrainingRequestId(rand.nextInt());
				reqs.add(req);
				
				req = new TrainingRequest();
				req.setTrainingRequestId(rand.nextInt());
				reqs.add(req);
				
				requests = reqs;
				hasLoaded = true;
			}
		}
	}
	
	class RequestCRUDService extends TrainingRequestCRUD
	{		
		public List<TrainingRequest> getITNewRequests()
		{
			return DataStore.requests;
		}
		
		public List<TrainingRequest> getITInProgressRequests()
		{
			List<TrainingRequest> reqs = new ArrayList<TrainingRequest>();
			
			return reqs;
		}
		
		public List<TrainingRequest> getITDoneRequests()
		{
			List<TrainingRequest> reqs = new ArrayList<TrainingRequest>();
			
			return reqs;
		}
		
		public int deleteTrainingRequest(int id)
		{
			for (int i = 0; i < DataStore.requests.size(); ++i)
			{
				if (DataStore.requests.get(i).getTrainingRequestId() == id)
				{
					DataStore.requests.remove(i);
					return 1;
				}
			}
			
			return 0;
		}
		
		public int confirmSchedule(int id)
		{
			return 0;
		}
		
		public Employee getExecutiveById(int execId)
		{
			Employee emp = new Employee();
			emp.setFirst_name("Sammy");
			
			return emp; 
		}
		
		public Employee getSPOCById(int spocId)
		{
			Employee emp = new Employee();
			emp.setFirst_name("Sammy");
			
			return emp; 
		}
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