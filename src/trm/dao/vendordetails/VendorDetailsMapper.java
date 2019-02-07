package trm.dao.vendordetails;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorDetailsMapper implements RowMapper<VendorDetails>{

	@Override
	public VendorDetails mapRow(ResultSet result, int arg1) throws SQLException {
		VendorDetails vendorDetails = new VendorDetails();
		vendorDetails.setVendor_id(result.getInt(1));
		vendorDetails.setVendor_name(result.getString(2));
		vendorDetails.setVendor_phone(result.getString(3));
		vendorDetails.setVendor_email(result.getString(4));
		vendorDetails.setVendor_city(result.getString(5));
		vendorDetails.setVendor_state(result.getString(6));
		vendorDetails.setVendor_country (result.getString(7));
		vendorDetails.setVendor_zipcode (result.getString(8));
		vendorDetails.setVendor_time_zone (result.getString(9));
		return vendorDetails;
	}
}
