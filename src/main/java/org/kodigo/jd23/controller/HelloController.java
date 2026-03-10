package org.kodigo.jd23.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping({"/hello/helloword", "/jd23/hello"})
    public String hello(){
        return "Hello KodiJava!";
    }

}
