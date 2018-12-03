package govender.kevashan.com.bakingapp.viewrecipes.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Ingredient;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.RecipeViewHolder> {

    private List<Ingredient> ingredients;

    public IngredientsAdapter(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingredients_item,
                viewGroup, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        recipeViewHolder.ingredientName.setText(ingredients.get(i).getIngredient());
        recipeViewHolder.measureTv.setText(ingredients.get(i).getMeasure() + " " + ingredients.get(i).getQuantity());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView ingredientName;
        TextView measureTv;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientName = itemView.findViewById(R.id.ingredient_name_tv);
            measureTv = itemView.findViewById(R.id.measure_tv);
        }
    }
}
