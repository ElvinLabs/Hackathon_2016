package com.ajantha.purchase.controller;

import com.ajantha.purchase.model.PurchasePost;
import com.ajantha.purchase.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = {"/v1/rest/purchase"}, method = RequestMethod.GET)
    public ResponseEntity<List<PurchasePost>> getPurchases(){

        List<PurchasePost> donationPostList = purchaseService.getPurchases();
        if (donationPostList != null) {
            return new ResponseEntity<>( donationPostList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/v1/rest/purchases/{postId}"}, method = RequestMethod.GET)
    public ResponseEntity<PurchasePost> getPurchase(@RequestBody String postId){

        PurchasePost purchasePost = purchaseService.getPurchaseById(postId);
        if (purchasePost != null) {
            return new ResponseEntity<>( purchasePost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"/v1/rest/purchases"}, method = RequestMethod.POST)
    public ResponseEntity<PurchasePost> addDonation(@RequestBody PurchasePost purchasePost){

        purchaseService.addPurchase(purchasePost);
        if (purchasePost.getPostId() != null) {
            return new ResponseEntity<>( purchasePost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = {"/v1/rest/purchase/{postId}"}, method = RequestMethod.PUT)
    public ResponseEntity<PurchasePost> updateDonation(@RequestBody PurchasePost purchasePost){

        PurchasePost updatedPost = purchaseService.updatePurchase(purchasePost);
        if (updatedPost.getPostId() != null) {
            return new ResponseEntity<>( purchasePost, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = {"/v1/rest/purchase/{postId}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteDonation(@RequestBody String postId){

        Boolean status = purchaseService.deletePurchaseById(postId);
        if (status) {
            return new ResponseEntity<>( status ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
