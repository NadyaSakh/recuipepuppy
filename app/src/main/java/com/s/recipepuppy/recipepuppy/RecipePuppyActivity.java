package com.s.recipepuppy.recipepuppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.s.recipepuppy.R;
import com.s.recipepuppy.domain.pojo.Recipe;
import com.s.recipepuppy.domain.pojo.RecipesResponse;

import java.util.List;

public class RecipePuppyActivity extends AppCompatActivity implements RecipePuppyContract.View {
    private static final String TAG = RecipePuppyActivity.class.getSimpleName();
    public static final String RECIPES_KEY = "RECIPES_KEY";
    private RecipePuppyAdapter mAdapterRecipes;
    private RecipePuppyContract.Presenter mPresenter;
    private RecipesResponse mRecipesResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_puppy);
        mPresenter = new RecipePuppyPresenter(this);
        initRecyclerView();
        if (savedInstanceState != null) {
            String savedRecipeResponse = savedInstanceState.getString(RECIPES_KEY, "Данные не сохранены");
            mRecipesResponse = new Gson().fromJson(savedRecipeResponse, RecipesResponse.class);
            mAdapterRecipes.addAllRecipes(mRecipesResponse.getResults());;
        }
        else{
            mPresenter.fetchRecipes();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        if(!mRecipesResponse.getResults().isEmpty()){
            String recipesJson = new Gson().toJson(mRecipesResponse);
            outState.putString(RECIPES_KEY, recipesJson);
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void initRecyclerView() {
        mAdapterRecipes = new RecipePuppyAdapter();
        RecyclerView recyclerRecipesView = findViewById(R.id.rv_recipes_list);

        recyclerRecipesView.setAdapter(mAdapterRecipes);
        recyclerRecipesView.setHasFixedSize(true);
    }

    public void setRecipesToAdapter(final List<Recipe> fetchedRecipes) {
        mAdapterRecipes.addAllRecipes(fetchedRecipes);
    }

    public void setRecipesResponse(RecipesResponse recipesResponse){
        mRecipesResponse = recipesResponse;
    }

    @Override
    public void showError(String errorStr) {
        Log.e(TAG, errorStr);
        Toast.makeText(this, errorStr, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        Log.d(TAG, "OnDestroy");
        super.onDestroy();
    }
}
