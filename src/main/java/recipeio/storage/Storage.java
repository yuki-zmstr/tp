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

import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

public class Storage {
    public static final String DELIMITER_WRITE = " | ";
    public static final String DELIMITER_READ = " \\| ";
    public static final String DELIMITER_ALLERGY = ",";
    public static final String MINUTE_IDENTIFIER = " mins";
    public static final String CALORIE_IDENTIFIER = " kcals";
    private static File dataFile;
    private static String pathToFile;

    public Storage(String fileName) {
        dataFile = new File(fileName);
        pathToFile = fileName;
    }

    public static void createDataFile() throws IOException{
        if (dataFile.exists()) {
            return;
        }
        if (!dataFile.getParentFile().exists()) {
            // create directory to save in.
            boolean hasDirectoryCreated = dataFile.getParentFile().mkdirs();
            if (!hasDirectoryCreated) {
                throw new IOException("Failed to create the 'data' directory.");
            }
            // create file to save in.
            boolean hasFileCreated = dataFile.createNewFile();
            if (!hasFileCreated) {
                throw new IOException("Failed to create the output text file.");
            }
        }
    }

    /**
     * Save the list of items to a txt file
     *
     * @throws IOException for any issues saving list to txt file
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
            bw.write(DELIMITER_WRITE);
            bw.write(String.valueOf(recipe.cookTime) + MINUTE_IDENTIFIER);
            bw.write(DELIMITER_WRITE);
            bw.write(String.valueOf(recipe.calories) + CALORIE_IDENTIFIER);
            bw.write(DELIMITER_WRITE);
            bw.write(String.join(DELIMITER_ALLERGY, recipe.allergies));
            bw.write(DELIMITER_WRITE);
            bw.write(recipe.category.toString());
            bw.write(DELIMITER_WRITE);
            bw.write(recipe.dateAdded.toString());
            bw.write(DELIMITER_WRITE);
            bw.write(recipe.url);
            bw.newLine();
        }
        bw.close();
        System.out.println("\tStorage client says: Successfully saved recipe book.");
    }

    /**
     * Attempts to load tasks from input data file into an ArrayList of Task.
     */
    public ArrayList<Recipe> loadData() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        try {
            ArrayList<String> dataItems = readFile();
            recipeList = parse(dataItems);
            System.out.println("Storage Client says: Loaded recipe book.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return recipeList;
    }

    /**
     * Loads the text file into a recipeList
     *
     * @throws FileNotFoundException if file cannot be found
     */
    private ArrayList<String> readFile() throws IOException {
        if (!dataFile.exists()) {
            throw new FileNotFoundException("No input file found, will create a new one.");
        }
        if (dataFile.length() == 0) {
            System.out.println("empty file");
            throw new IOException();
        }
        return (ArrayList<String>) Files.readAllLines(dataFile.toPath(), Charset.defaultCharset());
    }

    private ArrayList<Recipe> parse(ArrayList<String> dataItems) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (String line : dataItems) {
            String name = parseName(line);
            int cookTime = parseCookTime(line);
            int calories = parseCalories(line);
            ArrayList<String> allergies = parseAllergies(line);
            MealCategory category = parseCategory(line);
            LocalDate dateAdded = parseDate(line);
            String url = parseURL(line);
            Recipe toAdd = new Recipe(name, cookTime, calories, allergies, category, dateAdded, url);
            recipes.add(toAdd);
        }
        return recipes;
    }

    private String[] parseItem(String line) {
        return line.split(DELIMITER_READ);
    }

    private String parseName(String line) {
        return parseItem(line)[0];
    }

    private int parseCookTime(String line) {
        return Integer.parseInt(parseItem(line)[1].replace(MINUTE_IDENTIFIER, ""));
    }

    private int parseCalories(String line) {
        return Integer.parseInt(parseItem(line)[2].replace(CALORIE_IDENTIFIER, ""));
    }

    private ArrayList<String> parseAllergies(String line) {
        return new ArrayList<>(Arrays.asList(parseItem(line)[3].split(DELIMITER_ALLERGY)));
    }

    private MealCategory parseCategory(String line) {
        return MealCategory.valueOf(parseItem(line)[4]);
    }

    private LocalDate parseDate(String line) {
        return LocalDate.parse(parseItem(line)[5]);
    }

    private String parseURL(String line) {
        return (parseItem(line)[6]);
    }
}
