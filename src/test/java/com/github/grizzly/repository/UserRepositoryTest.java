package com.github.grizzly.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
@DataJdbcTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    @Test
    public void findById() {
    }

    @Test
    public void findUserByPhone() {
    }

    @Test
    public void findByEmail() {
    }

    @Test
    public void findByLogin() {
    }
}