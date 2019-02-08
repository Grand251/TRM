package trm.dao.vendortrainer;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.employee.Employee;
import trm.dao.employee.EmployeeMapper;

/**
 * CRUD Service for vendor trainer
 * @author Kei Ng
 *
 */
public class VendorTrainerCRUDService {
	private JdbcTemplate jtemp;
	
	public static void main(String s[])
	{
		System.out.println("----------------");
		VendorTrainer vt = new VendorTrainer();
		vt.setVendor_trainer_name("Q1");
		vt.setPhone("1235");
		vt.setEmail("Q1");
		
		vt.setProfile("pro");
		vt.setEvaluation_status("true");
		vt.setVendor_trainer_log("log");
		int i = new VendorTrainerCRUDService().insertVendorTrainer(vt);
		System.out.println(i);
	}
	
	
	public List<VendorTrainer> getAllVendorTrainer(){
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		List<VendorTrainer> custlist = jtemp.query("Select * from vendor_trainer order by 1", new VendorTrainerMapper());
		return custlist;
	}
	
	/**
	 * Query: Delete vendor trainer
	 * @param vendor_id
	 * @return int(bollean)
	 */
	public int deleteVendorTrainer(int vendor_trainer_id) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("delete from vendor_trainer where vendor_trainer_id = ?", 
				new Object[] {vendor_trainer_id});
		return ret;
	}
	
	/**
	 * Get vendor by id
	 * @param vendor_id
	 * @return Vendor
	 */
	public VendorTrainer getVendorTrainerById(int vendor_trainer_id) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		VendorTrainer vendorTrainer = jtemp.queryForObject("Select * from vendor_trainer where vendor_trainer_id = ?",
									new Object[]{vendor_trainer_id},
									new VendorTrainerMapper());
		return vendorTrainer;
	}
	
	public int updateVendorTrainer(
			 int vendor_trainer_id, 
			 String vendor_trainer_name,
			 String phone,
			 String email,
			 String profile,
			 String evaluation_status,
			 String vendor_trainer_log) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE vendor_trainer SET vendor_trainer_name= ?, phone= ?, email= ?, profile= ?, evaulation_status= ?, vendor_trainer_log= ? where vendor_trainer_id= ?",
							new Object[] { vendor_trainer_name,
										  phone,
										  email,
										  profile,
										  evaluation_status,
										  vendor_trainer_log,
										  vendor_trainer_id});
		return ret;
	}
	
	public int insertVendorTrainer(VendorTrainer vendorTrainer) {
		System.out.println(vendorTrainer.getVendor_trainer_id()+"------------------------");
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("insert into vendor_trainer values (vendor_trainer_id_seq.nextval, ?, ?, ?, ?, ?, ?)",
								new Object[] {
										vendorTrainer.getVendor_trainer_name(),
										vendorTrainer.getPhone(),
										vendorTrainer.getEmail(),
										vendorTrainer.getProfile(),
										vendorTrainer.getEvaluation_status(),
										vendorTrainer.getVendor_trainer_log()
										});
		return ret;
	}
	
	
	
}
