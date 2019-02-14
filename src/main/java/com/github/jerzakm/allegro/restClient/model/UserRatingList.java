package com.github.jerzakm.allegro.restClient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserRatingList {
    @SerializedName("ratings")
    @Expose
    List<Subject.UserRating> ratings;

    public UserRatingList() {
    }

    public List<Subject.UserRating> getRatings() {
        return ratings;
    }
}
