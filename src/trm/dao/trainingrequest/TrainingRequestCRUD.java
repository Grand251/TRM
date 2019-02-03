package trm.dao.trainingrequest;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


/*
 * @author Ian Nielsen
 * Last changed: February 1st 2019 10:47PM
 */
public class TrainingRequestCRUD 
{
	//JdbcTemplate object. Will be initialized in every method using the static method
	//getJdbcTemplate in the DAOJDBCTemplate class.
	private JdbcTemplate jTemp;
	
	/*
	 * Inserts a new training request into training_request table using 
	 * the instance variables of the training request object that was passed 
	 * as a parameter. Each attribute is accessed using the getter methods 
	 * of the training request class. The first attribute of the training_request
	 * table is generated using a sequence, so using a getter method for that
	 * attribute is not needed. 
	 *
	 * @param  Training Request object to be inserted.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int insertTrainingRequest(TrainingRequest trainingRequest)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int numberOfRowsEffected = jTemp.update("Insert into training_Request values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" , 
												  new Object[] {trainingRequest.getRequesterId(), trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestTrainingMode(), trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc(), trainingRequest.getExecutiveId(),
														  		trainingRequest.getTimeRequested(), trainingRequest.getStatus()});
		return numberOfRowsEffected;
	}
	
	/*
	 * Deletes the training request row from the training_request table based 
	 * on the training request ID passed as a parameter. Update statement uses 
	 * the passed parameter to delete entry.
	 *
	 * @param  Training Request ID of the request to be deleted.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int deleteTrainingRequest(int trainingRequestId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int numberOfRowsEffected = jTemp.update("delete from training_request where training_request_id = ?", 
												  new Object[] {trainingRequestId});
		return numberOfRowsEffected;
	}
	
	/*
	 * Updates the attributes of a training request row based on the request's id. 
	 * The attribute values that are changed are based on the values of the instance 
	 * variables in the training request object that was passed. The update method 
	 * uses the getter methods of the training request class to access the instance 
	 * variables of the object. The method updates all fields, whether changed or 
	 * unchanged. Other update methods are provided below if only specific fields 
	 * need to be updated.
	 *
	 * @param  Training Request object which represents the training request to be updated. 
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int updateTrainingRequest(TrainingRequest trainingRequest)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int numberOfRowsEffected = jTemp.update("Update training_request set request_training_type = ?, request_training_module = ?, request_training_module_scope = ?,"
							 + " request_training_mode = ?, request_start_time = ?, request_end_time = ?, request_location = ?, request_time_zone = ?, request_approx_participant = ?, request_project_spoc = ?,"
				             + " executive_id = ?, time_requested = ?, status = ? where training_request_id = ?",
												  new Object[] {trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestTrainingMode(), trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc(), trainingRequest.getExecutiveId(),
														  		trainingRequest.getTimeRequested(), trainingRequest.getTrainingRequestId(), trainingRequest.getStatus()});
		return numberOfRowsEffected;
	}
	
	/*
	 * Updates a specific attribute of a training request. The training request to
	 * be updated is specified by the trainingRequestId parameter. The specific
	 * attribute name to be changed is passed as the trainingRequestAttribute.
	 * The new value of the attribute is passed as the attributeNewValue.
	 * The method creates a SQL prepared statement by concatenating an update 
	 * statement with the attribute to be changed, as well as the new value.
	 * The purpose of this is to limit the amount of update methods in this class.
	 * This allows us to implement only three methods instead of fourteen, one for
	 * each attribute. Hence, this overloaded method is only for attributes that
	 * are Strings or varchars.
	 *
	 * @param  Training Request ID of the training request to be updated.
	 * @param  The attribute of the training_request table to be updated.
	 * @param  The new value of the attribute as a string, hence this method is 
	 * 		   specifically for attributes that are types String/Varchar.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int updateTrainingRequestByAttribute(int trainingRequestId, String trainingRequestAttribute, String attributeNewValue)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		
		String sqlPreparedStatement = "Update training_request set ";
		sqlPreparedStatement = sqlPreparedStatement.concat(trainingRequestAttribute);
		sqlPreparedStatement = sqlPreparedStatement.concat(" = '");
		sqlPreparedStatement = sqlPreparedStatement.concat(attributeNewValue);
		sqlPreparedStatement = sqlPreparedStatement.concat("' where training_request_id = ");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + trainingRequestId);
		
		int numberOfRowsEffected = jTemp.update(sqlPreparedStatement);
		
		return numberOfRowsEffected;
	}
	
	/*
	 * Updates a specific attribute of a training request. The training request to
	 * be updated is specified by the trainingRequestId parameter. The specific
	 * attribute name to be changed is passed as the trainingRequestAttribute.
	 * The new value of the attribute is passed as the attributeNewValue, which 
	 * is a Timestamp. The method executes an update statement based on whether the 
	 * attribute to be changed is the end date or start date. In both cases the 
	 * method updates the date to the Timestamp object that was passed as a parameter
	 *
	 * @param  Training Request ID of the training request to be updated.
	 * @param  The attribute of the training_request table to be updated.
	 * @param  The new value of the attribute as a Timestamp, hence this method is 
	 * 		   specifically for attributes that are Timestamps.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int updateTrainingRequestByAttribute(int trainingRequestId, String trainingRequestAttribute, Timestamp newTimestamp)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int numberOfRowsEffected = 0;
		if(trainingRequestAttribute.equals("request_start_time"))
		{
			numberOfRowsEffected = jTemp.update("Update training_request set request_start_time = ? where training_request_id = ?",
												  new Object[] {newTimestamp, trainingRequestId});
		}
		else
		{
			numberOfRowsEffected = jTemp.update("Update training_request set request_end_time = ? where training_request_id = ?",
					  new Object[] {newTimestamp, trainingRequestId});
		}
		
		return numberOfRowsEffected;
	}
	
	/*
	 * Updates a specific attribute of a training request. The training request to
	 * be updated is specified by the trainingRequestId parameter. The specific
	 * attribute name to be changed is passed as the trainingRequestAttribute.
	 * The new value of the attribute is passed as the attributeNewValue, which in
	 * this case is an integer. The method creates a SQL prepared statement by 
	 * concatenating an update statement with the attribute to be changed, as well 
	 * as the new value. The purpose of this is to limit the amount of update methods 
	 * in this class. This allows us to implement only three methods instead of 
	 * fourteen, one for each attribute. Hence, this overloaded method is only for 
	 * attributes that are integers.
	 *
	 * @param  Training Request ID of the training request to be updated.
	 * @param  The attribute of the training_request table to be updated.
	 * @param  The new value of the attribute as an integer, hence this method is 
	 * 		   specifically for attributes that are integers.
	 * @return Number of rows effected as an integer. Should be 1.
	 */
	public int updateTrainingRequestByAttribute(int trainingRequestId, String trainingRequestAttribute, int attributeNewValue)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		
		String sqlPreparedStatement = "Update training_request set ";
		sqlPreparedStatement = sqlPreparedStatement.concat(trainingRequestAttribute);
		sqlPreparedStatement = sqlPreparedStatement.concat(" = '");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + attributeNewValue);
		sqlPreparedStatement = sqlPreparedStatement.concat("' where training_request_id = ");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + trainingRequestId);
		
		int numberOfRowsEffected = jTemp.update(sqlPreparedStatement);
		
		return numberOfRowsEffected;
	}
	
	
	/*
	 * Gets the training request row from the training request table based on the 
	 * training request id passed as a parameter. The query statement uses that ID 
	 * to grab the row needed. That query then returns a training request object, 
	 * thanks to the mapper.That training request object is then returned. 
	 *
	 * @param  Training Request ID that represents the training request to be returned.
	 * @return Training request object which contains the attributes of the training 
	 * 		   request needed.
	 */
	public TrainingRequest getTrainingRequestById(int trainingRequestId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		TrainingRequest trainingRequest = jTemp.queryForObject("Select * from training_request where training_request_id = ?",
												   				new Object[]{trainingRequestId}, new TrainingRequestMapper());
		return trainingRequest;
	}
	
	/*
	 * Gets all of the training requests from the training_request table and inserts 
	 * them into a list, thanks to the mapper. Returns the list of training requests.
	 *
	 * @param  None.
	 * @return List of training request objects that represents all of the training
	 * 		   requests in the training_request table.
	 */
	public List<TrainingRequest> getAllTrainingRequest()
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		List<TrainingRequest> trainingRequestList = jTemp.query("Select * from training_request" , new TrainingRequestMapper());
		return trainingRequestList;
	}
}
