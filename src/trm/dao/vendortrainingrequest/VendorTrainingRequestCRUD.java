package trm.dao.vendortrainingrequest;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;
import trm.dao.vendordetails.VendorDetails;
import trm.dao.vendordetails.VendorDetailsCRUDService;

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
    
    public static void main(String[] args)
    {
	VendorTrainingRequestCRUD vendorCRUD = new VendorTrainingRequestCRUD();
	
	VendorTrainingRequest vendorRequest = new VendorTrainingRequest();
	
	TrainingRequest trainingRequest = new TrainingRequestCRUD().getTrainingRequestById(10071);
	vendorRequest.setTrainingRequest(trainingRequest);
	
	VendorDetails vendor = new VendorDetailsCRUDService().getVendorDetailsById(vendor_id)
    }
}
