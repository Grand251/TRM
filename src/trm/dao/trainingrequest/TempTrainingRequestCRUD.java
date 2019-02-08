package trm.dao.trainingrequest;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import trm.dao.DAOJDBCTemplate;

public class TempTrainingRequestCRUD {

	/*public static void main(String[] args) {
		TempTrainingRequestCRUD ttrCRUD = new TempTrainingRequestCRUD();
		Calendar c = Calendar.getInstance();   // this takes current date
	    
		Timestamp end = new Timestamp(new Date().getTime());
		c.add(Calendar.MONTH, -5);
		Timestamp start = new Timestamp(c.getTime().getTime());
		System.out.println(start);
		System.out.println(end);
		
		List<TrainingRequest> list1 = ttrCRUD.getAllTrainingRequestBySpoc(1000019);
		System.out.println(list1);
		
		List<TrainingRequest> list = ttrCRUD.getAllTrainingRequestBySpocStartInRange(1000019, start, end);
		System.out.println(list);
	}*/
	
	public int getNumTrainingRequestBySPOCLocationMode(int spocId, String location, String mode, Timestamp start, Timestamp end) { 
		Integer count = new DAOJDBCTemplate().getJdbcTemplate().queryForObject( 
				"Select count(*) from training_request WHERE request_project_spoc = ? "
				+ "AND request_training_mode = ? AND request_location = ? AND request_start_date >= ? AND request_end_date <= ?", 
					new Object[] {spocId, mode, location, start, end}, Integer.class); 
		
		if(count==null)
			return 0;
		
		return count.intValue(); 
	}
	
	
	public List<TrainingRequest> getRequestsByRequesterInRange(int requesterId, Timestamp start, Timestamp end){		
		List<TrainingRequest> trainingRequests = new DAOJDBCTemplate().getJdbcTemplate().query(
				"select * from training_request "
				+ "WHERE REQUESTER_ID=? AND request_start_date >= ? "
				+ "AND request_end_date <= ?",new Object[]{requesterId, start, end}, 
				new TrainingRequestMapper());
		
		return trainingRequests;
	}
	
	public int getNumRequestsByRequesterInStatusAndDateRange(int requesterId, int beginStatus, int endStatus,
									Timestamp start, Timestamp end){
		Integer count = new DAOJDBCTemplate().getJdbcTemplate().queryForObject( 
				"Select count(*) from training_request WHERE REQUESTER_ID=? "
				+ "AND STATUS >= ? AND STATUS<= ? AND request_start_date >= ? AND request_end_date <= ?", 
					new Object[] {requesterId, beginStatus, endStatus, start, end}, Integer.class); 
		
		if(count==null)
			return 0;
		
		return count.intValue(); 
		
	}
	
	
	//3 is not the final status to indicate completed, but is used for demonstration
	public int getSPOCSchedulePerformance(int spocId, Timestamp start, Timestamp end) { 
		Integer count = new DAOJDBCTemplate().getJdbcTemplate().queryForObject( 
				"Select sum(diff) from" + 	
						"(Select trunc(t.training_start_date) - trunc(tr.request_start_date) as diff from " + 	
							"(Select s.training_schedule_id, it.training_request_id, s.training_start_date " + 
							"from internal_training_request it " +
						    "join training_schedule s " + 
							"on it.schedule_id = s.training_schedule_id AND it.status > 3) t " + 
							"join training_request tr " +
						    "on t.training_request_id = tr.training_request_id AND request_project_spoc=? AND tr.request_start_date >= ? AND tr.request_start_date <= ?)", 
							new Object[] {spocId, start, end}, Integer.class);
		if(count==null)
			return 0;
		
		return count.intValue();
	}
	
	public List<TrainingRequest> getAllTrainingRequestBySpoc(int spocId)
	{
		List<TrainingRequest> trainingRequests = new DAOJDBCTemplate().getJdbcTemplate().query(
				"select * FROM training_request WHERE request_project_spoc=?",new Object[]{spocId}, 
				new TrainingRequestMapper());
		return trainingRequests;
	}
	
	public List<TrainingRequest> getAllTrainingRequestBySpocInRange(int spocId, Timestamp start, Timestamp end)
	{
		List<TrainingRequest> trainingRequests = new DAOJDBCTemplate().getJdbcTemplate().query(
				"select * FROM training_request WHERE request_project_spoc=? AND request_start_date >= ? AND request_start_date <= ?",
				new Object[]{spocId, start, end}, 
				new TrainingRequestMapper());
		return trainingRequests;
	}
	
	public List<TrainingRequest> getAllTrainingRequestBySpocStartInRange(int spocId, Timestamp start, Timestamp end)
	{
		List<TrainingRequest> trainingRequests = new DAOJDBCTemplate().getJdbcTemplate().query(
				"select * FROM training_request WHERE request_project_spoc=? "
				+ "AND request_start_date >= ? AND request_start_date <= ?",new Object[]{spocId, start, end}, 
				new TrainingRequestMapper());
		return trainingRequests;
	}
	
	
}
