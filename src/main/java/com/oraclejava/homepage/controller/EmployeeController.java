package com.oraclejava.homepage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.oraclejava.homepage.dto.Employee;
import com.oraclejava.homepage.dto.GenderType;
import com.oraclejava.homepage.service.EmployeeService;

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
@RequestMapping("/employee")
public class EmployeeController {
    
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/add")
    String addEmployee(@ModelAttribute EmployeeBean employeeBean) {
        return "employee/add";
    }

    @PostMapping("/saveEmployee")
    String saveEmployee(@Validated @ModelAttribute EmployeeBean employeeBean,
                    BindingResult bindingResult) throws IOException {
        logger.info("saveEmployee");

        if (bindingResult.hasErrors()) {
            return addEmployee(employeeBean);
        }

        Employee employee = new Employee();
        employee.setName(employeeBean.getName());
        
        MultipartFile file = employeeBean.getFile();
        if (!file.isEmpty()) {
            employee.setPicture(file.getBytes());
        }
        // https://www.tutorialspoint.com/how-to-convert-a-string-to-an-enum-in-java
        employee.setGender(GenderType.valueOf(employeeBean.getGender()));
        employee.setBirthday(employeeBean.getBirthday());
        
        employeeService.saveEmployee(employee);

        return "redirect:/employee/list";
    }


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
