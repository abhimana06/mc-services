package com.example.Gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack(){
        return "User service is taking longer than expected, please check logs or try again";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallback(){
        return "Department service is taking longer than expected, please check logs or try again";
    }
}
