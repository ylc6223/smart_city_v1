package com.belong.module02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class busController {
    @GetMapping("/bus")
    public String test() {
        return "/bus";
    }
}
