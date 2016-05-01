package com.sharingandcaring.purchase.services;

import com.sharingandcaring.common.BaseService;
import com.sharingandcaring.donation.model.DonationPost;
import com.sharingandcaring.purchase.model.PurchasePost;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sharingandcaring on 4/30/16.
 */
@Service( value = "purchaseService")
public class PurchaseServiceImpl extends BaseService implements PurchaseService {

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
