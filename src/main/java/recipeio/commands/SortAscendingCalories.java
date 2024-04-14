//@@ author PDHung1104
package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Command for sorting recipes by ascending calories.
 */
public class SortAscendingCalories {
    /**
     * Sort recipes by ascending calories.
     *
     * @param recipes the list of recipes.
     * @return a list of recipes sorted by calories.
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        recipes.sort(Comparator.comparing(Recipe::getCalories));
        return recipes;
    }
}
