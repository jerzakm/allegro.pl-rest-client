package com.github.jerzakm.allegro.restClient.core;

import com.github.jerzakm.allegro.restClient.model.AppType;
import org.apache.http.client.HttpClient;

import java.util.Base64;

public class AllegroAppClient {
    private String appName;
    private AppType appType;
    private String clientID;
    private String clientSecret;
    private HttpClient httpClient;

    public AllegroAppClient() {
    }

    public AllegroAppClient setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public AllegroAppClient setAppType(AppType appType) {
        this.appType = appType;
        return this;
    }

    public AllegroAppClient setClientID(String clientID) {
        this.clientID = clientID;
        return this;
    }

    public AllegroAppClient setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public AllegroAppClient setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
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

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public String getAuth64() {
        return Base64.getEncoder()
                .encodeToString(
                (this.clientID+":"+this.clientSecret)
                        .getBytes());
    }
}