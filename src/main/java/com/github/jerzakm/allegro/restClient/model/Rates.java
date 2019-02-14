package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {
    @SerializedName("delivery")
    @Expose
    private int delivery;

    @SerializedName("description")
    @Expose
    private int description;

    @SerializedName("service")
    @Expose
    private int service;

    @SerializedName("deliveryCost")
    @Expose
    private int deliveryCost;

    public Rates() {
    }

    public Rates(int delivery, int description, int service, int deliveryCost) {
        this.delivery = delivery;
        this.description = description;
        this.service = service;
        this.deliveryCost = deliveryCost;
    }

    public int getDelivery() {
        return delivery;
    }

    public Rates setDelivery(int delivery) {
        this.delivery = delivery;
        return this;
    }

    public int getDescription() {
        return description;
    }

    public Rates setDescription(int description) {
        this.description = description;
        return this;
    }

    public int getService() {
        return service;
    }

    public Rates setService(int service) {
        this.service = service;
        return this;
    }

    public int getDeliveryCost() {
        return deliveryCost;
    }

    public Rates setDeliveryCost(int deliveryCost) {
        this.deliveryCost = deliveryCost;
        return this;
    }
}
