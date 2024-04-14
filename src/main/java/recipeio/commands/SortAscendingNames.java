package recipeio.commands;

import java.util.ArrayList;
import recipeio.recipe.Recipe;
import java.util.Collections;

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
        Collections.sort(recipes, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return recipes;
    }
}
