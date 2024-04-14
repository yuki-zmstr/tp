package recipeio.recipe;

import recipeio.enums.MealCategory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The Recipe class represents a recipe containing attributes: name, cook time (in minutes),
 * calories (in kcals), list of allergies, meal category, and URL.
 */
public class Recipe {
    public String name = "";
    public int cookTime = 0;
    public int calories = 0;
    public ArrayList<String> allergies;
    public MealCategory category;
    public String url;
    public LocalDate dateAdded;

    /**
     * Constructor for Recipe.
     *
     * @param name The name of the recipe.
     * @param cookTime The cook time of the recipe.
     * @param calories The calories of the recipe.
     * @param allergies The list of allergies of the recipe.
     * @param category The meal category of the recipe.
     * @param dateAdded The date the recipe was added.
     * @param url The URL of the recipe.
     */
    public Recipe(String name, int cookTime, int calories, ArrayList<String> allergies,
                  MealCategory category, LocalDate dateAdded, String url) {
        this.name = name;
        this.cookTime = cookTime;
        this.calories = calories;
        this.allergies = allergies;
        this.category = Objects.requireNonNullElse(category, MealCategory.GENERAL);
        this.dateAdded = dateAdded;
        this.url = url;
    }

    /**
     * Returns the name of the recipe.
     *
     * @return The name of the recipe.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the date the recipe was added.
     *
     * @return The date the recipe was added.
     */
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    /**
     * Returns the calories of the recipe.
     *
     * @return The calories of the recipe.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns the cook time of the recipe.
     *
     * @return The cook time of the recipe.
     */
    public int getCookTime() {
        return cookTime;
    }

    /**
     * Returns the URL of the recipe.
     *
     * @return The URL of the recipe.
     */
    public String getURL() {
        return url;
    }

    /**
     * Returns the list of allergies of the recipe.
     *
     * @return The list of allergies of the recipe.
     */
    public ArrayList<String> getAllergies() {
        return allergies;
    }

    /**
     * Returns the meal category of the recipe.
     *
     * @return The meal category of the recipe.
     */
    public MealCategory getCategory() {
        return category;
    }

    /**
     * Returns a string representation of the recipe.
     *
     * @return A string representation of the recipe.
     */
    @Override
    public String toString() {
        return name + " / added on " + dateAdded + " / url: " + url;
    }
}
