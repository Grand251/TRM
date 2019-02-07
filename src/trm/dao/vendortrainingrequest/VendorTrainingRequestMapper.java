package trm.dao.vendortrainingrequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;
import trm.dao.vendordetails.VendorDetails;
import trm.dao.vendordetails.VendorDetailsCRUDService;
import trm.dao.vendortrainer.VendorTrainer;
import trm.dao.vendortrainer.VendorTrainerCRUDService;

public class VendorTrainingRequestMapper implements RowMapper<VendorTrainingRequest>
{
    public VendorTrainingRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
	VendorTrainingRequest vendorTrainingRequest = new VendorTrainingRequest();
	
	vendorTrainingRequest.setVendorTrainingRequestId(resultSet.getInt(1));
	
	TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(resultSet.getInt(2));
	vendorTrainingRequest.setTrainingRequest(trainingRequest);
	
	VendorDetails vendor = new VendorDetailsCRUDService().getVendorDetailsById(resultSet.getInt(3));
	vendorTrainingRequest.setVendor(vendor);
	
	VendorTrainer vendorTrainer = new VendorTrainerCRUDService().getVendorTrainerById(resultSet.getInt(4));
	vendorTrainingRequest.setVendorTrainer(vendorTrainer);
	
	TrainingSchedule schedule = new TrainingScheduleCRUDService().getTrainingScheduleById(resultSet.getString(5));
	vendorTrainingRequest.setSchedule(schedule);
	
	Employee executive = new EmployeeCRUDService().getEmployeeById(resultSet.getInt(6));
	vendorTrainingRequest.setExecutive(executive);
	
	vendorTrainingRequest.setPoStatus(resultSet.getString(7));
	vendorTrainingRequest.setVendorConfirmationEmail(resultSet.getString(8));
	vendorTrainingRequest.setStatus(resultSet.getInt(9));
	vendorTrainingRequest.setDescriptionOfStatus(resultSet.getString(10));
	
	return vendorTrainingRequest;
    }
}
