package com.oraclejava.homepage.controller;

import java.io.IOException;
import java.time.LocalDateTime;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    ProductService productService;

    @GetMapping("/add")
    String addProduct(@ModelAttribute ProductBean productBean) {
        return "product/add";
    }

    @PostMapping("/saveProduct")
    String saveProduct(@Validated @ModelAttribute ProductBean productBean,
                    BindingResult bindingResult) throws IOException {
        logger.info("saveProduct");

        if (bindingResult.hasErrors()) {
            return addProduct(productBean);
        }

        Product product = new Product();
        product.setName(productBean.getName());
        product.setPrice(productBean.getPrice());
        product.setDescription(productBean.getDescription());
        MultipartFile file = productBean.getFile();
        if (!file.isEmpty()) {
            product.setImage(file.getBytes());
        }
        product.setCreateDate(LocalDateTime.now());
        
        productService.saveProduct(product);

        return "redirect:/product/list";
    }

    @GetMapping("/list")
    String list(Model model) {
        List<Product> list = productService.findAll(1);
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
