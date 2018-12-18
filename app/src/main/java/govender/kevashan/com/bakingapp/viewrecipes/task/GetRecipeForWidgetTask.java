package govender.kevashan.com.bakingapp.viewrecipes.task;

import android.os.AsyncTask;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;

public class GetRecipeForWidgetTask extends AsyncTask<Void, Void, Recipe> {

    private IRecipeRepo recipeRepo;
    private int id;

    public GetRecipeForWidgetTask(IRecipeRepo recipeRepo, int id) {
        this.recipeRepo = recipeRepo;
        this.id = id;
    }

    @Override
    protected Recipe doInBackground(Void... voids) {
        return recipeRepo.getRecipeForWidget(id);
    }
}
