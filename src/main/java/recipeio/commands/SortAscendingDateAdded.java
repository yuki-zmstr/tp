//@@ author PDHung1104
package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Comparator;

public class SortAscendingDateAdded {
    /**
     * Sort recipes by ascending date added
     * @param recipes the list of recipes
     * @return a list of recipes sorted by date added
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        ArrayList<Recipe> sortedRecipes = new ArrayList<>(recipes);
        sortedRecipes.sort(Comparator.comparing(Recipe::getDateAdded));
        return sortedRecipes;
    }
}
