package recipeio.commands;

import recipeio.CommandValidator;
import recipeio.constants.CommandConstants;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.util.ArrayList;

import static recipeio.constants.CommandConstants.NO_MATCHES_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_PROMPT;
import static recipeio.constants.CommandConstants.VALID_KEYWORD_MATCHES;

public class FindKeyword {
    public static void execute(String keyword, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (CommandValidator.splitName(recipe.getName()).contains(keyword)) {
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
