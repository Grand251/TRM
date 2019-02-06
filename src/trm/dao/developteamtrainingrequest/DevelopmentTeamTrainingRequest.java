package trm.dao.developteamtrainingrequest;

import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingschedule.TrainingSchedule;

public class DevelopmentTeamTrainingRequest
{
    private int dttTrainingId;
    private TrainingRequest trainingRequest;
    private Employee confirmedTrainer;
    private String trainerApprovalMail;
    private String trainerManagerApprovalMail;
    private TrainingSchedule trainingSchedule;
    private Employee executive;
    private int status;
    private String descriptionOfStatus;
    
    public int getDttTrainingId()
    {
        return dttTrainingId;
    }
    
    public void setDttTrainingId(int dttTrainingId)
    {
        this.dttTrainingId = dttTrainingId;
    }
    
    public TrainingRequest getTrainingRequest()
    {
        return trainingRequest;
    }
    
    public void setTrainingRequest(TrainingRequest trainingRequest)
    {
        this.trainingRequest = trainingRequest;
    }
    
    public Employee getConfirmedTrainer()
    {
        return confirmedTrainer;
    }
    
    public void setConfirmedTrainer(Employee confirmedTrainer)
    {
        this.confirmedTrainer = confirmedTrainer;
    }
    
    public String getTrainerApprovalMail()
    {
        return trainerApprovalMail;
    }
    
    public void setTrainerApprovalMail(String trainerApprovalMail)
    {
        this.trainerApprovalMail = trainerApprovalMail;
    }
    
    public String getTrainerManagerApprovalMail()
    {
        return trainerManagerApprovalMail;
    }
    
    public void setTrainerManagerApprovalMail(String trainerManagerApprovalMail)
    {
        this.trainerManagerApprovalMail = trainerManagerApprovalMail;
    }
    
    public TrainingSchedule getTrainingSchedule()
    {
        return trainingSchedule;
    }
    
    public void setTrainingSchedule(TrainingSchedule trainingSchedule)
    {
        this.trainingSchedule = trainingSchedule;
    }
    
    public Employee getExecutive()
    {
        return executive;
    }
    
    public void setExecutive(Employee executive)
    {
        this.executive = executive;
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
