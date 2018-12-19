package govender.kevashan.com.bakingapp.viewrecipes.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import govender.kevashan.com.bakingapp.R;

import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.Util;
import govender.kevashan.com.bakingapp.model.Recipe;
import govender.kevashan.com.bakingapp.viewrecipes.repo.RecipeRepo;
import govender.kevashan.com.bakingapp.viewrecipes.service.IRecipeService;
import govender.kevashan.com.bakingapp.viewrecipes.service.RetrofitClientInstance;
import govender.kevashan.com.bakingapp.viewrecipes.task.RecipeTaskFactory;
import govender.kevashan.com.bakingapp.viewrecipes.viewmodel.GetRecipeViewmodel;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity implements IGetRecipeViews {

    private boolean mTwoPane;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.recipe_detail_container) != null) {
            mTwoPane = true;
        }

        recyclerView = findViewById(R.id.recipe_list);
        assert recyclerView != null;

        RecipeRepo recipeRepo = new RecipeRepo(RetrofitClientInstance.getRetrofitInstance().create(IRecipeService.class));
        GetRecipeViewmodel viewModel = new GetRecipeViewmodel(recipeRepo, new RecipeTaskFactory(), this);

        viewModel.getRecipes();
    }

    @Override
    public void displayRecipes(List<Recipe> recipes) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, recipes, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final RecipeListActivity mParentActivity;
        private final List<Recipe> mValues;
        private final boolean mTwoPane;

        SimpleItemRecyclerViewAdapter(RecipeListActivity parent,
                                      List<Recipe> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mContentView.setText(mValues.get(position).getName());
            holder.itemView.setOnClickListener(view -> {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putParcelable(RecipeDetailFragment.ARG_ITEM_ID, mValues.get(position));
                    RecipeDetailFragment fragment = new RecipeDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.recipe_detail_container, fragment)
                            .commit();
                    Util.writePrefferedRecipe(mParentActivity, mValues.get(position));
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, RecipeDetailActivity.class);
                    intent.putExtra(RecipeDetailFragment.ARG_ITEM_ID, mValues.get(position));
                    Util.writePrefferedRecipe(mParentActivity, mValues.get(position));
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = view.findViewById(R.id.id_text);
                mContentView = view.findViewById(R.id.content);
            }
        }
    }
}
