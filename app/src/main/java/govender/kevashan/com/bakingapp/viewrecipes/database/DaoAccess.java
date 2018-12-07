package govender.kevashan.com.bakingapp.viewrecipes.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;

@Dao
public interface DaoAccess {

    @Query("SELECT * FROM recipe_widget WHERE id =:id")
    Recipe getRecipe(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecipe(Recipe recipe);
}
