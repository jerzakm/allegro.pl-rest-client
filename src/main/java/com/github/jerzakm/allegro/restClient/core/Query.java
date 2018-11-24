package com.github.jerzakm.allegro.restClient.core;

import org.apache.http.client.methods.HttpUriRequest;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Query {
    private List<AbstractMap.SimpleEntry<String,String>> headers;
    private List<AbstractMap.SimpleEntry<String,String>> parameters;

    public Query() {
        this.headers = new ArrayList<>();
        this.parameters = new ArrayList<>();
    }

    public List<AbstractMap.SimpleEntry<String, String>> getHeaders() {
        return headers;
    }

    public Query setHeaders(List<AbstractMap.SimpleEntry<String, String>> headers) {
        this.headers = headers;
        return this;
    }

    public List<AbstractMap.SimpleEntry<String, String>> getParameters() {
        return parameters;
    }

    public Query setParameters(List<AbstractMap.SimpleEntry<String, String>> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Query addParameter(AbstractMap.SimpleEntry<String,String> entry) {
        parameters.add(entry);
        return this;
    }

    public Query addHeader(AbstractMap.SimpleEntry<String,String> entry) {
        headers.add(entry);
        return this;
    }

    public Query addParameter(String s, String s1) {
        parameters.add(new AbstractMap.SimpleEntry<String, String>(s,s1));
        return this;
    }

    public Query addHeader(String s, String s1) {
        headers.add(new AbstractMap.SimpleEntry<String, String>(s,s1));
        return this;
    }

}
