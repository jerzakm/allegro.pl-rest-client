package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateMessage {
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    @SerializedName("message")
    @Expose
    private String message;

    public RateMessage() {
    }

    public RateMessage(String createdAt, String message) {
        this.createdAt = createdAt;
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public RateMessage setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RateMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
