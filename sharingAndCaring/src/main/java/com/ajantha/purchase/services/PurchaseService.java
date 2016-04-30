package com.ajantha.purchase.services;

import com.ajantha.purchase.model.PurchasePost;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */

@Service( value = "")
public interface PurchaseService {

    public List<PurchasePost> getPurchases();

    public PurchasePost getPurchaseById( String postId );

    public PurchasePost addPurchase( PurchasePost purchasePost );

    public PurchasePost updatePurchase( PurchasePost purchasePost );

    public Boolean deletePurchaseById( String purchasePostId);
}
