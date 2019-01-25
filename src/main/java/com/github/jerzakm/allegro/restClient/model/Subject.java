package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("name")
    @Expose
    private String name;
    public Subject() {
    }

    public String getSubject() {
        return name;
    }

    public Subject setSubject(String name) {
        this.name = name;
        return this;
    }
}
