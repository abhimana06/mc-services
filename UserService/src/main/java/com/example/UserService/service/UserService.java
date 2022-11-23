package com.example.UserService.service;

import com.example.UserService.VO.Department;
import com.example.UserService.VO.ResponseTemplateVO;
import com.example.UserService.entity.User;
import com.example.UserService.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User findUser(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        User user =  userRepo.findById(userId).orElse(null);
        ResponseTemplateVO res = new ResponseTemplateVO();
        Department department = restTemplate.getForObject("http://department-service/departments/"+user.getDepartmentId(), Department.class);
        res.setDepartment(department);
        res.setUser(user);
        return res;
    }
}
