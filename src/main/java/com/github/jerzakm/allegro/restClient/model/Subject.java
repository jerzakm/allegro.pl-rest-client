package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subject {
    @SerializedName("name")
    @Expose
    private String name;
    public Subject() {
    }

    public String getSubject() {
        return name;
    }

    public Subject setSubject(String name) {
        this.name = name;
        return this;
    }

    public static class UserRating {
        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("createdAt")
        @Expose
        private String createdAt;

        @SerializedName("recommended")
        @Expose
        private boolean recommended;

        @SerializedName("buyer")
        @Expose
        private BuyerInfo buyerInfo;

        @SerializedName("comment")
        @Expose
        private String comment;

        @SerializedName("rates")
        @Expose
        private Rates rates;

        @SerializedName("order")
        @Expose
        private RatedOrder ratedOrder;

        @SerializedName("answer")
        @Expose
        private RateMessage answer;

        @SerializedName("removal")
        @Expose
        private RateRemovalRequest removalRequest;

        @SerializedName("excludedFromAverageRates")
        @Expose
        private boolean excludedFromAverageRates;

        public UserRating() {
        }

        public String getId() {
            return id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public boolean isRecommended() {
            return recommended;
        }

        public BuyerInfo getBuyerInfo() {
            return buyerInfo;
        }

        public String getComment() {
            return comment;
        }

        public Rates getRates() {
            return rates;
        }

        public RatedOrder getRatedOrder() {
            return ratedOrder;
        }

        public RateMessage getAnswer() {
            return answer;
        }

        public RateRemovalRequest getRemovalRequest() {
            return removalRequest;
        }

        public boolean isExcludedFromAverageRates() {
            return excludedFromAverageRates;
        }
    }
}
