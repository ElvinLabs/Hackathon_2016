package com.ajantha.donation.service;

import com.ajantha.base.Base;
import com.ajantha.donation.model.DonationPost;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */
public class DonationServiceImpl extends Base implements DonationService {

    public List<DonationPost> getDonations(){
        List<DonationPost> postList;
        postList = mongoTemplate.findAll(DonationPost.class);

        return postList;
    }

    public DonationPost getDonationById( String postId ){

        Query query = new Query();
        query.addCriteria(Criteria.where("postId").is(postId));

        return getMongoTemplate().findOne(query, DonationPost.class);
    }

    public DonationPost addDonation( DonationPost donationPost ){
        mongoTemplate.save(donationPost);

        return getDonationById(donationPost.getPostId());
    }

    public DonationPost updateDonation( DonationPost donationPost ){

        mongoTemplate.save(donationPost);
        return donationPost;
    }

    public Boolean deleteDonationById( String donationPostId){
        Query query = new Query();
        query.addCriteria(Criteria.where( "postId" ).is( donationPostId ));
        WriteResult writeResult =mongoTemplate.remove( query, DonationPost.class );
        if (writeResult.getN() > 0){
            return true;
        }

        return false;
    }
}
