package com.ajantha.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ajantha on 12/20/15.
 */
@Controller
public class UserController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UserController.class);

        @Autowired
        private MongoTemplate mongoTemplate;

        @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
        public ModelAndView loginPage(@RequestParam(value = "error",required = false)String error,
                                      @RequestParam(value = "logout",required = false)String logout ) {
            ModelAndView model = new ModelAndView();
            if (error != null) {
                model.addObject("error", "Invalid Credentials provided.");
            }
            if (logout != null) {
                model.addObject("message", "Logged out successfully.");
            }
            model.setViewName("login");

            return model;
        }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView wecomePage() {
        ModelAndView model = new ModelAndView();
//        model.addObject("username", "This is protected page - Database Page!");
//        model.addObject("title", "Spring Security Hello World");
        model.setViewName("welcome");

        return model;

    }

        @RequestMapping(value = "/admin**", method = RequestMethod.GET)
        public ModelAndView adminPage() {
            ModelAndView model = new ModelAndView();
            model.addObject("message", "This is protected page - Database Page!");
            model.addObject("title", "Spring Security Hello World");
            model.setViewName("admin");

            return model;

        }

        @RequestMapping(value = "/dba**", method = RequestMethod.GET)
        public ModelAndView dbaPage() {
            ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Hello World");
            model.addObject("message", "This is protected page - Database Page!");
            model.setViewName("admin");

            return model;

        }


}
