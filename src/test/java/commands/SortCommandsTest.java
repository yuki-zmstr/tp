package commands;

import org.junit.jupiter.api.Test;
import recipeio.commands.SortAscendingNames;
import recipeio.commands.SortAscendingCalories;
import recipeio.commands.SortAscendingCookTime;
import recipeio.commands.SortAscendingDateAdded;
import recipeio.commands.ListRecipeCommand;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortCommandsTest {

    ArrayList<Recipe> recipes = new ArrayList<>();

    void initRecipes() {
        ArrayList<String> allergies = new ArrayList<>();
        Recipe testRecipe1 = new Recipe("pizza", 34, 340, allergies,
                MealCategory.DINNER, LocalDate.parse("2024-04-10"), "www.url.com");
        Recipe testRecipe2 = new Recipe("pho", 100, 600, allergies,
                MealCategory.BREAKFAST, LocalDate.parse("2024-03-12"), "www.pho.com");
        Recipe testRecipe3 = new Recipe("banh mi", 5, 500, allergies,
                MealCategory.BREAKFAST, LocalDate.parse("2022-01-12"), "www.banhmi.com");
        Recipe testRecipe4 = new Recipe("bun bo hue", 480, 600, allergies,
                MealCategory.LUNCH, LocalDate.parse("2013-04-12"), "www.bunbohue.com");
        Recipe testRecipe5 = new Recipe("tra da", 2, 10, allergies,
                MealCategory.DESSERT, LocalDate.parse("2024-01-12"), "www.trada.com");

        recipes.add(testRecipe1);
        recipes.add(testRecipe2);
        recipes.add(testRecipe3);
        recipes.add(testRecipe4);
        recipes.add(testRecipe5);
    }

    @Test
    public void testSortNamesAscending() {
        initRecipes();

        String expected = "Here is a summary of your recipe book." + System.lineSeparator() +
                "\t1. banh mi / added on 2022-01-12 / url: www.banhmi.com" + System.lineSeparator() +
                "\t2. bun bo hue / added on 2013-04-12 / url: www.bunbohue.com" + System.lineSeparator() +
                "\t3. pho / added on 2024-03-12 / url: www.pho.com" + System.lineSeparator() +
                "\t4. pizza / added on 2024-04-10 / url: www.url.com" + System.lineSeparator() +
                "\t5. tra da / added on 2024-01-12 / url: www.trada.com" + System.lineSeparator() +
                System.lineSeparator() +
                "To find out more about a particular recipe, try the 'detail {recipe number}' command."
                + System.lineSeparator();

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        ArrayList<Recipe> result = SortAscendingNames.execute(recipes);
        ListRecipeCommand.execute(result);

        String actual = testOut.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void testSortAscendingDateAdded() {
        initRecipes();

        String expected = "Here is a summary of your recipe book." + System.lineSeparator() +
                "\t1. bun bo hue / added on 2013-04-12 / url: www.bunbohue.com" + System.lineSeparator() +
                "\t2. banh mi / added on 2022-01-12 / url: www.banhmi.com" + System.lineSeparator() +
                "\t3. tra da / added on 2024-01-12 / url: www.trada.com" + System.lineSeparator() +
                "\t4. pho / added on 2024-03-12 / url: www.pho.com" + System.lineSeparator() +
                "\t5. pizza / added on 2024-04-10 / url: www.url.com" + System.lineSeparator() +
                System.lineSeparator() +
                "To find out more about a particular recipe, try the 'detail {recipe number}' command."
                + System.lineSeparator();

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        ArrayList<Recipe> result = SortAscendingDateAdded.execute(recipes);
        ListRecipeCommand.execute(result);

        String actual = testOut.toString();

        assertEquals(actual, expected);

    }

    @Test
    public void testSortAscendingCalories() {
        initRecipes();

        String expected = "Here is a summary of your recipe book." + System.lineSeparator() +
                "\t1. tra da / added on 2024-01-12 / url: www.trada.com" + System.lineSeparator() +
                "\t2. pizza / added on 2024-04-10 / url: www.url.com" + System.lineSeparator() +
                "\t3. banh mi / added on 2022-01-12 / url: www.banhmi.com" + System.lineSeparator() +
                "\t4. pho / added on 2024-03-12 / url: www.pho.com" + System.lineSeparator() +
                "\t5. bun bo hue / added on 2013-04-12 / url: www.bunbohue.com" + System.lineSeparator() +
                System.lineSeparator() +
                "To find out more about a particular recipe, try the 'detail {recipe number}' command."
                + System.lineSeparator();

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        ArrayList<Recipe> result = SortAscendingCalories.execute(recipes);
        ListRecipeCommand.execute(result);

        String actual = testOut.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void testSortAscendingCookTime() {
        initRecipes();

        String expected = "Here is a summary of your recipe book." + System.lineSeparator() +
                "\t1. tra da / added on 2024-01-12 / url: www.trada.com" + System.lineSeparator() +
                "\t2. banh mi / added on 2022-01-12 / url: www.banhmi.com" + System.lineSeparator() +
                "\t3. pizza / added on 2024-04-10 / url: www.url.com" + System.lineSeparator() +
                "\t4. pho / added on 2024-03-12 / url: www.pho.com" + System.lineSeparator() +
                "\t5. bun bo hue / added on 2013-04-12 / url: www.bunbohue.com" + System.lineSeparator() +
                System.lineSeparator() +
                "To find out more about a particular recipe, try the 'detail {recipe number}' command."
                + System.lineSeparator();

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOut);
        System.setOut(printStream);

        ArrayList<Recipe> result = SortAscendingCookTime.execute(recipes);
        ListRecipeCommand.execute(result);

        String actual = testOut.toString();

        assertEquals(actual, expected);
    }
}
