package govender.kevashan.com.bakingapp.viewrecipes.viewmodel;

import android.content.Context;


public class Util {

    private static final String RECIPE_PREF_WIDGET = "recipe_pref_widget";
    private static final String RECIPE_ID = "recipe_id";

    public static void writePrefferedRecipe(Context context, int id){
        context.getSharedPreferences(RECIPE_PREF_WIDGET, Context.MODE_PRIVATE)
                .edit()
                .putString(RECIPE_ID, String.valueOf(id))
                .apply();
    }

    public static int getPrefferedRecipe(Context context){
        String id = context.getSharedPreferences(RECIPE_PREF_WIDGET, Context.MODE_PRIVATE)
                .getString(RECIPE_ID, "1");
        return Integer.valueOf(id);
    }
}
