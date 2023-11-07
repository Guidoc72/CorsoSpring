package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RedirectController {
    @GetMapping("/redirect")
    public String redirect(HttpServletRequest request) {
        request.setAttribute("message", "Questa è una richiesta di reindirizzamento!");
        //il messaggio non passa col redirect
        return "redirect:/destination_r";
    }

    @GetMapping("/destination_r")
    public String destination(HttpServletRequest request) {
        return "destination";
    }
   
}

