package trm.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatus;
import trm.dao.executiveworkflowstatus.ExecutiveWorkflowStatusCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.trainingparticipant.TrainingParticipant;
import trm.dao.trainingparticipant.TrainingParticipantCRUD;
import trm.dao.internaltrainingrequest.*;
import trm.dao.trainingrequest.*;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;
import trm.editors.EmployeeEditor;
import trm.editors.TrainingRequestEditor;
import trm.editors.TrainingScheduleEditor;


@Controller
public class SpocController {
	/*
	@RequestMapping(value="showoneTR/{employee_id}")
	public String showOneTR(@ModelAttribute("trainingRequest") int trainer_id, ModelMap map)
	{
		InternalTrainer internalTrainer = new InternalTrainerCRUD().getInternalTrainerById(trainer_id);
		map.addAttribute("trainingRequest", internalTrainer);
		return "trbyid";
	}*/	
	
	
	@RequestMapping(value="viewspocdashboard")
	public String showDashboard(ModelMap map)
	{
		int spocId = 1000037;
		
		List<TrainingRequest> trs = new TrainingRequestCRUD().getAllRequestBySPOCStatus(spocId, 0);
		List<TrainingRequest> tr = new TrainingRequestCRUD().getAllRequestBySPOCStatus(spocId, 1);
		List<InternalTrainingRequest> itr = new InternalTrainingCRUD().getAllItrBySPOC(spocId);
		
		
		map.addAttribute("ntrList", trs);
		map.addAttribute("trList", tr);
		
		List<InternalTrainingRequest> rightOnes = new ArrayList<InternalTrainingRequest>();
		for (InternalTrainingRequest i : itr){
			if (i.getItrStatus() < 5) {
				rightOnes.add(i);
				if (i.getItrStatus() == 2)
					i.setItrStatusDescription("New");
				if (i.getItrStatus() == 3)
					i.setItrStatusDescription("Pending PM Approval");
				if (i.getItrStatus() == 4)
					i.setItrStatusDescription("PM Approval Recieved");
			}
		}
		map.addAttribute("itrList", rightOnes);
		
		

		
		return "spocdashboard";
	}
	
	@RequestMapping(value="selectNewRequest")
    public String selectedTrainingRequest(HttpServletRequest request, ModelMap map) 
	{
		String[] ids = request.getParameterValues(("trainingRequestId"));
        Boolean reqPassed = false;

        String prev = null;
		for(String curr : ids)
		{
			if(prev != null){
				if(curr.contains("on")) {
					System.out.println(prev);
		        	int ret = new TrainingRequestCRUD().updateTrainingRequestByAttribute(Integer.parseInt(prev), "status", 1);
		        	if (ret > 0)
		        		reqPassed = true;
		        	else
		        	{
		        		reqPassed = false;
		        		break;
		        	}
				}
			}
			prev = curr;
		}
        if (reqPassed==true)
        	return "redirect:/viewspocdashboard";
        else
        	return "error";
    }
	
	@RequestMapping(value="selectTrainingType/{trainingRequestId}")
	public String selectTrainingType(@PathVariable("trainingRequestId") int trId, ModelMap map)
	{
		System.out.println(trId);
		
		TrainingRequest treq = new TrainingRequestCRUD().getTrainingRequestById(trId);
		map.addAttribute("command", treq);
		
		return "spocrequesttype";
	}
	
	@RequestMapping(value="createItr/{trId}")
	public String creatItr(@PathVariable("trId") int trId, HttpServletRequest request, ModelMap model) {
		
			
		TrainingRequest tr = new TrainingRequestCRUD().getTrainingRequestById(trId);
		tr.setStatus(2);
		new TrainingRequestCRUD().updateTrainingRequest(tr);
			
			
		InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setItrTrainingRequest(tr);
		itr.setItrStatus(2);
		itr.setItrTrainer(new EmployeeCRUDService().getEmployeeById(1000000));
		itr.setItrExecutive(new EmployeeCRUDService().getEmployeeById(1000038));
		itr.setItrStatusDescription("ONE");
			
			
		TrainingSchedule sch = new TrainingSchedule();
		sch = new TrainingScheduleCRUDService().insertTrainingSchedule(sch);
		itr.setItrSchedule(sch);
		
		new InternalTrainingCRUD().insertItr(itr);
		
		return "redirect:/viewspocdashboard";
	}
	
	@RequestMapping(value="saveTrainingType")
	public String saveTrainingType(@ModelAttribute("treq") TrainingRequest treq, ModelMap map)
	{

		int type = new TrainingRequestCRUD().updateTrainingRequestByAttribute(treq.getTrainingRequestId(), 
				"request_training_type", treq.getRequestTrainingType());
		if(type > 0)
		{
			int status = new TrainingRequestCRUD().updateTrainingRequestByAttribute(treq.getTrainingRequestId(), "status", 2);
			if(status > 0)
				return "redirect:/createItr/" + treq.getTrainingRequestId();
			else
				return "error";
		}
		else
			return "error";
	}

	@RequestMapping(value="steponeform/{itrId}")
	public String stepOneForm(@PathVariable("itrId") int itrId, ModelMap map) {
		map.addAttribute("itrId", itrId);
		EmployeeCRUDService empCrud = new EmployeeCRUDService();
		List<Employee> trainers = empCrud.getAllEmployeeByTitle("Trainer");
		map.addAttribute("trainers", trainers);
		return "steponeform";
	}
	
	@RequestMapping(value="submitstepone/{itrId}")
	public String submitStepOne(@PathVariable("itrId") int itrId, HttpServletRequest request, ModelMap map) {
		map.addAttribute("itrId", itrId);
		InternalTrainingCRUD itrCrud = new InternalTrainingCRUD();
		InternalTrainingRequest itr = itrCrud.getItrById(itrId);
		TrainingScheduleCRUDService tsCrud = new TrainingScheduleCRUDService();
		//TrainingSchedule ts = tsCrud.getTrainingScheduleById(itr.get);
		TrainingSchedule ts = itr.getItrSchedule();
		ts.setTraining_room_number(request.getParameter("room"));
		ts.setTraining_location(request.getParameter("location"));
		ts.setTraining_city(request.getParameter("city"));
		ts.setTraining_state(request.getParameter("state"));
		ts.setTraining_zipcode(request.getParameter("zip"));
		
		itr.getItrTrainingRequest().setRequestTrainingMode(request.getParameter("mode"));
		new TrainingRequestCRUD().updateTrainingRequest(itr.getItrTrainingRequest());

		int trainerId = Integer.parseInt(request.getParameter("trainerId"));
		Employee trainer = new EmployeeCRUDService().getEmployeeById(trainerId);
		itr.setItrTrainer(trainer);
		//Selected Trainer
		itrCrud.updateItr(itr);
		
		Date startDate = null;
		Time startTime = null;
		Date endDate = null;
		Time endTime = null;
		try {
			System.out.println(request.getParameter("startDate"));
			String temp;
			startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse((String)request.getParameter("startDate")).getTime());
			startTime = Time.valueOf(request.getParameter("startTime"));
			endTime = Time.valueOf(request.getParameter("endTime"));
			endDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse((String)request.getParameter("endDate")).getTime());
		} catch (Exception e) {System.out.println(e.getMessage()); return "error";}
		
		
		ts.setTraining_start_date(startDate);
		ts.setTraining_end_date(endDate);
//		tsCrud.updateTrainingSchedule(ts.getTraining_schedule_id(), "", "", "", "", "", "", "", 
//				ts.getTraining_start_date(), ts.getTraining_end_date());
		return "redirect:/edititr/" + itrId;
	}
	
	//Function that inserts an ExecutiveWorkFlowStatus and updates the statuses of the InternalTrainingRequest and the TrainingRequest that corresponds with it
		@RequestMapping(value="submitsteptwo/{itrId}")
		public String submitStepTwo(@PathVariable("itrId") int itrId, @ModelAttribute("execWorkflowStatus") ExecutiveWorkflowStatus execWorkflowStatus, ModelMap map)
		{
			System.out.println(itrId);
			InternalTrainingCRUD itrCrud = new InternalTrainingCRUD();
			TrainingRequestCRUD trCrud = new TrainingRequestCRUD();
			ExecutiveWorkflowStatusCRUD ewfsCrud = new ExecutiveWorkflowStatusCRUD();
			InternalTrainingRequest itr = itrCrud.getItrById(itrId);
			
			System.out.println(itr.getItrId());
			
			
			itr.setItrStatus(5);
			itrCrud.updateItr(itr);
			itr.getItrTrainingRequest().setStatus(5);
			trCrud.updateTrainingRequest(itr.getItrTrainingRequest());
			
			
			itr.setItrExecutive(execWorkflowStatus.getExecutiveWorkflowStatusExecutive());
			
			//update corresponding ITR with correct statuses and executives
			int ret = new InternalTrainingCRUD().updateItr(itr);
			
			Employee executive = itr.getItrExecutive();
			
			
			
			//insert ExecutiveWorkflowStatus into database for executive to see on their end once the SPOC is finished
			
			execWorkflowStatus.setTrainingRequest(itr.getItrTrainingRequest());
			execWorkflowStatus.setExecutiveWorkflowStatusExecutive(executive);
			int ret2 = ewfsCrud.insertExecutiveWorkflowStatus(execWorkflowStatus);
			
			
			
			
			map.addAttribute("executiveWorkflowStatus", execWorkflowStatus);

			if(ret > 0 && ret2 > 0)
				return "redirect:/viewspocdashboard";
			else
				return "error";
			
				
		}
	//initBinder allows Spring forms to map user input to attributes of type Employee, TrainingRequest, and TrainingSchedule
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder ) {

	        binder.registerCustomEditor(Employee.class, new EmployeeEditor(new EmployeeCRUDService()));
	        binder.registerCustomEditor(TrainingRequest.class, new TrainingRequestEditor(new TrainingRequestCRUD()));
	        binder.registerCustomEditor(TrainingSchedule.class, new TrainingScheduleEditor(new TrainingScheduleCRUDService()));
	  
	} 
	@RequestMapping(value="spocdashboard")
	public String viewSpocDashboard(HttpServletRequest request, ModelMap model) {
		if (request.getSession(false) == null || request.getSession().getAttribute("user") == null)
			return "redirect:/loginform";
		
		return "spocdashboard";
	}
	
		  
	@RequestMapping(value="showallitr")
	public String showallITRequests(ModelMap map) {
		List<InternalTrainingRequest> internalTrainingRequests = new InternalTrainingCRUD().getAllItr();
		map.addAttribute("internalTrainingRequests", internalTrainingRequests);
		
		return "allitrequests";
	}
	@RequestMapping(value="showallemployees")
	public String showallEmployees(ModelMap map) {
		List<Employee> employees = new EmployeeCRUDService().getAllEmployee();
		map.addAttribute("employees", employees);
		
		return "allemployees";
	}
	@RequestMapping(value="showalltr")
	public String showallTRequests(ModelMap map) {
		List<TrainingRequest> trainingRequests = new TrainingRequestCRUD().getAllTrainingRequest();
		map.addAttribute("trainingRequests", trainingRequests);
		
		return "alltrequests";
	}
	@RequestMapping(value="showallschedules")
	public String showallSchedules(ModelMap map) {
		List<TrainingSchedule> trainingSchedules = new TrainingScheduleCRUDService().getAllTrainingSchedule();
		map.addAttribute("trainingSchedules", trainingSchedules);
		
		return "allschedules";
	}
	@RequestMapping(value="insertitrform")
	public String insertITRequestForm(ModelMap map)
	{
		InternalTrainingRequest internalTrainingRequest = new InternalTrainingRequest();
		map.addAttribute("command", internalTrainingRequest);

		List<Employee> employees = new EmployeeCRUDService().getAllEmployee();
		List<TrainingRequest> trainingRequests = new TrainingRequestCRUD().getAllTrainingRequest();
		List<TrainingSchedule> schedules = new TrainingScheduleCRUDService().getAllTrainingSchedule();
		

		map.addAttribute("employees", employees);
		map.addAttribute("trainingRequests", trainingRequests);
		map.addAttribute("schedules", schedules);

		
		
		return "insertitr";
	}
	@RequestMapping(value="edititr/{itrId}")
	public String editiITRequest(@PathVariable("itrId") int itrId, ModelMap map)
	{
		//create Internal Training object here --->
		//change from internalTrainingRequest to InternalTraining
		InternalTrainingRequest itr = new InternalTrainingCRUD().getItrById(itrId);
		List<Employee> execList = new EmployeeCRUDService().getAllEmployeeByTitle("Executive");
		
		map.addAttribute("execList", execList);
		map.addAttribute("itrId", itrId);
		map.addAttribute("itr", itr);
		EmployeeCRUDService empCrud = new EmployeeCRUDService();
		List<Employee> trainers = empCrud.getAllEmployeeByTitle("Trainer");
		map.addAttribute("trainers", trainers);
		
		int trid = itr.getItrTrainingRequest().getTrainingRequestId();
		
		List<TrainingParticipant> partList = new TrainingParticipantCRUD().getAllParticipantsByRequest(trid);
		List<String> partNameList = new ArrayList<String>();
		for(TrainingParticipant part: partList)
		{
			Employee partEmployee = part.getParticipantEmployee();
			partNameList.add(partEmployee.getFirst_name() + " " + partEmployee.getLast_name());
		}
		ExecutiveWorkflowStatus execWorkflowStatus = new ExecutiveWorkflowStatus();
		map.addAttribute("command", execWorkflowStatus);
		map.addAttribute("partNameList", partNameList);
		

		if (itr.getItrStatus() > 3)
			map.addAttribute("approvalStatus", "Confirmed");
		else
			map.addAttribute("approvalStatus", "Not Confirmed");

		
		return "edititrform";
	}
	@RequestMapping(value="saveUpdatedData")
	public String saveUpdatedDetails(@ModelAttribute("itr") InternalTrainingRequest itr)
	{
		itr.setItrStatus(3);
		itr.getItrTrainingRequest().setStatus(4);
		
		/*
		int ret = new InternalTrainingTableCRUD.insert();
		
		if(ret > 0)
			return "redirect:/showall";
		else
			return "error";
		*/
		return "redirect:/edititrform/1000000";
		
	}
	@RequestMapping(value="newitr")
	public String insertITRequest(@ModelAttribute("internalTrainingRequest") InternalTrainingRequest internalTrainingRequest)
	{
		
		System.out.println(internalTrainingRequest.getItrTrainer());
		//internalTrainingRequest.setItrId(99999);
		int ret = new InternalTrainingCRUD().insertItr(internalTrainingRequest);
		
		if(ret > 0)
			return "redirect:/showallitr";
		else
			return "error";
	}
	@RequestMapping(value="DT")
	public String showDTRequests(ModelMap model) {
		
		return "dtform";
	}
	@RequestMapping(value="VT")
	public String showVTRequests(ModelMap model) {
		
		return "vtform";
	}
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
		
		return "spocrequestoverview";
	}
	
}
