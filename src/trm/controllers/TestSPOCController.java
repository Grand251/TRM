package trm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestSPOCController {
<<<<<<< HEAD
//	//Initial Page (root directory)
=======
	//Initial Page (root directory)
>>>>>>> 45d65e0c5178b6a14324ec90988d8aff18420b92
//	@RequestMapping(value="/")
//	public String test()
//	{
//		return "SPOCForm";
//	}	
<<<<<<< HEAD
//	//function that will take data for SPOC and store it into object with DAO
//	//currently simply returns the same view
//	@RequestMapping(value="SPOCInputData")
//	public String spocInputData()
//	{
//		//insert into dataBase
//		//int ret = new CustomerCRUDService().updateCustomer(customer.getCustId(), customer.getCustCity(), customer.getCustPhone());
//		
//		return "SPOCForm";
//	}
=======
	//function that will take data for SPOC and store it into object with DAO
	//currently simply returns the same view
	@RequestMapping(value="SPOCInputData")
	public String spocInputData()
	{
		//insert into dataBase
		//int ret = new CustomerCRUDService().updateCustomer(customer.getCustId(), customer.getCustCity(), customer.getCustPhone());
		
		return "SPOCForm";
	}
>>>>>>> 45d65e0c5178b6a14324ec90988d8aff18420b92
	
}