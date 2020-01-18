package com.s.recipepuppy.domain.pojo;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipesResponse {
    @SerializedName("title")
    private String title;

    @SerializedName("version")
    private Float version;

    @SerializedName("href")
    private String href;

    @SerializedName("results")
    private List<Recipe> results = new ArrayList<>();

    public RecipesResponse() {

    }

    public RecipesResponse(final RecipesResponse other) {
        this.title = other.title;
        this.version = other.version;
        this.href = other.href;
        this.results = other.results;
    }

    public String getTitle() {
        return title;
    }

    public Float getVersion() {
        return version;
    }

    public String getHref() {
        return href;
    }

    public List<Recipe> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "RecipesResponse{" +
                "title='" + title + '\'' +
                ", version=" + version +
                ", href='" + href + '\'' +
                ", results=" + results +
                '}';
    }
}
