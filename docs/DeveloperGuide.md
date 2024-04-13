# Developer Guide

## Acknowledgements

* This application is built in partial fulfillment of the requirements of CS2113.
* Knowledge and ideas are adapted from the CS2113 textbook, as well as SE-EDU textbook.

---

# Table of Contents

1. [Setting up, getting started](#setting-up-getting-started)
2. [Design & Implementation](#design--implementation)
   1. [Architecture](#architecture)
   2. [UI Component](#ui-component)
   3. [RecipeList Component](#recipelist-component)
3. [Appendix - Requirements](#appendix-requirements)
4. [Appendix - Commands Glossary](#appendix-commands-glossary)
5. [Appendix - Manual Testing](#appendix-instructions-for-manual-testing)
6. [Appendix - Area of Improvement](#appendix-area-of-improvement)

---

## Setting up, getting started

Refer to the User guide at https://ay2324s2-cs2113-w14-2.github.io/tp/UserGuide.html.

---

## Design & implementation

### Architecture

<img src="images/ArchitectureDiagram.png" width="350" />

The ***Architecture Diagram*** given above explains the high-level design of the application.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`RecipeIO`**  is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following five components:

* `UI` The UI of the App.
* `RecipeList`: The command executor and holder of data of the app.
* `InputParser`: Extracts information from the user input into the command line.
* `CommandValidator`: The command validator.
* `Storage`: Reads data from, and writes data to, the hard disk.

The `commands`package represents a collection of commands used by **`RecipeList`**.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/DeleteRecipe.png" width="800" />

### UI Component

The **API** of this component is specified in [UI.java](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/src/main/java/recipeio/ui/UI.java)

![Structure of the UI Component](images/UIDiagram.png)

The `UI` has an class-level attribute `SEPARATOR`, which is a line of dashes that can be used in console output.

The `UI` the following methods
* `getUserInput` : asks the user for an input through the command line.
* `sayHi` (class-level): greets the user.
* `printInstructions` (class-level) : prints a list of accepted commands.
* `printInvalidCommandWarning` (class-level) : warns the user of an invalid command.
* `bye` (class-level) : bids farewell to the user.

How the component works:

* Upon starting of the app, `RecipeIO` will create an instance of the `UI` class.
* The instance will be asking the user for his or her input, via the `getUserInput` method.
* During the execution of the app, it will also give the user some console feedback.
  * For example, the `printInstructions` method is called when the user inputs `help`.


### RecipeList Component

The **API** of this component is specified in [RecipeList.java](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/src/main/java/recipeio/recipe/RecipeList.java)

![Structure of the RecipeList Component](images/RecipeListDiagram.png)

The `RecipeList` contains many `Recipe`s, which has attributes:
* `name` : String
* `cookTime` : int
* `calories` : int
* `allergies` : ArrayList<String>
* `mealCategory` : MealCategory
* `url` : String
* `dateAdded` : LocaleDate

How the component works:

* Upon `executeCommand` call, the `RecipeList` will identify the command given in the user input (e.g. `list`), 
* It will then call the corresponding `list()` method defined in `RecipeList`. 
* This `list()` method in turn calls the `ListRecipeCommand.execute()` command. 
* The reason for such a structure is to allow for command validation *before* the real execution. A good example is the `find()` command. 
* Thus, `RecipeList` contains an intermediate method for each functionality (add, find, delete, so on) , and serves as a command validator.
  * **Note:** these methods have been omitted in the class diagram for brevity.
* In `add()` and `delete()`, the `saveRecipes()` method is called to save the recipeBook after the modification.

---

## Appendix: Requirements

## Product scope

### Target user profile

* Has a need to manage a significant number of recipes.
  * For example, professional culinary practitioners, students who love to cook.
* Can type fast 
* People having special dietary restrictions.
* People who would like easily access the recipes they found online.

### Value proposition

* The user will be able to add, access, and list recipes.
* He can also filter recipes based on ingredients, time required, dietary restrictions, etc.
* The saved recipes will be loaded in a recipe text file for easy sharing with friends.
* The user can put the recipes into different categories.
* THe user can view his recipes in different orders.

## User Stories

| Version | As a ... | I want to ...                              | So that I can ...                                             |
|---------|----------|--------------------------------------------|---------------------------------------------------------------|
| v1.0    | new user | see usage instructions                     | refer to them when I forget how to use the application        |
| v1.0    | user     | add a recipe                               | curate my own unique recipes for future use                   |
| v1.0    | user     | delete a recipe                            | remove any outdated or unimportant recipes                    |
| v2.0    | user     | find a recipe by name                      | locate a recipe without having to go through the entire list  |
| v2.0    | foodie   | save and load recipes                      | share recipes with friends conveniently                       |
| v2.0    | user     | find recipes without a certain ingredient  | save time finding recipes that I can eat                      |
| v2.0    | user     | find a recipe by date                      | find a recipe if I don't remember its name                    |
| v2.1 | user | see a my recipe list in a certain way | make decisions quicker |

### Use cases

(For all use cases below, the **System** is the `RecipeIO` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Delete a recipe**

1.  User requests to list recipes
2.  RecipeIO shows a list of recipes
3.  User requests to delete a specific recipe in the list
4.  AddressBook deletes the person

Use case ends.

## Non-Functional Requirements

1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.

---

## Appendix: Commands Glossary

* *add [NAME, MINUTES, KCALS, ALLERGIES, CATEGORY, URL]* - This is the command a user can call to add a recipe. 
* *help* - This shows the user all the available commands. 
* *list {SORT_TYPE}* - This lists out a users recipebook for them. 
* *delete* - This deletes a recipe at a given valid index. If not valid, it will return an error message.
* *find kw [KEYWORD]* - This finds recipes with a user-given keyword.
* *find date [YYYY-MM-DD]* - This finds recipes added on a user-given date. The date is auto-added when adding. 
* *find allergy [KEYWORD]* - This finds recipes without a certain ingredient.
* *exit* - This is the command to leave the program. 

---

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.</div>

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### Adding a recipe

1. **Test case** `add pizza, 34, 340, egg nut dairy gluten, dinner, www.food.com`
   * **Expected**: Mentioned recipe is added to the list of recipes.
   * **Console output**: Provides a brief description of the added recipe 
   and total number recipes present in list.

2. **Test case** `add pizza, 34, 340, egg nut dairy gluten, dinner`
   * **Expected**: Recipe is not added to the list due to missing parameter.
   * **Console output**: Asks the user to input 6 parameters.

3. **Test case** `add pizza, abc, def, egg nut dairy gluten, dinner, www.food.com`
   * **Expected**: Recipe is not added to list due to incorrect input types.
   * **Console output**: Asks the user to use integer for fields of cook time
   and calories.

4. **Test case** `add pizza, 34, 340, egg nut dairy gluten, capybara, www.food.com`
   * **Expected**: Recipe is not added to the list due to invalid meal categories.
   * **Console output**: Asks the user to select correct meal category from options of
   breakfast, lunch, dinner, appetizer and dessert.

5. **Test case** `add pizza, 34, 340, egg nut dairy gluten, lunch, food.com`
   * **Expected**: Recipe is not added to the list due to missing protocol.
   * **Console output**: Asks the user to utilise proper protocols with examples

6. **Test case** `add pizza, 34, 340, egg nut dairy gluten, lunch, www.food`
   * **Expected**: Recipe is not added to the list due to invalid domain or TLD
   * **Console output**: Asks the user to utilise proper domains with examples

### Deleting a recipe

**Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.

1. **Test case**: `delete 1`
   * **Expected**: First recipe is deleted from the list. 
   * *Console output*: Says which recipe was deleted with a brief description.

2. **Test case**: `delete 0`
   * **Expected**: No recipe is deleted due to index given being out of bounds.
   * *Console output*: Asks the user to input a number within the range of the recipe list numbers.

3. **Test case**: `delete xyz`
   * **Expected**: No recipe is deleted. 
   * *Console output*: Asks the user to input an integer instead of other data types.

4. **Test case**: `delete`
   * **Expected**: No recipe is deleted due to given index. 
   * *Console output* Asks the user to use an index parameter for the delete function.

### Finding a recipe by keyword

**Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.
   At least one with "soup" in recipe name.

1. **Test case**: `find kw soup`
   * **Expected**: Matching recipes are found. 
   * *Console output*: Shows the user which recipes have the word "soup" in its name.

2. **Test case**: `find kw sou`
   * **Expected**: No matching recipe is found. 
   * *Console output*: Asks the user to attempt to search for another ingredient.

3. **Test case**: `find kw`
   * **Expected**: No matching recipe is found due to lack of search keywords.
   * *Console output*: Asks the user to check that he or she inputted two arguments to the find method.

4. **Test case**: `find kw 1`
   * **Expected**: No matching recipes is found due to invalid keyword. 
   * *Console output*: Asks the user to ensure the keyword uses alphabets.

### Finding a recipe by date

1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.
   At least one with date as `2024-03-30` but none with `2024-01-03`.

2. **Test case**: `find date 2024-03-30`
   * **Expected**: Matching recipes are found with a valid date given. 
   * *Console output*: Shows the user which recipes were added on 2024-03-30.

3. **Test case**: `find date 2024-01-03`
   * **Expected**: No matching recipes are found despite a valid date given. 
   * *Console output*: Reports that no recipes were added on 2024-01-03 as a 
   valid date is given without any matching recipes.

4. **Test case**: `find date xyx`
   * **Expected**: No recipe is found due to invalid date format or not following the
   correct date convention. 
   * *Console output*: Reports that the parameter cannot be parsed as a valid date. 
   * *Console output*: Also hints at the user to use the format of YYYY-MM-DD.

5. **Test case**: `find date`
   * **Expected**: No recipe is found due to the lack of a given date. 
   * *Console output*: Asks the user to check that he or she inputted two arguments to the find method.

### Show the recipe list
1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.

2. **Test case**: `list sortname sortdate`
   * **Expected**: The recipe list is not shown due to having extra details aside from `SORT_TYPE`
   * *Console output*: Reports that there are redundant details for the command

3. **Test case**: `list srt`
   * **Expected**: The recipe list is not shown due to the incorrect `SORT_TYPE`.
   * *Console output*: Reports that `SORT_TYPE` is incorrect.
   * *Console output*: Also display available options for `SORT_TYPE` to the user.

4. **Test case**: `list sortname`
   * **Expected**: The recipes in recipe list are sorted according to their name.
   * *Console output*: Display list of recipes organised according to their recipe name in alphabetical order.

5. **Test case**: `list sortdate`
   * **Expected**: The recipes in recipe list are sorted according to the date they were added.
   * *Console output*: Display list of recipes organised according to the date they were added from earliest to latest.

6. **Test case**: `list sortcooktime`
   * **Expected**: The recipe list is sorted according to their cook time.
   * *Console output*: Display list of recipes organised according to their cooking time from the shortest.

7. **Test case**: `list sortcalories`
   * **Expected**: The recipe list is sorted according to their calories.
   * *Console output*: Display list of recipes organised according to their calories from the lowest.
   

### Finding a recipe by url

1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.
   At least one recipe with url of `www.food.com/fish` but none with url of `www.food.net`.

2. **Test case**: `find url www.food.com`
   * **Expected**: Matching recipes containing valid urls are given, including `www.food.com/fish`
   * *Console output*: Shows the user which recipes match the url of `www.food.com`
   
3. **Test case**: `find url`
   * **Expected**: No recipe is found due to the lack of a given url.
   * *Console output*: Asks the user to check that he or she inputted two arguments to the find method.

4. **Test case**: `find url 123`
   * **Expected**: No recipe is found due to an invalid url subdomain.
   * *Console output*: Reports to the user that a valid subdomain must be given, with valid url examples given.

5. **Test case**: `find url food.com`
   * **Expected**: No recipe is found due to an invalid url subdomain.
   * *Console output*: Reports to the user that a valid subdomain must be given, with valid url examples given.

6. **Test case**: `find url www.food`
   * **Expected**: No recipe is found due to an invalid url domain.
   * *Console output*: Reports to the user that a valid domain or TLD must be given, with valid url examples given.

7. **Test case**: `find url www.food.net`
   * **Expected**: No matching recipes are found despite a valid url given.
   * *Console output*: Reports that no recipes matches `www.food.net` as a
     valid url is given without any matching recipes.

8. **Test case**: `find url www.food.com/fish`
   * **Expected**: Recipes matching the whole url including path will be matched, thus excluding `www.food.com` recipes
   * *Console output*: Shows the user which recipes match the url of `www.food.com/fish`

---

## Appendix: Area of Improvement

1. **Having the CommandValidator return the parsed input, if the command is valid.**
   * `CommandValidator` evaluates the inputs from the user, but only returns a boolean value of whether the command is valid.
   * If the command is valid, there is an additional call to `InputParser` to get the inputs again.
   * **Recommendation**: The `CommandValidator` could return the input together if the command is valid, and `null` otherwise.
