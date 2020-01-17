package com.s.recipepuppy.recipepuppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.s.recipepuppy.R;
import com.s.recipepuppy.domain.pojo.Recipe;

import java.util.List;

public class RecipePuppyActivity extends AppCompatActivity implements RecipePuppyContract.View{
    private static final String TAG = RecipePuppyActivity.class.getSimpleName();

    private RecipePuppyContract.Presenter mPresenter;
    private RecipePuppyAdapter mAdapterRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_puppy);

        mPresenter = new RecipePuppyPresenter(this);
        initRecyclerView();
        mPresenter.fetchRecipes();
    }

    private void initRecyclerView(){
        mAdapterRecipes = new RecipePuppyAdapter(this);
        RecyclerView recyclerRecipesView = findViewById(R.id.rv_recipes_list);

        try{
            ((SimpleItemAnimator) recyclerRecipesView.getItemAnimator()).setSupportsChangeAnimations(false);
        }
        catch (NullPointerException e){
            Log.e("Error set animator", e.toString());
        }

        recyclerRecipesView.setLayoutManager(new LinearLayoutManager(this));
        recyclerRecipesView.setAdapter(mAdapterRecipes);
        recyclerRecipesView.setHasFixedSize(true);
    }

    public void setRecipesToAdapter(final List<Recipe> fetchedRecipes){
        mAdapterRecipes.addAllRecipes(fetchedRecipes);
    }

    @Override
    public void showError(String errorStr) {
        Log.e(TAG, errorStr);
        Toast.makeText(this, errorStr, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        Log.d(TAG, "OnDestroy");
    }
}
