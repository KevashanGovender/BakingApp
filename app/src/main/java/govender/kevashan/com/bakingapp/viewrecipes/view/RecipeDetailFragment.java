package govender.kevashan.com.bakingapp.viewrecipes.view;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.adapter.IngredientsAdapter;

public class RecipeDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Recipe recipe;

    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            recipe = getArguments().getParcelable(ARG_ITEM_ID);

            Activity activity = this.getActivity();
            assert activity != null;
            CollapsingToolbarLayout appBarLayout = activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(recipe.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_detail_fragment, container, false);

        RecyclerView ingredientRv = rootView.findViewById(R.id.ingredients_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ingredientRv.setLayoutManager(layoutManager);

        IngredientsAdapter adapter = new IngredientsAdapter(recipe.getIngredients());
        ingredientRv.setAdapter(adapter);

        return rootView;
    }
}
