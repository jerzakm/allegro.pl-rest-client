package com.github.jerzakm.allegro.restClient.auth;

import com.github.jerzakm.allegro.restClient.model.AllegroError;
import com.github.jerzakm.allegro.restClient.model.AuthRegistrationStatus;
import com.google.gson.Gson;
import com.github.jerzakm.allegro.restClient.core.AllegroAppClient;
import com.github.jerzakm.allegro.restClient.model.AuthRegisterDevice;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import static com.github.jerzakm.allegro.restClient.core.Constant.ALLEGRO_URL;
import static com.github.jerzakm.allegro.restClient.core.Constant.DEVICE_AUTH_FLOW_GRANT_TYPE;

public class AuthDeviceFlow {
    static Logger log = Logger.getLogger(AuthDeviceFlow.class.getName());

    private AuthRegisterDevice authRegisterDevice;
    private AuthRegistrationStatus authRegistrationStatus;
    private boolean userAutorizedDevice;

    public AuthDeviceFlow registerDevice(AllegroAppClient allegroAppClient) throws IOException {
        log.info("Registering device [1]");
        RequestBuilder requestBuilder = RequestBuilder.create("POST").setCharset(Charset.forName("UTF-8"));
        requestBuilder.setUri(ALLEGRO_URL+ "auth/oauth/device")
                .addHeader("Authorization","Basic "+allegroAppClient.getAuth64())
                .addHeader("Content-Type","application/x-www-form-urlencoded")
                .addParameter("client_id",allegroAppClient.getClientID());
        HttpUriRequest request = requestBuilder.build();


        log.info("Registering device [1] - building URL completed -> fetching Http response");
        HttpResponse response = allegroAppClient.getHttpClient().execute(request);
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
        System.out.println(json);
        log.info("Registering device [2] - completed");

        return this;
    }

    public String getUserVerificationURI() {
        return this.authRegisterDevice.getVerificationUriComplete();
    }

    public String listenForUserAuth(AllegroAppClient allegroAppClient) throws IOException {
        log.info("Listening for user confirmation on service website [3]");
        RequestBuilder requestBuilder = RequestBuilder.create("POST").setCharset(Charset.forName("UTF-8"));
        requestBuilder.setUri(ALLEGRO_URL+ "auth/oauth/token")
                .addHeader("Authorization","Basic "+allegroAppClient.getAuth64())
                .addParameter("grant_type",DEVICE_AUTH_FLOW_GRANT_TYPE)
                .addParameter("device_code",authRegisterDevice.getDeviceCode());
        HttpUriRequest request = requestBuilder.build();
        log.info("Listenting for user confirmation [3] - building URL completed -> fetching Http response");
        HttpResponse response = allegroAppClient.getHttpClient().execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        String json = "";
        String line = "";
        log.info("Registering device [1] HTTP response code: "+response.getStatusLine());
        while ((line = rd.readLine()) != null) {
            json+=line;
        }
        System.out.println(json);

        Gson gson = new Gson();

        if(json.contains("access_token")) {
            AuthRegistrationStatus status = gson.fromJson(json, AuthRegistrationStatus.class);
            this.authRegistrationStatus = status;
            this.userAutorizedDevice = true;
            log.info("Registered to: "+status.getScope()+" expires in: "+status.getExpiresIn());
        } else if(json.contains("error")) {
            AllegroError error = gson.fromJson(json,AllegroError.class);
            log.warning(error.getErrorDescription());
        }

        return json;
    }

    public boolean deviceAuthorized() {
        return userAutorizedDevice;
    }
}
