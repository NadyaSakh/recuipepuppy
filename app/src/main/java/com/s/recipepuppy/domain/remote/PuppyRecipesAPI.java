package com.s.recipepuppy.domain.remote;

import com.s.recipepuppy.domain.pojo.Recipes;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PuppyRecipesAPI {
    /**
     * метод получения списка рецептов
     */
    @GET("?")
    @Headers({"Content-Type: text/plain"})
    Single<Recipes> fetchPuppyRecipes(@Query("i") String ingredients, @Query("q") String query, @Query("p") int pages);
}
