package commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import recipeio.commands.DeleteRecipeCommand;
import recipeio.recipe.Recipe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class DeleteCommandTest {
    private ArrayList<Recipe> recipes;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        recipes = new ArrayList<>();
        recipes.add(new Recipe("Pasta", 20, 500,
                null, null, null, "www.example.com"));
        recipes.add(new Recipe("Soup", 15, 300,
                null, null, null, "www.example.com"));
        recipes.add(new Recipe("Salad", 10, 200,
                null, null, null, "www.example.com"));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testValidDelete() {
        DeleteRecipeCommand.execute(1, recipes);
        assertEquals(2, recipes.size());
        assertTrue(outContent.toString().contains("Pasta"));
    }

    @Test
    public void testDeleteOutOfRangeHigh() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                DeleteRecipeCommand.execute(4, recipes));
        assertEquals("Index 3 out of bounds for length 3", exception.getMessage());
    }

    @Test
    public void testDeleteOutOfRangeLow() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                DeleteRecipeCommand.execute(0, recipes));
        assertEquals("Index -1 out of bounds for length 3", exception.getMessage());
    }

    @Test
    public void testDeleteEmptyList() {
        recipes.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> DeleteRecipeCommand.execute(1, recipes));
    }
}
