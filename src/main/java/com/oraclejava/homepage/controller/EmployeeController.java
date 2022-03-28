package com.oraclejava.homepage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.homepage.dto.Employee;
import com.oraclejava.homepage.service.EmployeeService;

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
@RequestMapping("/employee")
public class EmployeeController {
    
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    String list(Model model) {
        List<Employee> list = employeeService.findAll();
        model.addAttribute("list", list);
        return "employee/list";
    }

    @GetMapping("/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Integer id, HttpServletResponse response, Optional<Employee> employee)
			throws ServletException, IOException {
		logger.info("Id :: " + id);
		employee = employeeService.getEmployeeById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(employee.get().getPicture());
		response.getOutputStream().close();
	}
}
