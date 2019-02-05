package trm.dao.trainingschedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import trm.dao.trainingschedule.TrainingSchedule;
/**
 * This is training schedule mapper class
 * @author Kei Ng
 *
 */
public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>{
	/**
	 * use RowMapper interface
	 * @param ResultSet
	 * @param arg
	 * @return TrainingSchedule
	 */
	@Override
	public TrainingSchedule mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingSchedule schedule = new TrainingSchedule();
		schedule.setTraining_schedule_id(result.getString(1));
		schedule.setTraining_city(result.getString(2));
		schedule.setTraining_state(result.getString(3));
		schedule.setTraining_country(result.getString(4));
		schedule.setTraining_zipcode(result.getString(5));
		schedule.setTraining_time_zone(result.getString(6));
		schedule.setTraining_location(result.getString(7));
		schedule.setTraining_room_number(result.getString(8));
		schedule.setTraining_start_date(result.getDate(9));
		schedule.setTraining_end_date(result.getDate(10));
		return schedule;
	}

}
