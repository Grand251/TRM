package trm.dao.vendordetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VendorDetails {
	
	/*
	 *  VENDOR_ID        NOT NULL NUMBER(5)    
		VENDOR_NAME      NOT NULL VARCHAR2(20) 
		VENDOR_PHONE     NOT NULL VARCHAR2(20) 
		VENDOR_EMAIL     NOT NULL VARCHAR2(40) 
		VENDOR_CITY      NOT NULL VARCHAR2(20) 
		VENDOR_STATE     NOT NULL VARCHAR2(10) 
		VENDOR_COUNTRY   NOT NULL VARCHAR2(10) 
		VENDOR_ZIPCODE   NOT NULL VARCHAR2(10) 
		VENDOR_TIME_ZONE NOT NULL VARCHAR2(10) 
	 * 
	 * 
	 */
	
	
	  @NotNull
	  private int vendor_id;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=20)
	  private String vendor_name;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=20)
	  private String vendor_phone;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=40)
	  @Email
	  private String vendor_email;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=20)
	  private String vendor_city;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=10)
	  private String vendor_state;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=10)
	  private String vendor_country;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=10)
	  private String vendor_zipcode;
	  
	  @NotNull
	  @NotBlank
	  @Size(max=10)
	  private String vendor_time_zone;
	  
	  
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVendor_phone() {
		return vendor_phone;
	}
	public void setVendor_phone(String vendor_phone) {
		this.vendor_phone = vendor_phone;
	}
	public String getVendor_email() {
		return vendor_email;
	}
	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}
	public String getVendor_city() {
		return vendor_city;
	}
	public void setVendor_city(String vendor_city) {
		this.vendor_city = vendor_city;
	}
	public String getVendor_state() {
		return vendor_state;
	}
	public void setVendor_state(String vendor_state) {
		this.vendor_state = vendor_state;
	}
	public String getVendor_country() {
		return vendor_country;
	}
	public void setVendor_country(String vendor_country) {
		this.vendor_country = vendor_country;
	}
	public String getVendor_zipcode() {
		return vendor_zipcode;
	}
	public void setVendor_zipcode(String vendor_zipcode) {
		this.vendor_zipcode = vendor_zipcode;
	}
	public String getVendor_time_zone() {
		return vendor_time_zone;
	}
	public void setVendor_time_zone(String vendor_time_zone) {
		this.vendor_time_zone = vendor_time_zone;
	}
}
