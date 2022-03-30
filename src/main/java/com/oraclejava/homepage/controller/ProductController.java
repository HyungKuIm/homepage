package com.oraclejava.homepage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.homepage.dto.Product;
import com.oraclejava.homepage.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    String list(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("list", list);
        return "product/list";
    }

    @GetMapping("/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Integer id, HttpServletResponse response, Optional<Product> product)
			throws ServletException, IOException {
		logger.info("Id :: " + id);
		product = productService.getProductById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(product.get().getImage());
		response.getOutputStream().close();
	}


}
