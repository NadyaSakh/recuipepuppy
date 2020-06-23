package com.s.recipepuppy;

import com.google.gson.Gson;
import com.s.recipepuppy.domain.pojo.Recipe;
import com.s.recipepuppy.domain.pojo.RecipesResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PojoTest {
    private Recipe mRecipe;
    private RecipesResponse mRecipesResponse;
    private String json = "{\"title\":\"Recipe Puppy\",\"version\":0.1,\"href\":\"http:\\/\\/www.recipepuppy.com\\/\",\"results\":[{\"title\":\"Vegetable-Pasta Oven Omelet\",\"href\":\"http:\\/\\/find.myrecipes.com\\/recipes\\/recipefinder.dyn?action=displayRecipe&recipe_id=520763\",\"ingredients\":\"tomato, onions, red pepper, garlic, olive oil, zucchini, cream cheese, vermicelli, eggs, parmesan cheese, milk, italian seasoning, salt, black pepper\",\"thumbnail\":\"http:\\/\\/img.recipepuppy.com\\/560556.jpg\"},{\"title\":\"Roasted Pepper and Bacon Omelet\",\"href\":\"http:\\/\\/www.bigoven.com\\/43919-Roasted-Pepper-and-Bacon-Omelet-recipe.html\",\"ingredients\":\"eggs, salt, black pepper, butter, black pepper, bacon, onions, garlic, roasted red peppers, oregano, black pepper\",\"thumbnail\":\"\"}]}";

    @Before
    public void init(){
        Gson gson = new Gson();
        mRecipesResponse = gson.fromJson(json, RecipesResponse.class);
        mRecipe = mRecipesResponse.getResults().get(0);
    }

    @Test
    public void testRecipesResponseNotNull(){
        recipesResponseFieldsNotNull(mRecipesResponse);
    }

    @Test
    public void testRecipeNotNull(){
        recipeFieldsNotNull(mRecipe);
    }

    @Test
    public void testCopyConstructors(){
        Recipe newRecipe;
        RecipesResponse newRecipesResponse;

        newRecipe = new Recipe(mRecipe);
        newRecipesResponse = new RecipesResponse(mRecipesResponse);

        List<Recipe> recipes = newRecipesResponse.getResults();
        Assert.assertFalse(recipes.isEmpty());

        recipeFieldsNotNull(newRecipe);
        recipesResponseFieldsNotNull(newRecipesResponse);
    }

    private void recipesResponseFieldsNotNull(RecipesResponse recipesResponse){
        Assert.assertNotNull(recipesResponse);
        Assert.assertNotNull(recipesResponse.getHref());
        Assert.assertNotNull(recipesResponse.getResults());
        Assert.assertNotNull(recipesResponse.getTitle());
        Assert.assertNotNull(recipesResponse.getVersion());
    }

    private void recipeFieldsNotNull(Recipe recipe){
        Assert.assertNotNull(recipe);
        Assert.assertNotNull(recipe.title());
        Assert.assertNotNull(recipe.href());
        Assert.assertNotNull(recipe.ingredients());
        Assert.assertNotNull(recipe.thumbnail());
    }

}
