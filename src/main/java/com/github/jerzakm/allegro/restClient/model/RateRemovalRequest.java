package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateRemovalRequest {

    @SerializedName("request")
    @Expose
    private RateMessage request;

    @SerializedName("possibleTo")
    @Expose
    private String possibleTo;

    public RateRemovalRequest() {
    }

    public RateMessage getRequest() {
        return request;
    }

    public RateRemovalRequest setRequest(RateMessage request) {
        this.request = request;
        return this;
    }

    public String getPossibleTo() {
        return possibleTo;
    }

    public RateRemovalRequest setPossibleTo(String possibleTo) {
        this.possibleTo = possibleTo;
        return this;
    }
}
