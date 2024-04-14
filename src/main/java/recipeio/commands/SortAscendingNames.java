//@@ author PDHung1104
package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Command for sorting recipes by ascending name in lexicographical order.
 */
public class SortAscendingNames {
    /**
     * Sort recipes by ascending name in lexicographical order.
     *
     * @param recipes the list of recipes.
     * @return a list of recipes sorted by name.
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        recipes.sort(Comparator.comparing(Recipe::getName));
        return recipes;
    }
}
