	package trm.dao.trainingrequest;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestMapper implements RowMapper<TrainingRequest>
{
		public TrainingRequest mapRow(ResultSet result, int arg1) throws SQLException 
		{
			TrainingRequest trainingRequest = new TrainingRequest();
			trainingRequest.setTrainingRequestId(result.getInt(1));
			trainingRequest.setRequesterId(result.getInt(2));
			trainingRequest.setRequestTrainingType(result.getString(3));
			trainingRequest.setRequestTrainingModule(result.getString(4));
			trainingRequest.setRequestTrainingModuleScope(result.getString(5));
			trainingRequest.setRequestTrainingMode(result.getString(6));
			trainingRequest.setRequestStartTime(result.getTimestamp(7));
			trainingRequest.setRequestEndTime(result.getTimestamp(8));
			trainingRequest.setRequestLocation(result.getString(9));
			trainingRequest.setRequestTimeZone(result.getString(10));
			trainingRequest.setApproxNumberOfParticipants(result.getInt(11));
			trainingRequest.setRequestProjectSpoc(result.getInt(12));
			trainingRequest.setExecutiveId(result.getInt(13));
			trainingRequest.setTimeRequested(result.getTimestamp(14));
			trainingRequest.setStatus(result.getInt(15));
			
			return trainingRequest;
		}
}

