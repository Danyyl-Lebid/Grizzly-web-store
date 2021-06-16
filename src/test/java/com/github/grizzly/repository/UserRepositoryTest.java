package com.github.grizzly.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJdbcTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

}