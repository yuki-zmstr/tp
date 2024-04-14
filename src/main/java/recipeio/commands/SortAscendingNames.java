//@@ author PDHung1104
package recipeio.commands;

import java.util.ArrayList;
import recipeio.recipe.Recipe;
import java.util.Comparator;

public class SortAscendingNames {
    /**
     * Sort recipes by ascending name in lexicographical order
     * @param recipes the list of recipes
     * @return a list of recipes sorted by name
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        ArrayList<Recipe> sortedRecipes = new ArrayList<>(recipes);
        sortedRecipes.sort(Comparator.comparing(Recipe::getName));
        return sortedRecipes;
    }
}
