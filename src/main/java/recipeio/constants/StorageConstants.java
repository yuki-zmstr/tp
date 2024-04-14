package recipeio.constants;

public class StorageConstants {

    public static final String WRITE_DELIMITER = " | ";
    public static final String READ_DELIMITER = " \\| ";
    public static final String ALLERGY_DELIMITER = ",";
    public static final String MINUTE_IDENTIFIER = " mins";
    public static final String CALORIE_IDENTIFIER = " kcals";

    public static final String STORAGE_CLIENT_GREETING = "\nStorage client says: ";

    public static final String SUCCESSFUL_SAVE_MESSAGE = "Successfully saved recipe book.";
    public static final String UNSUCCESSFUL_SAVE_MESSAGE = "Failed to save recipe book.";

    public static final String SUCCESSFUL_LOAD_MESSAGE = "Successfully loaded recipe book.";

    public static final String FAIL_TO_CREATE_DIRECTORY_MESSAGE = "Failed to create the 'data' directory.";
    public static final String FAIL_TO_CREATE_FILE_MESSAGE = "Failed to create the output text file.";

    public static final String FILE_NOT_FOUND_MESSAGE = "No input file found, will create a new one.";
    public static final String EMPTY_FILE_FOUND_MESSAGE =
            "Empty 'recipe.txt' found in 'data' directory. Will be writing into this file.";

    // used in parsing details from the data file.
    public static final int NAME_LOCATION = 0;
    public static final int COOKTIME_LOCATION = 1;
    public static final int CALORIES_LOCATION = 2;
    public static final int ALLERGIES_LOCATION = 3;
    public static final int CATEGORY_LOCATION = 4;
    public static final int DATE_LOCATION = 5;
    public static final int URL_LOCATION = 6;

    // used in parsing the cook time and calories.
    public static final String EMPTY_STRING = "";
}
