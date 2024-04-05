package recipeio.commands;

import recipeio.recipe.Recipe;

public class ShowDetailsCommand {

    /**
     * Prints details about a recipe.
     *
     * @param recipe The recipe to show details of.
     */
    public static void execute(Recipe recipe) {

        System.out.println("Here are the details:");
        System.out.println("\tName: " + recipe.name);
        System.out.println("\tCook time: " + recipe.cookTime + " min");
        System.out.println("\tCalories: " + recipe.calories + " kcal");
        System.out.print("\tAllergies: ");
        recipe.allergies.forEach(System.out::print);
        System.out.println("\n\tCategory: " + recipe.category);
        System.out.println("\tDateAdded: " + recipe.dateAdded.toString());
        System.out.println("\tURL: " + recipe.url);
    }
}
