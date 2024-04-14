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

    public String getName() {
        return name;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public int getCalories() {
        return calories;
    }

    public int getCookTime() {
        return cookTime;
    }

    public String getURL() {
        return url;
    }
    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public MealCategory getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return name + " / added on " + dateAdded + " / url: " + url;
    }
}
