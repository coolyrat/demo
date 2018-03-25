package com.example.docker.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Luis on 25/03/2018.
 */
@RequestMapping("/test")
@RestController
public class HelloController {

    private final String instanceId;

    public HelloController(@Value("${instance-id}") String instanceId) {
        this.instanceId = instanceId;
    }

    @GetMapping
    public String instanceId() {
        return instanceId;
    }
}
