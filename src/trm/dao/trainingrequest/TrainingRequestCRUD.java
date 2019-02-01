package trm.dao.trainingrequest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;

public class TrainingRequestCRUD 
{
	private JdbcTemplate jTemp;
	
	/*
	 * Parameter: TrainingRequest object
	 * Return Value: Status integer
	 * 
	 * Description:
	 * 	Inserts a new training request into training_request table using the instance variables of the training_request
	 *	object that was passed as a parameter. Each attribute is accessed using the getter methods of the training request class.
	 */
	public int insertTrainingRequest(TrainingRequest trainingRequest)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("Insert into training_Request values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)" , 
												  new Object[] {trainingRequest.getRequesterId(), trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestTrainingMode(), trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc(), trainingRequest.getExecutiveId(),
														  		trainingRequest.getTimeRequested()});
		return ret;
	}
	
	/*
	 * Parameter: The training request ID as an integer
	 * Return Value: Status integer
	 * 
	 * Description:
	 * 	Deletes the training request row from the training_request table based on the training request ID passed as a parameter.
	 *	Update statement uses the passed parameter to delete entry.
	 */
	public int deleteTrainingRequest(int trainingRequestId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("delete from training_request where training_request_id = ?", 
												  new Object[] {trainingRequestId});
		return ret;
	}
	
	/*
	 * Parameter: TrainingRequest object
	 * Return Value: Status integer
	 * 
	 * Description:
	 * 	Updates the attributes of a training request row based on the request's id. The attribute values that are changed are based
	 * 	on the values of the instance variables in the training request object that was passed. The update method uses the getter methods of the
	 * 	training request class to access the instance variables of the object. The method updates all fields, whether changed or unchanged.
	 * 	DIFFERENT APPROACH MAY BE TAKEN IF UPDATING ONLY SOME FIELDS IS DESIRED.
	 */
	public int updateTrainingRequest(TrainingRequest trainingRequest)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jTemp.update("Update training_request set requester_id = ?, request_training_type = ?, request_training_module = ?, request_training_module_scope = ?,"
							 + " request_training_mode = ?, request_start_time = ?, request_end_time = ?, request_location = ?, request_time_zone = ?, request_approx_participant = ?, request_project_spoc = ?,"
				             + " executive_id = ?, time_requested = ? where training_request_id = ?",
												  new Object[] {trainingRequest.getRequesterId(), trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestTrainingMode(), trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc(), trainingRequest.getExecutiveId(),
														  		trainingRequest.getTimeRequested(), trainingRequest.getTrainingRequestId()});
		return ret;
	}
	
	/*
	 * Parameter: training request ID as an integer
	 * Return Value: Training Request object that represents the training request desired.
	 * 
	 * Description:
	 * 	Gets the training request row from the training request table based on the training request id passed as a parameter.
	 * 	The query statement uses that ID to grab the row needed. That query then returns a training request object, thanks to the mapper.
	 * 	That training request object is then returned. 
	 */
	public TrainingRequest getTrainingRequestById(int trainingRequestId)
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		TrainingRequest trainingRequest = jTemp.queryForObject("Select * from training_request where training_request_id = ?",
												   				new Object[]{trainingRequestId}, new trm.dao.trainingrequest.TrainingRequestMapper());
		return trainingRequest;
	}
	
	/*
	 * Parameter: none
	 * Return Value: List of training request objects
	 * 
	 * Description:
	 * 	Gets all of the training requests from the training_request table and inserts them into a list, thanks to the mapper.
	 * 	Returns the list of training requests.
	 */
	public List<TrainingRequest> getAllTrainingRequest()
	{
		jTemp = DAOJDBCTemplate.getJdbcTemplate();
		List<TrainingRequest> custList = jTemp.query("Select * from training_request" , new trm.dao.trainingrequest.TrainingRequestMapper());
		return custList;
	}
}
