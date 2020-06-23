package com.s.recipepuppy;

import android.util.Log;

import com.s.recipepuppy.domain.remote.ApiClient;

import org.junit.Assert;
import org.junit.Test;


public class FetchRecipesTest {

    @Test
    public void testFetchRecipes() {
        ApiClient api = ApiClient.instance();
        api.puppyRecipesAPI()
                .fetchPuppyRecipes("onions,garlic", "omelet", 3)
                .map(response -> {
                    Log.w("RESULT: ", response.toString());
                    return response;
                })
                .doOnError((e) -> {
                    String errorMessage = e.getMessage();
                    Log.e("ERROR WHILE FETCHING", errorMessage);
                    Assert.fail(errorMessage);
                })
                .test()
                .assertNoErrors()
                .assertComplete();

    }
}
