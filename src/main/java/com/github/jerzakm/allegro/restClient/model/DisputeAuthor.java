package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisputeAuthor {
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("author")
    @Expose
    private DisputeAuthorRole author;

    public DisputeAuthor() {
    }

    public String getLogin() {
        return login;
    }

    public DisputeAuthor setLogin(String login) {
        this.login = login;
        return this;
    }

    public DisputeAuthorRole getAuthor() {
        return author;
    }

    public DisputeAuthor setAuthor(DisputeAuthorRole author) {
        this.author = author;
        return this;
    }
}
