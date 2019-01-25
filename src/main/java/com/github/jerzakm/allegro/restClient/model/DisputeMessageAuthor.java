package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeMessageAuthor {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("role")
    @Expose
    private MessageAuthorRole role;

    public DisputeMessageAuthor() {
    }

    public String getLogin() {
        return login;
    }

    public DisputeMessageAuthor setLogin(String login) {
        this.login = login;
        return this;
    }

    public MessageAuthorRole getRole() {
        return role;
    }

    public DisputeMessageAuthor setRole(MessageAuthorRole role) {
        this.role = role;
        return this;
    }
}
