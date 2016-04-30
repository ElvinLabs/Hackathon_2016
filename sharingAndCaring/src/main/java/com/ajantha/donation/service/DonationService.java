package com.ajantha.donation.service;

import com.ajantha.donation.model.DonationPost;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */

@Service(value = "donationService")
public interface DonationService {

   public List<DonationPost> getDonations();

   public DonationPost getDonationById( String postId );

    public DonationPost addDonation( DonationPost donationPost );

    public DonationPost updateDonation( DonationPost donationPost );

    public Boolean deleteDonationById( String donationPostId);

}
