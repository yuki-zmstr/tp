package recipeio.recipe;

import recipeio.Constants;
import recipeio.InputParser;
import recipeio.commands.AddRecipeCommand;
import recipeio.commands.DeleteRecipeCommand;
import recipeio.commands.FindByAllergyCommand;
import recipeio.commands.FindByNameCommand;
import recipeio.commands.ListRecipeCommand;
import recipeio.ui.UI;
import recipeio.storage.Storage;

import java.util.ArrayList;

import static recipeio.Constants.MAX_RECIPES;
import static recipeio.InputParser.parseAdd;

public class RecipeList {
    /**
     * Represents the user's list of recipes (ie their recipe book).
     */
    private final ArrayList<Recipe> recipes;

    public RecipeList() {
        this.recipes = new ArrayList<>();
        loadRecipes();
    }

    /**
     * Returns the size of the list (recipe book).
     */
    public int getSize() {
        return recipes.size();
    }

    /**
     * Returns the recipe at the specified index.
     *
     * @param index The index of the recipe.
     * @return The recipe at the specified index.
     */
    public Recipe get(int index) {
        return recipes.get(index);
    }

    /**
     * Used to add recipes from user inputs
     *
     * @param userInput takes the user input
     */
    public void add(String userInput) {
        assert(recipes.size() < MAX_RECIPES);
        try {
            Recipe newRecipe = parseAdd(userInput);
            AddRecipeCommand.execute(newRecipe, recipes, false);
            saveRecipes();
        } catch (Exception e){
            UI.printMessage(e.getMessage());
        }
    }

    /**
     * Used to load recipe to RecipeList
     */
    public void add(Recipe recipe) {
        AddRecipeCommand.execute(recipe, recipes, true);
    }

    public void delete (String userInput) {
        int index = InputParser.parseID(userInput);
        DeleteRecipeCommand.execute(index, recipes);
        saveRecipes();
    }

    public void delete (int index) {
        DeleteRecipeCommand.execute(index, recipes);
        saveRecipes();
    }

    public void listRecipes() {
        ListRecipeCommand.execute(recipes);
    }

    public void findName(String name) {
        FindByNameCommand.execute(name, recipes);
    }

    public String findAllergy(String allergy) {
        return FindByAllergyCommand.execute(allergy, recipes);
    }

    public void saveRecipes() {
        try {
            Storage.saveFile(RecipeList.this);
            System.out.println(Constants.RECIPE_SAVE_SUCCESS);
        }
        catch (Exception e) {
            System.out.println(Constants.RECIPE_SAVE_ERROR);
        }
    }

    public void loadRecipes() {
        try {
            Storage.loadFile(RecipeList.this);
            System.out.println(Constants.RECIPE_LOAD_SUCCESS);
        } catch (Exception e) {
            System.out.println(Constants.RECIPE_LOAD_ERROR);
        }
    }

    public void executeCommand(String command, String userInput){
        switch (command) {
        case Constants.LIST_COMMAND:
            listRecipes();
            break;
        case Constants.ADD_COMMAND:
            add(userInput);
            break;
        case Constants.DELETE_COMMAND:
            delete(userInput);
            break;
        case Constants.FIND_BY_NAME:
            findName(userInput);
            break;
        default:
            System.out.println("try another command");
        }
    }
}
