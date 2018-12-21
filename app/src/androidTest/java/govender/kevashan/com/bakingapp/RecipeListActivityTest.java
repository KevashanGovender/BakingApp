package govender.kevashan.com.bakingapp;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import govender.kevashan.com.bakingapp.Util.RecyclerViewMatcher;
import govender.kevashan.com.bakingapp.viewrecipes.view.RecipeDetailActivity;
import govender.kevashan.com.bakingapp.viewrecipes.view.RecipeListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class RecipeListActivityTest {

    private static final int RECIPE_LIST_ID = R.id.recipe_list;

    @Rule
    public ActivityTestRule<RecipeListActivity> activityTestRule =
            new ActivityTestRule<>(RecipeListActivity.class);


    @Test
    public void shouldDisplayARecyclerView(){
        onView(withId(RECIPE_LIST_ID)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayEachRecipeInRecyclerView(){
        onView(withRecyclerView().atPositionOnView(0, R.id.content))
                .check(matches(isDisplayed()))
                .check(matches(withText("Nutella Pie")));

        onView(withRecyclerView().atPositionOnView(1, R.id.content))
                .check(matches(isDisplayed()))
                .check(matches(withText("Brownies")));

        onView(withRecyclerView().atPositionOnView(2, R.id.content))
                .check(matches(isDisplayed()))
                .check(matches(withText("Yellow Cake")));


        onView(withRecyclerView().atPositionOnView(3, R.id.content))
                .check(matches(isDisplayed()))
                .check(matches(withText("Cheesecake")));
    }

    @Test
    public void onRecipeListItemClick_ShouldLaunchRecipeDetailActivity(){
        Intents.init();


        onView(withRecyclerView()
                .atPosition(0))
                .perform(click());

        intended(hasComponent(RecipeDetailActivity.class.getName()));

        Intents.release();
    }

    private static RecyclerViewMatcher withRecyclerView() {
        return new RecyclerViewMatcher(RecipeListActivityTest.RECIPE_LIST_ID);
    }
}
