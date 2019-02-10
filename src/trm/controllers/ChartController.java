package trm.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingparticipant.TrainingParticipantCRUD;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;

@Controller
public class ChartController {
	TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
	
	@RequestMapping(value="chartverticalrequests")
	public String chartRequestsByVert(HttpServletRequest req, ModelMap model) {
			
		if(req.getParameter("period")!=null) {
			int period = Integer.parseInt(req.getParameter("period"));
			
			model.addAttribute("requests",  getRequestsByVertical(period));
			model.addAttribute("period", period);
		}
		else {
			model.addAttribute("requests",  getRequestsByVertical(30));
			model.addAttribute("period", 30);
		}
		
		return "ChartVerticalRequests";
	}
	
	private HashMap<String, Integer> getRequestsByVertical(int period){
		TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		
		List<Employee> employees = eCRUD.getAllEmployeeByTitle("SPOC");
		
		HashMap<Integer, Employee> spocs = new HashMap<Integer, Employee>();
		
		for(Employee emp : employees) {
			spocs.put(emp.getEmployee_id(), emp);
		}
		
		HashMap<String, Integer> requestsByVertical = new HashMap<String, Integer>();
		ArrayList<Timestamp> dateRange = getDateRange(period);
		for(Integer key : spocs.keySet()) {
			requestsByVertical.put(spocs.get(key).getVertical(), 
					trCRUD.getAllTrainingRequestBySpocInRange(key, dateRange.get(0), dateRange.get(1)).size());
		}
		return requestsByVertical;
	}
	
	@RequestMapping(value="chartspoclocation")
	public String chartSpocRequestByLocationandMode(HttpServletRequest req, ModelMap model) {
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		List<Employee> spocs = eCRUD.getAllEmployeeByTitle("SPOC");
		HashMap<Integer, String> spocOptions = new HashMap<Integer, String>();
		
		for(Employee spoc : spocs) {
			spocOptions.put(spoc.getEmployee_id(), spoc.getFirst_name() + " " + spoc.getLast_name());
		}
		
		model.addAttribute("spocOptions", spocOptions);
		
		if(req.getParameter("spocChoice")!=null && req.getParameter("period")!=null) {
			int period = Integer.parseInt(req.getParameter("period"));
			int spocId = Integer.parseInt(req.getParameter("spocChoice"));
			
			model.addAttribute("requests", getSpocRequestByModeAndLocation(spocId, period));
			model.addAttribute("period", period);
			model.addAttribute("spoc", spocId);
		}		
		return "ChartSingleSpocLocation";
	}
	
	@RequestMapping(value="chartspocrequests")
	public String chartSpocRequestByRange(HttpServletRequest req, ModelMap model) {
		
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		List<Employee> spocs = eCRUD.getAllEmployeeByTitle("SPOC");
		
		HashMap<Integer, String> spocOptions = new HashMap<Integer, String>();
		
		for(Employee spoc : spocs) {
			spocOptions.put(spoc.getEmployee_id(), spoc.getFirst_name() + " " + spoc.getLast_name());
		}
		
		model.addAttribute("spocOptions", spocOptions);
		
		if(req.getParameter("spocChoice")!=null && req.getParameter("period")!=null) {
			int period = Integer.parseInt(req.getParameter("period"));
			int spocId = Integer.parseInt(req.getParameter("spocChoice"));
			
			model.addAttribute("timeRequests", getSpocRequestByRanges(spocId, period));
			model.addAttribute("period", period);
			model.addAttribute("spoc", spocId);
		}
		
		return "ChartSpocRequests";
	}
	
	private LinkedHashMap<String, LinkedHashMap<String, Integer>> getSpocRequestByModeAndLocation(int spocId, int period) {
		TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
		
		List<TrainingRequest> spocTrainingRequests = trCRUD.getAllTrainingRequestBySpoc(spocId);
		
		LinkedHashSet<String> modes = new LinkedHashSet<String>();
		LinkedHashSet<String> locations = new LinkedHashSet<String>();
		
		for(TrainingRequest tr : spocTrainingRequests) {
			if(!modes.contains(tr.getRequestTrainingMode()))
				modes.add(tr.getRequestTrainingMode());
			if(!locations.contains(tr.getRequestLocation()))
				locations.add(tr.getRequestLocation());
		}
		
		LinkedHashMap<String, LinkedHashMap<String, Integer>> requestsByModeAndLocation = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
		ArrayList<Timestamp> dateRange = getDateRange(period);
		
		for(String location : locations) {
			requestsByModeAndLocation.put(location, new LinkedHashMap<String, Integer>());
			for(String mode : modes) {
				int numTrainings = trCRUD.getNumTrainingRequestBySPOCLocationMode(spocId, location, mode, dateRange.get(0), dateRange.get(1));
				requestsByModeAndLocation.get(location).put(mode, numTrainings);
			}
		}
		
		return requestsByModeAndLocation;
	}
	
	
	
	
	@RequestMapping(value="charttrainingperformance")
	public String chartSpocPerformanceByRange(HttpServletRequest req, ModelMap model) {
		
		if(req.getParameter("period")!=null) {
			int period = Integer.parseInt(req.getParameter("period"));
			
			model.addAttribute("performance", getSpocPerformancesInPeriod(period));
			model.addAttribute("period", period);
		}
		else {
			model.addAttribute("performance", getSpocPerformancesInPeriod(30));
			model.addAttribute("period", 30);
		}
		
		return "ChartTrainingPerformance";
	}
	
	
	private LinkedHashMap<String, Integer> getParticipantsPerTrainingType(int requesterId, int period){
		TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
		TrainingParticipantCRUD tpCRUD = new TrainingParticipantCRUD();
		LinkedHashMap<String, Integer> results = new LinkedHashMap<String, Integer>();
		
		ArrayList<Timestamp> range = getDateRange(period);
		List<TrainingRequest> trainingRequests = trCRUD.getRequestsByRequesterInRange(requesterId, range.get(0), range.get(1));
		
		for(TrainingRequest trainingRequest : trainingRequests) {
			String module = trainingRequest.getRequestTrainingModule();
			int requestId = trainingRequest.getTrainingRequestId();
			int participants = tpCRUD.getAllParticipantsByRequest(requestId).size();
			if(results.keySet().contains(module)) {
				int result = results.get(module) + participants;
				results.put(module, result);
			}
			else
				results.put(module, participants);
		}
		
		return results;
	}
	
	@RequestMapping(value="chartRequester")
	public String chartRequestForRequester(HttpServletRequest req, ModelMap model) {
		
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		//List<Employee> requesters = eCRUD.getAllEmployeeByTitle("senior consultant");
		List<Employee> requesters = eCRUD.getAllEmployeeByTitle("Project Manager");
		//requesters.addAll(managers);
		
		HashMap<Integer, String> reqOptions = new HashMap<Integer, String>();
		
		for(Employee requester : requesters) {
			reqOptions.put(requester.getEmployee_id(), requester.getFirst_name() + " " + requester.getLast_name());
		}
		model.addAttribute("reqOptions", reqOptions);
		
		if(req.getParameter("reqChoice")!=null && req.getParameter("period")!=null) {

			int period = Integer.parseInt(req.getParameter("period"));
			int requesterId = Integer.parseInt(req.getParameter("reqChoice"));
			
			model.addAttribute("participants", getParticipantsPerTrainingType(requesterId, period));
			model.addAttribute("status", getStatusCountInPeriod(requesterId, period));
			model.addAttribute("period", period);
			model.addAttribute("req", requesterId);
		}
		
		return "ChartRequesters";
	}
	
	//status values are arbitrary to produce output
	private ArrayList<Integer> getStatusCountInPeriod(int requesterId, int period){
		ArrayList<Integer> statusCounts = new ArrayList<Integer>();
		TrainingRequestCRUD ttrCRUD = new TrainingRequestCRUD();
		ArrayList<Timestamp> range = getDateRange(period);
		
		int canceled = ttrCRUD.getNumRequestsByRequesterInStatusAndDateRange(requesterId, 1, 3, range.get(0), range.get(1));
		int inProgress = ttrCRUD.getNumRequestsByRequesterInStatusAndDateRange(requesterId, 4, 6, range.get(0), range.get(1));
		int complete = ttrCRUD.getNumRequestsByRequesterInStatusAndDateRange(requesterId, 7, 10, range.get(0), range.get(1));
		statusCounts.add(canceled);
		statusCounts.add(inProgress);
		statusCounts.add(complete);
		
		return statusCounts;
		
	}
	
	
	
	private LinkedHashMap<String, Integer> getSpocPerformancesInPeriod(int period){
		LinkedHashMap<String, Integer> performances = new LinkedHashMap<String, Integer>();
		
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		List<Employee> spocs = eCRUD.getAllEmployeeByTitle("SPOC");
		
		ArrayList<Timestamp> range = getDateRange(period);
		
		TrainingRequestCRUD ttrCRUD = new TrainingRequestCRUD();
		for(Employee spoc: spocs) {
			String uID = spoc.getFirst_name().charAt(0) + "" + spoc.getLast_name().charAt(0) + "" + spoc.getEmployee_id();
			int performance = ttrCRUD.getSPOCSchedulePerformance(spoc.getEmployee_id(), range.get(0), range.get(1));
			performances.put(uID, performance);
		}
	
		return performances;
	}
	
	private ArrayList<Timestamp> getDateRange(int period){
		switch(period){
			case 30:
				return getLastFullMonth();
			case 90:
				return getLastFullQuarter();
			case 180:
				return getLastSixMonths();
			case 365:
				return getLastYear();
		}
		
		return getLastFullMonth();
	}
	
	private ArrayList<Timestamp> getLastFullMonth(){
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date end = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date begin = calendar.getTime();
		range.add(new Timestamp(begin.getTime()));
		range.add(new Timestamp(end.getTime()));
		
		return range;
	}
	
	private ArrayList<Timestamp> getLastFullQuarter() {
		Calendar calendar = Calendar.getInstance();

		if(calendar.get(Calendar.MONTH)>=9) { //9, 10, 11
			return getThirdQuarter(calendar);
		}
		else if(calendar.get(Calendar.MONTH)>=6) { //6, 7, 8
			return getSecondQuarter(calendar);
		}
		else if(calendar.get(Calendar.MONTH)>=3) {//3, 4, 5
			return getFirstQuarter(calendar);
		}
		else {//0, 1, 2
			calendar.add(Calendar.YEAR, -1);
			return getFourthQuarter(calendar);
		}
	}
	
	private ArrayList<Timestamp> getLastSixMonths(){
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -6);
		range.add(new Timestamp(calendar.getTimeInMillis()));
		range.add(new Timestamp(System.currentTimeMillis()));
		return range;
	}
	
	private ArrayList<Timestamp> getLastYear(){
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		range.add(new Timestamp(calendar.getTimeInMillis()));
		range.add(new Timestamp(System.currentTimeMillis()));
		return range;
	}
	
	private LinkedHashMap<String, Integer> getSpocRequestByRanges(int spocId, int period){
		ArrayList<ArrayList<Timestamp>> ranges = new ArrayList<ArrayList<Timestamp>>();
		switch(period) {
			case 30:
				ranges = getMonthlyRanges();
				return getMonthlyTotals(ranges, spocId);
				
			case 90:
				ranges = getQuarterlyRanges();
				return getQuarterlyTotals(ranges, spocId);
			
			case 180:
				
			case 365:			
		}
		
		return null;
	}
	
	private LinkedHashMap<String, Integer> getQuarterlyTotals(ArrayList<ArrayList<Timestamp>> ranges, int spocId){
		TrainingRequestCRUD ttrCRUD = new TrainingRequestCRUD();
		LinkedHashMap<String, Integer> results = new LinkedHashMap<String, Integer>();
		
		for(ArrayList<Timestamp> range : ranges) {
			String label = getQuarterLabel(range.get(0));
			int value = ttrCRUD.getAllTrainingRequestBySpocStartInRange(spocId, range.get(0), range.get(1)).size();
			results.put(label, value);
		}
		
		return results;
	}
	
	private String getQuarterLabel(Timestamp requestTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(requestTime);
		String label = new String();
		if(calendar.get(Calendar.MONTH)==9) {
			label = "4Q-" + calendar.get(Calendar.YEAR);
		}
		else if(calendar.get(Calendar.MONTH)==6) {
			label = "3Q-" + calendar.get(Calendar.YEAR);
		}
		else if(calendar.get(Calendar.MONTH)==3) {
			label = "2Q-" + calendar.get(Calendar.YEAR);
		}
		else {
			label = "1Q-" + calendar.get(Calendar.YEAR);
		}
		
		return label;
	}
	
	private LinkedHashMap<String, Integer> getMonthlyTotals(ArrayList<ArrayList<Timestamp>> ranges, int spocId){
		TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
		LinkedHashMap<String, Integer> results = new LinkedHashMap<String, Integer>();
		
		for(ArrayList<Timestamp> range : ranges) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(range.get(0));
			String label = cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
			int value = trCRUD.getAllTrainingRequestBySpocStartInRange(spocId, range.get(0), range.get(1)).size();
			results.put(label, value);
		}
		
		return results;
	}
	
	ArrayList<ArrayList<Timestamp>> getMonthlyRanges(){
		ArrayList<ArrayList<Timestamp>> ranges = new ArrayList<ArrayList<Timestamp>>();
		Calendar calendar = Calendar.getInstance();   // this takes current date
	    
		Date end = new Date();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date start = calendar.getTime();
		
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		ranges.add(range);
		
		for(int i = 0; i < 11; i++) {
			range = new ArrayList<Timestamp>();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			end = calendar.getTime();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			start = calendar.getTime();
			range.add(new Timestamp(start.getTime()));
			range.add(new Timestamp(end.getTime()));
			ranges.add(range);
		}
		Collections.reverse(ranges);
		
		return ranges;
		
	}
	
	ArrayList<ArrayList<Timestamp>> getQuarterlyRanges(){
		ArrayList<ArrayList<Timestamp>> ranges = new ArrayList<ArrayList<Timestamp>>();
		Calendar calendar = Calendar.getInstance();

		if(calendar.get(Calendar.MONTH)>=9) { //9, 10, 11
			ranges.add(getFourthQuarter(calendar));
			ranges.add(getThirdQuarter(calendar));
			ranges.add(getSecondQuarter(calendar));
			ranges.add(getFirstQuarter(calendar));
		}
		else if(calendar.get(Calendar.MONTH)>=6) { //6, 7, 8
			ranges.add(getThirdQuarter(calendar));
			ranges.add(getSecondQuarter(calendar));
			ranges.add(getFirstQuarter(calendar));
			calendar.add(Calendar.YEAR, -1);
			ranges.add(getFourthQuarter(calendar));
		}
		else if(calendar.get(Calendar.MONTH)>=3) {//3, 4, 5
			ranges.add(getSecondQuarter(calendar));
			ranges.add(getFirstQuarter(calendar));
			calendar.add(Calendar.YEAR, -1);
			ranges.add(getFourthQuarter(calendar));
			ranges.add(getThirdQuarter(calendar));
		}
		else {//0, 1, 2
			ranges.add(getFirstQuarter(calendar));
			calendar.add(Calendar.YEAR, -1);
			ranges.add(getFourthQuarter(calendar));
			ranges.add(getThirdQuarter(calendar));
			ranges.add(getSecondQuarter(calendar));
		}
			
		
		Collections.reverse(ranges);
				
		return ranges;
	}
	
	private ArrayList<Timestamp> getFourthQuarter(Calendar calendar){
		Date start = new Date();
		Date end = new Date();
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		calendar.set(calendar.get(Calendar.YEAR), 9, 1, 0, 0, 0);
		start = calendar.getTime();
		calendar.set(calendar.get(Calendar.YEAR), 11, 31, 0, 0, 0);
		end = calendar.getTime();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		return range;
	}
	
	private ArrayList<Timestamp> getThirdQuarter(Calendar calendar){
		Date start = new Date();
		Date end = new Date();
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		calendar.set(calendar.get(Calendar.YEAR), 6, 1, 0, 0, 0);
		start = calendar.getTime();
		calendar.set(calendar.get(Calendar.YEAR), 8, 30, 0, 0, 0);
		end = calendar.getTime();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		return range;
	}
	
	private ArrayList<Timestamp> getSecondQuarter(Calendar calendar){
		Date start = new Date();
		Date end = new Date();
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		calendar.set(calendar.get(Calendar.YEAR), 3, 1, 0, 0, 0);
		start = calendar.getTime();
		calendar.set(calendar.get(Calendar.YEAR), 5, 31, 0, 0, 0);
		end = calendar.getTime();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		return range;
	}
	private ArrayList<Timestamp> getFirstQuarter(Calendar calendar){
		Date start = new Date();
		Date end = new Date();
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		calendar.set(calendar.get(Calendar.YEAR), 0, 1, 0, 0, 0);
		start = calendar.getTime();
		calendar.set(calendar.get(Calendar.YEAR), 2, 31, 0, 0, 0);
		end = calendar.getTime();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		return range;
	}
	
	public static void main(String[] args) {
		/*TrainingRequestCRUD trCRUD = new TrainingRequestCRUD();
		TempTrainingRequestCRUD ttrCRUD = new TempTrainingRequestCRUD();
		EmployeeCRUDService eCRUD = new EmployeeCRUDService();
		
		List<Employee> employees = eCRUD.getAllEmployee();
		
		HashMap<Integer, Employee> spocs = new HashMap<Integer, Employee>();
		
		for(Employee emp : employees) {
			if(!emp.getJob_title().equals("SPOC"))
				continue;
			if(!spocs.containsKey(emp.getEmployee_id()))
				spocs.put(emp.getEmployee_id(), emp);
		}
		System.out.println(spocs.keySet().size());
		HashMap<String, Integer> requestsBySPOC = new HashMap<String, Integer>();
		for(Integer key : spocs.keySet()) {
			requestsBySPOC.put(spocs.get(key).getVertical(), 
					ttrCRUD.getAllTrainingRequestBySpoc(key).size());
		}*/
		
		/*Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		c.add(Calendar.DAY_OF_MONTH, -20);
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.YEAR));
		c.add(Calendar.DAY_OF_MONTH, -20);
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.YEAR));
		
		Date end = new Date();
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date start = c.getTime();
		
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		
		for(int i = 0; i < 12; i++) {
			c.add(Calendar.DAY_OF_MONTH, -1);
			end = c.getTime();
			c.set(Calendar.DAY_OF_MONTH, 1);
			start = c.getTime();
			System.out.println(end);
			System.out.println(start);
		}*/
		
		/*ArrayList<ArrayList<Timestamp>> ranges = new ArrayList<ArrayList<Timestamp>>();
		Calendar c = Calendar.getInstance();   // this takes current date
	    
		Date end = new Date();
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date start = c.getTime();
		
		ArrayList<Timestamp> range = new ArrayList<Timestamp>();
		range.add(new Timestamp(start.getTime()));
		range.add(new Timestamp(end.getTime()));
		ranges.add(range);
		
		for(int i = 0; i < 11; i++) {
			range = new ArrayList<Timestamp>();
			c.add(Calendar.DAY_OF_MONTH, -1);
			end = c.getTime();
			c.set(Calendar.DAY_OF_MONTH, 1);
			start = c.getTime();
			range.add(new Timestamp(start.getTime()));
			range.add(new Timestamp(end.getTime()));
			ranges.add(range);
		}
		
		for(ArrayList<Timestamp> arange : ranges)
			for(Timestamp ts : arange)
				System.out.println(ts.toString());*/
		
		//System.out.println(allRequests);
		//System.out.println(ttrCRUD.getAllTrainingRequestBySpoc(1000006));
	}
	
}
