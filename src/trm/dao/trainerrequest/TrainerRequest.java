package trm.dao.trainerrequest;

import java.sql.Timestamp;

import trm.dao.employee.Employee;
import trm.dao.trainingschedule.TrainingSchedule;

public class TrainerRequest
{
    private int trainerRequestId;
    private Timestamp requestSentDate;
    private Employee trainer;
    private TrainingSchedule trainingSchedule;
    private String topic;
    private String comments;
    private String response;
    private int activeStatus;
    
    public int getTrainerRequestId()
    {
        return trainerRequestId;
    }
    public void setTrainerRequestId(int trainerRequestId)
    {
        this.trainerRequestId = trainerRequestId;
    }
    public Timestamp getRequestSentDate()
    {
        return requestSentDate;
    }
    public void setRequestSentDate(Timestamp requestSentDate)
    {
        this.requestSentDate = requestSentDate;
    }
    public Employee getTrainer()
    {
        return trainer;
    }
    public void setTrainer(Employee trainer)
    {
        this.trainer = trainer;
    }
    public TrainingSchedule getTrainingSchedule()
    {
        return trainingSchedule;
    }
    public void setTrainingSchedule(TrainingSchedule trainingSchedule)
    {
        this.trainingSchedule = trainingSchedule;
    }
    public String getTopic()
    {
        return topic;
    }
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    public String getComments()
    {
        return comments;
    }
    public void setComments(String comments)
    {
        this.comments = comments;
    }
    public String getResponse()
    {
        return response;
    }
    public void setResponse(String response)
    {
        this.response = response;
    }
    public int getActiveStatus()
    {
        return activeStatus;
    }
    public void setActiveStatus(int activeStatus)
    {
        this.activeStatus = activeStatus;
    }
}
