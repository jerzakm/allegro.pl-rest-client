package core;

import org.apache.http.client.HttpClient;

import java.util.Base64;

public class AllegroAppClient {
    private String appName = "marketflow-scheduler";
    private boolean isDeviceType;
    private String clientID;
    private String clientSecret;
    private HttpClient httpClient;

    public AllegroAppClient() {
    }

    public AllegroAppClient setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public AllegroAppClient setDeviceType(boolean deviceType) {
        isDeviceType = deviceType;
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

    public boolean isDeviceType() {
        return isDeviceType;
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