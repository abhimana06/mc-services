package com.example.UserService.controller;

import com.example.UserService.VO.ResponseTemplateVO;
import com.example.UserService.entity.User;
import com.example.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        if (user != null) {
            log.info("saving user: " + user.getUserId());
            return userService.saveUser(user);
        }
        return null;
    }

    @GetMapping("/{userId}")
    public User getUser(@RequestParam("userId") Long userId) {
        log.info("finding user: " + userId);
        return userService.findUser(userId);
    }

    @GetMapping("/findUserWithDepartment/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
