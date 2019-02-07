package trm.dao.vendortrainingrequest;

import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.vendordetails.VendorDetails;
import trm.dao.vendortrainer.VendorTrainer;

public class VendorTrainingRequest
{
    private int vendorTrainingRequestId;
    private TrainingRequest trainingRequest;
    private VendorDetails vendor;
    private VendorTrainer vendorTrainer;
    private TrainingSchedule schedule;
    private Employee executive;
    private String poStatus;
    private String vendorConfirmationEmail;
    private int status;
    private String descriptionOfStatus;
    
    public int getVendorTrainingRequestId()
    {
        return vendorTrainingRequestId;
    }
    public void setVendorTrainingRequestId(int vendorTrainingRequestId)
    {
        this.vendorTrainingRequestId = vendorTrainingRequestId;
    }
    public TrainingRequest getTrainingRequest()
    {
        return trainingRequest;
    }
    public void setTrainingRequest(TrainingRequest trainingRequest)
    {
        this.trainingRequest = trainingRequest;
    }
    public VendorDetails getVendor()
    {
        return vendor;
    }
    public void setVendor(VendorDetails vendor)
    {
        this.vendor = vendor;
    }
    public VendorTrainer getVendorTrainer()
    {
        return vendorTrainer;
    }
    public void setVendorTrainer(VendorTrainer vendorTrainer)
    {
        this.vendorTrainer = vendorTrainer;
    }
    public TrainingSchedule getSchedule()
    {
        return schedule;
    }
    public void setSchedule(TrainingSchedule schedule)
    {
        this.schedule = schedule;
    }
    public Employee getExecutive()
    {
        return executive;
    }
    public void setExecutive(Employee executive)
    {
        this.executive = executive;
    }
    public String getPoStatus()
    {
        return poStatus;
    }
    public void setPoStatus(String poStatus)
    {
        this.poStatus = poStatus;
    }
    public String getVendorConfirmationEmail()
    {
        return vendorConfirmationEmail;
    }
    public void setVendorConfirmationEmail(String vendorConfirmationEmail)
    {
        this.vendorConfirmationEmail = vendorConfirmationEmail;
    }
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
    public String getDescriptionOfStatus()
    {
        return descriptionOfStatus;
    }
    public void setDescriptionOfStatus(String descriptionOfStatus)
    {
        this.descriptionOfStatus = descriptionOfStatus;
    }
}
