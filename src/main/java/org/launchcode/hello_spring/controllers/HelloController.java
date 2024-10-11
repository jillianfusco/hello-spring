package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    //handles requests of the form /hello?name=LaunchCode
    @ResponseBody
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) //instead of GetMapping, takes both get and post requests
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    
    //handles requests of the form /hello/LaunchCode
    @ResponseBody
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


}
