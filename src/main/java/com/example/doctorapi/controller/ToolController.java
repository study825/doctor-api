package com.example.doctorapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tool")
public class ToolController {

    @PostMapping("phone")
    public Integer phone(@RequestParam Integer number) {
        return number;
    }
}
