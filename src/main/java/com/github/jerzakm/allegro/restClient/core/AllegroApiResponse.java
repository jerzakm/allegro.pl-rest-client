package com.github.jerzakm.allegro.restClient.core;

import com.github.jerzakm.allegro.restClient.auth.model.AllegroError;

public class AllegroApiResponse {
    private Object responseBody;
    private AllegroError error;

    public AllegroApiResponse() {
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    public AllegroError getError() {
        return error;
    }

    public void setError(AllegroError error) {
        this.error = error;
    }
}
