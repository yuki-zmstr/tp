package recipeio;

import recipeio.recipe.Recipe;

import java.util.ArrayList;

public class Utils {

    public static boolean isParsableAsInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("\tParameter cannot be parsed as an integer");
            System.out.println("\tPlease enter an integer from 1 onwards");
            return false;
        }
    }

    public static boolean isWithinRange(ArrayList<Recipe> recipes, int index) {
        if (index > recipes.size() || index < 1) {
            System.out.println("\tSorry, there is no recipe at index: " + index);
            System.out.println("\tYou currently have: " + recipes.size() + " recipes");
            return false;
        }
        return true;
    }
}
