package com.github.grizzly.repository;

import com.github.grizzly.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findAll(){
        List<User> exp = UserRepositoryMocks.users();
        List<User> act = userRepository.findAll();
        System.out.println(act);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

}