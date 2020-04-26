package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderInterface;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("order")
public class OrderController {
	@Autowired
	OrderInterface oi;
	
	@Autowired
	OrderService os;
	
	@Autowired
	ProductService ps;
	
	@Autowired
	CustomerService cs;

	@RequestMapping(value = "/newOrder.html", method = RequestMethod.GET)
	public String addOrderGET(Model model) {
		Order order = new Order();
		ArrayList<Customer> customers = cs.getAllCustomers();
		ArrayList<Product> products = ps.getAllProducts();
		
		Map<Long, String> customersList = new HashMap<Long, String>();
		Map<Long, String> productsList = new HashMap<Long, String>();
		
		for(Customer c: customers) {
			customersList.put(c.getcId(), c.getcName());
		}
		
		for(Product p: products) {
			productsList.put(p.getpId(), p.getpDesc());
		}
		
		model.addAttribute("customers", customersList);
		model.addAttribute("products", productsList);	
		model.addAttribute("order", order);

		return "newOrder";
	}

	@RequestMapping(value = "/newOrder.html", method = RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("order") Order o, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			return "newOrder";
		}
		Product p = o.getProd();
		Customer c = o.getCust();
							
		if(p == null || c == null) {
			m.addAttribute("product", p);
			m.addAttribute("customer", c);
			m.addAttribute("order", o);
			
			return "deletionError";
		}
	
		int orderQty = o.getQty();
		int inStock = p.getQtyInStock();
		
		if(orderQty < inStock) {
			os.saveOrder(o);
			oi.updateDate(o.getoId());

			oi.updateProducts(o.getQty(), p.getpId());
			
			return "redirect:ListOrders.html";
		} else {
			m.addAttribute("product", p);
			m.addAttribute("customer", c);
			m.addAttribute("order", o);
			
			return "orderError";
		}

	}

	@RequestMapping(value = "/ListOrders.html", method = RequestMethod.GET)
	public String courseAddedGET(Model m) {
		ArrayList<Order> orders = os.getAllOrders();
		m.addAttribute("orders", orders);
		return "ListOrders";
	}

}
