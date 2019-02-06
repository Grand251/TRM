package trm.dao.trainingschedule;

import java.sql.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;


/**
 * CRUD Service for Training Schedule
 * @author Kei Ng
 */
public class TrainingScheduleCRUDService {
	
	private JdbcTemplate jtemp;
	
	public static void main(String[] args) {
		//int i = new TrainingScheduleCRUDService().getAllTrainingSchedule().size();
		//System.out.println(i);
		
		//List<TrainingSchedule> sc= new TrainingScheduleCRUDService().getAllTrainingSchedule();
		//System.out.println(sc.get(0).getTraining_schedule_id());
		//int i = new TrainingScheduleCRUDService().updateTrainingSchedule("9876543211", "Boston", "MA", "US", "12345", "EST", "542 st", "R210", null, null);
		int i = new TrainingScheduleCRUDService().updateTrainingScheduleCityById("9876543211", "city");
		new TrainingScheduleCRUDService().updateTrainingScheduleStateById("9876543211", "state");
		new TrainingScheduleCRUDService().updateTrainingScheduleCountryById("9876543211", "country");
		new TrainingScheduleCRUDService().updateTrainingScheduleZipcodeById("9876543211", "zip");
		new TrainingScheduleCRUDService().updateTrainingScheduleTimeZoneById("9876543211", "time Z");
		new TrainingScheduleCRUDService().updateTrainingScheduleRoomNumberById("9876543211", "room");
		new TrainingScheduleCRUDService().updateTrainingScheduleStartDateById("9876543211", null);
		new TrainingScheduleCRUDService().updateTrainingScheduleEndDateById("9876543211", null);
		new TrainingScheduleCRUDService().updateTrainingScheduleLocationById("9876543211", "location");

		System.out.println(i);
	}
	
	
	/**
	 * Query: get all training schedule
	 * @return List<TrainingSchedule>
	 */
	public List<TrainingSchedule> getAllTrainingSchedule(){
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		List<TrainingSchedule> scheduleList = jtemp.query("Select * from TRAINING_SCHEDULE", new TrainingScheduleMapper());
		return scheduleList;
	}
	
	/**
	 * Query: Delete training schedule
	 * @param training_schedule_id
	 * @return int(bollean)
	 */
	public int deleteTrainingSchedule(String training_schedule_id) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("delete from TRAINING_SCHEDULE where training_schedule_id = ?", 
				new Object[] {training_schedule_id});
		return ret;
	}
	
	/**
	 * Get training schedule by id
	 * @param training_schedule_id
	 * @return TrainingSchedule
	 */
	public TrainingSchedule getTrainingScheduleById(String training_schedule_id) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		TrainingSchedule schedule = jtemp.queryForObject("Select * from TRAINING_SCHEDULE where training_schedule_id = ?",
									new Object[]{training_schedule_id},
									new TrainingScheduleMapper());
		return schedule;
	}
	
	/**
	 * Query: update training schedule 
	 * @param training_schedule_id
	 * @param training_city
	 * @param training_state
	 * @param training_country
	 * @param training_zipcode
	 * @param training_time_zone
	 * @param training_location
	 * @param training_room_number
	 * @param training_start_date
	 * @param training_end_date
	 * @return
	 */
	public int updateTrainingSchedule(String training_schedule_id, String training_city, String training_state,
			String training_country, String training_zipcode, String training_time_zone, String training_location,
			String training_room_number, Date training_start_date, Date training_end_date, String trainingUrl, String trainingAudio) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_city = ?, training_state = ?, training_country = ?, training_zipcode = ?, training_time_zone = ?, training_location = ?, training_room_number = ?, training_start_date = ?, training_end_date = ?, training_url = ?, training_audio = ? where training_schedule_id = ?",
							new Object[] {
									training_city,
									training_state,
									training_country,
									training_zipcode,
									training_time_zone,
									training_location,
									training_room_number,
									training_start_date,
									training_end_date,
									training_schedule_id,
									trainingUrl,
									trainingAudio});
		return ret;
	}
	
	
	/**
	 * Query: insert new training schedule
	 * @param schedule
	 * @return int(boolean)
	 */
	public int insertTrainingSchedule(TrainingSchedule schedule) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("insert into TRAINING_SCHEDULE values (training_schedule_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
								new Object[] {
										schedule.getTraining_schedule_id(),
										schedule.getTraining_city(),
										schedule.getTraining_state(),
										schedule.getTraining_country(),
										schedule.getTraining_zipcode(),
										schedule.getTraining_time_zone(),
										schedule.getTraining_location(),
										schedule.getTraining_room_number(),
										schedule.getTraining_start_date(),
										schedule.getTraining_end_date(),
										schedule.getTrainingUrl(),
										schedule.getTrainingAudio()});
		return ret;
	}
	
	/**
	 * update training schedule city
	 * @param training_schedule_id
	 * @param training_city
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleCityById(String training_schedule_id, String training_city) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_city = ? where training_schedule_id = ?",
							new Object[] {training_city, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule state
	 * @param training_schedule_id
	 * @param training_state
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleStateById(String training_schedule_id, String training_state) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_state = ? where training_schedule_id = ?",
							new Object[] {training_state, training_schedule_id});
		return ret;
	}
	
	/**
	 *  update training schedule country
	 * @param training_schedule_id
	 * @param training_country
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleCountryById(String training_schedule_id, String training_country) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_country = ? where training_schedule_id = ?",
							new Object[] {training_country, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule zipcode
	 * @param training_schedule_id
	 * @param training_zipcode
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleZipcodeById(String training_schedule_id, String training_zipcode) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_zipcode = ? where training_schedule_id = ?",
							new Object[] {training_zipcode, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule time zone
	 * @param training_schedule_id
	 * @param training_time_zone
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleTimeZoneById(String training_schedule_id, String training_time_zone) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_time_zone = ? where training_schedule_id = ?",
							new Object[] {training_time_zone, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule location
	 * @param training_schedule_id
	 * @param training_location
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleLocationById(String training_schedule_id, String training_location) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_location = ? where training_schedule_id = ?",
							new Object[] {training_location, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule room number
	 * @param training_schedule_id
	 * @param training_location
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleRoomNumberById(String training_schedule_id, String training_room_number) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_room_number = ? where training_schedule_id = ?",
							new Object[] {training_room_number, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule start date
	 * @param training_schedule_id
	 * @param training_start_date
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleStartDateById(String training_schedule_id, String training_start_date) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_start_date = ? where training_schedule_id = ?",
							new Object[] {training_start_date, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training schedule end date
	 * @param training_schedule_id
	 * @param training_start_date
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleEndDateById(String training_schedule_id, String training_end_date) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_end_date = ? where training_schedule_id = ?",
							new Object[] {training_end_date, training_schedule_id});
		return ret;
	}
	
	public int updateTrainingScheduleUrlById(String training_schedule_id, String training_url) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_url = ? where training_schedule_id = ?",
							new Object[] {training_url, training_schedule_id});
		return ret;
	}
	
	public int updateTrainingScheduleAudioById(String training_schedule_id, String training_audio) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_audio = ? where training_schedule_id = ?",
							new Object[] {training_audio, training_schedule_id});
		return ret;
	}
}
