package trm.dao.trainingrequestlog;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;

/*
 * @author Ian Nielsen
 * Last changed: February 2nd 2019 5:29PM
 */

public class TrainingRequestLogCRUD 
{
        //JdbcTemplate object. Will be initialized in every method using the static method
  	//getJdbcTemplate in the new DAOJDBCTemplate() class.
	private JdbcTemplate jTemp;
	
	/*
	 * Inserts a new training request log into training_request_log table using 
	 * the instance variables of the training request log object that was passed 
	 * as a parameter. Each attribute is accessed using the getter methods 
	 * of the training request log class. The first attribute of the training_request_log
	 * table is generated using a sequence, so using a getter method for that
	 * attribute is not needed. 
	 *
	 * @param  Training Request  log object to be inserted.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int insertTrainingRequestLog(TrainingRequestLog trainingRequestLog)
	{
		jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jTemp.update("Insert into training_request_log values(training_request_log_id_seq.nextval,?,?,?,?)" , 
												  new Object[] {trainingRequestLog.getTrainingRequestId(), trainingRequestLog.getStatus(),
														  		trainingRequestLog.getStatusChangeTime(), trainingRequestLog.getDescription(),
														  		});
		return ret;
	}
	
	/*
	 * Deletes the training request log row from the training_request_log table based 
	 * on the training request log ID passed as a parameter. Update statement uses 
	 * the passed parameter to delete entry.
	 *
	 * @param  Training Request Log ID of the log to be deleted.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int deleteTrainingRequestLog(int trainingRequestLogId)
	{
		jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jTemp.update("delete from training_request_log where request_log_id = ?", 
												  new Object[] {trainingRequestLogId});
		return ret;
	}
	
	
	/*
	 * Gets the training request log row from the training request log table based on the 
	 * training request log id passed as a parameter. The query statement uses that ID 
	 * to grab the row needed. That query then returns a training request log object, 
	 * thanks to the mapper.That training request log object is then returned. 
	 *
	 * @param  Training Request Log ID that represents the training request log to be returned.
	 * @return Training request Log object which contains the attributes of the training 
	 *         request needed.
	 */
	public TrainingRequestLog getTrainingRequestLogById(int trainingRequestLogId)
	{
		jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		TrainingRequestLog trainingRequestLog = jTemp.queryForObject("Select * from training_request_log where request_log_id = ?",
												   				new Object[]{trainingRequestLogId}, new TrainingRequestLogMapper());
		return trainingRequestLog;
	}
	
	public TrainingRequestLog getTrainingRequestLogByRequestId(int trainingRequestId)
	{
	        jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		TrainingRequestLog trainingRequestLog = jTemp.queryForObject("Select * from training_request_log where training_request_id = ?",
												   				new Object[]{trainingRequestId}, new TrainingRequestLogMapper());
		return trainingRequestLog;
	}
	
	/*
	 * Gets all of the training request logs from the training_request_log table and inserts 
	 * them into a list, thanks to the mapper. Returns the list of training request logs.
	 *
	 * @param  None.
	 * @return List of training request log objects that represents all of the training
	 *         request logs in the training_request_log table.
	 */
	public List<TrainingRequestLog> getAllTrainingRequestLog()
	{
		jTemp = new DAOJDBCTemplate().getJdbcTemplate();
		List<TrainingRequestLog> custList = jTemp.query("Select * from training_request_log" , new TrainingRequestLogMapper());
		return custList;
	}
	
	public static void main(String[] args)
	{
	}
}
