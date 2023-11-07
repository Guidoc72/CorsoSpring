package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ForwardController {
    @GetMapping("/forward")
    public String forward(HttpServletRequest request) {
        request.setAttribute("message", "Questa è una richiesta inoltrata!");
        //con il forward il messaggio passa!
        return "forward:/destination_f";
    }

    @GetMapping("/destination_f")
    public String destination(HttpServletRequest request) {
    	return "destination";
    }
}
