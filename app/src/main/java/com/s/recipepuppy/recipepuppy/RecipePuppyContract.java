package com.s.recipepuppy.recipepuppy;

import java.util.List;

public class RecipePuppyContract {
    interface View {
        //methods
    }

    interface Presenter {
        void onButtonWasClicked();
    }

    interface Model {
        List loadRecipes();
    }
}
