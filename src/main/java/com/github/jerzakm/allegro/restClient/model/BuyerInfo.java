package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyerInfo {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("login")
    @Expose
    private String login;

    public BuyerInfo(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public BuyerInfo() {
    }

    public int getId() {
        return id;
    }

    public BuyerInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public BuyerInfo setLogin(String login) {
        this.login = login;
        return this;
    }
}
