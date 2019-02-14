package com.github.jerzakm.allegro.restClient.sale.userRatings;

import com.github.jerzakm.allegro.restClient.auth.model.AllegroError;
import com.github.jerzakm.allegro.restClient.auth.model.UserAuth;
import com.github.jerzakm.allegro.restClient.core.AllegroApiResponse;
import com.github.jerzakm.allegro.restClient.core.Query;
import com.github.jerzakm.allegro.restClient.sale.disputes.ListDisputes;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static com.github.jerzakm.allegro.restClient.core.Constant.ALLEGRO_API;

public class ListUserRatings {
    private Query query;
    private HttpUriRequest uriRequest;

    public ListUserRatings(UserAuth userAuth) {
        this.query = new Query()
                .addHeader("Content-Type","application/vnd.allegro.public.v1+json")
                .addHeader("Accept","application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer "+userAuth.getAccessToken());
    }

    public ListUserRatings setUserId(int userId) {
        this.query.addParameter("user.id", String.valueOf(userId));
        return this;
    }

    public ListUserRatings setRecommended(boolean recommended) {
        this.query.addParameter("recommended", String.valueOf(recommended));
        return this;
    }

    public ListUserRatings setOffset(int offset) {
        this.query.addParameter("offset", String.valueOf(offset));
        return this;
    }

    public ListUserRatings setLimit(int limit) {
        this.query.addParameter("limit", String.valueOf(limit));
        return this;
    }

    public ListUserRatings buildQuery() {
        RequestBuilder requestBuilder = RequestBuilder.create("GET")
                .setCharset(Charset.forName("UTF-8"))
                .setUri(ALLEGRO_API + "sale/user-ratings");

        this.query.getHeaders().forEach(h -> requestBuilder.addHeader(h.getKey(),h.getValue()));
        this.query.getParameters().forEach(p -> requestBuilder.addParameter(p.getKey(),p.getValue()));
        this.uriRequest = requestBuilder.build();
        return this;
    }

    public Query getQuery() {
        return query;
    }

    public AllegroApiResponse executeWithClient(HttpClient httpClient) throws IOException {
        HttpResponse response = httpClient.execute(this.uriRequest);
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        String line = "";

        while ((line = rd.readLine()) != null) {sb.append(line);}

        Gson gson = new Gson();

        AllegroApiResponse allegroApiResponse = new AllegroApiResponse();
        //todo better error catching not just string..
        allegroApiResponse.setResponseBody(sb.toString());
        allegroApiResponse.setResponseBody(sb.toString());

        return allegroApiResponse;
    }
}
