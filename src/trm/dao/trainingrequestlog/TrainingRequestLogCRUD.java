package trm.dao.trainingrequestlog;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;

public class TrainingRequestLogCRUD 
{
	private JdbcTemplate jTemp;
	
	/*
	 * Parameter: Training request log object
	 * Return Value: Status as an integer
	 * 
	 * Description:
	 * 	Inserts a new training request log into the training_request_log table using the instance variables of the training request log
	 *	object that was passed as a parameter. Each attribute is accessed using the getter methods of the training request log class. 
	 */
	public int insertTrainingRequestLog(TrainingRequestLog trainingRequestLog)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("Insert into training_request_log values(training_request_log_id_seq.nextval,?,?,?,?)" , 
												  new Object[] {trainingRequestLog.getTrainingRequestId(), trainingRequestLog.getStatus(),
														  		trainingRequestLog.getStatusChangeTime(), trainingRequestLog.getDescription(),
														  		});
		return ret;
	}
	
	/*
	 * Parameter: The training request log ID as an integer
	 * Return Value: Status as an integer
	 * 
	 * Description:
	 * 	Deletes the training request log row from the training_request_log table based on the training request log ID passed as a parameter.
	 *	Update statement uses the passed parameter to delete entry.
	 */
	public int deleteTrainingRequestLog(int trainingRequestLogId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("delete from training_request_log where request_log_id = ?", 
												  new Object[] {trainingRequestLogId});
		return ret;
	}
	
	/*
	 * Parameter: TrainingRequestLog object
	 * Return Value: Status as an integer
	 * 
	 * Description:
	 * 	Updates the attributes of a training request log row based on the log's id. The attribute values that are changed are based
	 * 	on the values of the instance variables in the training request log object that was passed. The update method uses the getter methods of the
	 * 	training request log class to access the instance variables of the object. The method updates all fields, whether changed or unchanged.
	 * 	DIFFERENT APPROACH MAY BE TAKEN IF UPDATING ONLY SOME FIELDS IS DESIRED.
	 */
	public int updateTrainingRequestLog(TrainingRequestLog trainingRequestLog)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("update training_request_log set training_request_id = ?, status = ?, status_change_time = ?, description = ? where request_log_id = ?", 
												  new Object[] {trainingRequestLog.getTrainingRequestId(), trainingRequestLog.getStatus(),
														        trainingRequestLog.getStatusChangeTime(), trainingRequestLog.getDescription(), trainingRequestLog.getRequestLogId()});
		return ret;
	}
	
	/*
	 * Parameter: training request log ID as an integer
	 * Return Value: Training Request log object that represents the training request desired.
	 * 
	 * Description:
	 * 	Gets the training request log row from the training request log table based on the training request log id passed as a parameter.
	 * 	The query statement uses that ID to grab the row needed. That query then returns a training request log object, thanks to the mapper.
	 * 	That training request log object is then returned. 
	 */
	public TrainingRequestLog getTrainingRequestLogById(int trainingRequestLogId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		TrainingRequestLog trainingRequestLog = jTemp.queryForObject("Select * from training_request_log where request_log_id = ?",
												   				new Object[]{trainingRequestLogId}, new TrainingRequestLogMapper());
		return trainingRequestLog;
	}
	
	/*
	 * Parameter: none
	 * Return Value: List of training request log objects
	 * 
	 * Description:
	 * 	Gets all of the training request logs from the training_request_log table and inserts them into a list, thanks to the mapper.
	 * 	Returns the list of training request logs.
	 */
	public List<TrainingRequestLog> getAllTrainingRequestLog()
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		List<TrainingRequestLog> custList = jTemp.query("Select * from training_request_log" , new TrainingRequestLogMapper());
		return custList;
	}
}
