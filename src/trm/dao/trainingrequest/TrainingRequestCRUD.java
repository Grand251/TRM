package trm.dao.trainingrequest;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;



/*
 * @author Ian Nielsen
 * Last changed: February 4th 2019 12:46PM
 */
public class TrainingRequestCRUD 
{
	//JdbcTemplate object. Will be initialized in every method using the static method
	//getJdbcTemplate in the new DAOJDBCTemplate() class.
        private JdbcTemplate jTemp = new DAOJDBCTemplate().getJdbcTemplate();
	
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
	        //DAOJDBCTemplate jdbcTemplate = new DAOJDBCTemplate();
	        //jTemp = jdbcTemplate.getJdbcTemplate();
	    	//ConfigurableApplicationContext context = new DAOJDBCTemplate().getApplicationContext();
	    	//JdbcTemplate jTemp = (JdbcTemplate)context.getBean("jTemp");
		int numberOfRowsEffected = jTemp.update("Insert into training_Request values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" , 
												  new Object[] {trainingRequest.getRequesterId(), trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestTrainingMode(), trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc().getEmployee_id(),
														  		trainingRequest.getTimeRequested(), trainingRequest.getStatus(), trainingRequest.getJustificationOfRequest()});
		
		//jdbcTemplate.close();
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
		int numberOfRowsEffected = jTemp.update("Update training_request set status = -1 where training_request_id = ?", 
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
		int numberOfRowsEffected = jTemp.update("Update training_request set request_training_type = ?, request_training_module = ?, request_training_module_scope = ?,"
							 + " request_start_date = ?, request_end_date = ?, request_location = ?, request_time_zone = ?, request_approx_participant = ?, request_project_spoc = ?,"
				                         + " time_requested = ?, status = ?, justification_of_request = ? where training_request_id = ?",
												  new Object[] {trainingRequest.getRequestTrainingType(),
														  		trainingRequest.getRequestTrainingModule(), trainingRequest.getRequestTrainingModuleScope(),
														  		trainingRequest.getRequestStartTime(),
														  		trainingRequest.getRequestEndTime(), trainingRequest.getRequestLocation(),
														  		trainingRequest.getRequestTimeZone(), trainingRequest.getApproxNumberOfParticipants(),
														  		trainingRequest.getRequestProjectSpoc().getEmployee_id(),
														  		trainingRequest.getTimeRequested(), trainingRequest.getStatus(), trainingRequest.getJustificationOfRequest(),
														  		trainingRequest.getTrainingRequestId()});
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
		
		String sqlPreparedStatement = "Update training_request set ";
		sqlPreparedStatement = sqlPreparedStatement.concat(trainingRequestAttribute);
		sqlPreparedStatement = sqlPreparedStatement.concat(" = '");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + attributeNewValue);
		sqlPreparedStatement = sqlPreparedStatement.concat("' where training_request_id = ");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + trainingRequestId);
		
		int numberOfRowsEffected = jTemp.update(sqlPreparedStatement);
		
		return numberOfRowsEffected;
	}
	
	public int updateTrainingRequestByAttribute(int trainingRequestId, String trainingRequestAttribute, double attributeNewValue)
	{
		
		String sqlPreparedStatement = "Update training_request set ";
		sqlPreparedStatement = sqlPreparedStatement.concat(trainingRequestAttribute);
		sqlPreparedStatement = sqlPreparedStatement.concat(" = ");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + attributeNewValue);
		sqlPreparedStatement = sqlPreparedStatement.concat(" where training_request_id = ");
		sqlPreparedStatement = sqlPreparedStatement.concat("" + trainingRequestId);
		
		int numberOfRowsEffected = jTemp.update(sqlPreparedStatement);
		
		return numberOfRowsEffected;
	}
	
	public int updateTrainingRequestScopeTypeModeParticip(int trainingRequestId, String requestScope, String requestType, String requestMode, int requestNumberOfParticipants)
	{
	    int count = jTemp.update("Update training_request set request_training_module_scope = ?, request_training_type = ?, request_training_mode = ?, request_approx_participant = ? where training_request_id = ?",
		    				           new Object[] {requestScope, requestType, requestMode, requestNumberOfParticipants, trainingRequestId});
	    return count;
	}
	
	public int updateTrainingRequestTimesTimezoneLocation(int trainingRequestId, Timestamp requestStartTime, Timestamp requestEndTime, String requestTimeZone, String requestLocation)
	{
	    int count = jTemp.update("Update training_request set request_start_date = ?, request_end_date = ?, request_time_zone = ?, request_location = ? where training_request_id = ?",
		    		      new Object[] { requestStartTime, requestEndTime, requestTimeZone, requestLocation, trainingRequestId});
	    return count;
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
		TrainingRequest trainingRequest = jTemp.queryForObject("Select * from training_request where training_request_id = ? AND status >= 0",
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
		List<TrainingRequest> trainingRequestList = jTemp.query("Select * from training_request where status >= 0" , new TrainingRequestMapper());
		
		//jTemp.getDataSource().getConnection().close();
		
		return trainingRequestList;
	}
	
	public List<TrainingRequest> getAllTrainingRequestForPM(int projectManagerId) throws SQLException
	{
	        List<TrainingRequest> trainingRequestList = jTemp.query("Select * from training_request where requester_id = ? AND status >= 0",
	        	new Object[] {projectManagerId}, new TrainingRequestMapper());
	        
	        jTemp.getDataSource().getConnection().close();
	        return trainingRequestList;
	}
	
	public List<TrainingRequest> getAllRequestBySPOCStatus(int spocId, int status) throws SQLException
	{
	        List<TrainingRequest> trainingRequestList = jTemp.query("Select * from training_request where request_project_spoc = ? AND status = ?",
	        	new Object[] {spocId, status}, new TrainingRequestMapper());
	        
	        jTemp.getDataSource().getConnection().close();
	        return trainingRequestList;
	}
	
	public List<TrainingRequest> getAllTrainingRequestByStatus(double status) throws SQLException
	{
	    	List<TrainingRequest> trainingRequestList = jTemp.query("Select * from training_request where status = ?",
	    								new Object[] {status}, new TrainingRequestMapper());
	    	jTemp.getDataSource().getConnection().close();
	    	return trainingRequestList;
	}

	
	
	public static void main(String[] args)
	{
		TrainingRequestCRUD crud = new TrainingRequestCRUD();
		//crud.deleteTrainingRequest(10115);
		
		/*
		List<TrainingRequest> list;
		try
		{
		    List<>list = crud.getAllTrainingRequestByStatus(3);
		} catch (SQLException e)
		{
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		for(TrainingRequest request:list)
		{
		    System.out.println(request.getRequesterId());
		}
		*/
		
		TrainingRequest tr = new TrainingRequest();
		tr.setRequesterId(1000057);
		tr.setRequestTrainingType("IT");
		tr.setRequestTrainingModule("Java FSD");
		tr.setRequestTrainingModuleScope("Spring");
		tr.setRequestTrainingMode("class room");
		Timestamp st = Timestamp.valueOf("2019-01-08 09:00:00");
		Timestamp et = Timestamp.valueOf("2019-02-18 03:00:00");
		tr.setRequestStartTime(st);
		tr.setRequestEndTime(et);
		tr.setRequestLocation("Boston");
		tr.setRequestTimeZone("EST");
		tr.setApproxNumberOfParticipants(15);
		
		Employee spoc = new EmployeeCRUDService().getEmployeeById(1000032);
		tr.setRequestProjectSpoc(spoc);
		
		Timestamp timeR = Timestamp.valueOf("2019-01-18 03:00:00");
		tr.setTimeRequested(timeR);
		tr.setStatus(1);
		tr.setJustificationOfRequest("Needed");
		
		//System.out.println(crud.insertTrainingRequest(tr));
		
		/*
		TrainingRequest tr = new TrainingRequest();
		tr.setTrainingRequestId(10015);
		tr.setRequesterId(1000021);
		tr.setRequestTrainingType("IT");
		tr.setRequestTrainingModule(".NET");
		tr.setRequestTrainingModuleScope("VB");
		tr.setRequestTrainingMode("web based");
		Timestamp st = Timestamp.valueOf("2019-04-18 10:00:00");
		Timestamp et = Timestamp.valueOf("2019-05-28 07:00:00");
		tr.setRequestStartTime(st);
		tr.setRequestEndTime(et);
		tr.setRequestLocation("Phoenix");
		tr.setRequestTimeZone("MST");
		tr.setApproxNumberOfParticipants(10);
		tr.setRequestProjectSpoc(1000006);
		tr.setExecutiveId(1000012);
		Timestamp timeR = Timestamp.valueOf("2019-02-08 15:30:00");
		tr.setTimeRequested(timeR);
		*/
		
		//crud.insertTrainingRequest(tr);
		
		//crud.deleteTrainingRequest(10116);
		
		//System.out.println(crud.updateTrainingRequest(tr));
		
		//System.out.println(crud.updateTrainingRequestScopeTypeModeParticip(10000, "SpringMVC", "VT", "web based", 20));
		
		//System.out.println(crud.getTrainingRequestById(10000).getRequestLocation());
		
		//Timestamp st = Timestamp.valueOf("2019-04-18 10:00:00");
		//Timestamp et = Timestamp.valueOf("2019-05-28 07:00:00");
		
		//System.out.println(crud.updateTrainingRequestTimesTimezoneLocation(10000, st, et, "MST", "Phoenix"));
		
		//List<TrainingRequest> list = crud.getAllRequest;
		System.out.println("Hello");
		//System.out.println("Connection count before getAll: " + crud.getActiveConnectionCount());
		List<TrainingRequest> list = crud.getAllTrainingRequest();
		//System.out.println("Connection count after getAll: " + crud.getActiveConnectionCount());
		for(TrainingRequest trainerRequest : list)
		{
			System.out.println(trainerRequest.getTrainingRequestId());
		}
		
		
	}
}
