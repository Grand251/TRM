package trm.editors;

import java.beans.PropertyEditorSupport;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;

public class EmployeeEditor extends PropertyEditorSupport {

    private EmployeeCRUDService employeeCRUDService;

    public EmployeeEditor(EmployeeCRUDService employeeCRUDService){
        this.employeeCRUDService = employeeCRUDService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Employee employee = null;
        try {
            Integer id = Integer.parseInt(text);
            employee = employeeCRUDService.getEmployeeById(id);
            System.out.println("Employee name:" + employee.getFirst_name());
        } catch (NumberFormatException ex) {
            System.out.println("Employee will be null");
        }
        setValue(employee);
    }
}