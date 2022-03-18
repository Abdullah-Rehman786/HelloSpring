package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//     get /hello
//    @GetMapping("")
//    public String hello() {
//        return "Hello, Spring";
//    }

    // get /hello/gb
    @GetMapping("gb")
    public String gb() {
        return "Gb, Spring";
    }

    //handles request of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
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
