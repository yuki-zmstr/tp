package recipeio.commands;

import recipeio.recipe.Recipe;

import java.util.ArrayList;

public class ListRecipeCommand {

    /**
     * Lists the recipes in the list.
     *
     * @param recipes The list of current recipes.
     */
    public static void execute(ArrayList<Recipe> recipes) {
        if (recipes.isEmpty()) {
            System.out.println("\tSorry, there are no recipes in your recipe book to print.");
            return;
        }
        System.out.println("\tHere is a summary of your recipe book.");
        recipes.forEach(recipe -> System.out.println("\t\t" + recipe));
        System.out.println("\n\tTo find out more about a particular recipe, try the 'detail {index}' command.");
    }
}
