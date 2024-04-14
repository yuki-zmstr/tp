package recipeio.commands;

import recipeio.enums.SortType;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import java.util.ArrayList;

import static recipeio.constants.CommandConstants.EMPTY_RECIPE_ERROR;

/**
 * Command for listing all recipes in the list with a specified sort type.
 */
public class ListRecipeWithSortCommand {
    private static final String RECIPE_SUMMARY = "Here's your sorted list: ";

    /**
     * Prints the sorted list of recipes.
     *
     * @param recipes The list of current recipes.
     */
    private static void printSortedList(ArrayList<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println(EMPTY_RECIPE_ERROR);
            return;
        }
        System.out.println(RECIPE_SUMMARY);
        for (int i = 0; i < recipes.size(); i ++) {
            int printNumber = i + 1;
            System.out.println("\t" + printNumber + ". " + recipes.get(i));
        }
    }

    /**
     * Executes the list command with a specified sort type.
     *
     * @param recipes The list of current recipes.
     * @param sortType The type of sort to be executed.
     */
    public static void execute(ArrayList<Recipe> recipes, SortType sortType) {
        switch (sortType) {
        case NAME:
        case CALORIES:
        case COOK_TIME:
        case DATE:
            ArrayList<Recipe> listToBePrinted = SortList.execute(recipes, sortType);
            printSortedList(listToBePrinted);
            RecipeList.saveRecipes(recipes);
            break;
        default:
            ListRecipeCommand.execute(recipes);
            break;
        }
    }
}
