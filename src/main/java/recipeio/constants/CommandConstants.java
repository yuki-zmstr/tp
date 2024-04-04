package recipeio.constants;

public class CommandConstants {
    public static final String RECIPES_INCLUDED = "All your recipes include:";
    public static final String RECIPES_EXCLUDED = "These recipes do not include:";
    public static final String FIND_BY_MEAL = "meal";
    public static final String FIND_BY_KEYWORD = "kw";
    public static final String FIND_BY_DATE = "date";
    public static final String NO_MATCHES_ERROR = "\tThere were no matches. Try searching for something else. ";
    public static final String INVALID_MEAL_ERROR = "Invalid meal category!";
    public static final String INVALID_FIND_ERROR = "\tSorry, please follow one of the find command formats." +
            "\n\tAccepted find parameters are: 'kw' and 'date'.";
    public static final String NO_MATCHES_PROMPT = "\tPlease ensure that you have inputted a full word.";
    public static final String VALID_KEYWORD_MATCHES = "\tHere are your matches with keyword: ";
    public static final String VALID_DATE_MATCHES = "\tHere are your matches with date: ";
    public static final String NO_CATEGORY_MATCHES = "\tThere's no recipe with category ";
    public static final String VALID_CATEGORY_MATCHES = "\tThese recipes have the category ";
    public static final String EMPTY_RECIPE_ERROR = "\tSorry, there are no recipes in your recipe book to print.";
    public static final String RECIPE_SUMMARY = "\tHere is a summary of your recipe book.";
    public static final String RECIPE_DETAILS_PROMPT = "\n\tTo find out more about a particular recipe," +
            " try the 'detail {index}' command.";


}
