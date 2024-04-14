package recipe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipeio.constants.CommandConstants;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecipeListTest {
    public static final String RECIPE_DELETE_INPUT = "delete 1";
    private RecipeList recipeList;
    private static final String RECIPE_ADD_INPUT = "add pasta, 20, 500, dairy / egg, dinner, www.example.com";
    private static final ArrayList<String> ALLERGIES = new ArrayList<>(List.of("dairy", "egg"));
    private static final Recipe RECIPE = new Recipe("pasta", 20, 500, ALLERGIES, MealCategory.DINNER, LocalDate.now(), "www.example.com");

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        recipeList = new RecipeList(new ArrayList<>());
        recipeList.add(RECIPE_ADD_INPUT); // Adding a recipe for testing
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @BeforeEach
    public void setup() {
        recipeList = new RecipeList(new ArrayList<>());
    }

    @Test
    public void testAddRecipe() {
        recipeList.add(RECIPE_ADD_INPUT);
        assertEquals(RECIPE.name, recipeList.get(0).name);
        assertEquals(RECIPE.cookTime, recipeList.get(0).cookTime);
        assertEquals(RECIPE.calories, recipeList.get(0).calories);
        assertEquals(RECIPE.allergies, recipeList.get(0).allergies);
        assertEquals(RECIPE.url, recipeList.get(0).url);
        assertEquals(RECIPE.category, recipeList.get(0).category);
        assertEquals(RECIPE.dateAdded, recipeList.get(0).dateAdded);
    }

    @Test
    public void testDeleteRecipe() {
        recipeList.add(RECIPE_ADD_INPUT);
        recipeList.delete(RECIPE_DELETE_INPUT);
        assertEquals(recipeList.getSize(), 0);
    }

    @Test
    public void testGetRecipeByIndex() {
        recipeList.add(RECIPE_ADD_INPUT);
        Recipe actual = recipeList.get(0);
        assertEquals(RECIPE.getName(), actual.getName());
        assertEquals(RECIPE.getCookTime(), actual.getCookTime());
        assertEquals(RECIPE.getCalories(), actual.getCalories());
        assertEquals(RECIPE.getURL(), actual.getURL());
        assertEquals(RECIPE.getDateAdded(), actual.getDateAdded());
        assertEquals(RECIPE.getCategory(), actual.getCategory());
        assertIterableEquals(RECIPE.getAllergies(), actual.getAllergies());
    }

    @Test
    public void testFindKeywordRecipe() {
        recipeList.add(RECIPE_ADD_INPUT);
        recipeList.find("find kw pasta");
        assertTrue(outContent.toString().contains(CommandConstants.VALID_KEYWORD_MATCHES + "pasta"));
        assertTrue(outContent.toString().contains(RECIPE.getURL()));
        assertTrue(outContent.toString().contains("pasta"));
    }

    @Test
    public void testFindMealRecipe() {
        recipeList.add(RECIPE_ADD_INPUT);
        recipeList.find("find meal dinner");
        assertTrue(outContent.toString().contains(CommandConstants.VALID_CATEGORY_MATCHES + "dinner"));
        assertTrue(outContent.toString().contains(RECIPE.getURL()));
        assertTrue(outContent.toString().contains("pasta"));
    }

    @Test
    public void testFindUrlRecipe() {
        recipeList.add(RECIPE_ADD_INPUT);
        recipeList.find("find url www.example.com");
        assertTrue(outContent.toString().contains(CommandConstants.VALID_URL_MATCHES + "www.example.com"));
        assertTrue(outContent.toString().contains(RECIPE.getURL()));
        assertTrue(outContent.toString().contains("pasta"));
    }

}