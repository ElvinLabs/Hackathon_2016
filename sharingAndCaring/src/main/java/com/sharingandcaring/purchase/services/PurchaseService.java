package com.sharingandcaring.purchase.services;

import com.sharingandcaring.purchase.model.PurchasePost;

import java.util.List;

/**
 * Created by sharingandcaring on 4/30/16.
 */


public interface PurchaseService {

    public List<PurchasePost> getPurchases();

    public PurchasePost getPurchaseById( String postId );

    public PurchasePost addPurchase( PurchasePost purchasePost );

    public PurchasePost updatePurchase( PurchasePost purchasePost );

    public Boolean deletePurchaseById( String purchasePostId);
}
