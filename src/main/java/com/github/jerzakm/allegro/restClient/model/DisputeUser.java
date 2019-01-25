package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeUser {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("login")
    @Expose
    private String login;

    public DisputeUser() {
    }

    public String getId() {
        return id;
    }

    public DisputeUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public DisputeUser setLogin(String login) {
        this.login = login;
        return this;
    }
}
