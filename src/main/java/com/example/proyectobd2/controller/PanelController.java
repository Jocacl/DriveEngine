package com.example.proyectobd2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {
    
    @RequestMapping("/")
    public String inicio(){
        return "index";
    }
}
