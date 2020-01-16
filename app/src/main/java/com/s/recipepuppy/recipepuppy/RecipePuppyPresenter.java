package com.s.recipepuppy.recipepuppy;

import com.s.recipepuppy.domain.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipePuppyPresenter implements RecipePuppyContract.Presenter {

    private RecipePuppyContract.View mView;
    private RecipePuppyContract.Model mModel;


    private final List<Recipe> mRecipes = new ArrayList<>();

    @Override
    public void onButtonWasClicked() {

    }

}
