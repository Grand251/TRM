package trm.dao.internaltrainer;

import trm.dao.employee.Employee;
/*
 * CREATE TABLE INTERNAL_TRAINER
(
  it_trainer_id number(7) references employee(employee_id) unique not null,
  profile_file_path varchar(100),
  trainer_location varchar(20)
);
 * 
 */

public class InternalTrainer {
	private Employee trainer;
	private String profileFilePath;
	private String trainerLocation;
	
	public void displayDetails() {
		System.out.println(trainer.getEmployee_id() + " " + getProfileFilePath() + " " + getTrainerLocation());
	}
	
	public Employee getTrainer() {
		return trainer;
	}
	public void setTrainer(Employee trainer) {
		this.trainer = trainer;
	}
	public String getProfileFilePath() {
		return profileFilePath;
	}
	public void setProfileFilePath(String profileFilePath) {
		this.profileFilePath = profileFilePath;
	}
	public String getTrainerLocation() {
		return trainerLocation;
	}
	public void setTrainerLocation(String trainerLocation) {
		this.trainerLocation = trainerLocation;
	}
}
