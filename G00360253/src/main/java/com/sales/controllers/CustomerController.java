package com.sales.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	// Retrieves the addCustomer page for the user if they request the URL "addCustomer.html".
	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.GET)
	public String addCustomerGET(Model model) {

		Customer c = new Customer();
		model.addAttribute("customer", c);

		return "addCustomer";
	}

	// Posts to the addCustomer page using the form input. Data is injected into the Customer object
	// And passed to the database using the service > repository model. Errors are displayed if forms are
	// left empty.
	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.POST)
	public String addCustomerPOST(@Valid @ModelAttribute("customer") Customer c, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addCustomer";
		}
		
		cs.saveCustomer(c);
		return "redirect:ListCustomers.html";
	}
	
	// Retrieves all customers from the database and displays them on the jsp page.
	@RequestMapping(value = "/ListCustomers.html", method = RequestMethod.GET)
	public String customerAddedGET(Model m) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		m.addAttribute("customers", customers);
		return "ListCustomers";
	}

}
