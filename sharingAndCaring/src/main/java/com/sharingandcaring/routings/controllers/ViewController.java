package com.sharingandcaring.routings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dileeepa on 4/30/16.
 */
@Controller
public class ViewController {
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView profilePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("layout/main");

        return model;
    }

    @RequestMapping(value = {"/intro"}, method = RequestMethod.GET)
    public ModelAndView introPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("layout/intro");

        return model;
    }

    @RequestMapping(value = {"/addDonation"}, method = RequestMethod.GET)
    public ModelAndView addDonationPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("layout/addDonation");

        return model;
    }
}
