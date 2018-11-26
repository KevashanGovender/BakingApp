package govender.kevashan.com.bakingapp.viewrecipes.repo;

import java.io.IOException;
import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.service.IRecipeService;

public class RecipeRepo implements IRecipeRepo {

    private IRecipeService service;

    public RecipeRepo(IRecipeService service) {
        this.service = service;
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
}
