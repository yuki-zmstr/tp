package recipeio.recipe;

import recipeio.Constants;
import recipeio.InputParser;
import recipeio.Utils;
import recipeio.commands.AddRecipeCommand;
import recipeio.commands.ListRecipeCommand;
import recipeio.commands.ShowDetailsCommand;
import recipeio.commands.FindCommand;
import recipeio.commands.FindByAllergyCommand;
import recipeio.commands.DeleteRecipeCommand;
import recipeio.storage.Storage;

import recipeio.exceptions.InvalidIndexException;
import recipeio.ui.UI;

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

    public void add(String userInput) {
        assert(recipes.size() < MAX_RECIPES);
        try {
            Recipe newRecipe = parseAdd(userInput);
            AddRecipeCommand.execute(newRecipe, recipes);
            saveRecipes();
        } catch (Exception e){
            UI.printMessage(e.getMessage());
        }
    }

    public void add(Recipe recipe) {
        AddRecipeCommand.execute(recipe, recipes);
    }

    public void delete (int index) {
        try {
            DeleteRecipeCommand.execute(index, recipes);
            saveRecipes();
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage() + "\nPlease enter a valid index");
        }
    }

    public void listRecipes() {
        ListRecipeCommand.execute(recipes);
    }

    public void showDetails(String userInput) {
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return;
        }
        if (!Utils.isWithinRange(recipes, index)) {
            return;
        }
        Recipe recipe = get(index-1);
        ShowDetailsCommand.execute(recipe);
    }

    public void find(String input) {
        FindCommand.execute(input, recipes);
    }

    public String findAllergy(String allergy) {
        return FindByAllergyCommand.execute(allergy, recipes);
    }

    public void saveRecipes() {
        try {
            Storage.saveFile(RecipeList.this);
            System.out.println("File save successful");
        }
        catch (Exception e) {
            System.out.println("File save unsuccessful");
        }
    }

    public void loadRecipes() {
        try {
            Storage.loadFile(RecipeList.this);
            System.out.println("File load successful");
        } catch (Exception e) {
            System.out.println("File load unsuccessful");
        }
    }

    public void executeCommand(String command, String userInput){
        switch (command) {
        case Constants.LIST_COMMAND:
            listRecipes();
            break;
        case Constants.DETAIL_COMMAND:
            showDetails(userInput);
            break;
        case Constants.ADD_COMMAND:
            add(userInput);
            break;
        case Constants.DELETE_COMMAND:
            Integer index = InputParser.parseID(userInput);
            if (index != null) {
                delete(index);
            }
            break;
        case Constants.FIND_COMMAND:
            find(userInput);
            break;
        case Constants.HELP_COMMAND:
            UI.printInstructions();
            break;
        default:
            UI.printInvalidCommandWarning();
            UI.printInstructions();
            break;
        }
    }
}
