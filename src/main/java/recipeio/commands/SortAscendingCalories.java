package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collections;

public class SortAscendingCalories {
    /**
     * Sort recipes by ascending calories
     * @param recipes the list of recipes
     * @return a list of recipes sorted by calories
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        ArrayList<Recipe> copy = new ArrayList<>(recipes);
        Collections.sort(copy, (o1, o2) -> new Integer(o1.getCalories()).compareTo(new Integer(o2.getCalories())));
        return copy;
    }
}
