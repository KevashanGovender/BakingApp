package govender.kevashan.com.bakingapp.viewrecipes.service;

import java.util.List;

import govender.kevashan.com.bakingapp.model.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IRecipeService {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getRecipes();
}
