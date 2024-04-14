import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipeio.enums.MealCategory;
import recipeio.recipe.Recipe;
import recipeio.recipe.RecipeList;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecipeListTest {
    private RecipeList recipeList;
    private static final String RECIPE_INPUT = "add pasta, 20, 500, dairy / egg, dinner, www.example.com";
    private static final ArrayList<String> ALLERGIES = new ArrayList<>(List.of("dairy", "egg"));
    private static final Recipe RECIPE = new Recipe("pasta", 20, 500, ALLERGIES,
            MealCategory.DINNER, LocalDate.now(),"www.example.com");

    @BeforeEach
    public void setup() {
        recipeList = new RecipeList(new ArrayList<>());
    }

    @Test
    public void testAddRecipe() {
        recipeList.add(RECIPE_INPUT);
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
        recipeList.add(RECIPE_INPUT);
        recipeList.delete("delete 1");
        assertEquals(recipeList.getSize(), 0);
    }

    @Test
    public void testGetRecipeByIndex() {
        recipeList.add(RECIPE_INPUT);
        Recipe actual = recipeList.get(0);
        assertEquals(RECIPE.getName(), actual.getName());
        assertEquals(RECIPE.getCookTime(), actual.getCookTime());
        assertEquals(RECIPE.getCalories(), actual.getCalories());
        assertEquals(RECIPE.getURL(), actual.getURL());
        assertEquals(RECIPE.getDateAdded(), actual.getDateAdded());
        assertEquals(RECIPE.getCategory(), actual.getCategory());
        assertIterableEquals(RECIPE.getAllergies(), actual.getAllergies());
    }
}