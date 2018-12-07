package govender.kevashan.com.bakingapp.viewrecipes.task;

import android.os.AsyncTask;

import govender.kevashan.com.bakingapp.viewrecipes.widget.IGetRecipeForWidgetView;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.IRecipeRepo;

public class GetRecipeForWidgetTask extends AsyncTask<Void, Void, Recipe> {

    private IRecipeRepo recipeRepo;
    private int id;
    private IGetRecipeForWidgetView view;

    public GetRecipeForWidgetTask(IRecipeRepo recipeRepo, int id, IGetRecipeForWidgetView view) {
        this.recipeRepo = recipeRepo;
        this.id = id;
        this.view = view;
    }

    @Override
    protected Recipe doInBackground(Void... voids) {
        return recipeRepo.getRecipeForWidget(id);
    }

    @Override
    protected void onPostExecute(Recipe recipe) {
        super.onPostExecute(recipe);

        view.showIngredients(recipe);
    }
}
