package com.oraclejava.homepage.controller;

import java.util.List;

import com.oraclejava.homepage.dto.Jusorok;
import com.oraclejava.homepage.service.JusorokService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jusorok")
public class JusorokController {
    
    @Autowired
    JusorokService jusorokService;

    

    //@RequestMapping
    @GetMapping
    String list(@ModelAttribute JusorokBean jusorokBean,  Model model) {
        List<Jusorok> list = jusorokService.findAll();
        model.addAttribute("list", list);

        return "jusorok/index";
    }



    @PostMapping("/add")
    String add(@Validated @ModelAttribute JusorokBean jusorokBean, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return list(jusorokBean, model);
        }
        Jusorok jusorok = new Jusorok(jusorokBean.getNum(), jusorokBean.getName(), jusorokBean.getMail());
        jusorokService.create(jusorok);

        return "redirect:/jusorok";
    }


    @GetMapping("/edit")
    String edit(@ModelAttribute JusorokBean jusorokBean,  Model model) {
        List<Jusorok> list = jusorokService.findAll();
        model.addAttribute("list", list);

        return "jusorok/edit";
    }
}
