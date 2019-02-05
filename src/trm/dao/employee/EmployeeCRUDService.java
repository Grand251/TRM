package trm.dao.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import trm.dao.DAOJDBCTemplate;

import trm.dao.DAOJDBCTemplate;

/**
 * CRUD Service for employee
 * @author Kei Ng
 */
public class EmployeeCRUDService {
	private JdbcTemplate jtemp;
	


	/**
	 * Query: get all employee 
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployee(){
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		List<Employee> custlist = jtemp.query("Select * from employee order by 1", new EmployeeMapper());
		return custlist;
	}
	
	/**
	 * Query: get all employee by title
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployeeByTitle(String jobTitle)
	{
	    jtemp = DAOJDBCTemplate.getJdbcTemplate();
	    List<Employee> employeeList = jtemp.query("Select * from employee where job_title = ?", new Object[]{jobTitle}, new EmployeeMapper());
	    
	    return employeeList;
	}
	/**
	 * Query: Delete employee
	 * @param empid
	 * @return int(bollean)
	 */
	public int deleteEmployee(int empid) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("delete from employee where employee_id = ?", 
				new Object[] {empid});
		return ret;
	}
	
	/**
	 * Get employee by id
	 * @param employee_id
	 * @return Employee
	 */
	public Employee getEmployeeById(int employee_id) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		Employee employee = jtemp.queryForObject("Select * from employee where employee_id = ?",
									new Object[]{employee_id},
									new EmployeeMapper());
		return employee;
	}
	
	/**
	 * Query: update employee 
	 * @param employee_id
	 * @param last_name
	 * @param first_name
	 * @param user_name
	 * @param password
	 * @param phone_number
	 * @param email
	 * @param street
	 * @param city
	 * @param state
	 * @param country
	 * @param job_title
	 * @param vertical
	 * @param project
	 * @param pid
	 * @return int(bollean)
	 */
	public int updateEmployee( 
			 int employee_id,
			 String last_name,
			 String first_name,
			 String user_name,
			 String password,
			 String phone_number,
			 String email,
			 String street,
			 String city,
			 String state,
			 String country,
			 String job_title,
			 String vertical,
			 String project,
			 int pid){
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET last_name = ?, first_name = ?, user_name = ?, password = ?, phone_number = ?, email = ?, street = ?, city = ?, state = ?, country = ?, job_title = ?, vertical = ?, project = ?, pid = ? where employee_id = ?",
							new Object[] {last_name, first_name, user_name, password, 
									  	  phone_number, email, street, city, state, 
									  	  country, job_title, vertical, project, pid, employee_id});
		return ret;
	}
	

	/**
	 * Query: insert new employee
	 * @param employee
	 * @return int(boolean)
	 */
	public int insertCustomer(Employee employee) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
								new Object[] {employee.getEmployee_id(),
										employee.getLast_name(),
										employee.getFirst_name(),
										employee.getUser_name(),
										employee.getPassword(),
										employee.getPhone_number(),
										employee.getEmail(),
										employee.getStreet(),
										employee.getCity (),
										employee.getState(),
										employee.getCountry(),
										employee.getJob_title(),
										employee.getVertical(),
										employee.getProject(),
										employee.getPid()});
		return ret;
	}

	/**
	 * Update employee last name
	 * @param employee_id
	 * @param last_name
	 * @return int(boolean)
	 */
	public int updateEmployeeLastNameById(int employee_id, String last_name) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET last_name = ? where employee_id = ?",
							new Object[] {last_name, employee_id});
		return ret;
	}
	
	/**
	 * Update employee first name
	 * @param employee_id
	 * @param first_name
	 * @return int(boolean)
	 */
	public int updateEmployeeFirstNameById(int employee_id, String first_name) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET first_name = ? where employee_id = ?",
							new Object[] {first_name, employee_id});
		return ret;
	}
	
	/**
	 * Update employee user name
	 * @param employee_id
	 * @param user_name
	 * @return int(boolean)
	 */
	public int updateEmployeeUserNameById(int employee_id, String user_name) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET user_name = ? where employee_id = ?",
							new Object[] {user_name, employee_id});
		return ret;
	}
	
	/**
	 * Update employee password
	 * @param employee_id
	 * @param password
	 * @return int(boolean)
	 */
	public int updateEmployeePasswordById(int employee_id, String password) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET password = ? where employee_id = ?",
							new Object[] {password, employee_id});
		return ret;
	}
	
	/**
	 * Update employee phone number
	 * @param employee_id
	 * @param phone_number
	 * @return int(boolean)
	 */
	public int updateEmployeePhoneNumberById(int employee_id, String phone_number) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET phone_number = ? where employee_id = ?",
							new Object[] {phone_number, employee_id});
		return ret;
	}
	
	/**
	 * Update employee emile address
	 * @param employee_id
	 * @param email
	 * @return int(boolean)
	 */
	public int updateEmployeeEmailById(int employee_id, String email) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET email = ? where employee_id = ?",
							new Object[] {email, employee_id});
		return ret;
	}
	
	/**
	 * Update employee street
	 * @param employee_id
	 * @param street
	 * @return int(boolean)
	 */
	public int updateEmployeeAddressStreetById(int employee_id, String street) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET street = ? where employee_id = ?",
							new Object[] {street, employee_id});
		return ret;
	}
	
	/**
	 * Update employee city
	 * @param employee_id
	 * @param city
	 * @return int(boolean)
	 */
	public int updateEmployeeAddressCityById(int employee_id, String city) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET city = ? where employee_id = ?",
							new Object[] {city, employee_id});
		return ret;
	}
	
	/**
	 * Update employee state
	 * @param employee_id
	 * @param state
	 * @return int(boolean)
	 */
	public int updateEmployeeAddressStateById(int employee_id, String state) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET state = ? where employee_id = ?",
							new Object[] {state, employee_id});
		return ret;
	}
	
	/**
	 * Update employee country
	 * @param employee_id
	 * @param country
	 * @return int(boolean)
	 */
	public int updateEmployeeAddressCountryById(int employee_id, String country) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET country = ? where employee_id = ?",
							new Object[] {country, employee_id});
		return ret;
	}
	
	/**
	 * Update employee job title
	 * @param employee_id
	 * @param job_title
	 * @return int(boolean)
	 */
	public int updateEmployeeJobTitleById(int employee_id, String job_title) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET job_title = ? where employee_id = ?",
							new Object[] {job_title, employee_id});
		return ret;
	}
	
	/**
	 * Update employee vertical name
	 * @param employee_id
	 * @param vertical
	 * @return int(boolean)
	 */
	public int updateEmployeeVerticalById(int employee_id, String vertical) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET vertical = ? where employee_id = ?",
							new Object[] {vertical, employee_id});
		return ret;
	}
	
	/**
	 * Update employee project name
	 * @param employee_id
	 * @param project
	 * @return int(boolean)
	 */
	public int updateEmployeeProjectNameById(int employee_id, String project) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET project = ? where employee_id = ?",
							new Object[] {project, employee_id});
		return ret;
	}
	
	/**
	 * Update employee project id
	 * @param employee_id
	 * @param pid
	 * @return int(boolean)
	 */
	public int updateEmployeeProjectIdById(int employee_id, int pid) {
		jtemp = DAOJDBCTemplate.getJdbcTemplate();
		int ret = jtemp.update("UPDATE employee SET pid = ? where employee_id = ?",
							new Object[] {pid, employee_id});
		return ret;
	}
	
	
	public static void main(String[] args) {
	    	/*
		System.out.println("hello");
	//	int i = new EmployeeCRUDService().updateEmployee(1111111, "Moran", "Inaaya", "IM1111111", "123", "7759294432","Inaaya_Moran@syntelinc.com","122 St",
    //            "Boston", "MA", "US","SPOC", "BNFS","spoc", 12345);
		new EmployeeCRUDService().updateEmployeeLastNameById(1212121, "MON");
		new EmployeeCRUDService().updateEmployeeFirstNameById(1212121, "first");
		new EmployeeCRUDService().updateEmployeeUserNameById(1212121, "user");
		new EmployeeCRUDService().updateEmployeePasswordById(1212121, "pd");
		new EmployeeCRUDService().updateEmployeePhoneNumberById(1212121, "phone");
		new EmployeeCRUDService().updateEmployeeEmailById(1212121, "email");
		new EmployeeCRUDService().updateEmployeeAddressStreetById(1212121, "st");
		new EmployeeCRUDService().updateEmployeeAddressCityById(1212121, "city");
		new EmployeeCRUDService().updateEmployeeAddressStateById(1212121, "state");
		new EmployeeCRUDService().updateEmployeeAddressCountryById(1212121, "country");
		new EmployeeCRUDService().updateEmployeeJobTitleById(1212121, "title");
		new EmployeeCRUDService().updateEmployeeVerticalById(1212121, "ver");
		new EmployeeCRUDService().updateEmployeeProjectNameById(1212121, "PNAme");
		new EmployeeCRUDService().updateEmployeeProjectIdById(1212121, 12);
		int i = new EmployeeCRUDService().updateEmployee(1111111, "Moran", "Inaaya", "IM1111111", "123", "7759294432","Inaaya_Moran@syntelinc.com","122 St",
                "Boston", "MA", "US","SPOC", "BNFS","spoc", 12345);
		System.out.println(i);
		*/

	}
	
}
