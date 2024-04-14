package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Command for sorting recipes by ascending date added.
 */
public class SortAscendingDateAdded {
    /**
     * Sort recipes by ascending date added.
     *
     * @param recipes the list of recipes.
     * @return a list of recipes sorted by date added.
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        Collections.sort(recipes, (o1, o2) -> o1.getDateAdded().compareTo(o2.getDateAdded()));
        return recipes;
    }
}
