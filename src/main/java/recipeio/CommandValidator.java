package recipeio;

import recipeio.constants.InputParserConstants;
import recipeio.recipe.Recipe;
import recipeio.constants.CommandValidatorConstants;
import recipeio.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;

import static recipeio.InputParser.splitUpAddInput;
import static recipeio.constants.CommandValidatorConstants.INPUT_DETAILS_INDEX;
import static recipeio.constants.CommandValidatorConstants.MAX_RECIPES;
import static recipeio.constants.CommandValidatorConstants.VALID_DETAILS_LENGTH;
import static recipeio.constants.CommandValidatorConstants.VALID_DELETE_LENGTH;
import static recipeio.constants.CommandValidatorConstants.VALID_FILTER_LENGTH;
import static recipeio.constants.CommandValidatorConstants.VALID_FIND_LENGTH;
import static recipeio.constants.CommandValidatorConstants.SUB_DOMAIN_MATCHES;
import static recipeio.constants.CommandValidatorConstants.DOMAIN_REGEX;
import static recipeio.constants.CommandValidatorConstants.VALID_DETAILS_PROMPT;
import static recipeio.constants.CommandValidatorConstants.VALID_DETAILS_EXAMPLE;
import static recipeio.constants.CommandValidatorConstants.VALID_DELETE_PROMPT;
import static recipeio.constants.CommandValidatorConstants.VALID_DELETE_EXAMPLE;
import static recipeio.constants.CommandValidatorConstants.VALID_FILTER_PROMPT;
import static recipeio.constants.CommandValidatorConstants.VALID_FILTER_EXAMPLE;
import static recipeio.constants.CommandValidatorConstants.DATE_TIME_PARSE_ERROR;
import static recipeio.constants.CommandValidatorConstants.URL_SUBDOMAIN_HTTP;
import static recipeio.constants.CommandValidatorConstants.URL_SUBDOMAIN_HTTPS;
import static recipeio.constants.CommandValidatorConstants.URL_SUBDOMAIN_WWW;
import static recipeio.constants.CommandValidatorConstants.MAX_COOKTIME;
import static recipeio.constants.InputParserConstants.ALLERGIES_INDEX;
import static recipeio.constants.InputParserConstants.CALORIES_INDEX;
import static recipeio.constants.InputParserConstants.COOK_TIME_INDEX;
import static recipeio.constants.InputParserConstants.URL_INDEX;
import static recipeio.constants.InputParserConstants.INTEGER_NEEDED_ERROR_MESSAGE;
import static recipeio.constants.InputParserConstants.COOKTIME_ERROR_MESSAGE;
import static recipeio.constants.InputParserConstants.CALORIES_ERROR_MESSAGE;
import static recipeio.constants.InputParserConstants.MEAL_CATEGORY_ERROR_MESSAGE;
import static recipeio.constants.InputParserConstants.MEAL_CATEGORY_INDEX;
import static recipeio.constants.InputParserConstants.RECIPE_NAME_INDEX;

/**
 * Class containing methods that validate a user's input into the command line.
 */
public class CommandValidator {
    /**
     * Splits a recipe name into individual words.
     *
     * @return ArrayList of words in recipe name.
     */
    public static ArrayList<String> splitName(String recipeName) {
        String[] nameWords = recipeName.split(" ");
        return new ArrayList<>(Arrays.asList(nameWords));
    }


    /**
     * Checks if an input can be parsed as an integer more than zero.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isParsableAsInteger(String input) {
        try {
            int result = Integer.parseInt(input);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if an input can be parsed as a word.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isWord(String input) {
        // Regular expression to match only alphabetic characters
        if (!input.matches(CommandValidatorConstants.MATCH_WORD_REGEX)){
            System.out.println("Sorry, I was unable to detect a word.");
            System.out.println("Please make sure to enter a word using lower and upper case alphabets.");
            return false;
        }
        return true;
    }

    /**
     * Checks if an input can be parsed as a name.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isName(String input) {
        if (input.matches(CommandValidatorConstants.NUMS_ONLY_REGEX)) {
            System.out.println("Your recipe name should not contain numbers only.");
            System.out.println("Please make sure to enter a name using alphabets as well.");
            return false;
        }
        if (!input.matches(CommandValidatorConstants.ALLOW_SPACES_AND_NUMS_REGEX)){
            System.out.println("You seem to be using special characters in your recipe name.");
            System.out.println("Please make sure to enter a name using alphabets and numbers only.");
            return false;
        }
        return true;
    }

    /**
     * Checks if an input can be parsed as allergies.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isAllergies(String input) {
        if (!input.matches(CommandValidatorConstants.ALLOW_SPACES_AND_NUMS_REGEX)){
            System.out.println("Sorry, I was unable to detect appropriate allergies for your recipe.");
            System.out.println("Please make sure to enter allergies using upper and lower case alphabets, spaces, " +
                    "and numbers.\n");
            System.out.println("Ensure that while your allergies can include numbers, that they are not JUST " +
                    "a number.");
            System.out.println("If there are no allergies, please type 'none' instead.");
            return false;
        }
        String[] allergies = input.trim().split("/");
        ArrayList<String> allergiesList = new ArrayList<>(List.of(allergies));
        for (String allergy : allergiesList) {
            if (allergy.matches(CommandValidatorConstants.NUMS_ONLY_REGEX)) {
                System.out.println("Your allergen should not contain numbers only.");
                System.out.println("Please make sure to enter an allergen using alphabets as well.");
                return false;

            }
        }
        return true;
    }

    /**
     * Checks if an input can be parsed as a meal category.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isMealCat(String input) {
        String coreInput = input.trim().toLowerCase();
        boolean isCategory;
        switch (coreInput) {
        case CommandValidatorConstants.MEAL_CAT_GENERAL:
        case CommandValidatorConstants.MEAL_CAT_DINNER:
        case CommandValidatorConstants.MEAL_CAT_LUNCH:
        case CommandValidatorConstants.MEAL_CAT_BREAKFAST:
        case CommandValidatorConstants.MEAL_CAT_APPETIZER:
        case CommandValidatorConstants.MEAL_CAT_DESSERT:
            isCategory = true;
            break;
        default:
            isCategory = false;
        }
        return isCategory;
    }

    /**
     * Checks if an input can be parsed as a word.
     *
     * @param input the String to check.
     * @return status of check.
     */
    public static boolean isParsableAsDate(String input) {
        try {
            LocalDate date = LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(DATE_TIME_PARSE_ERROR);
            return false;
        }
    }
    /**
     * Checks if an integer is within the range of number of recipes currently stored.
     *
     * @param recipes the list of current recipes.
     * @param index the index to check.
     * @return status of check.
     */
    public static boolean isWithinRange(ArrayList<Recipe> recipes, int index) {
        if (index > recipes.size() || index < MAX_RECIPES) {
            System.out.println("Sorry, there is no recipe at index: " + index);
            System.out.println("You currently have: " + recipes.size() + " recipes");
            return false;
        }
        return true;
    }

    /**
     * Checks if a detail command is valid.
     * Check fails if number of parameters is not 1, or the parameter is not an integer,
     * or the parameter is out of range.
     *
     * @param userInput User's input in the command line.
     * @param recipes list of current recipes.
     * @return status of check.
     */
    public static boolean isValidDetailCommand(String userInput, ArrayList<Recipe> recipes) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != VALID_DETAILS_LENGTH || details[INPUT_DETAILS_INDEX].isEmpty()) {
            System.out.println(VALID_DETAILS_PROMPT);
            System.out.println(VALID_DETAILS_EXAMPLE);
            return false;
        }
        if (!isParsableAsInteger(details[INPUT_DETAILS_INDEX])) {
            System.out.println(INTEGER_NEEDED_ERROR_MESSAGE);
            System.out.println(VALID_DETAILS_EXAMPLE);
            return false;
        }
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return false;
        }
        if (!CommandValidator.isWithinRange(recipes, index)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a delete command is valid.
     * Check fails if number of parameters is not 1, or the parameter is not an integer,
     * or the parameter is out of range.
     *
     * @param userInput User's input in the command line.
     * @param recipes list of current recipes.
     * @return status of check.
     */
    public static boolean isValidDeleteCommand(String userInput, ArrayList<Recipe> recipes) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != VALID_DELETE_LENGTH || details[INPUT_DETAILS_INDEX].isEmpty()) {
            System.out.println(VALID_DELETE_PROMPT);
            System.out.println(VALID_DELETE_EXAMPLE);
            return false;
        }
        if (!isParsableAsInteger(details[INPUT_DETAILS_INDEX])) {
            System.out.println(INTEGER_NEEDED_ERROR_MESSAGE);
            System.out.println(VALID_DELETE_PROMPT);
            return false;
        }
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return false;
        }
        if (!CommandValidator.isWithinRange(recipes, index)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a find command is given two parameters.
     *
     * @param userInput User's input in the command line.
     * @return status of check.
     */
    public static boolean isValidFindCommand(String userInput) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != VALID_FIND_LENGTH) {
            System.out.println("The find function accepts two parameters: {type} and {criteria}.");
            System.out.println("\tInput Example: find kw pizza");
            System.out.println("\tInput Example: find date 2024-03-28");
            System.out.println("\tInput Example: find meal dinner");
            System.out.println("\tInput Example: find url www.food.com");
            return false;
        }
        return true;
    }

    /**
     * Checks if a given cookTime is reasonable.
     *
     * @param input User's input of cookTime in the command line.
     * @return status of check.
     */
    public static boolean isValidCookTime(String input) {
        if (!isParsableAsInteger(input)) {
            System.out.println(COOKTIME_ERROR_MESSAGE);
            return false;
        }
        int cookTime = Integer.parseInt(input.trim());
        if (cookTime > MAX_COOKTIME) {
            System.out.println("Your recipe takes more than three days to cook...Please double check your cook time.");
            return false;
        }
        return true;
    }

    /**
     * Checks if a given calorie is reasonable.
     *
     * @param input User's input of calories in the command line.
     * @return status of check.
     */
    public static boolean isValidCalories(String input) {
        if (!isParsableAsInteger(input)) {
            System.out.println(CALORIES_ERROR_MESSAGE);
            return false;
        }
        int calories = Integer.parseInt(input.trim());
        if (calories > CommandValidatorConstants.MAX_CALORIES) {
            System.out.println("Your recipe gives you more calories than you need in three days... " +
                    "Please double check your calories.");
            return false;
        }
        return true;
    }

    /**
     * Checks if an add recipe command is valid
     * The input is initially checked against the expected total number of ingredients and subsequently all the
     * other input parameters to ensure that they are of the expected format.
     *
     * @param userInput User's input in the command line.
     * @return status of check.
     */
    public static boolean isValidAddCommand(String userInput) {
        String[] details = InputParser.splitUpAddInput(userInput);
        if (details.length != InputParserConstants.TOTAL_INGREDIENTS_INDEX) {
            System.out.println("The add function accepts 6 parameters: {name} {cook time} {calories}\n\t {singular " +
                    "slash separated allergies} {meal category} {url}");
            System.out.println("Input Example: add pizza, 34, 340, egg/red meat, dinner, www.food.com");
            System.out.println("Tip: make sure you are not missing a comma anywhere!");
            return false;
        }

        String[] remainingInput = splitUpAddInput(userInput);
        if (!isName(remainingInput[RECIPE_NAME_INDEX])) {
            return false;
        }
        if (!isValidCookTime(remainingInput[COOK_TIME_INDEX])) {
            return false;
        }
        if (!isValidCalories(remainingInput[CALORIES_INDEX])) {
            return false;
        }
        if (!isAllergies(remainingInput[ALLERGIES_INDEX])) {
            return false;
        }
        if (!isMealCat(remainingInput[MEAL_CATEGORY_INDEX])) {
            System.out.println(MEAL_CATEGORY_ERROR_MESSAGE);
            return false;
        }
        if (!isValidURL(remainingInput[URL_INDEX])) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a filter command is valid.
     * Check fails if number of parameters is not 1, or the parameter is not a word,
     *
     * @param userInput User's input in the command line.
     * @return status of check.
     */
    public static boolean isValidFilterCommand(String userInput) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length < VALID_FILTER_LENGTH || details[INPUT_DETAILS_INDEX].isEmpty()) {
            System.out.println(VALID_FILTER_PROMPT);
            System.out.println(VALID_FILTER_EXAMPLE);
            return false;
        }
        if (!isWord(details[INPUT_DETAILS_INDEX])) {
            System.out.println(VALID_FILTER_EXAMPLE);
            return false;
        }
        return true;
    }

    /**
     * Checks if a recipe is not a repeat of an existing recipe.
     *
     * @param newRecipe the recipe to be checked.
     * @param recipes the list of current recipes.
     * @return status of check.
     */
    public static boolean isNotRepeatRecipe(Recipe newRecipe, ArrayList<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(newRecipe.getName()) &&
                    recipe.getCookTime() == newRecipe.getCookTime() &&
                    recipe.getCalories() == newRecipe.getCalories() &&
                    compareAllergies(recipe.getAllergies(), newRecipe.getAllergies()) &&
                    recipe.getCategory().equals(newRecipe.getCategory()) &&
                    recipe.getURL().equals(newRecipe.getURL())) {
                System.out.println(CommandValidatorConstants.SAME_RECIPE_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * Compares two lists of allergies.
     *
     * @param allergies1 the first list of allergies.
     * @param allergies2 the second list of allergies.
     * @return status of check.
     */
    public static boolean compareAllergies(ArrayList<String> allergies1, ArrayList<String> allergies2) {
        if (allergies1.size() != allergies2.size()) {
            return false;
        }
        Collections.sort(allergies1);
        Collections.sort(allergies2);
        return allergies1.equals(allergies2);
    }


    /**
     * Checks whether the url entered is valid by checking with URLValidator.
     * Valid urls starts with 'http://', 'https://', or 'www.'
     * Valid urls must also follow domain naming conventions
     *
     * @param userInput User's input in the command line.
     * @return status of check.
     */
    public static boolean isValidURL(String userInput) {
        String details = userInput.trim();
        boolean isValid = true;

        // Validate URL subdomain
        if (!details.startsWith(URL_SUBDOMAIN_HTTP) && !details.startsWith(URL_SUBDOMAIN_HTTPS)
                && !details.startsWith(URL_SUBDOMAIN_WWW)) {
            System.out.println(CommandValidatorConstants.URL_SUBDOMAIN_ERROR);
            System.out.println(CommandValidatorConstants.URL_EXAMPLE);
            isValid = false;
        } else if (!details.matches(SUB_DOMAIN_MATCHES + DOMAIN_REGEX + ".*$")) {
            System.out.println(CommandValidatorConstants.URL_INVALID_DOMAIN);
            System.out.println(CommandValidatorConstants.URL_EXAMPLE);
            isValid = false;
        }
        return isValid;
    }


    /**
     * Checks if a list command is valid.
     * Check fails if number of parameters is not 1, or the parameter is not a valid sort type.
     *
     * @param userInput User's input in the command line.
     * @return status of check.
     */
    public static boolean isValidListCommand(String userInput) {
        String[] words = userInput.trim().split("\\s+");
        //if there are more than 2 words in the command, return false
        if (words.length > 2) {
            System.out.println(CommandValidatorConstants.EXCESS_DETAILS_ERROR);
            return false;
        }
        //case of list without optional flag
        if (words.length == 1) {
            return true;
        }
        //if the sort type is incorrect, return false
        if (!(words[1].equals(InputParserConstants.SORT_NAME) ||
                words[1].equals(InputParserConstants.SORT_DATE_ADDED) ||
                words[1].equals(InputParserConstants.SORT_CALORIES) ||
                words[1].equals(InputParserConstants.SORT_COOK_TIME))) {
            System.out.println(CommandValidatorConstants.INVALID_SORT_TYPE_ERROR_MESSAGE);
            UI.printSortTypes();
            return false;
        }
        return true;
    }
}
