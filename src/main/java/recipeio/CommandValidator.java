package recipeio;

import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.time.format.DateTimeParseException;

public class Utils {


    public static ArrayList<String> splitName(String recipeName) {
        String[] nameWords = recipeName.split(" ");
        return new ArrayList<>(Arrays.asList(nameWords));
    }


    public static boolean isParsableAsInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("\tParameter cannot be parsed as an integer.");
            System.out.println("\tPlease enter an integer from 1 onwards.");
            return false;
        }
    }

    public static boolean isWithinRange(ArrayList<Recipe> recipes, int index) {
        if (index > recipes.size() || index < 1) {
            System.out.println("\tSorry, there is no recipe at index: " + index);
            System.out.println("\tYou currently have: " + recipes.size() + " recipes");
            return false;
        }
        return true;
    }

    public static boolean isWord(String input) {
        // Regular expression to match only alphabetic characters
        String regex = "^[a-zA-Z]+$";
        if (!input.matches(regex)){
            System.out.println("\tParameter cannot be parsed as an word.");
            System.out.println("\tPlease enter a word using lower and upper case alphabets.");
            return false;
        }
        return true;
    }

    public static boolean isValidDetailCommand(String userInput, ArrayList<Recipe> recipes) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != 1 || details[0].isEmpty()) {
            System.out.println("\tThe detail function takes in one parameter: {index}");
            System.out.println("\t\tInput Example: detail 1");
            return false;
        }
        if (!isParsableAsInteger(details[0])) {
            System.out.println("\t\tInput Example: detail 1");
            return false;
        }
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return false;
        }
        if (!Utils.isWithinRange(recipes, index)) {
            return false;
        }
        return true;
    }

    public static boolean isValidFindCommand(String userInput) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != 2) {
            System.out.println("\tThe find function accepts two parameters: {type} and {criteria}");
            System.out.println("\t\tInput Example: find kw pizza");
            System.out.println("\t\tInput Example: find date 2024-03-28");
            return false;
        }
        return true;
    }

    public static boolean isParsableAsDate(String input) {
        try {
            LocalDate date = LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("\tParameter cannot be parsed as a date.");
            System.out.println("\tPlease enter a date in the format yyyy-MM-dd");
            System.out.println("\t\tInput Example: find date 2024-03-28");
            return false;
        }
    }

    public static boolean isValidFilterCommand(String userInput) {
        String[] details = InputParser.parseDetails(userInput);
        if (details.length != 1 || details[0].isEmpty()) {
            System.out.println("\tThe filter function takes in one parameter: {allergy}");
            System.out.println("\t\tInput Example: filter dairy");
            return false;
        }
        if (!isWord(details[0])) {
            System.out.println("\t\tInput Example: filter dairy");
            return false;
        }
        return true;
    }
}
