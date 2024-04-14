package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Command for sorting recipes by ascending cook time.
 */
public class SortAscendingCookTime {
    /**
     * Sort recipes by ascending cook time.
     *
     * @param recipes the list of recipes.
     * @return a list of recipes sorted by cook time.
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        Collections.sort(recipes, (o1, o2) -> new Integer(o1.getCookTime()).compareTo(new Integer(o2.getCookTime())));
        return recipes;
    }
}
