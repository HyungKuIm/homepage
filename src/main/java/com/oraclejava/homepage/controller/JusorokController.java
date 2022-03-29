package com.oraclejava.homepage.controller;

import java.util.List;

import com.oraclejava.homepage.dto.Jusorok;
import com.oraclejava.homepage.dto.Member;
import com.oraclejava.homepage.service.JusorokService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.SessionAttribute;

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
    
    @GetMapping("/delete")
    String delete(@ModelAttribute JusorokBean jusorokBean,  Model model) {
        List<Jusorok> list = jusorokService.findAll();
        model.addAttribute("list", list);

        return "jusorok/delete";
    }

    @GetMapping("/delete/{num}")
    String delete_ok(@PathVariable Integer num) {
        
        jusorokService.delete(num);

        return "redirect:/jusorok/delete";
    }


    @GetMapping("/{num}")
    @ResponseBody
    public ResponseEntity<Jusorok> getJusorok(@PathVariable Integer num) {
        return new ResponseEntity<Jusorok>(jusorokService.findOne(num), HttpStatus.OK);
    }
}
