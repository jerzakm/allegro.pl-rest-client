package com.github.jerzakm.allegro.restClient.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("promoted")
    @Expose
    private List<ListingOffer> promoted = null;
    @SerializedName("regular")
    @Expose
    private List<ListingOffer> regular = null;

    public List<ListingOffer> getPromoted() {
        return promoted;
    }

    public void setPromoted(List<ListingOffer> promoted) {
        this.promoted = promoted;
    }

    public List<ListingOffer> getRegular() {
        return regular;
    }

    public void setRegular(List<ListingOffer> regular) {
        this.regular = regular;
    }

}
