package com.s.recipepuppy.recipepuppy;

import com.s.recipepuppy.domain.pojo.Recipe;
import com.s.recipepuppy.domain.pojo.RecipesResponse;

import java.util.List;

class RecipePuppyContract {
    interface View {
        //methods обработка ошибок, сообщения
        void showError(String errorStr);
        void setRecipesToAdapter(final List<Recipe> fetchedRecipes);
        void setRecipesResponse(RecipesResponse recipesResponse);
    }

    interface Presenter {
        void fetchRecipes(); // fetch рецептов
        void onDestroy(); // удалять подписки
    }
}
