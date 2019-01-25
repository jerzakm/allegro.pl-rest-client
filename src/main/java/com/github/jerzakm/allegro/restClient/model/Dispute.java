package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dispute {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("subject")
    @Expose
    private Subject subject;

    @SerializedName("status")
    @Expose
    private DisputeStatus status;

    @SerializedName("buyer")
    @Expose
    private DisputeUser buyer;

    @SerializedName("seller")
    @Expose
    private DisputeUser seller;

    @SerializedName("checkoutForm")
    @Expose
    private DisputeCheckoutForm checkoutForm;

    @SerializedName("message")
    @Expose
    private DisputeFirstMessage message;

    @SerializedName("messagesCount")
    @Expose
    private int messagesCount;

    public Dispute() {
    }

    public String getId() {
        return id;
    }

    public Dispute setId(String id) {
        this.id = id;
        return this;
    }

    public Subject getSubject() {
        return subject;
    }

    public Dispute setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public DisputeStatus getStatus() {
        return status;
    }

    public Dispute setStatus(DisputeStatus status) {
        this.status = status;
        return this;
    }

    public DisputeUser getBuyer() {
        return buyer;
    }

    public Dispute setBuyer(DisputeUser buyer) {
        this.buyer = buyer;
        return this;
    }

    public DisputeUser getSeller() {
        return seller;
    }

    public Dispute setSeller(DisputeUser seller) {
        this.seller = seller;
        return this;
    }

    public DisputeCheckoutForm getCheckoutForm() {
        return checkoutForm;
    }

    public Dispute setCheckoutForm(DisputeCheckoutForm checkoutForm) {
        this.checkoutForm = checkoutForm;
        return this;
    }

    public DisputeFirstMessage getMessage() {
        return message;
    }

    public Dispute setMessage(DisputeFirstMessage message) {
        this.message = message;
        return this;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public Dispute setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
        return this;
    }
}
