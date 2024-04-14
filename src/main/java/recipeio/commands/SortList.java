package recipeio.commands;

import recipeio.enums.SortType;
import recipeio.recipe.Recipe;

import java.util.ArrayList;

public class SortList {
    /**
     * Sort the list by different type, such as calories, cook time, name, and date added
     * @param recipes list of recipes
     * @param sortType specify which attribute to sort by
     * @return a sorted ArrayList of recipes sorted by the specified sort type
     */
    public static ArrayList<Recipe> execute(ArrayList<Recipe> recipes, SortType sortType) {
        ArrayList<Recipe> temp;
        switch (sortType) {
        case DATE:
            temp = SortAscendingDateAdded.execute(recipes);
            break;
        case COOK_TIME:
            temp = SortAscendingCookTime.execute(recipes);
            break;
        case CALORIES:
            temp = SortAscendingCalories.execute(recipes);
            break;
        default:
            temp = SortAscendingNames.execute(recipes);
        }
        return temp;
    }
}
