package com.github.grizzly.repository;

import com.github.grizzly.entity.Role;
import com.github.grizzly.exceptions.EntityNotFoundException;
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
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findAll(){
        List<Role> exp = RoleRepositoryMocks.expectedRoles();
        List<Role> act = roleRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findById_guest(){
        Role exp = RoleRepositoryMocks.guest();
        Role act = roleRepository.findById(1L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findById_user(){
        Role exp = RoleRepositoryMocks.user();
        Role act = roleRepository.findById(2L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findById_manager(){
        Role exp = RoleRepositoryMocks.manager();
        Role act = roleRepository.findById(3L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findById_admin(){
        Role exp = RoleRepositoryMocks.admin();
        Role act = roleRepository.findById(4L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findById_notExisting(){
        roleRepository.findById(5L).orElseThrow(EntityNotFoundException::new);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findByRole_guest(){
        Role exp = RoleRepositoryMocks.guest();
        Role act = roleRepository.findByRole(Role.Roles.GUEST).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findByRole_user(){
        Role exp = RoleRepositoryMocks.user();
        Role act = roleRepository.findByRole(Role.Roles.USER).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findByRole_manager(){
        Role exp = RoleRepositoryMocks.manager();
        Role act = roleRepository.findByRole(Role.Roles.MANAGER).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findByRole_admin(){
        Role exp = RoleRepositoryMocks.admin();
        Role act = roleRepository.findByRole(Role.Roles.ADMIN).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"roles-schema.sql", "roles-data.sql"})
    public void findByRole_null(){
        roleRepository.findByRole(null).orElseThrow(EntityNotFoundException::new);
    }

}