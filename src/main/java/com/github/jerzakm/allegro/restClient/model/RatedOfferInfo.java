package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatedOfferInfo {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("snapshot")
    @Expose
    private String snapshot;

    public RatedOfferInfo() {
    }

    public RatedOfferInfo(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public RatedOfferInfo(long id, String title, String snapshot) {
        this.id = id;
        this.title = title;
        this.snapshot = snapshot;
    }

    public long getId() {
        return id;
    }

    public RatedOfferInfo setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RatedOfferInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public RatedOfferInfo setSnapshot(String snapshot) {
        this.snapshot = snapshot;
        return this;
    }
}
