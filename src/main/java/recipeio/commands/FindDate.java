package recipeio.commands;

import recipeio.constants.CommandConstants;
import recipeio.recipe.Recipe;
import recipeio.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;

import static recipeio.constants.CommandConstants.NO_MATCHES_ERROR;
import static recipeio.constants.CommandConstants.VALID_DATE_MATCHES;

public class FindDate {

    public static void execute(LocalDate date, ArrayList<Recipe> recipes) {
        ArrayList<Recipe> matches = new ArrayList<>();
        ArrayList<Integer> listNumbers = new ArrayList<>();
        Integer count = CommandConstants.STARTING_COUNT;
        for (Recipe recipe : recipes) {
            if (recipe.dateAdded.isEqual(date)) {
                matches.add(recipe);
                listNumbers.add(count);
            }
            count ++;
        }
        if (matches.isEmpty()) {
            System.out.println(NO_MATCHES_ERROR);
            return;
        }
        System.out.println(VALID_DATE_MATCHES + date + "\n");
        UI.printRecipes(matches, listNumbers);
    }


}
