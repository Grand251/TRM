package trm.dao.trainingrequestlog;

import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;

/*
 * @author Ian Nielsen
 * Last changed: February 2nd 2019 5:22PM
 */
public class TrainingRequestLogMapper implements RowMapper<TrainingRequestLog>
{
        /*
	 * Maps the columns of the result set to a Training Request log object.
	 * This mapper is used for queries where the query selects all or only 
	 * one of the columns of the training_request_log table. 
	 *
	 * @param  Result set of the query.
	 * @return Training request log object that was mapped.
	 */
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
