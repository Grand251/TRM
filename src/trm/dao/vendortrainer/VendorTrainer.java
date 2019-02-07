package trm.dao.vendortrainer;

/**
 * This is the vendor
 * @author Kei Ng
 *
 */
public class VendorTrainer {
	private int vendor_trainer_id; 
	private String vendor_trainer_name;
	private String phone;
	private String email;
	private String profile;
	private String evaulation_status;
	private String vendor_trainer_log;
	public int getVendor_trainer_id() {
		return vendor_trainer_id;
	}
	public void setVendor_trainer_id(int vendor_trainer_id) {
		this.vendor_trainer_id = vendor_trainer_id;
	}
	public String getVendor_trainer_name() {
		return vendor_trainer_name;
	}
	public void setVendor_trainer_name(String vendor_trainer_name) {
		this.vendor_trainer_name = vendor_trainer_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getEvaulation_status() {
		return evaulation_status;
	}
	public void setEvaulation_status(String evaulation_status) {
		this.evaulation_status = evaulation_status;
	}
	public String getVendor_trainer_log() {
		return vendor_trainer_log;
	}
	public void setVendor_trainer_log(String vendor_trainer_log) {
		this.vendor_trainer_log = vendor_trainer_log;
	}
}
