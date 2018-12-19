package govender.kevashan.com.bakingapp.viewrecipes.viewmodel;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Ingredient;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.widget.RecipeWidget;


public class Util {

    private static final String RECIPE_PREF_WIDGET = "recipe_pref_widget";
    private static final String RECIPE_ID = "ingredients";

    public static void writePrefferedRecipe(Context context, Recipe recipe){

        String s1 = Converter.ingredientsListToString(recipe.getIngredients());
        context.getSharedPreferences(RECIPE_PREF_WIDGET, Context.MODE_PRIVATE)
                .edit()
                .putString(RECIPE_ID, s1)
                .apply();

        updateWidgets(context);
    }

    public static List<Ingredient> getPrefferedRecipe(Context context){
        String id = context.getSharedPreferences(RECIPE_PREF_WIDGET, Context.MODE_PRIVATE)
                .getString(RECIPE_ID, "1");
        return Converter.ingredientsStringToList(id);
    }

    private static void updateWidgets(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] ids = appWidgetManager.getAppWidgetIds(new ComponentName(context, RecipeWidget.class));

        Intent intent = new Intent(context.getApplicationContext(), RecipeWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        context.sendBroadcast(intent);
    }
}
