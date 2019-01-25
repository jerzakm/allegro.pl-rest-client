package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeMessage {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("attachment")
    @Expose
    private DisputeAttachment attachment;

    @SerializedName("author")
    @Expose
    private DisputeMessageAuthor author;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public DisputeMessage setId(String id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public DisputeMessage setText(String text) {
        this.text = text;
        return this;
    }

    public DisputeAttachment getAttachment() {
        return attachment;
    }

    public DisputeMessage setAttachment(DisputeAttachment attachment) {
        this.attachment = attachment;
        return this;
    }

    public DisputeMessageAuthor getAuthor() {
        return author;
    }

    public DisputeMessage setAuthor(DisputeMessageAuthor author) {
        this.author = author;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public DisputeMessage setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
