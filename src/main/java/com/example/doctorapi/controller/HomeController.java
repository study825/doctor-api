package com.example.doctorapi.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
    @RequestMapping("home")
    public String show(HttpServletRequest request) {
        return "2";
    }
}
