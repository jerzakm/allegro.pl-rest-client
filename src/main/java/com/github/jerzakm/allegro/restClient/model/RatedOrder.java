package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RatedOrder {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("offers")
    @Expose
    private List<RatedOfferInfo> ratedOfferInfoList;

    public RatedOrder() {
    }

    public RatedOrder(String id, List<RatedOfferInfo> ratedOfferInfoList) {
        this.id = id;
        this.ratedOfferInfoList = ratedOfferInfoList;
    }

    public String getId() {
        return id;
    }

    public List<RatedOfferInfo> getRatedOfferInfoList() {
        return ratedOfferInfoList;
    }
}
