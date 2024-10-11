package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at /hello
//    @ResponseBody
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now lives at /hello/goodbye because of @RequestMapping("hello") above
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) //instead of GetMapping, takes both get and post requests
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    
    //handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
