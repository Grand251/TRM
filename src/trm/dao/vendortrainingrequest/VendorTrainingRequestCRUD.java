package trm.dao.vendortrainingrequest;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import trm.dao.DAOJDBCTemplate;

public class VendorTrainingRequestCRUD
{
    private JdbcTemplate jTemp = new DAOJDBCTemplate().getJdbcTemplate();
    
    public int insertVendorTrainingRequest(VendorTrainingRequest vendorTrainingRequest)
    {
	int numberOfRowsEffected = jTemp.update("Insert into vendor_training_request values(vendor_training_request_id_seq.nextval,?,?,?,?,?,?,?,?,?)" , 
												  new Object[] {vendorTrainingRequest.getTrainingRequest().getTrainingRequestId(), vendorTrainingRequest.getVendor().getVendor_id(),
													  	vendorTrainingRequest.getVendorTrainer().getVendor_trainer_id(), vendorTrainingRequest.getSchedule().getTraining_schedule_id(),
													  	vendorTrainingRequest.getExecutive().getEmployee_id(), vendorTrainingRequest.getPoStatus(),
													  	vendorTrainingRequest.getVendorConfirmationEmail(), vendorTrainingRequest.getStatus(), vendorTrainingRequest.getDescriptionOfStatus()});
	return numberOfRowsEffected;
    }
    
    public int deleteVendorTrainingRequest(int vendorRequestId)
    {
	int numOfRowsEffected = jTemp.update("Update vendor_training_request set status = -1 where vendor_training_request_id = ?", 
			new Object[] {vendorRequestId});
	
	return numOfRowsEffected;
    }
    
    public int updateVendorTrainingRequest(VendorTrainingRequest vendorRequest)
    {
	int numOfRowsEffected = jTemp.update("Update vendor_training_request set training_request_id = ?, confirmed_vendor_id = ?, "
					   + "vendor_trainer_id = ?, schedule_id = ?, executive_id = ?, po_status = ?, vendor_confirmation_email = ?, "
					   + "status = ?, description_of_status = ? where vendor_training_request_id = ?",
					   new Object[] {vendorRequest.getTrainingRequest().getTrainingRequestId(), vendorRequest.getVendor().getVendor_id(),
						         vendorRequest.getVendorTrainer().getVendor_trainer_id(), vendorRequest.getSchedule().getTraining_schedule_id(),
						         vendorRequest.getExecutive().getEmployee_id(), vendorRequest.getPoStatus(), vendorRequest.getVendorConfirmationEmail(),
						         vendorRequest.getStatus(), vendorRequest.getDescriptionOfStatus(), vendorRequest.getVendorTrainingRequestId()});
	return numOfRowsEffected;
    }
    
    public int updateVendorTrainingRequestStatus(int vendorRequestId, int newStatus)
    {
	int numOfRowsEffected = jTemp.update("Update vendor_training_request set status = ? where vendor_training_request_id = ?",
		      new Object[] {newStatus, vendorRequestId});
        return numOfRowsEffected;
    }
    
    public VendorTrainingRequest getVendorTrainingRequestById(int vendorRequestId)
    {
	VendorTrainingRequest vendorRequest = jTemp.queryForObject("Select * from vendor_training_request where vendor_training_request_id = ? AND status >= 0",
		      new Object[] {vendorRequestId}, new VendorTrainingRequestMapper());
        return vendorRequest;
    }
    
    public List<VendorTrainingRequest> getAllVendorTrainingRequestForExecutive(int executiveId)
    {
	List<VendorTrainingRequest> vendorRequestList = jTemp.query("Select * from vendor_training_request where executive_id = ? AND status >= 0",
		      new Object[] {executiveId}, new VendorTrainingRequestMapper());
        return vendorRequestList;
    }
    
    public List<VendorTrainingRequest> getAllVendorTrainingRequestForSPOC(int spocId)
    {
	List<VendorTrainingRequest> vendorRequestList = jTemp.query("Select * " + 
		  "from vendor_training_request vt " + 
		  "join training_request tr " + 
		  "on tr.training_request_id = vt.training_request_id AND vt.status >= 0 AND tr.request_project_spoc = ?",
		  new Object[] {spocId}, new VendorTrainingRequestMapper());
        return vendorRequestList;
    }
    
    public List<VendorTrainingRequest> getAllVendorTrainingRequestForPM(int projectManagerId)
    {
	List<VendorTrainingRequest> vendorRequestList = jTemp.query("Select * " + 
		  "from vendor_training_request vt " + 
		  "join training_request tr " + 
		  "on tr.training_request_id = vt.training_request_id AND vt.status >= 0 AND tr.requester_id = ?",
		  new Object[] {projectManagerId}, new VendorTrainingRequestMapper());
        return vendorRequestList;
    }
    
    public List<VendorTrainingRequest> getAllVendorTrainingRequestBySPOCandStatus(int spocId, int status)
    {
	List<VendorTrainingRequest> vendorRequestList = jTemp.query("Select * " + 
		  "from vendor_training_request vt " + 
		  "join training_request tr " + 
		  "on tr.training_request_id = vt.training_request_id AND vt.status = ? AND tr.request_project_spoc = ?",
		  new Object[] {status, spocId}, new VendorTrainingRequestMapper());
        return vendorRequestList;
    }
    
    public static void main(String[] args)
    {
	
	VendorTrainingRequestCRUD vendorCRUD = new VendorTrainingRequestCRUD();
	
        List<VendorTrainingRequest> vendorRequestList = vendorCRUD.getAllVendorTrainingRequestForPM(1000072);
	
	for(VendorTrainingRequest vendorRequest : vendorRequestList)
	{
	    System.out.println(vendorRequest.getVendorTrainingRequestId() + " " + vendorRequest.getTrainingRequest().getTrainingRequestId() + " "
		    		+ vendorRequest.getVendor().getVendor_id() + " " + vendorRequest.getVendorTrainer().getVendor_trainer_id() + " "
		    		+ vendorRequest.getSchedule().getTraining_schedule_id() + " " + vendorRequest.getExecutive().getEmployee_id() + " "
		    		+ vendorRequest.getPoStatus() + " " + vendorRequest.getVendorConfirmationEmail() + " " + vendorRequest.getStatus() + " " + vendorRequest.getDescriptionOfStatus());
	    
	}
	
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
	
	//vendorCRUD.deleteDevelopmentTeamTrainingRequest(10000);
	
    }
}
