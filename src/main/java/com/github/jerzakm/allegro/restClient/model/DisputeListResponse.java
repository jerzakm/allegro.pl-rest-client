package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisputeListResponse {
    @SerializedName("disputes")
    @Expose
    private List<Dispute> disputes;


    public DisputeListResponse() {
    }

    public List<Dispute> getDisputes() {
        return disputes;
    }

    public DisputeListResponse setDisputes(List<Dispute> disputes) {
        this.disputes = disputes;
        return this;
    }
}
