package trm.dao.vendortrainingrequest;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;
import trm.dao.vendordetails.VendorDetails;
import trm.dao.vendordetails.VendorDetailsCRUDService;
import trm.dao.vendortrainer.VendorTrainer;
import trm.dao.vendortrainer.VendorTrainerCRUDService;

public class VendorTrainingRequestCRUD
{
    private JdbcTemplate jtemp;
    
    public int insertVendorTrainingRequest(VendorTrainingRequest vendorTrainingRequest)
    {
	jtemp = new DAOJDBCTemplate().getJdbcTemplate();
	int numberOfRowsEffected = jtemp.update("Insert into vendor_training_request values(vendor_training_request_id_seq.nextval,?,?,?,?,?,?,?,?,?)" , 
												  new Object[] {vendorTrainingRequest.getTrainingRequest().getTrainingRequestId(), vendorTrainingRequest.getVendor().getVendor_id(),
													  	vendorTrainingRequest.getVendorTrainer().getVendor_trainer_id(), vendorTrainingRequest.getSchedule().getTraining_schedule_id(),
													  	vendorTrainingRequest.getExecutive().getEmployee_id(), vendorTrainingRequest.getPoStatus(),
													  	vendorTrainingRequest.getVendorConfirmationEmail(), vendorTrainingRequest.getStatus(), vendorTrainingRequest.getDescriptionOfStatus()});
	return numberOfRowsEffected;
    }
    
    public int deleteDevelopmentTeamTrainingRequest(int vendorRequestId)
    {
	jtemp = new DAOJDBCTemplate().getJdbcTemplate();
	int numOfRowsEffected = jtemp.update("Update vendor_training_request set status = -10 where vendor_training_request_id = ?", 
			new Object[] {vendorRequestId});
	
	return numOfRowsEffected;
    }
    
    public static void main(String[] args)
    {
	
	VendorTrainingRequestCRUD vendorCRUD = new VendorTrainingRequestCRUD();
	
	/*
	VendorTrainingRequest vendorRequest = new VendorTrainingRequest();
	
	TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(10071);
	vendorRequest.setTrainingRequest(trainingRequest);
	
	VendorDetails vendor = new VendorDetailsCRUDService().getVendorDetailsById(10000);
	vendorRequest.setVendor(vendor);
	
	VendorTrainer vendorTrainer = new VendorTrainerCRUDService().getVendorTrainerById(10000);
	vendorRequest.setVendorTrainer(vendorTrainer);
	
	TrainingSchedule schedule = new TrainingScheduleCRUDService().getTrainingScheduleById("10113");
	vendorRequest.setSchedule(schedule);
	
	Employee executive = new EmployeeCRUDService().getEmployeeById(1000040);
	vendorRequest.setExecutive(executive);
	
	vendorRequest.setPoStatus("Paid for");
	vendorRequest.setVendorConfirmationEmail("Confirmed");
	vendorRequest.setStatus(1);
	vendorRequest.setDescriptionOfStatus("Started");
	
	vendorCRUD.insertVendorTrainingRequest(vendorRequest);
	*/
	
	vendorCRUD.deleteDevelopmentTeamTrainingRequest(10000);
	
    }
}
