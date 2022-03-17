package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // get /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring";
    }

    // get /gb
    @GetMapping("gb")
    @ResponseBody
    public String gb() {
        return "Gb, Spring";
    }
}