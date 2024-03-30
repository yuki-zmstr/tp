package recipeio;

import recipeio.recipe.RecipeList;
import recipeio.storage.Storage;
import recipeio.ui.UI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
/**
 * Main entry-point for the Recipe.IO application.
 */
public class RecipeIO {
    private static UI ui;
    private static final Logger logger = Logger.getLogger("RecipeIO Logger");
    private final RecipeList recipeList;

    public RecipeIO(String filePath) {
        ui = new UI();
        Storage storage = new Storage(filePath);
        recipeList = new RecipeList(storage.loadData());
    }

    public void run() {
        UI.sayHi();
        runCommandLoopUntilExitCommand();
        UI.bye();
    }

    public void runCommandLoopUntilExitCommand() {
        logger.log(Level.INFO, Constants.MESSAGE_ASK_INPUT);
        String userInput = ui.getUserInput();
        String parsedCommand = InputParser.parseCommand(userInput);
        assert !userInput.isEmpty() : "user input empty";

        while (!parsedCommand.equals(Constants.EXIT_COMMAND)) {
            logger.log(Level.INFO, "Executing command: "+ userInput);
            recipeList.executeCommand(parsedCommand, userInput);
            logger.log(Level.INFO, Constants.MESSAGE_ASK_INPUT);
            userInput = ui.getUserInput();
            parsedCommand = InputParser.parseCommand(userInput);
        }

    }

    public static void setUpLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        try {
            FileHandler fileHandler = new FileHandler("logger.log", false);
            fileHandler.setLevel(Level.INFO);
            logger.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            assert logger.getHandlers().length > 0 : "File handler not added to logger";
        } catch (IOException e){
            logger.log(Level.SEVERE, "File logger not working");
        }
    }

    public static void main(String[] args) {
        setUpLogger();
        new RecipeIO("data/recipe.txt").run();
    }
}
