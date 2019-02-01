package trm.dao.trainingrequestLog;

import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;

public class TrainingRequestLogMapper implements RowMapper<TrainingRequestLog>
{
	public TrainingRequestLog mapRow(ResultSet result, int arg1) throws SQLException 
	{
		TrainingRequestLog trainingRequestLog = new TrainingRequestLog();
		
		trainingRequestLog.setRequestLogId(result.getInt(1));
		trainingRequestLog.setTrainingRequestId(result.getInt(2));
		trainingRequestLog.setStatus(result.getString(3));
		trainingRequestLog.setStatusChangeTime(result.getTimestamp(4));
		trainingRequestLog.setDescription(result.getString(5));
		
		return trainingRequestLog;
	}
}
