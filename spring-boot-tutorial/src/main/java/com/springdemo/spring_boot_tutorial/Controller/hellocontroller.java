package com.springdemo.spring_boot_tutorial.Controller;

 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

        @GetMapping("/hello")
        public String helloword() {
                return "Hello World my nigga";
        }
}
        