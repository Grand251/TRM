package trm.dao.employee;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
//import trm.dao.DAOJDBCTemplate;

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


	public static void main(String[] args) {
	    	/*
		System.out.println("hello");
		int i = new EmployeeCRUDService().updateEmployee(1111111, "Moran", "Inaaya", "IM1111111", "123", "7759294432","Inaaya_Moran@syntelinc.com","122 St",
                "Boston", "MA", "US","SPOC", "BNFS","spoc", 12345);
		System.out.println(i);
		*/
	    
	    	List<Employee> spocList = new EmployeeCRUDService().getAllEmployeeByTitle("SPOC");
	    	
	    	for(Employee spoc:spocList)
	    	{
	    	    System.out.println(spoc.getEmployee_id());
	    	}
	}
	
}
