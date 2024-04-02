package recipeio.commands;

import recipeio.InputParser;
import recipeio.CommandValidator;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static recipeio.constants.CommandConstants.FIND_BY_KEYWORD;
import static recipeio.constants.CommandConstants.FIND_BY_MEAL;
import static recipeio.constants.CommandConstants.FIND_BY_DATE;
import static recipeio.constants.CommandConstants.INVALID_MEAL_ERROR;
import static recipeio.constants.CommandConstants.INVALID_FIND_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_PROMPT;
import static recipeio.constants.CommandConstants.VALID_KEYWORD_MATCHES;
import static recipeio.constants.CommandConstants.VALID_DATE_MATCHES;
import static recipeio.constants.CommandConstants.NO_CATEGORY_MATCHES;
import static recipeio.constants.CommandConstants.VALID_CATEGORY_MATCHES;

public class FindCommand {
    public static void execute(String userInput, ArrayList<Recipe> recipes) {
        if (!CommandValidator.isValidFindCommand(userInput)) {
            return;
        }
        String findType = InputParser.parseFindType(userInput);
        String criteria = InputParser.parseFindCriteria(userInput);
        switch (findType) {
        case (FIND_BY_KEYWORD):
            if (!CommandValidator.isWord(criteria)) {
                return;
            }
            findKeyword(criteria, recipes);
            break;
        case (FIND_BY_DATE):
            if (!CommandValidator.isParsableAsDate(criteria)) {
                return;
            }
            LocalDate date = LocalDate.parse(criteria);
            findDate(date, recipes);
            break;
        case (FIND_BY_MEAL):
            if (!CommandValidator.isMealCat(criteria)) {
                System.out.println(INVALID_MEAL_ERROR);
                UI.printValidMealCategories();
                return;
            }
            findMeal(criteria, recipes);
            break;
        default:
            System.out.println(INVALID_FIND_ERROR);
        }
    }
    public static void findKeyword(String keyword, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (CommandValidator.splitName(recipe.getName()).contains(keyword)) {
                matches.add(recipe);
            }
        }
        if (matches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            System.out.println(NO_MATCHES_PROMPT);
            return;
        }
        System.out.println(VALID_KEYWORD_MATCHES + keyword);
        UI.printRecipes(matches);
    }

    public static void findDate(LocalDate date, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.dateAdded.isEqual(date)) {
                matches.add(recipe);
            }
        }
        if (matches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            return;
        }
        System.out.println(VALID_DATE_MATCHES + date);
        UI.printRecipes(matches);
    }

    /**
     * Show a list of recipes with a given meal category
     * @param meal the user's meal search from the terminal
     * @param recipes the current recipe list
     */
    public static void findMeal(String meal, ArrayList<Recipe> recipes) {
        MealCategory mealCategory = InputParser.parseMealCriteria(meal);
        ArrayList<Recipe> matches = (ArrayList<Recipe>) recipes.stream()
                .filter(recipe -> recipe.category == mealCategory)
                .collect(Collectors.toList());

        if (matches.isEmpty()) {
            System.out.println(NO_CATEGORY_MATCHES + meal);
            return;
        }

        System.out.println(VALID_CATEGORY_MATCHES + meal);
        UI.printRecipes(matches);
    }
}
