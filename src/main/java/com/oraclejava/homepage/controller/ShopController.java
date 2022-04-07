package com.oraclejava.homepage.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/shop")
public class ShopController {

    Logger logger = LoggerFactory.getLogger(ShopController.class);
    
    @Autowired
    ProductService productService;

    @GetMapping({"","/list"})
    String list(@RequestParam(value="sortOrder", required=false) Integer sortorder, Model model) {
        sortorder = sortorder == null ? 1 : sortorder;
        Map<String, Integer> priceItems;

        priceItems = new LinkedHashMap<>();	// 並べ替え選択肢
		priceItems.put("なし", 1);
		priceItems.put("安い順", 2);
		priceItems.put("高い順", 3);

        List<Product> list = productService.findAll(sortorder);
        model.addAttribute("list", list);

        model.addAttribute("priceItems", priceItems);
        return "shop/list";
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
