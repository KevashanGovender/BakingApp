package govender.kevashan.com.bakingapp.viewrecipes.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import govender.kevashan.com.bakingapp.model.Recipe;

@Database(entities = {Recipe.class}, version = 2, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class RecipeDb extends RoomDatabase {

    private static RecipeDb instance;

    public abstract DaoAccess daoAccess();

    public static RecipeDb getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, RecipeDb.class,
                    "recipe_widget").fallbackToDestructiveMigration().build();
        }
        return instance;
    }


}
