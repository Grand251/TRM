package trm.dao.trainingschedule;

import java.sql.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import trm.dao.DAOJDBCTemplate;


/**
 * CRUD Service for Training Schedule
 * @author Kei Ng
 */
public class TrainingScheduleCRUDService {
	
	private JdbcTemplate jtemp;
	
	public static void main(String[] args) {
		/*TrainingScheduleCRUDService tCRUD =  new TrainingScheduleCRUDService();
		//System.out.println(i);
		
		TrainingSchedule sc= new TrainingScheduleCRUDService().getTrainingScheduleById("10000");
		TrainingSchedule ts = tCRUD.insertTrainingSchedule(sc);
		
		
		tCRUD.insertTrainingSchedule(ts);*/
		
		//System.out.println(sc.get(0).getTraining_schedule_id());

		//int i = new TrainingScheduleCRUDService().updateTrainingSchedule("9876543211", "Boston", "MA", "US", "12345", "EST", "542 st", "R210", null, null,"url","audio");
		//int i = new TrainingScheduleCRUDService().updateTrainingScheduleCityById("9876543211", "city");
		/*
		new TrainingScheduleCRUDService().updateTrainingScheduleStateById("9876543211", "state");
		new TrainingScheduleCRUDService().updateTrainingScheduleCountryById("9876543211", "country");
		new TrainingScheduleCRUDService().updateTrainingScheduleZipcodeById("9876543211", "zip");
		new TrainingScheduleCRUDService().updateTrainingScheduleTimeZoneById("9876543211", "time Z");
		new TrainingScheduleCRUDService().updateTrainingScheduleRoomNumberById("9876543211", "room");
		new TrainingScheduleCRUDService().updateTrainingScheduleStartDateById("9876543211", null);
		new TrainingScheduleCRUDService().updateTrainingScheduleEndDateById("9876543211", null);
		new TrainingScheduleCRUDService().updateTrainingScheduleLocationById("9876543211", "location");
		*/
		//new TrainingScheduleCRUDService().updateTrainingScheduleTrainingURLlById("9876543211", "URL");
		//new TrainingScheduleCRUDService().updateTrainingScheduleTrainingAudioById("9876543211", "AUDIO");
		
		//TrainingSchedule ts = new TrainingSchedule();
		//ts.set

		//System.out.println(i);
	}
	
	
	/**
	 * Query: get all training schedule
	 * @return List<TrainingSchedule>
	 */
	public List<TrainingSchedule> getAllTrainingSchedule(){
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		List<TrainingSchedule> scheduleList = jtemp.query("Select * from TRAINING_SCHEDULE", new TrainingScheduleMapper());
		return scheduleList;
	}
	
	/**
	 * Query: Delete training schedule
	 * @param training_schedule_id
	 * @return int(bollean)
	 */
	public int deleteTrainingSchedule(String training_schedule_id) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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

			String training_room_number, Date training_start_date, Date training_end_date, String training_url, String training_audio) {

		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
									training_url,
									training_audio,
									training_schedule_id});

		return ret;
	}
	
	
	/**
	 * Query: insert new training schedule
	 * @param schedule
	 * @return int(boolean)
	 */
	public TrainingSchedule insertTrainingSchedule(TrainingSchedule schedule) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		NamedParameterJdbcTemplate j = new NamedParameterJdbcTemplate(jtemp);
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("city", schedule.getTraining_city())
    			.addValue("state",schedule.getTraining_state())
    			.addValue("country",schedule.getTraining_country())
    			.addValue("zip",schedule.getTraining_zipcode())
    			.addValue("time",schedule.getTraining_time_zone())
    			.addValue("loc",schedule.getTraining_location())
    			.addValue("room",schedule.getTraining_room_number())
    			.addValue("start",schedule.getTraining_start_date())
    			.addValue("end",schedule.getTraining_end_date())
    			.addValue("url",schedule.getTraining_url())
    			.addValue("audio",schedule.getTraining_audio());
											
		
		j.update("insert into TRAINING_SCHEDULE(TRAINING_SCHEDULE_ID, TRAINING_CITY, TRAINING_STATE, TRAINING_COUNTRY, "
				+ "TRAINING_ZIPCODE,TRAINING_TIME_ZONE, TRAINING_LOCATION, TRAINING_ROOM_NUMBER, TRAINING_START_DATE, TRAINING_END_DATE, "
				+ "TRAINING_URL,TRAINING_AUDIO) values (training_schedule_id_seq.nextval, :city, :state, :country, :zip, :time, :loc, :room"
				+ ", :start, :end, :url, :audio)", 
				 parameters,
				  keyHolder, new String[]{"TRAINING_SCHEDULE_ID"}
				 );
		
		int key = keyHolder.getKey().intValue();
		TrainingSchedule newTrainingSchedule = getTrainingScheduleById(key + "");
		return newTrainingSchedule;
	}
	
	/**
	 * update training schedule city
	 * @param training_schedule_id
	 * @param training_city
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleCityById(String training_schedule_id, String training_city) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
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
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_end_date = ? where training_schedule_id = ?",
							new Object[] {training_end_date, training_schedule_id});
		return ret;
	}
	
	public int updateTrainingScheduleUrlById(String training_schedule_id, String training_url) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_url = ? where training_schedule_id = ?",
							new Object[] {training_url, training_schedule_id});
		return ret;
	}
	
	public int updateTrainingScheduleAudioById(String training_schedule_id, String training_audio) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_audio = ? where training_schedule_id = ?",
							new Object[] {training_audio, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training URL
	 * @param training_schedule_id
	 * @param training_url
	 * @return int(boolean)
	 */
	public int updateTrainingScheduleTrainingURLlById(String training_schedule_id, String training_url) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_url = ? where training_schedule_id = ?",
							new Object[] {training_url, training_schedule_id});
		return ret;
	}
	
	/**
	 * update training audio
	 * @param training_schedule_id
	 * @param training_audio
	 * @return  int(boolean)
	 */
	public int updateTrainingScheduleTrainingAudioById(String training_schedule_id, String training_audio) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE TRAINING_SCHEDULE SET training_audio = ? where training_schedule_id = ?",
							new Object[] {training_audio, training_schedule_id});
		return ret;
	}
	
}
