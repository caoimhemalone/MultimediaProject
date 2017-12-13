package com.example.caoimhemalone.multimediaproject;

/**
 * Created by caoimhemalone on 13/12/2017.
 */

public class RestaurantsInfo {
    public int id;
    public String restName;
    public String restRanking;
    public String restAddress;
    public String restContact;

    public RestaurantsInfo(int id, String restName, String restRanking, String restAddress, String restContact) {
        this.id = id;
        this.restName = restName;
        this.restRanking = restRanking;
        this.restAddress = restAddress;
        this.restContact = restContact;
    }

    public int getId() {
        return id;
    }

    public String getRestName() {
        return restName;
    }

    public String getRestRanking() {
        return restRanking;
    }

    public String getRestAddress() {
        return restAddress;
    }

    public String getRestContact() {
        return restContact;
    }
}
