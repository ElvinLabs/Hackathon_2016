package com.sharingandcaring.donation.service;

import com.sharingandcaring.donation.model.DonationPost;

import java.util.List;

/**
 * Created by sharingandcaring on 4/30/16.
 */


public interface DonationService {

   public List<DonationPost> getDonations();

   public DonationPost getDonationById( String postId );

    public DonationPost addDonation( DonationPost donationPost );

    public DonationPost updateDonation( DonationPost donationPost );

    public Boolean deleteDonationById( String donationPostId);

}
