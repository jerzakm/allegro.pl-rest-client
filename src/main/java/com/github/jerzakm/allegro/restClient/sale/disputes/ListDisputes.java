package com.github.jerzakm.allegro.restClient.sale.disputes;

import com.github.jerzakm.allegro.restClient.auth.model.AllegroError;
import com.github.jerzakm.allegro.restClient.auth.model.UserAuth;
import com.github.jerzakm.allegro.restClient.core.AllegroApiResponse;
import com.github.jerzakm.allegro.restClient.core.Query;
import com.github.jerzakm.allegro.restClient.offers.listings.ListingSearch;
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

public class ListDisputes {
    private Query query;
    private HttpUriRequest uriRequest;

    public ListDisputes(UserAuth userAuth) {
        this.query = new Query()
                .addHeader("Content-Type","application/vnd.allegro.public.v1+json")
                .addHeader("Accept","application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer "+userAuth.getAccessToken());
    }

    public ListDisputes setLimit(int limit) {
        this.query.addParameter("limit", String.valueOf(limit));
        return this;
    }

    public ListDisputes setOffset(int offset) {
        this.query.addParameter("limit", String.valueOf(offset));
        return this;
    }

    public ListDisputes buildQuery() {
        RequestBuilder requestBuilder = RequestBuilder.create("GET")
                .setCharset(Charset.forName("UTF-8"))
                .setUri(ALLEGRO_API + "sale/disputes");

        this.query.getHeaders().forEach(h -> requestBuilder.addHeader(h.getKey(),h.getValue()));
        this.query.getParameters().forEach(p -> requestBuilder.addParameter(p.getKey(),p.getValue()));
        this.uriRequest = requestBuilder.build();

        return this;
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
        if(sb.toString().contains("error")) {
            AllegroError allegroError= gson.fromJson(sb.toString(),AllegroError.class);
            allegroApiResponse.setError(allegroError);
        } else {
            //ListingResponse lr = gson.fromJson(sb.toString(),ListingResponse.class);
            allegroApiResponse.setResponseBody(sb.toString());
        }

        return allegroApiResponse;
    }
}
