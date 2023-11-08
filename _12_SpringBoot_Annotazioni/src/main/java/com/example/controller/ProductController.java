package com.example.controller;


import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.ProductForm;
import com.example.model.Product;
import com.example.service.ProductService;



@Controller
public class ProductController {


	
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/input-product"})
    public String inputProduct() {
        logger.info("inputProduct called");
        return "ProductForm";
    }

    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
        logger.info("saveProduct called");
        // no need to create and instantiate a ProductForm
        // create Product
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
            product.setPrice(new BigDecimal(productForm.getPrice()));
        	} 
        	catch (NumberFormatException e) {
        		//docatch
        }
        // add product
        Product savedProduct = productService.add(product);
        redirectAttributes.addFlashAttribute("message", "The product was successfully added.");
        return "redirect:/view-product/" + savedProduct.getId();
    }

    @RequestMapping(value = "/view-product/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        
    	Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductView";
    }
    
    //se usassimo in alternativa un Request Parameter
    //testare con http://localhost:8080/Cap4_annotated2/view-product/?id=1
    @RequestMapping(value = "/view-product/")
    public String viewProductRequestParameter(@RequestParam Long id, Model model) {
    	Product product = productService.get(id);
        model.addAttribute("product", product);
        return "ProductView";
    }
}
