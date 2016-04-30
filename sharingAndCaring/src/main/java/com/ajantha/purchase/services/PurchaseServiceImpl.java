package com.ajantha.purchase.services;

import com.ajantha.base.Base;
import com.ajantha.donation.model.DonationPost;
import com.ajantha.purchase.model.PurchasePost;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */
public class PurchaseServiceImpl extends Base implements PurchaseService {

    public List<PurchasePost> getPurchases(){
        return mongoTemplate.findAll(PurchasePost.class);
    }

    public PurchasePost getPurchaseById( String postId ){
        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));

        return getMongoTemplate().findOne(query, PurchasePost.class);
    }

    public PurchasePost addPurchase( PurchasePost purchasePost ){
        mongoTemplate.save(purchasePost);

        return getPurchaseById(purchasePost.getPostId());
    }

    public PurchasePost updatePurchase( PurchasePost purchasePost ){
        mongoTemplate.save(purchasePost);
        return purchasePost;
    }

    public Boolean deletePurchaseById( String purchasePostId){
        Query query = new Query();
        query.addCriteria(Criteria.where( "postId" ).is( purchasePostId ));
        WriteResult writeResult =mongoTemplate.remove( query, DonationPost.class );
        if (writeResult.getN() > 0){
            return true;
        }

        return false;
    }
}
