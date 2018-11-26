package govender.kevashan.com.bakingapp.viewrecipes.task;

import android.os.AsyncTask;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.IGetRecipes;

public class GetRecipesTask extends AsyncTask<Void, Void, List<Recipe>> {

    private IRecipeRepo repo;
    private IGetRecipes view;

    public GetRecipesTask(IRecipeRepo repo, IGetRecipes view) {
        this.repo = repo;
        this.view = view;
    }

    @Override
    protected List<Recipe> doInBackground(Void... voids) {
        return repo.getRecipes();
    }

    @Override
    protected void onPostExecute(List<Recipe> recipes) {
        super.onPostExecute(recipes);
        view.onSuccess(recipes);
    }
}
