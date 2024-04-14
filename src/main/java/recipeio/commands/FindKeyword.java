package recipeio.commands;

import recipeio.constants.CommandConstants;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.util.ArrayList;

import static recipeio.constants.CommandConstants.NO_MATCHES_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_PROMPT;
import static recipeio.constants.CommandConstants.VALID_KEYWORD_MATCHES;

/**
 * Command for finding recipes based on a keyword.
 */
public class FindKeyword {
    /**
     * Executes the find command based on the user's input.
     *
     * @param keyword The keyword to be searched for.
     * @param recipes The list of current recipes.
     */
    public static void execute(String keyword, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(keyword)) {
                matches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }
        if (matches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            System.out.println(NO_MATCHES_PROMPT);
            return;
        }
        System.out.println(VALID_KEYWORD_MATCHES + keyword + "\n");
        UI.printRecipes(matches, listNumbers);
    }
}
