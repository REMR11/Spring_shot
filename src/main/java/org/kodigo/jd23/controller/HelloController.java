package org.kodigo.jd23.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping({"/api/hello/helloword", "/jd23/hello"})
    public String hello(){
        return "Hello KodiJava!";
    }
}
