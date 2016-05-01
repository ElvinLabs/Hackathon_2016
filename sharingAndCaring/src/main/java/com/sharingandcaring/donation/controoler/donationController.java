package com.sharingandcaring.donation.controoler;

import com.sharingandcaring.donation.model.DonationPost;
import com.sharingandcaring.donation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sharingandcaring on 4/30/16.
 */
@RestController
public class donationController {

    @Autowired
    private DonationService donationService;

    @RequestMapping(value = {"/v1/rest/donations"}, method = RequestMethod.GET)
    public ResponseEntity<List<DonationPost>> getDonations(){

       List<DonationPost> donationPostList = donationService.getDonations();
        if (donationPostList != null) {
            return new ResponseEntity<>( donationPostList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/v1/rest/donations/{postId}"}, method = RequestMethod.GET)
    public ResponseEntity<DonationPost> getDonation(@RequestBody String postId){

        DonationPost donationPost = donationService.getDonationById(postId);
        if (donationPost != null) {
            return new ResponseEntity<>( donationPost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/v1/rest/donations"}, method = RequestMethod.POST)
    public ResponseEntity<DonationPost> addDonation(@RequestBody DonationPost donationPost){

       donationService.addDonation(donationPost);
        if (donationPost.getPostId() != null) {
            return new ResponseEntity<>( donationPost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = {"/v1/rest/donations"}, method = RequestMethod.PUT)
    public ResponseEntity<DonationPost> updateDonation(@RequestBody DonationPost donationPost){

       DonationPost updatedPost = donationService.updateDonation(donationPost);
        if (updatedPost.getPostId() != null) {
            return new ResponseEntity<>( donationPost, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = {"/v1/rest/donations/{postId}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteDonation(@RequestBody String postId){

        Boolean status = donationService.deleteDonationById(postId);
        if (status) {
            return new ResponseEntity<>( status ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
