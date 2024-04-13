package recipeio.commands;

import recipeio.enums.SortType;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import java.io.IOException;
import java.util.ArrayList;

import static recipeio.constants.CommandConstants.EMPTY_RECIPE_ERROR;

public class ListRecipeWithSortCommand {
    private static final String RECIPE_SUMMARY = "Here's your sorted list: ";
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
        }
    }
}
