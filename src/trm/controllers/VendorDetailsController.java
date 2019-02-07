package trm.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dao.vendordetails.VendorDetails;
import trm.dao.vendordetails.VendorDetailsCRUDService;


@Controller
public class VendorDetailsController {
	//Vendor Details
			@RequestMapping (value = "showallVendorDetails")
			public String allEmployee(ModelMap map) {
				List<VendorDetails> allVendors = new VendorDetailsCRUDService().getAllVendorDetails();
				map.addAttribute("allVendors", allVendors);
				return "allVendorDetails";
			}
			
			@RequestMapping(value = "deleteVendorDetails/{vendor_id}")
			public String deleteEmployee(@PathVariable("vendor_id") int vendor_id, ModelMap map) {
				int ret = new VendorDetailsCRUDService().deleteVendorDetails(vendor_id);
				if(ret > 0) return "redirect:/showallVendorDetails";
				else return "error";
			}
			
			
			@RequestMapping(value = "editVendorDetails/{vendor_id}")
			public String createVendorDetailsObject(@PathVariable("vendor_id") int vendor_id, ModelMap map) {
				VendorDetails vendorDetails = new VendorDetailsCRUDService().getVendorDetailsById(vendor_id);
				map.addAttribute("command", vendorDetails);
				return "editVendorDetailsForm";
			}
			
			@RequestMapping(value = "saveUpdateVendorDetailsData")
			public String editVendorDetails(@ModelAttribute("vendorDetails") VendorDetails vendorDetails) {
				int ret = new VendorDetailsCRUDService().updateVendorDetails(
						vendorDetails.getVendor_id(),
						vendorDetails.getVendor_name(),
						vendorDetails.getVendor_phone(),
						vendorDetails.getVendor_email(),
						vendorDetails.getVendor_city(),
						vendorDetails.getVendor_state(),
						vendorDetails.getVendor_country(),
						vendorDetails.getVendor_zipcode(),
						vendorDetails.getVendor_time_zone());
				if(ret > 0) return "redirect:/showallVendorDetails";
				else return "error";
			}
			
			
			@RequestMapping(value = "insertVendorDetailsForm")
			public String insertVendorDetailsObject(ModelMap map) {
				VendorDetails vendorDetails = new VendorDetails();
				map.addAttribute("command", vendorDetails);
				return "newVendorDetailsForm";	
			}
			
			@RequestMapping(value = "insertVendorDetails")
			public String insertVendorDetails(@Valid @ModelAttribute("vendorDetails") VendorDetails vendorDetails, ModelMap model, BindingResult result) {
				System.out.println(result);
				for(FieldError error : result.getFieldErrors()) {
					System.out.println(error.getField());
					System.out.println(error.getRejectedValue());
					System.out.println(error.getDefaultMessage());
				}
				
				if(result.equals(null)) {
					ArrayList<LinkedHashMap<String, String>> errorReport = new ArrayList<LinkedHashMap<String, String>>();
					for(FieldError error : result.getFieldErrors()) {
						LinkedHashMap<String, String> errorValues = new LinkedHashMap<String, String>();
						errorValues.put("Field: ", error.getField());
						errorValues.put("Rejected Value: ", error.getRejectedValue().toString());
						errorValues.put("Error: ", error.getDefaultMessage());
						errorReport.add(errorValues);
					}
					model.addAttribute(errorReport);
					return "redirect:/insertVendorDetailsForm";
				}
				
				int ret = new VendorDetailsCRUDService().insertVendorDetails(vendorDetails);
				if(ret > 0) return "redirect:/showallVendorDetails";
				else return "error";
			}
}
