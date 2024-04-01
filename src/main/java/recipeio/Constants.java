package recipeio;

public class Constants {
    public static final int INDEX_COMMAND = 0;
    public static final int INDEX_ID = 1;
    public static final int MAX_RECIPES = 99999;

    public static final String RECIPE_DELIMETER = "/";

    public static final String EXIT_COMMAND = "exit";
    public static final String ADD_COMMAND = "add";
    public static final String DELETE_COMMAND = "delete";
    public static final String LIST_COMMAND = "list";
    public static final String HELP_COMMAND = "help";
    public static final String FIND_COMMAND = "find";
    public static final String FILTER_COMMAND = "filter";
    public static final String DETAIL_COMMAND = "detail";

    public static final String INVALID_TASK_FORMAT_ERROR_MESSAGE = "Sorry. I couldn't understand. Please follow the " +
            "correct format.";
    public static final String INTEGER_NEEDED_ERROR_MESSAGE = "Make sure you enter an integer for cook time and" +
            "calories!";
    public static final String MEAL_CATEGORY_ERROR_MESSAGE = "Please enter a valid meal category. Here are your" +
            "options:\n BREAKFAST, LUNCH, DINNER, APPETIZER, DESSERT";
    public static final String NO_RECIPES_ERROR_MESSAGE = "\tSorry, you have no recipes. Try adding some!";
    public static final String NO_MATCHES_ERROR_MESSAGE = "\tThere were no matches. Try searching for something else. ";
    public static final String MESSAGE_ASK_INPUT = "asking user for input";
    public static final String FIND_BY_KEYWORD = "kw";
    public static final String FIND_BY_DATE = "date";
    public static final String FIND_BY_ALLERGY = "allergy";

    public static final String MEAL_CAT_GENERAL = "general";
    public static final String MEAL_CAT_DINNER = "dinner";
    public static final String MEAL_CAT_BREAKFAST = "breakfast";
    public static final String MEAL_CAT_LUNCH = "lunch";
    public static final String MEAL_CAT_APPETIZER = "appetizer";
    public static final String MEAL_CAT_DESSERT = "dessert";

    //Test find commands
    public static final String TEST_FIND_BY_MEAL_EXIST_ITEM = "find meal breakfast";

    public static final String TEST_FIND_BY_MEAL_NOT_EXIST_ITEM = "find meal dessert";

    public static final String TEST_FIND_BY_INVALID_MEAL = "find meal djsakhfs";
}
