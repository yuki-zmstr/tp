package recipeio.commands;

import recipeio.InputParser;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterByAllergyCommand {

    /**
     * Shows a list of recipes with the allergy excluded.
     *
     * @param userInput user's input in the command line.
     * @param recipes list of recipes to execute on.
     */
    public static void execute(String userInput, ArrayList<Recipe> recipes) {

        String allergy = InputParser.parseAllergyCriteria(userInput);

        ArrayList<Recipe> matches = (ArrayList<Recipe>) recipes.stream()
                .filter(recipe -> !recipe.allergies.contains(allergy))
                .collect(Collectors.toList());

        if (matches.isEmpty()) {
            System.out.println("\tAll of your recipes include: " + allergy);
            return;
        }

        System.out.println("\tThese recipes do not include: " + allergy);
        UI.printRecipes(matches);
    }
}
