package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

//     get /hello
//    @GetMapping("")
//    public String hello() {
//        return "Hello, Spring";
//    }

    // get /hello/gb
    @ResponseBody
    @GetMapping("gb")
    public String gb() {
        return "Gb, Spring";
    }

    //handles request of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello " + name + "!";

        model.addAttribute("greeting",greeting);
        return "hello";
    }

    //handles /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    //handles request of form /hello/multilingual?name=LaunchCode&language=French
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="multilingual")
//    @ResponseBody
//    public String helloDiffLanguages(@RequestParam String name, @RequestParam String language) {
//
//        return HelloController.createMessage(name, language);
//    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();

        names.add("LaunchCode");
        names.add("Abdullah");
        names.add("Chris");

        model.addAttribute("names", names);

        return "hello-list";
    }

    public static String createMessage(String name, String language) {
        String greeting = "";
        if(language.equals("English")){
            greeting = "Hello ";
        } else if (language.equals("French")){
            greeting = "Bonjour ";
        } else if (language.equals("Spanish")){
            greeting = "Hola ";
        } else if (language.equals("German")){
            greeting = "Hallo ";
        } else if (language.equals("Italian")){
            greeting = "Ciao ";
        }

        return greeting + name + "!";
    }
}
