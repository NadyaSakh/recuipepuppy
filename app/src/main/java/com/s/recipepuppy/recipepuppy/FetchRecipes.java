package com.s.recipepuppy.recipepuppy;

import android.util.Log;

import java.util.List;

public class FetchRecipes implements RecipePuppyContract.Model{
    private static final String TAG = "FetchRecipes";

    @Override
    public List loadRecipes() {
        Log.d(TAG, "Start loading");
        return null;
    }
}
