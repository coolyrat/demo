package com.example.docker.helloworld.controller;

import com.example.docker.helloworld.dao.UserDao;
import com.example.docker.helloworld.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Luis on 25/03/2018.
 */
@RequestMapping("/test")
@RestController
public class HelloController {

    private final String instanceId;
    private final UserDao userDao;

    public HelloController(@Value("${instance-id}") String instanceId, UserDao userDao) {
        this.instanceId = instanceId;
        this.userDao = userDao;
    }

    @GetMapping
    public String instanceId() {
        return instanceId;
    }

    @GetMapping("/list")
    public List<UserDto> userList() {
        return userDao.findAll();
    }
}
