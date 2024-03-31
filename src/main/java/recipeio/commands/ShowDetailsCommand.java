package recipeio.commands;

import recipeio.recipe.Recipe;

public class ShowDetailsCommand {

    /**
     * Prints details about a recipe.
     *
     * @param recipe The recipe to show details of.
     */
    public static void execute(Recipe recipe) {

        System.out.println("\tHere are the details:");
        System.out.println("\t\tName: " + recipe.name);
        System.out.println("\t\tCook time: " + recipe.cookTime + " min");
        System.out.println("\t\tCalories: " + recipe.calories + " kcal");
        System.out.print("\t\tAllergies: ");
        recipe.allergies.forEach(System.out::print);
        System.out.println("\n\t\tCategory: " + recipe.category);
        System.out.println("\t\tDateAdded: " + recipe.dateAdded.toString());
        System.out.println("\t\tURL: " + recipe.url);
    }
}
