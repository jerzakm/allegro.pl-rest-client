package com.github.jerzakm.allegro.restClient.offers.listings;

public enum Sorting
{
    PRICE_ASC("+price"),
    PRICE_DESC("-price"),
    RELEVANCE_ASC("relevance"),
    DELIVERY_PRICE_ASC("+withDeliveryPrice"),
    DELIVERY_PRICE_DESC("-withDeliveryPrice"),
    POPULARITY_DESC("-popularity"),
    END_TIME_ASC("+endTime"),
    START_TIME_DESC("-startTime");

    private String url;

    Sorting(String sorting) {
        this.url = sorting;
    }

    public String getString() {
        return url;
    }
}
