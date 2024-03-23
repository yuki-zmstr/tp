package storage;
import org.junit.jupiter.api.Test;
import recipeio.recipe.RecipeList;
import recipeio.storage.Storage;
import recipeio.Constants;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class StorageTest {
    @Test
    public void testExist(){
        File f = new File(Constants.FILE_PATH);
        assert f.getPath().equals(Constants.FILE_PATH) : "File exists";
        if (f.exists()) {
            assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    public void testSaving(){
        RecipeList testRecipeList = new RecipeList();
        try {
            Storage.loadFile(testRecipeList);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}
