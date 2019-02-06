package trm.dao.vendordetails;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;
import trm.dao.vendortrainer.VendorTrainer;
import trm.dao.vendortrainer.VendorTrainerCRUDService;

public class VendorDetailsCRUDService {
	private JdbcTemplate jtemp;
	
	public static void main(String[] args) {
		//int i = new VendorDetailsCRUDService().updateVendorDetails(32141, "aa","1234", "mail", "b", "b", "b","b","b");
				VendorDetails vendorDetails = new VendorDetails();
				vendorDetails.setVendor_id(32141);
				vendorDetails.setVendor_name("a");
				vendorDetails.setVendor_phone("a");
				vendorDetails.setVendor_email("a");
				vendorDetails.setVendor_city("a");
				vendorDetails.setVendor_state("a");
				vendorDetails.setVendor_country ("a");
				vendorDetails.setVendor_zipcode ("a");
				vendorDetails.setVendor_time_zone ("a");
				//int i = new VendorDetailsCRUDService().insertVendorDetails(vendorDetails);

				//List<VendorDetails> v = new VendorDetailsCRUDService().getAllVendorDetails();
				VendorDetails vt = new VendorDetailsCRUDService().getVendorDetailsById(32141);
				System.out.println(vt);
	}
	
	public List<VendorDetails> getAllVendorDetails(){
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		List<VendorDetails> custlist = jtemp.query("Select * from vendor_Details order by 1", new VendorDetailsMapper());
		return custlist;
	}
	

	public int deleteVendorDetails(int vendor_trainer_id) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("delete from vendor_Details where vendor_id = ?", 
				new Object[] {vendor_trainer_id});
		return ret;
	}
	

	public VendorDetails getVendorDetailsById(int vendor_id) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		VendorDetails vendor = jtemp.queryForObject("Select * from vendor_details where vendor_id = ?",
									new Object[]{vendor_id},
									new VendorDetailsMapper());
		return vendor;
	}
	
	public int updateVendorDetails(
			 int vendor_id, 
			 String vendor_name,
			 String vendor_phone,
			 String vendor_email,
			 String vendor_city,
			 String vendor_state,
			 String vendor_country,
			 String vendor_zipcode,
			 String vendor_time_zone) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("UPDATE vendor_Details SET vendor_name= ?, vendor_phone= ?, vendor_email= ?, vendor_city= ?, vendor_state= ?, vendor_country= ?, vendor_zipcode =?, vendor_time_zone =? where vendor_id= ?",
							new Object[] {  
									  vendor_name, 
									  vendor_phone,
									  vendor_email, 
									  vendor_city, 
									  vendor_state, 
									  vendor_country, 
									  vendor_zipcode,
									  vendor_time_zone,
									  vendor_id});
		return ret;
	}
	
	public int insertVendorDetails(VendorDetails vendorDetails) {
		jtemp = new DAOJDBCTemplate().getJdbcTemplate();
		int ret = jtemp.update("insert into vendor_Details values (?, ?, ?, ?, ?, ?, ?,?,?)",
								new Object[] {vendorDetails.getVendor_id(),
										vendorDetails.getVendor_name(),
										vendorDetails.getVendor_phone(),
										vendorDetails.getVendor_email(),
										vendorDetails.getVendor_city(),
										vendorDetails.getVendor_state(),
										vendorDetails.getVendor_country(),
										vendorDetails.getVendor_zipcode(),
										vendorDetails.getVendor_time_zone()
										});
		return ret;
	}
}
