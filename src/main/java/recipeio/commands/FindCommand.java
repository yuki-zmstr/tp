package recipeio.commands;

import recipeio.InputParser;
import recipeio.CommandValidator;
import recipeio.constants.CommandConstants;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import static recipeio.constants.CommandConstants.FIND_BY_KEYWORD;
import static recipeio.constants.CommandConstants.FIND_BY_MEAL;
import static recipeio.constants.CommandConstants.FIND_BY_DATE;
import static recipeio.constants.CommandConstants.FIND_BY_URL;
import static recipeio.constants.CommandConstants.INVALID_MEAL_ERROR;
import static recipeio.constants.CommandConstants.INVALID_FIND_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_ERROR;
import static recipeio.constants.CommandConstants.NO_MATCHES_PROMPT;
import static recipeio.constants.CommandConstants.VALID_KEYWORD_MATCHES;
import static recipeio.constants.CommandConstants.VALID_DATE_MATCHES;
import static recipeio.constants.CommandConstants.VALID_URL_MATCHES;

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
            FindMeal.execute(criteria, recipes);
            break;
        case (FIND_BY_URL):
            if (!CommandValidator.isValidURL(criteria)) {
                return;
            }
            findURL(criteria, recipes);
            break;
        default:
            System.out.println(INVALID_FIND_ERROR);
        }
    }
    public static void findKeyword(String keyword, ArrayList<Recipe> recipes) {
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

    public static void findDate(LocalDate date, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (recipe.dateAdded.isEqual(date)) {
                matches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }
        if (matches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            return;
        }
        System.out.println(VALID_DATE_MATCHES + date + "\n");
        UI.printRecipes(matches, listNumbers);
    }
    /**
     * Tries to find any matching URL
     *
     * @param url User's url to be found
     * @param recipes List of available recipes to search through
     */
    public static void findURL(String url, ArrayList<Recipe> recipes) {
        ArrayList<Integer> listNumbers = new ArrayList<>();
        ArrayList<Recipe> urlMatches = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (CommandValidator.splitName(recipe.getURL()).contains(url)) {
                urlMatches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }
        if (urlMatches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            return;
        }
        System.out.println(VALID_URL_MATCHES + url + "\n");
        UI.printRecipes(urlMatches, listNumbers);
    }

}
