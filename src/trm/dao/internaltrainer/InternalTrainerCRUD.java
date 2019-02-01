package trm.dao.internaltrainer;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dao.DAOJDBCTemplate;


/*
 * CREATE TABLE INTERNAL_TRAINER
(
  it_trainer_id number(7) references employee(employee_id) unique not null,
  profile_file_path varchar(100),
  trainer_location varchar(20)
);
 * 
 */

public class InternalTrainerCRUD {
	/*
	 * Get List (ArrayList) of an InternalTrainer object for all internal trainers in database.
	 */
	public List<InternalTrainer> getAllInternalTrainers(){
		return DAOJDBCTemplate.getJdbcTemplate().query("SELECT * FROM internal_trainer", new InternalTrainerMapper());
	}
	
	/*
	 *  Get InternalTrainer object with target object's employee id.
	 *  
	 *  @param trainerId Target trainer's employee id.
	 */
	public InternalTrainer getInternalTrainerById(int trainerId){
		return DAOJDBCTemplate.getJdbcTemplate().queryForObject("SELECT * FROM internal_trainer "
				+ "WHERE it_trainer_id=?", new Object[] {trainerId}, new InternalTrainerMapper());
	}
	
	/*
	 * Insert internal trainer using InternalTrainer object. Trainer ID value is required 
	 * and no more than 7 digits. ProfileFilePath may be a maximum of 100 characters and 
	 * trainerLocation may be a maximum of 20 characters.
	 * 
	 * @param trainer Trainer object containing details to be updated. 
	 */
	public int insertInternalTrainer(InternalTrainer trainer) {
		return DAOJDBCTemplate.getJdbcTemplate().update("INSERT INTO internal_trainer VALUES(?, ?, ?)",
				new Object[]{trainer.getTrainer().getEmployee_id(), trainer.getProfileFilePath(),
						  trainer.getTrainerLocation()});
	}
		
	/*
	 * Update internal trainer using trainer object. Trainer ID may not be updated.
	 * ProfileFilePath may be a maximum of 100 characters and trainerLocation may be 
	 * a maximum of 20 characters.
	 * 
	 * @param trainer Trainer object which must contain Employee with 
	 */
	public int updateInternalTrainer(InternalTrainer trainer) {
		return DAOJDBCTemplate.getJdbcTemplate().update("UPDATE internal_trainer SET profile_file_path=?, "
										+ "trainer_location=? WHERE it_trainer_id= ?",
				new Object[]{trainer.getProfileFilePath(),
						  trainer.getTrainerLocation(), trainer.getTrainer().getEmployee_id()});
	}
	
	/*
	 * Delete internal trainer from table using trainer object.
	 * 
	 * @param trainer InternalTrainer object containing Employee object 
	 * 				  containing target records trainer ID.
	 */
	public int deleteInternalTrainer(InternalTrainer trainer) {
		return deleteInternalTrainer(trainer.getTrainer().getEmployee_id());
	}
	
	/*
	 * Delete internal trainer from table using the trainer's ID.
	 * 
	 * @param trainerId Unique trainer ID of 7 digits or less
	 */
	public int deleteInternalTrainer(int trainerId) {
		return DAOJDBCTemplate.getJdbcTemplate().update("DELETE FROM internal_trainer"
				+ " WHERE it_trainer_id=?",
				new Object[] {trainerId});
	}
	
	
/*
 * 
 * TEST SCRIPT
 *
 *	 public static void main(String[] args) {
	InternalTrainerCRUD iCRUD = new InternalTrainerCRUD();
	System.out.println(iCRUD.getAllInternalTrainers());
	System.out.println(iCRUD.getInternalTrainerById(1000000));
	InternalTrainer trainer = new InternalTrainer();
	Employee emp = new Employee();
	emp.setEmployee_id(1000010);
	trainer.setTrainer(emp);
	trainer.setProfileFilePath("Path/Profile");
	trainer.setTrainerLocation("Washington");
	
	iCRUD.deleteInternalTrainer(trainer);
	iCRUD.insertInternalTrainer(trainer);
	iCRUD.deleteInternalTrainer(1000010);
	iCRUD.insertInternalTrainer(trainer);
	trainer.setProfileFilePath("Path/NewPath");
	trainer.setTrainerLocation("Oregon");
	iCRUD.updateInternalTrainer(trainer);
	
	}*/
	 
}
