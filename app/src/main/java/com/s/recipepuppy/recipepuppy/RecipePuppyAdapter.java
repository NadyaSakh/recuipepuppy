package com.s.recipepuppy.recipepuppy;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.s.recipepuppy.R;
import com.s.recipepuppy.domain.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipePuppyAdapter extends RecyclerView.Adapter<RecipePuppyAdapter.RecipeViewHolder> {
    private final static String TAG = RecipePuppyAdapter.class.getSimpleName();

    private List<Recipe> mRecipeList = new ArrayList<>();

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View viewHolder = inflater.inflate(R.layout.item_recipe_list, viewGroup, false);
        return new RecipeViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        final Recipe recipe = mRecipeList.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    void addAllRecipes(List<Recipe> list) {
        Log.d(TAG, "Добавление всех рецептов в адаптер");
        mRecipeList.clear();
        mRecipeList.addAll(list);
        notifyDataSetChanged();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        final private TextView mTitle;
        final private TextView mIngredients;
        final private ImageView mImage;

        RecipeViewHolder(View itemView){
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mIngredients = itemView.findViewById(R.id.tv_ingredients);
            mImage = itemView.findViewById(R.id.iv_recipe_item_image);
        }

        private void bind(Recipe recipe) {
            mTitle.setText(recipe.title().replace("\n", ""));
            mIngredients.setText(recipe.ingredients());
            String link = recipe.thumbnail();
            if (!link.isEmpty()) {
                Glide.with(itemView.getContext())
                        .load(link)
                        .into(mImage);
            }
        }
    }
}
