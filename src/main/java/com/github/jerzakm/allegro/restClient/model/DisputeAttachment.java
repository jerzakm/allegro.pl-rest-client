package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeAttachment {
    @SerializedName("fileName")
    @Expose
    private String fileName;

    @SerializedName("url")
    @Expose
    private String url;

    public DisputeAttachment() {
    }

    public String getFileName() {
        return fileName;
    }

    public DisputeAttachment setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DisputeAttachment setUrl(String url) {
        this.url = url;
        return this;
    }
}
