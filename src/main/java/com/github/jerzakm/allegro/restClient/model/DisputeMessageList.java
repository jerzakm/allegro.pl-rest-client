package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisputeMessageList {
    @SerializedName("messages")
    @Expose
    private List<DisputeMessage> messages;


    public DisputeMessageList() {
    }

    public List<DisputeMessage> getMessages() {
        return messages;
    }

    public DisputeMessageList setMessages(List<DisputeMessage> messages) {
        this.messages = messages;
        return this;
    }
}
