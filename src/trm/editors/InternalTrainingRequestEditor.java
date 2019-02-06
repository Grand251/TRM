package trm.editors;

import java.beans.PropertyEditorSupport;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;
import trm.dao.internaltrainingrequest.InternalTrainingCRUD;
import trm.dao.internaltrainingrequest.InternalTrainingRequest;

public class InternalTrainingRequestEditor extends PropertyEditorSupport {

    private InternalTrainingCRUD internalTrainingCRUD;

    public InternalTrainingRequestEditor(InternalTrainingCRUD internalTrainingCRUD){
        this.internalTrainingCRUD = internalTrainingCRUD;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        InternalTrainingRequest internalTrainingRequest = null;
        try {
            Integer id = Integer.parseInt(text);
            internalTrainingRequest = internalTrainingCRUD.getItrById(id);
            System.out.println("Internal Training Request ID:" + internalTrainingRequest.getItrId());
        } catch (NumberFormatException ex) {
            System.out.println("Internal Training Request will be null");
        }
        setValue(internalTrainingRequest);
    }
}