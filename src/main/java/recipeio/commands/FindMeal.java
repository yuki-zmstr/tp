package recipeio.commands;

import recipeio.InputParser;
import recipeio.constants.CommandConstants;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.util.ArrayList;

import static recipeio.constants.CommandConstants.NO_CATEGORY_MATCHES;
import static recipeio.constants.CommandConstants.VALID_CATEGORY_MATCHES;

/**
 * Command for finding recipes based on a meal category.
 */
public class FindMeal {
    /**
     * Show a list of recipes with a given meal category.
     *
     * @param meal the user's meal search from the terminal.
     * @param recipes the current recipe list.
     */
    public static void execute(String meal, ArrayList<Recipe> recipes) {
        MealCategory mealCategory = InputParser.parseMealCriteria(meal);
        ArrayList<Recipe> matches = new ArrayList<>();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (recipe.category.equals(mealCategory)) {
                matches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }

        if (matches.isEmpty()) {
            System.out.println(NO_CATEGORY_MATCHES + meal);
            return;
        }

        System.out.println(VALID_CATEGORY_MATCHES + meal + "\n");
        UI.printRecipes(matches, listNumbers);
    }
}
