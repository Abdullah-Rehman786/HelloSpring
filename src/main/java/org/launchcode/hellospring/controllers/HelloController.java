package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // get /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    // get /gb
    @GetMapping("gb")
    @ResponseBody
    public String gb() {
        return "Gb, Spring";
    }

    //handles request of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='POST'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
