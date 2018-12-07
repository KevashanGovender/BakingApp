package govender.kevashan.com.bakingapp.viewrecipes.task;

import android.os.AsyncTask;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.repo.RecipeRepo;

public class InsertRecipeTask extends AsyncTask<Void, Void, Void> {

    private IRecipeRepo recipeRepo;
    private Recipe recipe;

    public InsertRecipeTask(IRecipeRepo recipeRepo, Recipe recipe) {
        this.recipeRepo = recipeRepo;
        this.recipe = recipe;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        recipeRepo.insertRecipe(recipe);
        return null;
    }
}
