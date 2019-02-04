package trm.editors;

import java.beans.PropertyEditorSupport;

import trm.dao.trainingrequest.TrainingRequest;
import trm.dao.trainingrequest.TrainingRequestCRUD;

public class TrainingRequestEditor extends PropertyEditorSupport {

    private TrainingRequestCRUD trainingRequestCRUD;

    public TrainingRequestEditor(TrainingRequestCRUD trainingRequestCRUD){
        this.trainingRequestCRUD = trainingRequestCRUD;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        TrainingRequest trainingRequest = null;
        try {
            Integer id = Integer.parseInt(text);
            trainingRequest = trainingRequestCRUD.getTrainingRequestById(id);
            System.out.println("Training Request ID:" + trainingRequest.getTrainingRequestId());
        } catch (NumberFormatException ex) {
            System.out.println("Training Request will be null");
        }
        setValue(trainingRequest);
    }
}