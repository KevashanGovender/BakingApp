package govender.kevashan.com.bakingapp.viewrecipes.viewmodel;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.task.RecipeTaskFactory;
import govender.kevashan.com.bakingapp.viewrecipes.view.IGetRecipeViews;

public class GetRecipeViewmodel implements IGetRecipes {

    private IRecipeRepo recipeRepo;
    private RecipeTaskFactory taskFactory;
    private IGetRecipeViews view;

    public GetRecipeViewmodel(IRecipeRepo recipeRepo, RecipeTaskFactory taskFactory, IGetRecipeViews view) {
        this.recipeRepo = recipeRepo;
        this.taskFactory = taskFactory;
        this.view = view;
    }

    public void getRecipes(){
        taskFactory.getRecipesTask(recipeRepo, this).execute();
    }

    @Override
    public void onSuccess(List<Recipe> recipes) {
        view.displayRecipes(recipes);
    }
}
