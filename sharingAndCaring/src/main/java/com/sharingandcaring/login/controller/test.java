package com.sharingandcaring.login.controller;

import com.sharingandcaring.config.MongoConfig;

import com.sharingandcaring.login.model.ApplicationUser;
import com.sharingandcaring.login.model.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharingandcaring on 1/3/16.
 */
public class test {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");

        ApplicationUser user = new ApplicationUser();
        user.setFirstName("firstName");
        user.setLastName("LastName");
        user.setUsername("admin");
        user.setPassword("123456");
        Role role= new Role();
        role.setName("ROLE_ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setAuthorities(roles);

        mongoTemplate.insert(user);
    }
}
