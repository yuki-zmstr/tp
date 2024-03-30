package recipeio.recipe;

import recipeio.Constants;
import recipeio.InputParser;
import recipeio.CommandValidator;
import recipeio.commands.AddRecipeCommand;
import recipeio.commands.ListRecipeCommand;
import recipeio.commands.ShowDetailsCommand;
import recipeio.commands.FindCommand;
import recipeio.commands.FilterByAllergyCommand;
import recipeio.commands.DeleteRecipeCommand;
import recipeio.storage.Storage;

import recipeio.ui.UI;

import java.util.ArrayList;

import static recipeio.Constants.MAX_RECIPES;
import static recipeio.InputParser.parseAdd;

public class RecipeList {
    /**
     * Represents the user's list of recipes (ie their recipe book).
     */
    private final ArrayList<Recipe> recipes;

    public RecipeList(ArrayList<Recipe> recipeData) {
        this.recipes = recipeData;
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

    public void listRecipes() {
        ListRecipeCommand.execute(recipes);
    }

    public void showDetails(String userInput) {
        if (!CommandValidator.isValidDetailCommand(userInput, recipes)){
            return;
        }
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return;
        }
        Recipe recipe = get(index-1);
        ShowDetailsCommand.execute(recipe);
    }

    public void add(String userInput) {
        assert(recipes.size() < MAX_RECIPES);
        try {
            Recipe newRecipe = parseAdd(userInput);
            AddRecipeCommand.execute(newRecipe, recipes);
            UI.printAddMessage(newRecipe, recipes.size());
            saveRecipes();
        } catch (Exception e){
            UI.printMessage(e.getMessage());
        }
    }

    public void add(Recipe recipe) {
        AddRecipeCommand.execute(recipe, recipes);
    }

    public void delete(String userInput) {
        if (!CommandValidator.isValidDeleteCommand(userInput, recipes)){
            return;
        }
        Integer index = InputParser.parseID(userInput);
        if (index == null) {
            return;
        }
        DeleteRecipeCommand.execute(index, recipes);
        saveRecipes();
    }

    /**
     * Deletes the recipe at the specified index, used in test methods.
     *
     * @param index The index of the recipe.
     */
    public void delete(int index) {
        DeleteRecipeCommand.execute(index, recipes);
    }

    public void find(String userInput) {
        if (recipes.isEmpty()) {
            System.out.println(Constants.NO_RECIPES_ERROR_MESSAGE);
            return;
        }
        FindCommand.execute(userInput, recipes);
    }

    public void filter(String userInput) {
        if (recipes.isEmpty()) {
            System.out.println(Constants.NO_RECIPES_ERROR_MESSAGE);
            return;
        }
        if (!CommandValidator.isValidFilterCommand(userInput)){
            return;
        }
        FilterByAllergyCommand.execute(userInput, recipes);
    }

    public void saveRecipes() {
        try {
            Storage.saveFile(recipes);
        } catch (Exception e) {
            System.out.println("File save unsuccessful");
        }
    }

    public void clear() {
        recipes.clear();
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
            delete(userInput);
            break;
        case Constants.FIND_COMMAND:
            find(userInput);
            break;
        case Constants.FILTER_COMMAND:
            filter(userInput);
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
