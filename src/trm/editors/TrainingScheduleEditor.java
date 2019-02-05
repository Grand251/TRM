package trm.editors;

import java.beans.PropertyEditorSupport;


import trm.dao.trainingschedule.TrainingSchedule;
import trm.dao.trainingschedule.TrainingScheduleCRUDService;

public class TrainingScheduleEditor extends PropertyEditorSupport {

    private TrainingScheduleCRUDService trainingScheduleCRUDService;

    public TrainingScheduleEditor(TrainingScheduleCRUDService trainingScheduleCRUDService){
        this.trainingScheduleCRUDService = trainingScheduleCRUDService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        TrainingSchedule trainingSchedule = null;
        try {
            String id = text;
            trainingSchedule = trainingScheduleCRUDService.getTrainingScheduleById(id);
            System.out.println("Training Schedule ID:" + trainingSchedule.getTraining_schedule_id());
        } catch (NumberFormatException ex) {
            System.out.println("Training Schedule will be null");
        }
        setValue(trainingSchedule);
    }
}