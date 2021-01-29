package com.example.hoffmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelProduct {


    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("image")

    private String image;
    @SerializedName("isFavorite")
    private boolean isFavorite;

    @SerializedName("prices")
    private ModelPrices prices;

    @SerializedName("isBestPrice")
    private boolean isBestPrice;

    @SerializedName("articul")
    private String articul;

    @SerializedName("rating")

    private int rating;
    @SerializedName("numberOfReviews")

    private int numberOfReviews;
    @SerializedName("statusText")

    private String statusText;
    @SerializedName("isAvailable")

    private boolean isAvailable;
    @SerializedName("images")

    private List<String> images = null;

    @SerializedName("categoryId")

    private String categoryId;


    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name=name;
    }

    public String getImage() {
        return image;
    }

    public void setImage( String image ) {
        this.image=image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite( boolean favorite ) {
        isFavorite=favorite;
    }

    public ModelPrices getPrices() {
        return prices;
    }

    public void setPrices( ModelPrices prices ) {
        this.prices=prices;
    }

    public boolean isBestPrice() {
        return isBestPrice;
    }

    public void setBestPrice( boolean bestPrice ) {
        isBestPrice=bestPrice;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul( String articul ) {
        this.articul=articul;
    }

    public int getRating() {
        return rating;
    }

    public void setRating( int rating ) {
        this.rating=rating;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews( int numberOfReviews ) {
        this.numberOfReviews=numberOfReviews;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText( String statusText ) {
        this.statusText=statusText;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable( boolean available ) {
        isAvailable=available;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages( List<String> images ) {
        this.images=images;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId( String categoryId ) {
        this.categoryId=categoryId;
    }
}
