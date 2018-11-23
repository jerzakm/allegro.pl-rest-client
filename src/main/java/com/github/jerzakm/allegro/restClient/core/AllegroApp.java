package com.github.jerzakm.allegro.restClient.core;

import com.github.jerzakm.allegro.restClient.auth.model.AppType;
import com.github.jerzakm.allegro.restClient.auth.model.UserAuthStatus;

import java.util.Base64;

public class AllegroApp {
    private String appName;
    private AppType appType;
    private String clientID;
    private String clientSecret;

    public AllegroApp() {
    }

    public AllegroApp setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public AllegroApp setAppType(AppType appType) {
        this.appType = appType;
        return this;
    }

    public AllegroApp setClientID(String clientID) {
        this.clientID = clientID;
        return this;
    }

    public AllegroApp setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public AppType getAppType() {
        return appType;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getAuth64() {
        return Base64.getEncoder()
                .encodeToString(
                (this.clientID+":"+this.clientSecret)
                        .getBytes());
    }
}