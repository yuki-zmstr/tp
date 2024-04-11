package commands;

import org.junit.jupiter.api.Test;
import recipeio.commands.SortAscendingNames;
import recipeio.commands.SortAscendingCalories;
import recipeio.commands.SortAscendingCookTime;
import recipeio.commands.SortAscendingDateAdded;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortCommandsTest {

    ArrayList<Recipe> recipes = new ArrayList<>();
    Recipe testRecipe1;
    Recipe testRecipe2;
    Recipe testRecipe3;
    Recipe testRecipe4;
    Recipe testRecipe5;
    void initRecipes() {
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
    }

    @Test
    public void testSortNamesAscending() {
        initRecipes();
        ArrayList<Recipe> actual = SortAscendingNames.execute(recipes);
        ArrayList<Recipe> expected = new ArrayList<>();
        expected.add(testRecipe3);
        expected.add(testRecipe4);
        expected.add(testRecipe2);
        expected.add(testRecipe1);
        expected.add(testRecipe5);
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testSortAscendingDateAdded() {
        initRecipes();
        ArrayList<Recipe> actual = SortAscendingDateAdded.execute(recipes);
        ArrayList<Recipe> expected = new ArrayList<>();
        expected.add(testRecipe4);
        expected.add(testRecipe3);
        expected.add(testRecipe5);
        expected.add(testRecipe2);
        expected.add(testRecipe1);
        assertEquals(actual.toString(), expected.toString());

    }

    @Test
    public void testSortAscendingCalories() {
        initRecipes();
        ArrayList<Recipe> actual = SortAscendingCalories.execute(recipes);
        ArrayList<Recipe> expected = new ArrayList<>();
        expected.add(testRecipe5);
        expected.add(testRecipe1);
        expected.add(testRecipe3);
        expected.add(testRecipe2);
        expected.add(testRecipe4);
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void testSortAscendingCookTime() {
        initRecipes();
        ArrayList<Recipe> actual = SortAscendingCookTime.execute(recipes);
        ArrayList<Recipe> expected = new ArrayList<>();
        expected.add(testRecipe5);
        expected.add(testRecipe3);
        expected.add(testRecipe1);
        expected.add(testRecipe2);
        expected.add(testRecipe4);
        assertEquals(actual.toString(), expected.toString());
    }
}
