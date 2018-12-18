package govender.kevashan.com.bakingapp.viewrecipes.widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;
import java.util.concurrent.ExecutionException;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Ingredient;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.database.RecipeDb;
import govender.kevashan.com.bakingapp.viewrecipes.repo.RecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.task.GetRecipeForWidgetTask;
import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.Util;

public class RecipeWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteRecipeIngredientsItemViewFactory(getApplicationContext());
    }

    public class RemoteRecipeIngredientsItemViewFactory implements RemoteViewsService.RemoteViewsFactory{

        private final RecipeRepo recipeRepo;
        private List<Ingredient> ingredients;
        private Context context;
        private GetRecipeForWidgetTask task;
        private Recipe global;

        public RemoteRecipeIngredientsItemViewFactory(Context context) {
            this.context = context;
            recipeRepo = new RecipeRepo(RecipeDb.getInstance(context));
            task = new GetRecipeForWidgetTask(recipeRepo, Util.getPrefferedRecipe(context));
            try {
                global = task.execute().get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            ingredients = global.getIngredients();
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public RemoteViews getViewAt(int i) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_item);
            views.setTextViewText(R.id.ingredient_item_text_view, ingredients.get(i).toString());
            return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 0;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }
    }
}
