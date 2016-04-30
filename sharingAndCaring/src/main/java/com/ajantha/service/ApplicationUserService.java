package com.ajantha.service;

import com.ajantha.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ajantha on 1/1/16.
 */
@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private ApplicationUserServiceImpl testUserService;


    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return testUserService.loadUserByUsername(username);
    }

}
