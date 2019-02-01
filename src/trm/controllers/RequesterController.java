package trm.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trm.dao.trainingrequest.*;

@Controller
public class RequesterController 
{
	@RequestMapping(value = "/pmdashboard")
	public String openMainView(ModelMap map) 
	{
		DataStore.loadData();
		List<TrainingRequest> newReqs = new RequestCRUDService().getITNewRequests();
		List<TrainingRequest> inProgressReqs = new RequestCRUDService().getITInProgressRequests();
		List<TrainingRequest> doneReqs = new RequestCRUDService().getITDoneRequests();
		
		map.addAttribute("newReq", newReqs);
		map.addAttribute("inProgressReqs", inProgressReqs);
		map.addAttribute("doneReqs", doneReqs);
		
		return "pmdashboard";
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
	
	@RequestMapping(value="requests/{id}/delete")
	public String deleteRequest(@PathVariable("id") int reqId)
	{
		int ret = new RequestCRUDService().deleteTrainingRequest(reqId);
		
		if(ret > 0)
			return "redirect:/requester/dashboard";
		else
			return "error";
	}
	
	@RequestMapping(value="requester/schedules/{id}/confirm", method=RequestMethod.PUT)
	public String confirmSchedule(@PathVariable("id") int scheduleId, ModelMap map)
	{
		int ret = new RequestCRUDService().confirmSchedule(scheduleId);
		
		if (ret>0)
			return "redirect:/requester/dashboard";
		else
			return "error";
	}
	
	static class DataStore
	{
		static List<TrainingRequest> requests = new ArrayList<TrainingRequest>();
		
		static void loadData()
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