package commands;

import org.junit.jupiter.api.Test;
import recipeio.constants.CommandValidatorConstants;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;
import recipeio.ui.UI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCommandTest {

    private static final String TEST1 = "list sortname sortdate";

    private static final String TEST2 = "list srt";

    private static final String SORT_TYPE_LIST =
    "These are the valid sort type inputs:" + System.lineSeparator()
    + "\tsortname: Sort the list by name in lexicographically ascending order" + System.lineSeparator()
    + "\tsortdate: Sort the list by date in ascending order i.e. from oldest to newest" + System.lineSeparator()
    + "\tsortcooktime: Sort the list by cook time in ascending order" + System.lineSeparator()
    + "\tsortcalories: Sort the list by calories in ascending order" + System.lineSeparator();

    ArrayList<Recipe> recipes = new ArrayList<>();
    Recipe testRecipe1;
    Recipe testRecipe2;
    Recipe testRecipe3;
    Recipe testRecipe4;
    Recipe testRecipe5;
    RecipeList testList;

    private void initTest() {
        ArrayList<String> allergies = new ArrayList<>();
        testRecipe1 = new Recipe("pizza", 34, 340, allergies,
                MealCategory.DINNER, LocalDate.parse("2024-04-10"), "www.url.com");
        testRecipe2 = new Recipe("pho", 100, 600, allergies,
                MealCategory.BREAKFAST, LocalDate.parse("2024-03-12"), "www.pho.com");
        testRecipe3 = new Recipe("banh mi", 5, 500, allergies,
                MealCategory.BREAKFAST, LocalDate.parse("2022-01-12"), "www.banhmi.com");
        testRecipe4 = new Recipe("bun bo hue", 480, 600, allergies,
                MealCategory.LUNCH, LocalDate.parse("2013-04-12"), "www.bunbohue.com");
        testRecipe5 = new Recipe("tra da", 2, 10, allergies,
                MealCategory.DESSERT, LocalDate.parse("2024-01-12"), "www.trada.com");

        recipes.add(testRecipe1);
        recipes.add(testRecipe2);
        recipes.add(testRecipe3);
        recipes.add(testRecipe4);
        recipes.add(testRecipe5);

        testList = new RecipeList(recipes);
    }
    @Test
    public void testRedundantDetails() {
        initTest();
        String expected = CommandValidatorConstants.EXCESS_DETAILS_ERROR + System.lineSeparator();
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        testList.listRecipes(TEST1);

        String actual = testOut.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void testWrongSortType() {
        initTest();
        String expected = CommandValidatorConstants.INVALID_SORT_TYPE_ERROR_MESSAGE +
                System.lineSeparator() +
                SORT_TYPE_LIST;
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        testList.listRecipes(TEST2);

        String actual = testOut.toString();

        assertEquals(actual, expected);
    }
}
