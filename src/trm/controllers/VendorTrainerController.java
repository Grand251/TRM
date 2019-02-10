package trm.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.vendortrainer.VendorTrainer;
import trm.dao.vendortrainer.VendorTrainerCRUDService;

@Controller
public class VendorTrainerController {
	//Vendor Trainer
		@RequestMapping (value = "showallVendorTrainers")
		public String allEmployee(ModelMap map) {
			List<VendorTrainer> vendorTrainers = new VendorTrainerCRUDService().getAllVendorTrainer();
			map.addAttribute("vendorTrainers", vendorTrainers);
			return "allVendorTrainers";
		}
		
		@RequestMapping(value = "deleteVendorTrainer/{vendor_trainer_id}")
		public String deleteEmployee(@PathVariable("vendor_trainer_id") int vendor_trainer_id, ModelMap map) {
			int ret = new VendorTrainerCRUDService().deleteVendorTrainer(vendor_trainer_id);
			if(ret > 0) return "redirect:/showallVendorTrainers";
			else return "error";
		}
		
		
		@RequestMapping(value = "editVendorTrainer/{vendor_trainer_id}")
		public String createVendorTrainerObject(@PathVariable("vendor_trainer_id") int vendor_trainer_id, ModelMap map) {
			VendorTrainer vendorTrainer = new VendorTrainerCRUDService().getVendorTrainerById(vendor_trainer_id);
			map.addAttribute("command", vendorTrainer);
			return "editVendorTrainerForm";
		}
		
		@RequestMapping(value = "saveUpdateVendorTrainerData")
		public String editVendorTrainer(@ModelAttribute("vendorTrainer") VendorTrainer vendorTrainer) {
			int ret = new VendorTrainerCRUDService().updateVendorTrainer(
					vendorTrainer.getVendor_trainer_id(),
					vendorTrainer.getVendor_trainer_name(),
					vendorTrainer.getPhone(),
					vendorTrainer.getEmail(),
					vendorTrainer.getProfile(),
					vendorTrainer.getEvaluation_status(),
					vendorTrainer.getVendor_trainer_log());
			if(ret > 0) return "redirect:/showallVendorTrainers";
			else return "error";
		}
		
		
		@RequestMapping(value = "insertVendorTrainerForm")
		public String insertVendorTrainerObject(ModelMap map) {
			VendorTrainer vendorTrainer = new VendorTrainer();
			map.addAttribute("command", vendorTrainer);
			return "newVendorTrainerForm";	
		}
		
		@RequestMapping(value = "insertVendorTrainer")
		public String insertVendorTrainer(@ModelAttribute("vendorTrainer") VendorTrainer vendorTrainer) {
			System.out.println(vendorTrainer.getVendor_trainer_id() + "-------------------------*");
			int ret = new VendorTrainerCRUDService().insertVendorTrainer(vendorTrainer);
			if(ret > 0) return "redirect:/showallVendorTrainers";
			else return "error";
		}
		
}
