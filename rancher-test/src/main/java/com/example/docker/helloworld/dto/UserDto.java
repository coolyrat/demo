package com.example.docker.helloworld.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Luis on 25/03/2018.
 */
@Data
public class UserDto implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
}
