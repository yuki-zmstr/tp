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
- **Find Recipe:** Find a recipe using a keyword, date or meal category.
- **Filter Recipe:** Show recipes that do not contain a certain allergy.

### 2. Command-Line Interface
- **User-Friendly Commands:** Intuitive and easy-to-use commands for seamless interaction.


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
Shows instructions to use the chatbot.

Format: `help`

### 2. Adding a recipe : `add`
Adds recipe with description. The application saves your recipe book in a .txt file everytime this command is run.

Format: `add NAME/MINUTES/KCALS/ALLERGIES/CATEGORY/URL`

* The `NAME` can include multiple words.
* The `MINUTES` must be an integer.
* The `KCALS` must be an integer.
* The `ALLERGIES` can take multiple allergies, separated by a comma. e.g. `eggs,dairy`
* The `CATEGORY` must be one of: `breakfast`, `lunch`, `dinner`, `appetizer`, `dessert`.
* The `URL` must be a string, that leads to the website that contains the full recipe.

Example of usage: 

`add pizza/34/340/eggs/dinner/www.food.com`

### 3. Deleting a recipe : `delete`
Deletes a recipe at a given index. The application saves your recipe book in a .txt file everytime this command is run.

Format: `delete LIST_NUMBER`

* The `LIST_NUMBER` must be within the number of recipes already added.
* Use the `list` command to see your list of recipes.

### 4. Listing recipe book : `list`
Lists a summarized version of your recipe book.

Format: `list`

### 5. Showing details of a recipe : `detail`
Shows all details of a recipe.

Format: `detail LIST_NUMBER`
* The `LIST_NUMBER` must be within the number of recipes already added.
* Use the `list` command to see your list of recipes.

### 6. Find recipes : `find`
Searches for all recipes that meet a certain criteria.

Format: `find TYPE CRITERIA`
* The `TYPE` must be either `kw` (search by keyword), `date` (search by date), or `meal` (search by meal category).
* If type `kw` is given, `CRITERIA` must be a word. This searches for an exact match of the word in the recipe name.
* If type `date` is given, `CRITERIA` must be a date in yyyy-MM-dd format. This searches for recipes added on this date.
* If type `meal` is given, `CRITERIA` must be a valid meal category. There are 6 meal categories: `general`, `breakfast`, `lunch`, `dinner`, `appetizer`, and `dessert`.

Example of usage:
`find kw pizza`

`find date 2024-03-28`

`find meal breakfast`

### 7. Filter recipes by allergy : `filter`
Shows recipes that do not contain a given allergy.

Format: `filter CRITERIA`
* The `CRITERIA` must be a word.

Example of usage:
`filter eggs`

### 8. Exit program: `exit`
Exits program gracefully.

Format: `exit`

## Command Summary

* Show list of instructions `help`
* Add recipe `add NAME/MINUTES/KCALS/ALLERGIES/CATEGORY/URL`
* Delete recipe `delete LIST_NUMBER`
* List recipe book `list`
* Show details `detail LIST_NUMBER`
* Find by keyword `find kw pizza`
* Find by date `find date 2024-03-28`
* Find by meal category `find meal breakfast`
* Filter by allergy `filter dairy`
* Exit program `exit`

More instructions can also be found using the `help` command.

Have fun with the chatbot!