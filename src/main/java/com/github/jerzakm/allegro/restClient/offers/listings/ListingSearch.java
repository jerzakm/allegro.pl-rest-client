package com.github.jerzakm.allegro.restClient.offers.listings;

import com.github.jerzakm.allegro.restClient.auth.model.AllegroError;
import com.github.jerzakm.allegro.restClient.auth.model.UserAuth;
import com.github.jerzakm.allegro.restClient.core.AllegroApiResponse;
import com.github.jerzakm.allegro.restClient.core.Query;
import com.github.jerzakm.allegro.restClient.model.ListingResponse;
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

public class ListingSearch {
    private Query query;
    private HttpUriRequest uriRequest;

    public ListingSearch(UserAuth userAuth) {
        this.query = new Query()
                .addHeader("Content-Type","application/vnd.allegro.public.v1+json")
                .addHeader("Accept","application/vnd.allegro.public.v1+json")
                .addHeader("Authorization", "Bearer "+userAuth.getAccessToken());

    }

    public ListingSearch setCategoryId(String categoryId) {
        this.query.addParameter("category.id",categoryId);
        return this;
    }

    public ListingSearch setSearchPhrase(String phrase) {
        this.query.addParameter("phrase",phrase);
        return this;
    }

    public ListingSearch addSellerId(String sellerId) {
        this.query.addParameter("seller.id",sellerId);
        return this;
    }

    public ListingSearch setSearchMode(SearchMode searchMode) {
        this.query.addParameter("searchMode", String.valueOf(searchMode));
        return this;
    }

    public ListingSearch setOffset (int offset) {
        this.query.addParameter("offset", String.valueOf(offset));
        return this;
    }

    public ListingSearch setLimit (int limit) {
        this.query.addParameter("limit", String.valueOf(limit));
        return this;
    }

    public ListingSearch sort(Sorting sorting) {
        this.query.addParameter("sort",sorting.getString());
        return this;
    }

    public ListingSearch outputInclude(String include) {
        this.query.addParameter("include", include);
        return this;
    }

    public ListingSearch fallbackResults(boolean fallback) {
        this.query.addParameter("fallback", String.valueOf(fallback));
        return this;
    }

    public ListingSearch addParameter(String param, String value) {
        query.addParameter(param,value);
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
            ListingResponse lr = gson.fromJson(sb.toString(),ListingResponse.class);
            allegroApiResponse.setResponseBody(lr);
        }

        return allegroApiResponse;
    }

    public ListingSearch buildQuery() {
        RequestBuilder requestBuilder = RequestBuilder.create("GET")
                .setCharset(Charset.forName("UTF-8"))
                .setUri(ALLEGRO_API + "offers/listing");

        this.query.getHeaders().forEach(h -> requestBuilder.addHeader(h.getKey(),h.getValue()));
        this.query.getParameters().forEach(p -> requestBuilder.addParameter(p.getKey(),p.getValue()));
        this.uriRequest = requestBuilder.build();

        return this;
    }
}
