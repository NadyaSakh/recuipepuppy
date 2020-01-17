package com.s.recipepuppy.recipepuppy;

import android.util.Log;

import com.s.recipepuppy.domain.pojo.Recipe;
import com.s.recipepuppy.domain.pojo.Recipes;

import java.util.List;

import io.reactivex.disposables.Disposable;

public class RecipePuppyPresenter implements RecipePuppyContract.Presenter {
    private static final String TAG = RecipePuppyPresenter.class.getSimpleName();

    private RecipePuppyContract.View mView;
    private RecipesRepository mRepository;
    private Disposable mRequest;

    RecipePuppyPresenter(RecipePuppyContract.View mView) {
        this.mView = mView;
        this.mRepository = new RecipesRepository();
    }

    @Override
    public void fetchRecipes() {
        mRequest = mRepository.loadRecipes()
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(Recipes recipes){
        Log.d(TAG, recipes.toString());
        List<Recipe> recipeList = recipes.getResults();
        mView.setRecipesToAdapter(recipeList);
    }

    private void onError(Throwable e){
        e.printStackTrace();
        Log.d(TAG, e.getMessage());
        mView.showError("Рецепты не загружены!");
    }

    @Override
    public void onDestroy() {
        if(mRequest != null && !mRequest.isDisposed())
            mRequest.dispose();
    }
}
