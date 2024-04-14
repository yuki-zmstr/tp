//@@ author PDHung1104
package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Comparator;

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
        recipes.sort(Comparator.comparing(Recipe::getCookTime));
        return recipes;
    }
}
