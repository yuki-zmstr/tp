package recipeio.commands;

import recipeio.InputParser;
import recipeio.CommandValidator;
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
            FindKeyword.execute(criteria, recipes);
            break;
        case (FIND_BY_DATE):
            if (!CommandValidator.isParsableAsDate(criteria)) {
                return;
            }
            LocalDate date = LocalDate.parse(criteria);
            FindDate.execute(date, recipes);
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
            FindUrl.execute(criteria, recipes);
            break;
        default:
            System.out.println(INVALID_FIND_ERROR);
        }
    }
}
