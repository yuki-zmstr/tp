package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;
import static recipeio.constants.CommandConstants.EMPTY_RECIPE_ERROR;
import static recipeio.constants.CommandConstants.RECIPE_SUMMARY;
import static recipeio.constants.CommandConstants.RECIPE_DETAILS_PROMPT;

public class ListRecipeCommand {

    /**
     * Lists the recipes in the list.
     *
     * @param recipes The list of current recipes.
     */
    public static void execute(ArrayList<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println(EMPTY_RECIPE_ERROR);
            return;
        }
        System.out.println(RECIPE_SUMMARY);
        recipes.forEach(recipe -> System.out.println("\t" + recipe));
        System.out.println(RECIPE_DETAILS_PROMPT);
    }
}
