package recipeio.storage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import recipeio.constants.StorageConstants;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

public class Storage {

    private static File dataFile;
    private static String pathToFile;

    /**
     * Instantiates File object, using the path to file given in RecipeIO.java.
     *
     * @param filePath path to the file where recipe book is stored.
     */
    public Storage(String filePath) {
        dataFile = new File(filePath);
        pathToFile = filePath;
    }

    /**
     * Creates a data file in the directory /data. Exits early if the file already exists.
     *
     * @throws IOException if unable to create the 'data' directory, or unable to create the text file.
     */
    public static void createDataFile() throws IOException{
        if (dataFile.exists()) {
            return;
        }
        if (!dataFile.getParentFile().exists()) {
            // create directory to save in.
            boolean hasDirectoryCreated = dataFile.getParentFile().mkdirs();
            if (!hasDirectoryCreated) {
                identifySelfAsStorageClient();
                throw new IOException(StorageConstants.FAIL_TO_CREATE_DIRECTORY_MESSAGE);
            }
            // create file to save in.
            boolean hasFileCreated = dataFile.createNewFile();
            if (!hasFileCreated) {
                identifySelfAsStorageClient();
                throw new IOException(StorageConstants.FAIL_TO_CREATE_FILE_MESSAGE);
            }
        }
    }

    /**
     * Saves the list of items to a text file.
     *
     * @param recipeList list of recipes to write in the text file.
     * @throws IOException if an error is encountered when trying to write to the file.
     */
    public static void saveFile(ArrayList<Recipe> recipeList) throws IOException {
        try {
            createDataFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        FileWriter writer = new FileWriter(pathToFile);

        BufferedWriter bw = new BufferedWriter(writer);

        for (Recipe recipe : recipeList) {
            bw.write(recipe.name);
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(recipe.cookTime + StorageConstants.MINUTE_IDENTIFIER);
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(recipe.calories + StorageConstants.CALORIE_IDENTIFIER);
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(String.join(StorageConstants.ALLERGY_DELIMITER, recipe.allergies));
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(recipe.category.toString());
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(recipe.dateAdded.toString());
            bw.write(StorageConstants.WRITE_DELIMITER);
            bw.write(recipe.url);
            bw.newLine();
        }
        bw.close();
        identifySelfAsStorageClient();
        System.out.println(StorageConstants.SUCCESSFUL_SAVE_MESSAGE);
    }

    /**
     * Attempts to load recipes from data file into an ArrayList of Recipe.
     */
    public ArrayList<Recipe> loadData() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        try {
            ArrayList<String> dataItems = readFile();
            recipeList = parse(dataItems);
            identifySelfAsStorageClient();
            System.out.println(StorageConstants.SUCCESSFUL_LOAD_MESSAGE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return recipeList;
    }

    /**
     * Loads the text file into a into an ArrayList of String, where each line in the text file is an entry.
     *
     * @throws FileNotFoundException if file cannot be found
     */
    private ArrayList<String> readFile() throws IOException {
        if (!dataFile.exists()) {
            identifySelfAsStorageClient();
            throw new FileNotFoundException(StorageConstants.FILE_NOT_FOUND_MESSAGE);
        }
        if (dataFile.length() == 0) {
            identifySelfAsStorageClient();
            throw new IOException(StorageConstants.EMPTY_FILE_FOUND_MESSAGE);
        }
        return (ArrayList<String>) Files.readAllLines(dataFile.toPath(), Charset.defaultCharset());
    }

    /**
     * Parses each line in the data file into a Recipe object, using helper get methods defined below.
     *
     * @param dataItems ArrayList of String retrieved from readFile method above.
     */
    private ArrayList<Recipe> parse(ArrayList<String> dataItems) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (String line : dataItems) {
            // fetch details of the recipe
            String name = parseName(line);
            int cookTime = parseCookTime(line);
            int calories = parseCalories(line);
            ArrayList<String> allergies = parseAllergies(line);
            MealCategory category = parseCategory(line);
            LocalDate dateAdded = parseDate(line);
            String url = parseURL(line);

            // add recipe into ArrayList
            Recipe recipe = new Recipe(name, cookTime, calories, allergies, category, dateAdded, url);
            recipes.add(recipe);
        }
        return recipes;
    }

    private String[] parseItem(String line) {
        return line.split(StorageConstants.READ_DELIMITER);
    }

    private String parseName(String line) {
        return parseItem(line)[StorageConstants.NAME_LOCATION];
    }

    private int parseCookTime(String line) {
        return Integer.parseInt(parseItem(line)[StorageConstants.COOKTIME_LOCATION]
                .replace(StorageConstants.MINUTE_IDENTIFIER, StorageConstants.EMPTY_STRING));
    }

    private int parseCalories(String line) {
        return Integer.parseInt(parseItem(line)[StorageConstants.CALORIES_LOCATION]
                .replace(StorageConstants.CALORIE_IDENTIFIER, StorageConstants.EMPTY_STRING));
    }

    private ArrayList<String> parseAllergies(String line) {
        return new ArrayList<>(Arrays.asList(parseItem(line)[StorageConstants.ALLERGIES_LOCATION]
                .split(StorageConstants.ALLERGY_DELIMITER)));
    }

    private MealCategory parseCategory(String line) {
        return MealCategory.valueOf(parseItem(line)[StorageConstants.CATEGORY_LOCATION]);
    }

    private LocalDate parseDate(String line) {
        return LocalDate.parse(parseItem(line)[StorageConstants.DATE_LOCATION]);
    }

    private String parseURL(String line) {
        return (parseItem(line)[StorageConstants.URL_LOCATION]);
    }

    private static void identifySelfAsStorageClient() {
        System.out.print(StorageConstants.STORAGE_CLIENT_GREETING);
    }
}
