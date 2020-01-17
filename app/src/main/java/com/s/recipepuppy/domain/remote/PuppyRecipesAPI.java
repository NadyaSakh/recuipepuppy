package com.s.recipepuppy.domain.remote;

import com.s.recipepuppy.domain.pojo.RecipesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PuppyRecipesAPI {
    /**
     * метод получения списка рецептов
     */
    @GET("?") //todo: @Query должен автоматически подставлять '?'
    Single<RecipesResponse> fetchPuppyRecipes(
            @Query("i") String ingredients,
            @Query("q") String query,
            @Query("p") int pages
    );
}
