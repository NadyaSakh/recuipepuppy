package com.s.recipepuppy.recipepuppy;

import android.util.Log;

import com.s.recipepuppy.App;
import com.s.recipepuppy.domain.pojo.Recipes;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class RecipesRepository {
    private static final String TAG = "RecipesRepository";

    RecipesRepository() { }

    Single<Recipes> loadRecipes() {
        Log.d(TAG, "Start loading");
        return App.api().fetchPuppyRecipes("onions,garlic", "omelet", 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
