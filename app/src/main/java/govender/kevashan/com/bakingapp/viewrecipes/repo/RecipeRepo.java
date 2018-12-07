package govender.kevashan.com.bakingapp.viewrecipes.repo;

import java.io.IOException;
import java.util.List;

import govender.kevashan.com.bakingapp.model.Ingredient;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.database.RecipeDb;
import govender.kevashan.com.bakingapp.viewrecipes.service.IRecipeService;

public class RecipeRepo implements IRecipeRepo {

    private IRecipeService service;
    private RecipeDb db;

    public RecipeRepo(IRecipeService service, RecipeDb db) {
        this.service = service;
        this.db = db;
    }

    public RecipeRepo(RecipeDb db) {
        this.db = db;
    }

    @Override
    public List<Recipe> getRecipes() {
        try {
            return service.getRecipes().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertRecipe(Recipe recipe) {
        db.daoAccess().insertRecipe(recipe);
    }

    @Override
    public Recipe getRecipeForWidget(int id) {
        return db.daoAccess().getRecipe(id);
    }
}
