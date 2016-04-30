package com.ajantha.purchase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by ajantha on 4/30/16.
 */


@Document(collection = "purchasepost")
public class PurchasePost {

    @Id
    private String purchasepostId;
    private String title;
    private String content;
    private List<String> keywords;
    private String imagePath;


    public String getPurchasepostId() {
        return purchasepostId;
    }

    public void setPurchasepostId(String purchasepostId) {
        this.purchasepostId = purchasepostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
