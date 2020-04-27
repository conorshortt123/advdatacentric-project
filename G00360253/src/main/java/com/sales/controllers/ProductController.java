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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {
	@Autowired
	ProductService ps;

	// Gets add product page from server.
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.GET)
	public String addProductGET(Model model) {

		Product p = new Product();
		model.addAttribute("product", p);

		return "addProduct";
	}

	// Retrieves data entered into form and injects it into the product object.
	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		
		// Prints invalid input errors.
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		// Saves product to the database and returns list products page.
		ps.saveProduct(p);
		return "redirect:ListProducts.html";
	}

	// Gets all products from the database and puts them into an ArrayList, and lists them on JSP page.
	@RequestMapping(value = "/ListProducts.html", method = RequestMethod.GET)
	public String courseAddedGET(Model m) {
		ArrayList<Product> products = ps.getAllProducts();
		m.addAttribute("products", products);
		return "ListProducts";
	}

}
