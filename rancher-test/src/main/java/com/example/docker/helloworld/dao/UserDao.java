package com.example.docker.helloworld.dao;

import com.example.docker.helloworld.dto.UserDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.docker.helloworld.domain.tables.User.USER;

/**
 * Created by Luis on 25/03/2018.
 */
@Repository
public class UserDao {

    private final DSLContext dsl;

    public UserDao(DSLContext dsl) {
        this.dsl = dsl;
    }

    public List<UserDto> findAll() {
        return dsl.selectFrom(USER).fetchInto(UserDto.class);
    }
}
