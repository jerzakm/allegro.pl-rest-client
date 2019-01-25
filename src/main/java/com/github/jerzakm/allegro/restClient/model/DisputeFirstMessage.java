package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeFirstMessage {
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
    private DisputeAuthor author;

    @SerializedName("createdAt")
    @Expose
    private String createdAt;
}
