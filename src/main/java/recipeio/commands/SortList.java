//@@author PDHung1104
package recipeio.commands;

import recipeio.enums.SortType;
import recipeio.recipe.Recipe;

import java.util.ArrayList;

/**
 * Command for sorting recipes by different types.
 */
public class SortList {
    /**
     * Sort the list by different type, such as calories, cook time, name, and date added.
     *
     * @param recipes list of recipes.
     * @param sortType specify which attribute to sort by.
     * @return a sorted ArrayList of recipes sorted by the specified sort type.
     */
    public static ArrayList<Recipe> execute(ArrayList<Recipe> recipes, SortType sortType) {
        ArrayList<Recipe> sortedRecipes;
        switch (sortType) {
        case DATE:
            sortedRecipes = SortAscendingDateAdded.execute(recipes);
            break;
        case COOK_TIME:
            sortedRecipes = SortAscendingCookTime.execute(recipes);
            break;
        case CALORIES:
            sortedRecipes = SortAscendingCalories.execute(recipes);
            break;
        default:
            sortedRecipes = SortAscendingNames.execute(recipes);
        }
        return sortedRecipes;
    }
}
