package govender.kevashan.com.bakingapp.viewrecipes.repo;

import java.util.List;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Ingredient;
import govender.kevashan.com.bakingapp.model.Recipe;

public interface IRecipeRepo {

    List<Recipe> getRecipes();
    void insertRecipe(Recipe ingredients);
    Recipe getRecipeForWidget(int id);
}
