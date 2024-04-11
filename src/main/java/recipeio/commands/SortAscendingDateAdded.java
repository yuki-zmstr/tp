package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collections;

public class SortAscendingDateAdded {
    /**
     * Sort recipes by ascending date added
     * @param recipes the list of recipes
     * @return a list of recipes sorted by date added
     */
    public static ArrayList<Recipe> execute (ArrayList<Recipe> recipes) {
        ArrayList<Recipe> copy = new ArrayList<>(recipes);
        Collections.sort(copy, (o1, o2) -> o1.getDateAdded().compareTo(o2.getDateAdded()));
        return copy;
    }
}
