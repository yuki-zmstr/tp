# User Guide to Recipe.io

## Introduction

Recipe.io is a command line application that helps people who love to cook, be it professional culinary practitioners, 
or even students, to manage their recipes.

In particular, it allows users to keep track of the URL at which he or she found the recipe.

## Features
### 1. Recipe Book Management
- **Add Recipe:** Add new recipe through the command line by providing a recipe description.
- **Delete Recipe:** Delete a recipe from the recipe book.
- **View Recipe Book:** List all recipes in recipe book.
- **Find Recipe:** Find a recipe using a keyword, date, meal category or url.
- **Filter Recipe:** Show recipes that do not contain a certain allergy.

### 2. Command-Line Interface
- **User-Friendly Commands:** Intuitive and easy-to-use commands for seamless interaction.
- **Efficient and Concise Commands:** Quick and precise commands allows users to be efficient 
    in recipe management with some adequate practice.

## Getting Started

Follow these steps to get started with Recipe.io

1. **Ensure that you have Java 11 installed.**

2. **Download the latest JAR File:**
    - Download the latest release from https://github.com/AY2324S2-CS2113-W14-2/tp

3. **Run the JAR File from the command line:**
    - Execute the JAR file to launch the chatbot.
    - `java -jar tp.jar`
   
4. **Interact with the Chatbot:**
    - Follow the on-screen instructions to add recipes and manage your recipe book!

## Commands 

### 1. Viewing help : `help`
Shows instructions to use RecipeIO's chatbot.

Format: `help`

### 2. Adding a recipe : `add`
Adds recipe with a comma separated description. The application saves your recipe book in a .txt file everytime this command is run.

Format: `add NAME,MINUTES,KCALS,ALLERGIES,CATEGORY,URL`

* The `NAME` can include multiple words.
* The `MINUTES` must be an integer.
* The `KCALS` must be an integer.
* The `ALLERGIES` can take multiple allergies, separated by a space. e.g. `egg dairy` All allergies must be singular tense. e.g. `egg` NOT `eggs`
* The `CATEGORY` must be one of: `breakfast`, `lunch`, `dinner`, `appetizer`, `dessert`.
* The `URL` must be a string, that leads to the website that contains the full recipe.
  It should contain subdomains of `"www"` , `"http"` or `"https"` and a valid domain.

Example of usage: 

`add pizza, 34, 340, egg dairy, dinner, www.food.com`

`add burger, 30, 500, dairy, lunch, https://www.bbcfoods.com`

`add fries, 20, 200, dairy, dessert, http://www.example.com`

### 3. Deleting a recipe : `delete`
Deletes a recipe at a given recipe number. The application saves your recipe book in a .txt file everytime this command is run.

Format: `delete RECIPE_NUMBER`

* The `RECIPE_NUMBER` must be within the number of recipes already added.
* A recipe's number can be found in the `list`, `find`, or `filter` commands.


### 4. Listing recipe book : `list`
Lists a summarized version of your recipe book. This summarized version includes the
recipes' name, date added, and url in the order they were added

Format: `list`

### 5. Showing details of a recipe : `detail`
Shows all details of a recipe.

Format: `detail RECIPE_NUMBER`
* The `RECIPE_NUMBER` must be within the number of recipes already added.
* A recipe's number can be found in the `list`, `find`, or `filter` commands.

### 6. Find recipes : `find`
Searches for all recipes that meet a certain criteria.

Format: `find TYPE CRITERIA`
* The `TYPE` must be either `kw` (search by keyword), `date` (search by date), `meal` (search by meal category)
    or `url` (search by url)
* If type `kw` is given, `CRITERIA` must be a word. This searches for an exact match of the word in the recipe name.
* If type `date` is given, `CRITERIA` must be a date in yyyy-MM-dd format. This searches for recipes added on this date.
* If type `meal` is given, `CRITERIA` must be a valid meal category. There are 6 meal categories: `general`, `breakfast`, `lunch`, `dinner`, `appetizer`, and `dessert`.
* If type `url` is given, `CRITERIA` must be a valid url. This searches in the recipe list for a match in domain of the 
    url, or an exact match if url path is given

Example of usage:
* `find kw pizza`

* `find date 2024-03-28`

* `find meal breakfast`

* `find url www.food.com`

### 7. Filter recipes by allergy : `filter`
Shows recipes that do not contain a given allergy. 

Format: `filter CRITERIA`
* The `CRITERIA` must be a word. Ensure that the criteria is singular tense (eg. `egg` NOT `eggs`)

Example of usage:
`filter egg`

### 8. Exit program: `exit`
Exits program gracefully.

Format: `exit`

Upon exiting, a file named `recipe.txt` will be saved containing your recipe book.
When rerunning the program the next time, RecipeIO will look for this saved file, to load your previously recorded 
recipes once again. 

## Command Summary

* Show list of instructions `help`
* Add recipe `add NAME,MINUTES,KCALS,ALLERGIES,CATEGORY,URL`
* Delete recipe `delete RECIPE_NUMBER`
* List recipe book `list`
* Show details `detail RECIPE_NUMBER`
* Find by keyword `find kw NAME_KEYWORD`
* Find by date `find date YYYY-MM-DD`
* Find by meal category `find meal MEAL_CATEGORY`
* Filter by allergy `filter ALLERGY`
* Exit program `exit`

More instructions can also be found at any time using the `help` command.

Have fun with RecipeIO!