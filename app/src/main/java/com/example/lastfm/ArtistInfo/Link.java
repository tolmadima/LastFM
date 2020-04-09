package com.example.lastfm.ArtistInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Link {

    @SerializedName("#text")
    @Expose
    private String text;
    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("href")
    @Expose
    private String href;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
