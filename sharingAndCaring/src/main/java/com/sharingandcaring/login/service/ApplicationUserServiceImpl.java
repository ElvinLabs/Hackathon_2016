package com.sharingandcaring.login.service;

import com.sharingandcaring.common.BaseService;
import com.sharingandcaring.login.model.ApplicationUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by sharingandcaring on 1/1/16.
 */

@Repository
public class ApplicationUserServiceImpl extends BaseService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ApplicationUserServiceImpl.class);

    public ApplicationUser loadUserByUsername(final String username) {
        //Write your DB call code to get the user details from DB,But I am just hard coding the user

        LOGGER.debug("userName================"+username);
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username));
        ApplicationUser applicationUser = getMongoTemplate().findOne(query,ApplicationUser.class);
        LOGGER.debug("userName================"+ applicationUser.getPassword());

        return applicationUser;
    }


}
