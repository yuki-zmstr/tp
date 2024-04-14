package recipeio.constants;

/**
 * Constants for CommandValidator.
 */
public class CommandValidatorConstants {
    public static final int INPUT_DETAILS_INDEX = 0;
    public static final int VALID_DETAILS_LENGTH = 1;
    public static final int VALID_DELETE_LENGTH = 1;
    public static final int VALID_FILTER_LENGTH = 1;
    public static final int MAX_RECIPES = 1;
    public static final int VALID_FIND_LENGTH = 2;
    public static final int MAX_COOKTIME = 4320;
    public static final int MAX_CALORIES = 9000;
    public static final String MEAL_CAT_GENERAL = "general";
    public static final String MEAL_CAT_DINNER = "dinner";
    public static final String MEAL_CAT_BREAKFAST = "breakfast";
    public static final String MEAL_CAT_LUNCH = "lunch";
    public static final String MEAL_CAT_APPETIZER = "appetizer";
    public static final String MEAL_CAT_DESSERT = "dessert";
    public static final String MATCH_WORD_REGEX = "^[a-zA-Z]+$";
    public static final String ALLOW_SPACES_AND_NUMS_REGEX = "^(?=.*[a-zA-Z])[a-zA-Z0-9 /]+$";
    public static final String NUMS_ONLY_REGEX = "\\d+";
    public static final String URL_SUBDOMAIN_ERROR = "Make sure your URL starts with 'http://', 'https://', or 'www.'";
    public static final String URL_INVALID_DOMAIN = "URL domain name or TLD is invalid.";
    public static final String URL_EXAMPLE = "Example: \"www.food.com\" or \" https://www.example.com\" ";
    public static final String DOMAIN_REGEX = "\\w+([\\-\\.]{1}[\\w]+)*\\.[a-zA-Z]{2,}";
    public static final String SUB_DOMAIN_MATCHES = "^(http://www\\.|https://www\\.|http://|https://|www\\.)";
    public static final String DATE_TIME_PARSE_ERROR = "Make sure you enter a valid date!" +
            "\nPlease enter your date in the format yyyy-MM-dd" + "\n\tInput Example: find date 2024-03-28";
    public static final String VALID_DETAILS_PROMPT = "The detail function takes in one parameter: {recipe number}";
    public static final String VALID_DETAILS_EXAMPLE = "\tInput Example: detail 1";
    public static final String VALID_DELETE_PROMPT = "The delete function takes in one parameter: {recipe number}";
    public static final String VALID_DELETE_EXAMPLE = "\tInput Example: delete 1";
    public static final String VALID_FILTER_PROMPT = "The filter function takes in one parameter: {allergy}";
    public static final String VALID_FILTER_EXAMPLE = "\tInput Example: filter dairy";
    public static final String URL_SUBDOMAIN_HTTP = "http://";
    public static final String URL_SUBDOMAIN_HTTPS = "https://";
    public static final String URL_SUBDOMAIN_WWW = "www.";
    public static final String SAME_RECIPE_MESSAGE = "Sorry, you are attempting to add a same recipe that is already" +
            " in your recipe book.\nTry adding something new!";
    public static final String INVALID_SORT_TYPE_ERROR_MESSAGE = "Invalid sort type.";
    public static final String EXCESS_DETAILS_ERROR = "There seems to be more details than needed.";

}
