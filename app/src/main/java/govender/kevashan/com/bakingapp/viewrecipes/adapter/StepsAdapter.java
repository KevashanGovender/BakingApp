package govender.kevashan.com.bakingapp.viewrecipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import govender.kevashan.com.bakingapp.R;
import govender.kevashan.com.bakingapp.model.Step;
import govender.kevashan.com.bakingapp.viewrecipes.view.RecipeStepActivity;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsViewHolder> {

    private List<Step> steps;
    private Context context;

    public StepsAdapter(List<Step> steps, Context context) {
        this.steps = steps;
        this.context = context;
    }

    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.steps_item,
                viewGroup, false);
        return new StepsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder stepsViewHolder, int i) {

        stepsViewHolder.description.setText(steps.get(i).getShortDescription());
        stepsViewHolder.description.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecipeStepActivity.class);
            intent.putExtra(RecipeStepActivity.ID, steps.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    class StepsViewHolder extends RecyclerView.ViewHolder{

        TextView description;

        public StepsViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.step_description_tv);
        }
    }
}
