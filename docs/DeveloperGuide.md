# Developer Guide

## Acknowledgements

* This application is built in partial fulfillment of the requirements of CS2113.<br>
* Knowledge and ideas are adapted from the CS2113 textbook, as well as SE-EDU textbook.

---

## Setting up, getting started

Refer to the User guide at https://ay2324s2-cs2113-w14-2.github.io/tp/UserGuide.html.

---

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Architecture

<img src="images/ArchitectureDiagram.png" width="350" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`RecipeIO`**  is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following five components:

* **`UI`** The UI of the App.
* **`RecipeList`**: The command executor and holder of data of the app.
* **`InputParser`**: Extracts information from the user input into the command line.
* **`CommandValidator`**: The command validator.
* **`Storage`**: Reads data from, and writes data to, the hard disk.

**`commands`** represents a collection of commands used by **`RecipeList`**

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/DeleteRecipe.png" width="800" />

---

## **Appendix: Requirements**

## Product scope

### Target user profile

* Has a need to manage a significant number of recipes.
* e.g. Professional culinary practitioners, students who love to cook.
* can type fast 
* People having special dietary restrictions.
* People who would like easily access the recipes they found online.

### Value proposition

The user will be able to add, access, and list recipes.
He can also filter recipes based on ingredients, time required, dietary restrictions, etc.
The saved recipes will be loaded in a recipe text file for easy sharing with friends.
The user can put the recipes into different categories.

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

### Use cases

(For all use cases below, the **System** is the `RecipeIO` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Delete a person**

1.  User requests to list recipes
2.  RecipeIO shows a list of recipes
3.  User requests to delete a specific recipe in the list
4.  AddressBook deletes the person

    Use case ends.

## Non-Functional Requirements

1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.

## Commands Glossary

* *add [NAME, MINUTES, KCALS, ALLERGIES, CATEGORY, URL]* - This is the command a user can call to add a recipe. 
* *help* - This shows the user all the available commands. 
* *list* - This lists out a users recipebook for them. 
* *delete* - This deletes a recipe at a given valid index. If not valid, it will return an error message.
* *find kw [KEYWORD]* - This finds recipes with a user-given keyword.
* *find date [YYYY-MM-DD]* - This finds recipes added on a user-given date. The date is auto-added when adding. 
* *find allergy [KEYWORD]* - This finds recipes without a certain ingredient.
* *exit* - This is the command to leave the program. 

---

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.</div>

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

### Adding a recipe

1. **Test case** `add pizza/34/340/eggs/dinner/www.food.com`<br>
   * **Expected**: Mentioned recipe is added to the list of recipes. <br>
   Console output providing a brief description of the added recipe <br>
   and total number recipes present in list 

2. **Test case** `add pizza/34/340/www.food.com`<br>
   * **Expected**: Recipe is not added to the list due to format error.<br>
   Console output stating for the user to follow the correct format.

3. **Test case** `add pizza/aa/aa/eggs/dinner/www.food.com`<br>
   * **Expected**: Recipe is not added to list due to incorrect input types.<br>
   Console output asking for user to use integer for fields of cook time <br>
   and calories

4. **Test case** `add pizza/30/30/eggs/dinnerTest/www.food.com`<br>
   * **Expected**: Recipe is not added to the list due to invalid meal categories.<br>
   Console output asking for user select correct meal category from options of <br>
   breakfast, lunch, dinner, appetizer and dessert

### Deleting a recipe

1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.

2. **Test case**: `delete 1`<br>
   * **Expected**: First recipe is deleted from the list. Console output <br>
   saying which recipe was deleted with a brief description.

3. **Test case**: `delete 0`<br>
   * **Expected**: No recipe is deleted due to index given being out of bounds. <br>
   Console output tells you to input a number within the range of the recipe list numbers.

4. **Test case**: `delete xyz`<br>
   * **Expected**: No recipe is deleted. Console output tells you to input <br>
   an integer instead of other data types.

5. **Test case**: `delete`<br>
   * **Expected**: No recipe is deleted due to given index. Console output <br>
   tells you to use a index parameter for the delete function.

### Finding a recipe by keyword

1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list.<br>
   At least one with "soup" in recipe name.

2. **Test case**: `find kw soup`<br>
   * **Expected**: Matching recipes are found. Console output shows you which <br>
   recipes have the word "soup" in its name.

3. **Test case**: `find kw sou`<br>
   * **Expected**: No matching recipe is found. Console output tells you to attempt <br>
   to search for another ingredient.

4. **Test case**: `find kw`<br>
   * **Expected**: No matching recipe is found due to lack of search keywords. <br>
   Console output tells you to check that you inputted two arguments to the find method.

5. **Test case**: `find kw 1`<br>
   * **Expected**: No matching recipes is found due to invalid keyword. Console output <br> 
   tells you to ensure the keyword is an alphabet

### Finding a recipe by date

1. **Prerequisites**: List all recipes using the `list` command. Multiple recipes in the list. <br>
   At least one with date as 2024-03-30 but none with 2024-01-03.

2. **Test case**: `find date 2024-03-30`<br>
   * **Expected**: Matching recipes are found with a valid date given. Console output <br>
   shows you which recipes were added on 2024-03-30.

3. **Test case**: `find date 2024-01-03`<br>
   * **Expected**: No matching recipes are found despite a valid date given. Console output <br>
   shows you that no recipes were added on 2024-01-03 as a valid gate is given without any <br>
   matching recipes

4. **Test case**: `find date xyx`<br>
   * **Expected**: No recipe is found due to invalid date format or not following the <br> 
   correct date convention. Console output tells you that the parameter cannot be parsed <br> 
   as a valid date. Console output also hints the user to use the format of YYYY-MM-DD.

5. **Test case**: `find date`<br>
   * **Expected**: No recipe is found due to the lack of a given date. Console output tells <br> 
   you to check that you inputted two arguments to the find method.
