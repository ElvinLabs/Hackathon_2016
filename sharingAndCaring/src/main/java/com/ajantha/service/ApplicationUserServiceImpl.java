package com.ajantha.service;

import com.ajantha.base.Base;
import com.ajantha.model.ApplicationUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by ajantha on 1/1/16.
 */

@Repository
public class ApplicationUserServiceImpl extends Base {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApplicationUserServiceImpl.class);

    public ApplicationUser loadUserByUsername(final String username) {
        //Write your DB call code to get the user details from DB,But I am just hard coding the user

        LOGGER.debug("userName================"+username);
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username));
        ApplicationUser applicationUser = getMongoTemplate().findOne(query,ApplicationUser.class);
        LOGGER.debug("userName================"+ applicationUser.getPassword());

//
//        TestUser user = new TestUser();
//        user.setFirstName("kb");
//        user.setLastName("gc");
//        user.setUsername("kb");
//        user.setPassword("1234");
//        Role role= new Role();
//        role.setName("ROLE_ADMIN");
//        List<Role> roles = new ArrayList<>();
//        roles.add(role);
//        user.setAuthorities(roles);
        return applicationUser;
    }


}
