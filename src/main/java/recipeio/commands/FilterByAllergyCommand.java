package recipeio.commands;

import recipeio.InputParser;
import recipeio.constants.CommandConstants;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.util.ArrayList;
import static recipeio.constants.CommandConstants.RECIPES_INCLUDED;
import static recipeio.constants.CommandConstants.RECIPES_EXCLUDED;

/**
 * Command for filtering recipes by allergy.
 */
public class FilterByAllergyCommand {

    /**
     * Shows a list of recipes that do not contain the given allergy.
     *
     * @param userInput User's input in the command line.
     * @param recipes The list of current recipes.
     */
    public static void execute(String userInput, ArrayList<Recipe> recipes) {
        String allergy = InputParser.parseAllergyCriteria(userInput);
        ArrayList<Integer> listNumbers = new ArrayList<>();
        ArrayList<Recipe> matches = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;

        for (Recipe recipe : recipes) {
            if (!recipe.allergies.contains(allergy)) {
                matches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }

        if (matches.isEmpty()) {
            System.out.println(RECIPES_INCLUDED + allergy);
            return;
        }

        System.out.println(RECIPES_EXCLUDED + allergy + "\n");
        UI.printRecipes(matches, listNumbers);
    }
}
