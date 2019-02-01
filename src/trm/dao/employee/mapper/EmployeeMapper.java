package dao.employee.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.employee.*;
/**
 * This is Employee mapper class
 * @author kei Ng
 *
 */
public class EmployeeMapper implements RowMapper<Employee>{
	/**
	 * use RowMapper interface
	 * @param ResultSet
	 * @param arg
	 * @return Employee
	 */
	@Override
	public Employee mapRow(ResultSet result, int arg) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployee_id(result.getInt(1));
		emp.setLast_name(result.getString(2));
		emp.setFirst_name(result.getString(3));
		emp.setUser_name(result.getString(4));
		emp.setPassword(result.getString(5));
		emp.setPhone_number(result.getString(6));
		emp.setEmail(result.getString(7));
		emp.setStreet(result.getString(8));
		emp.setCity (result.getString(9));
		emp.setState(result.getString(10));
		emp.setCountry(result.getString(11));
		emp.setJob_title(result.getString(12));
		emp.setVertical(result.getString(13));
		emp.setProject(result.getString(14));
		emp.setPid(result.getInt(15));
		return emp;
	}

}
