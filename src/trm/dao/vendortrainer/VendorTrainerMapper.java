package trm.dao.vendortrainer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This is vendor mapper
 * @author Kei Ng
 *
 */
public class VendorTrainerMapper implements RowMapper<VendorTrainer> {

	@Override
	public VendorTrainer mapRow(ResultSet result, int arg1) throws SQLException {
		VendorTrainer vendorTrainer = new VendorTrainer();
		vendorTrainer.setVendor_trainer_id(result.getInt(1));
		vendorTrainer.setVendor_trainer_name(result.getString(2));
		vendorTrainer.setPhone(result.getString(3));
		vendorTrainer.setEmail(result.getString(4));
		vendorTrainer.setProfile(result.getString(5));
		vendorTrainer.setEvaluation_status(result.getString(6));
		vendorTrainer.setVendor_trainer_log(result.getString(7));
		return vendorTrainer;
	}

}
