package com.github.jerzakm.allegro.restClient.auth;

import com.github.jerzakm.allegro.restClient.auth.model.AllegroError;
import com.github.jerzakm.allegro.restClient.auth.model.UserAuth;
import com.google.gson.Gson;
import com.github.jerzakm.allegro.restClient.core.AllegroApp;
import com.github.jerzakm.allegro.restClient.auth.model.AuthRegisterDevice;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import static com.github.jerzakm.allegro.restClient.core.Constant.ALLEGRO_URL;

public class AuthDeviceFlow {
    static Logger log = Logger.getLogger(AuthDeviceFlow.class.getName());
    private AuthRegisterDevice authRegisterDevice;
    private HttpClient httpClient;
    private AllegroApp allegroApp;
    private boolean authenticated;

    public AuthDeviceFlow(AllegroApp allegroApp, HttpClient httpClient) {
        this.allegroApp = allegroApp;
        this.httpClient = httpClient;
    }


    public AuthDeviceFlow setAllegroApp(AllegroApp allegroApp) {
        this.allegroApp = allegroApp;
        return this;
    }

    public AuthDeviceFlow registerDevice(UserAuth userAuth) throws IOException {
        log.info("Registering device [1]");
        RequestBuilder requestBuilder = RequestBuilder.create("POST").setCharset(Charset.forName("UTF-8"));
        requestBuilder.setUri(ALLEGRO_URL+ "auth/oauth/device")
                .addHeader("Authorization","Basic "+ allegroApp.getAuth64())
                .addHeader("Content-Type","application/x-www-form-urlencoded")
                .addParameter("client_id", allegroApp.getClientID());
        HttpUriRequest request = requestBuilder.build();


        log.info("Registering device [1] - building URL completed -> fetching Http response");
        HttpResponse response = this.httpClient.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        String json = "";
        String line = "";
        log.info("Registering device [2] HTTP response code: "+response.getStatusLine());
        while ((line = rd.readLine()) != null) {
            json+=line;
        }
        Gson gson = new Gson();
        this.authRegisterDevice = gson.fromJson(json, AuthRegisterDevice.class);
        log.info("Registering device [2] - completed");

        return this;
    }

    public String getUserVerificationURI() {
        return this.authRegisterDevice.getVerificationUriComplete();
    }

    public UserAuth listenForUserAuth() throws IOException {
        log.info("Listening for user confirmation on service website [3]");
        RequestBuilder requestBuilder = RequestBuilder.create("POST").setCharset(Charset.forName("UTF-8"));
        requestBuilder.setUri(ALLEGRO_URL+ "auth/oauth/token")
                .addHeader("Authorization","Basic "+ allegroApp.getAuth64())
                .addParameter("grant_type","urn%3Aietf%3Aparams%3Aoauth%3Agrant-type%3Adevice_code")
                .addParameter("device_code",authRegisterDevice.getDeviceCode());
        HttpUriRequest request = requestBuilder.build();
        log.info("Listenting for user confirmation [3] - building URL completed -> fetching Http response");
        HttpResponse response = this.httpClient.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        log.info("Listenting for user confirmation [3] HTTP response code: "+response.getStatusLine());
        while ((line = rd.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();

        Gson gson = new Gson();

        UserAuth status = new UserAuth();
        if(json.contains("access_token")) {
            status = gson.fromJson(json, UserAuth.class);
            log.info("Listenting for user confirmation [3] Registered to: "+status.getScope()+" expires in: "+status.getExpiresIn());
            this.authenticated = true;
            return status;
        } else {
            AllegroError error = gson.fromJson(json,AllegroError.class);
            log.warning("Listenting for user confirmation error[3] "+error.getErrorDescription());
            this.authenticated = false;
            return status;
        }
    }

    public UserAuth refreshUserAuth(UserAuth userAuth) throws IOException {

        RequestBuilder requestBuilder = RequestBuilder.create("POST").setCharset(Charset.forName("UTF-8"));
        requestBuilder.setUri(ALLEGRO_URL+ "auth/oauth/token")
                .addHeader("Authorization","Basic "+ allegroApp.getAuth64())
                .addParameter("grant_type","refresh_token")
                .addParameter("refresh_token", userAuth.getRefreshToken());
        HttpUriRequest request = requestBuilder.build();

        HttpResponse response = this.httpClient.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();

        Gson gson = new Gson();
        if(json.contains("access_token")) {
            userAuth = gson.fromJson(json, UserAuth.class);
            log.info("Refreshing token for: "+ userAuth.getScope()+" expires in: "+ userAuth.getExpiresIn());
            this.authenticated = true;
            return userAuth;
        } else {
            AllegroError error = gson.fromJson(json,AllegroError.class);
            log.warning("Error refreshing token "+error.getErrorDescription());
            userAuth.setAccessToken("ERROR");
            this.authenticated = false;
            return userAuth;
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}