package govender.kevashan.com.bakingapp.viewrecipes.widget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Ingredient;
import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.Util;

public class RecipeWidgetService extends RemoteViewsService  {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RemoteRecipeIngredientsItemViewFactory(this.getApplicationContext());
    }

    public class RemoteRecipeIngredientsItemViewFactory implements RemoteViewsService.RemoteViewsFactory{

        private List<Ingredient> ingredients;
        private Context context;

        public RemoteRecipeIngredientsItemViewFactory(Context context) {
            this.context = context;
        }

        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            ingredients = Util.getPrefferedRecipe(context);
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return ingredients.size();
        }

        @Override
        public RemoteViews getViewAt(int i) {
            System.out.println("[wtf] getViewAt");
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_item);
            views.setTextViewText(R.id.ingredient_item_text_view, ingredients.get(i).getIngredient());
            return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
