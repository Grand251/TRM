package trm.dao.trainingschedule;

import java.sql.Date;
import java.sql.Timestamp;
/**
 * This is TrainingSchedule class
 * @author Kei Ng
 *
 */
public class TrainingSchedule {
	private String training_schedule_id;
	private String training_city;
	private String training_state;
	private String training_country;
	private String training_zipcode;
	private String training_time_zone;
	private String training_location;
	private String training_room_number;
	private Timestamp training_start_date;
	private Timestamp training_end_date;
	private String training_url;
	private String training_audio;

	
	public String getTraining_schedule_id() 
	{
		return training_schedule_id;
	}
	
	public void setTraining_schedule_id(String training_schedule_id) 
	{
		this.training_schedule_id = training_schedule_id;
	}
	
	public String getTraining_city() 
	{
		return training_city;
	}
	
	public void setTraining_city(String training_city) 
	{
		this.training_city = training_city;
	}
	
	public String getTraining_state() 
	{
		return training_state;
	}
	
	public void setTraining_state(String training_state) 
	{
		this.training_state = training_state;
	}
	
	public String getTraining_country() 
	{
		return training_country;
	}
	
	public void setTraining_country(String training_country) 
	{
		this.training_country = training_country;
	}
	
	public String getTraining_zipcode() 
	{
		return training_zipcode;
	}
	
	public void setTraining_zipcode(String training_zipcode) 
	{
		this.training_zipcode = training_zipcode;
	}
	
	public String getTraining_time_zone() 
	{
		return training_time_zone;
	}
	
	public void setTraining_time_zone(String training_time_zone)
	{
		this.training_time_zone = training_time_zone;
	}
	
	public String getTraining_location() 
	{
		return training_location;
	}
	
	public void setTraining_location(String training_location) 
	{
		this.training_location = training_location;
	}
	
	public String getTraining_room_number() 
	{
		return training_room_number;
	}
	
	public void setTraining_room_number(String training_room_number) 
	{
		this.training_room_number = training_room_number;
	}
	
	public Timestamp getTraining_start_date() 
	{
		return training_start_date;
	}
	
	public void setTraining_start_date(Timestamp training_start_date) 
	{
		this.training_start_date = training_start_date;
	}
	
	public Timestamp getTraining_end_date() 
	{
		return training_end_date;
	}
	
	public void setTraining_end_date(Timestamp training_end_date) 
	{
		this.training_end_date = training_end_date;
	}

	public String getTraining_url() {
		return training_url;
	}
	public void setTraining_url(String training_url) {
		this.training_url = training_url;
	}
	public String getTraining_audio() {
		return training_audio;
	}
	public void setTraining_audio(String training_audio) {
		this.training_audio = training_audio;

	}
}

