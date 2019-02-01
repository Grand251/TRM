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
	
	@RequestMapping(value="requester/requests/{id}", method=RequestMethod.DELETE)
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
	}
	
	class RequestCRUDService extends TrainingRequestCRUD
	{		
		public List<TrainingRequest> getITNewRequests()
		{
			List<TrainingRequest> reqs = new ArrayList<TrainingRequest>();
			
			TrainingRequest req = new TrainingRequest();
			req.setRequesterId(new Random().nextInt());
			reqs.add(req);
			
			req = new TrainingRequest();
			req.setRequesterId(new Random().nextInt());
			reqs.add(req);
			
			req = new TrainingRequest();
			req.setRequesterId(new Random().nextInt());
			reqs.add(req);
			
			req = new TrainingRequest();
			req.setRequesterId(new Random().nextInt());
			reqs.add(req);
			
			return reqs;
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

class Employee {
	private int employee_id;
	private String last_name;
	private String first_name;
	private String user_name;
	private String password;
	private String phone_number;
	private String email;
	private String street;
	private String city;
	private String state;
	private String country;
	private String job_title;
	private String vertical;
	private String project;
	private int pid;

	public String getLast_name(){
		return last_name;
	}

	public void setLast_name(String last_name){
		this.last_name=last_name;
	}

	public String getFirst_name(){
		return first_name;
	}

	public void setFirst_name(String first_name){
		this.first_name=first_name;
	}

	public String getUser_name(){
		return user_name;
	}

	public void setUser_name(String user_name){
		this.user_name=user_name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPhone_number(){
		return phone_number;
	}

	public void setPhone_number(String phone_number){
		this.phone_number=phone_number;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getStreet(){
		return street;
	}

	public void setStreet(String street){
		this.street=street;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city=city;
	}

	public String getState(){
		return state;
	}

	public void setState(String state){
		this.state=state;
	}

	public String getCountry(){
		return country;
	}

	public void setCountry(String country){
		this.country=country;
	}

	public String getJob_title(){
		return job_title;
	}

	public void setJob_title(String job_title){
		this.job_title=job_title;
	}

	public String getVertical(){
		return vertical;
	}

	public void setVertical(String vertical){
		this.vertical=vertical;
	}

	public String getProject(){
		return project;
	}

	public void setProject(String project){
		this.project=project;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}


class Internal_trainer {
	private String profile_file_path;
	private String trainer_location;

	public String getProfile_file_path(){
		return profile_file_path;
	}

	public void setProfile_file_path(String profile_file_path){
		this.profile_file_path=profile_file_path;
	}

	public String getTrainer_location(){
		return trainer_location;
	}

	public void setTrainer_location(String trainer_location){
		this.trainer_location=trainer_location;
	}
}

class TrainingSchedule {
	private int training_schedule_id;
	private String training_city;
	private String training_state;
	private String training_country;
	private String training_zipcode;
	private String training_time_zone;
	private String training_location;
	private String training_room_number;
	private java.util.Date training_start_date;
	private java.util.Date training_end_date;

	public String getTraining_city(){
		return training_city;
	}

	public void setTraining_city(String training_city){
		this.training_city=training_city;
	}

	public String getTraining_state(){
		return training_state;
	}

	public void setTraining_state(String training_state){
		this.training_state=training_state;
	}

	public String getTraining_country(){
		return training_country;
	}

	public void setTraining_country(String training_country){
		this.training_country=training_country;
	}

	public String getTraining_zipcode(){
		return training_zipcode;
	}

	public void setTraining_zipcode(String training_zipcode){
		this.training_zipcode=training_zipcode;
	}

	public String getTraining_time_zone(){
		return training_time_zone;
	}

	public void setTraining_time_zone(String training_time_zone){
		this.training_time_zone=training_time_zone;
	}

	public String getTraining_location(){
		return training_location;
	}

	public void setTraining_location(String training_location){
		this.training_location=training_location;
	}

	public String getTraining_room_number(){
		return training_room_number;
	}

	public void setTraining_room_number(String training_room_number){
		this.training_room_number=training_room_number;
	}

	public java.util.Date getTraining_start_date(){
		return training_start_date;
	}

	public void setTraining_start_date(java.util.Date training_start_date){
		this.training_start_date=training_start_date;
	}

	public java.util.Date getTraining_end_date(){
		return training_end_date;
	}

	public void setTraining_end_date(java.util.Date training_end_date){
		this.training_end_date=training_end_date;
	}

	public int getTraining_schedule_id() {
		return training_schedule_id;
	}

	public void setTraining_schedule_id(int training_schedule_id) {
		this.training_schedule_id = training_schedule_id;
	}
}

class InternalTrainingRequest{
	private int internal_training_id;
	private int status;
	private int confirmed_trainer_id;
	private int training_request_id;
	private int training_spoc_id;
	private String internal_training_mode;
	private String schedule_id;
	private String description_of_status;

	public String getInternal_training_mode(){
		return internal_training_mode;
	}

	public void setInternal_training_mode(String internal_training_mode){
		this.internal_training_mode=internal_training_mode;
	}

	public String getSchedule_id(){
		return schedule_id;
	}

	public void setSchedule_id(String schedule_id){
		this.schedule_id=schedule_id;
	}

	public String getDescription_of_status(){
		return description_of_status;
	}

	public void setDescription_of_status(String description_of_status){
		this.description_of_status=description_of_status;
	}

	public int getInternal_training_id() {
		return internal_training_id;
	}

	public void setInternal_training_id(int internal_training_id) {
		this.internal_training_id = internal_training_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getConfirmed_trainer_id() {
		return confirmed_trainer_id;
	}

	public void setConfirmed_trainer_id(int confirmed_trainer_id) {
		this.confirmed_trainer_id = confirmed_trainer_id;
	}

	public int getTraining_request_id() {
		return training_request_id;
	}

	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}

	public int getTraining_spoc_id() {
		return training_spoc_id;
	}

	public void setTraining_spoc_id(int training_spoc_id) {
		this.training_spoc_id = training_spoc_id;
	}

}