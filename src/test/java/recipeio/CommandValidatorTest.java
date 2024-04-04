package recipeio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommandValidatorTest {

    @Test
    public void isValidAddCommand_validCommand_true() {
        String test = "add pizza, 34, 340, egg nut dairy gluten, dinner, www.food.com";
        assertTrue(CommandValidator.isValidAddCommand(test));
    }

    @Test
    public void isValidAddCommand_invalidCommand_false() {
        String test = "add pizza, abc, 340, egg nut dairy gluten, dinner, www.food.com";
        assertFalse(CommandValidator.isValidAddCommand(test));
    }

}
