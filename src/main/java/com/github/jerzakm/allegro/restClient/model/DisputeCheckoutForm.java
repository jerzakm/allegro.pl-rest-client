package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeCheckoutForm {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public DisputeCheckoutForm() {
    }

    public String getId() {
        return id;
    }

    public DisputeCheckoutForm setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public DisputeCheckoutForm setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
