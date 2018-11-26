package govender.kevashan.com.bakingapp.viewrecipes.viewmodel;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;

public interface IGetRecipes {

    void onSuccess(List<Recipe> recipes);
}
