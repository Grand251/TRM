package trm.dao.trainingparticipant;

import trm.dao.employee.Employee;
import trm.dao.trainingrequest.TrainingRequest;

public class TrainingParticipant
{
    private int trainingParticipantId;
    private Employee participantEmployee;
    private TrainingRequest trainingSessionAttended;
    
    public Employee getParticipantEmployee()
    {
        return participantEmployee;
    }
    public void setParticipantEmployee(Employee participantEmployeeId)
    {
        this.participantEmployee = participantEmployeeId;
    }
    public TrainingRequest getTrainingSessionAttended()
    {
        return trainingSessionAttended;
    }
    public void setTrainingSessionAttended(TrainingRequest trainingSessionAttended)
    {
        this.trainingSessionAttended = trainingSessionAttended;
    }
    public int getTrainingParticipantId()
    {
        return trainingParticipantId;
    }
    public void setTrainingParticipantId(int trainingParticipantId)
    {
        this.trainingParticipantId = trainingParticipantId;
    }
}
