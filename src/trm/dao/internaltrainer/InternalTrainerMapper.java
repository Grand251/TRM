package trm.dao.internaltrainer;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeCRUDService;

public class InternalTrainerMapper implements RowMapper<InternalTrainer>{

	@Override
	public InternalTrainer mapRow(ResultSet rs, int rowNum) throws SQLException {
		InternalTrainer it = new InternalTrainer();
		Employee trainer = new EmployeeCRUDService().getEmployeeById(rs.getInt(1));
		it.setTrainer(trainer);
		it.setProfileFilePath(rs.getString(2));
		it.setTrainerLocation(rs.getString(3));
		return it;
	}

}
