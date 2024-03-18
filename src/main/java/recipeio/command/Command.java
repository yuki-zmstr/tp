package recipeio.command;

import recipeio.recipe.RecipeList;
import recipeio.storage.Storage;

/**
 * A command class to keep track of different user actions.
 * Inspiration from addressbook-level 2 Github.
 */
public abstract class Command {
    public abstract void execute(RecipeList recipes, Storage storage) throws Exception;

    public boolean isExitCommand() {
        return false;
    }
}
