package com.belong.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController {
    @GetMapping("/web")
    public String test() {
        return "web";
    }
}
