package com.s.recipepuppy.domain.pojo;

import com.google.gson.annotations.SerializedName;


public class Recipe {
    @SerializedName("title")
    private String title;

    @SerializedName("href")
    private String href;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("thumbnail")
    private String thumbnail;

    public Recipe() {
    }

    public Recipe(Recipe other) {
        this.title = other.title;
        this.href = other.href;
        this.ingredients = other.ingredients;
        this.thumbnail = other.thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
