package recipeio.commands;

import recipeio.InputParser;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;
import recipeio.Constants;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FindByMealCommand {
    public static void execute(String userInput, ArrayList<Recipe> recipes) {
        MealCategory mealCategory = InputParser.parseMealCriteria(userInput);
        String category = InputParser.parseDetails(userInput)[1];
        ArrayList<Recipe> matches = (ArrayList<Recipe>) recipes.stream()
                .filter(recipe -> recipe.category == mealCategory)
                .collect(Collectors.toList());;

        if (matches.isEmpty()) {
            System.out.println("\tThere's no recipe with category " + category);
            return;
        }

        System.out.println("\tThese recipes have the category " + category);
        UI.printRecipes(matches);
    }
}
