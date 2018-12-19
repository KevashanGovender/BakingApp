package govender.kevashan.com.bakingapp.viewrecipes.task;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.IGetRecipes;

public class RecipeTaskFactory {

    public GetRecipesTask getRecipesTask(IRecipeRepo recipeRepo, IGetRecipes view){
        return new GetRecipesTask(recipeRepo, view);
    }
}
