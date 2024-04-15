# User Guide to Recipe.io

## Introduction

Recipe.io is a command line application that helps people who love to cook, be it professional culinary practitioners, 
or even students, to manage and access their recipes.

In particular, it allows users to keep track of the URL at which he or she found or wrote down the recipe.

## Features
### 1. Recipe Book Management
- **Add Recipe:** Add new recipe through the command line by providing a recipe description.
- **Delete Recipe:** Delete a recipe from the recipe book.
- **View Recipe Book:** List all recipes in recipe book in a certain order.
- **Find Recipe:** Find a recipe using a keyword, date, meal category or url.
- **Filter Recipe:** Show recipes that do not contain a certain allergy.

### 2. Command-Line Interface
- **User-Friendly Commands:** Intuitive and easy-to-use commands for seamless interaction.
- **Efficient and Concise Commands:** Quick and precise commands allows fast-typing users to be efficient 
    in recipe management with some adequate practice.

## Getting Started

Follow these steps to get started with Recipe.io

1. **Ensure that you have Java 11 installed.**

2. **Download the latest JAR File:**
    - Download the latest release from [team repo](https://github.com/AY2324S2-CS2113-W14-2/tp)

3. **Run the JAR File from the command line:**
    - Execute the JAR file to launch the chatbot.
    - `java -jar tp.jar`
   
4. **Interact with the Chatbot:**
    - Follow the on-screen instructions to add recipes and manage your recipe book!

## Commands 

### Disclaimers 
* In this document, parameters inside `[]` are compulsory, while those inside `{}` are optional.
* Additionally, this program uses the comma `,` as a delimiter, so ensure not to use commas within parameters for intended usability. 

### 1. Viewing help : `help`
Shows instructions to use RecipeIO's chatbot.

Format: `help`

### 2. Adding a recipe : `add`
Adds recipe with a comma separated description. The application saves your recipe book in a .txt file everytime this command is run.

Format: `add NAME,MINUTES,KCALS,ALLERGIES,CATEGORY,URL`

* The `NAME` can include multiple words.
* The `MINUTES` must be an integer.
* The `KCALS` must be an integer.
* The `ALLERGIES` can take multiple allergies, separated by a slash. e.g. `egg/dairy` All allergies must be singular tense. e.g. `egg` NOT `eggs`
* The `CATEGORY` must be one of: `breakfast`, `lunch`, `dinner`, `appetizer`, `dessert`, or `general`.
* The `URL` must be a string, that leads to the website that contains the full recipe.
  It should begin with `"www"` , `"http"` or `"https"` and have a valid domain.

Example of usage: 

`add pizza, 34, 340, egg/dairy/red meat, dinner, www.food.com`

`add burger, 30, 500, dairy, lunch, https://www.bbcfoods.com`

`add fries, 20, 200, dairy, dessert, http://www.example.com`

### 3. Deleting a recipe : `delete`
Deletes a recipe at a given recipe number. The application saves your recipe book in a .txt file everytime this command is run.

Format: `delete RECIPE_NUMBER`

* The `RECIPE_NUMBER` must be within the number of recipes already added.
* A recipe's number can be found in the `list` (with no `SORT_TYPE` specified), `find`, or `filter` commands.


### 4. Listing recipe book : `list`
Lists a summarized version of your recipe book. This summarized version includes the
recipes' name, date added, and url in the order they were added

Format: `list {SORT_TYPE}`
* The `SORT_TYPE` flag is optional and must be either `sortname` (sort the list by name), `sortdate` (sort the list by date added), `sortcooktime` (sort the list by cooktime), or `sortcalories` (sort the list by calories).
* When `SORT_TYPE` is specified in the command, RecipeIO will sort the list in ascending order (from older to newer for `sortdate`).

### 5. Showing details of a recipe : `detail`
Shows all details of a recipe.

Format: `detail RECIPE_NUMBER`
* The `RECIPE_NUMBER` must be within the number of recipes already added.
* A recipe's number can be found in the `list` (with no `SORT_TYPE` specified), `find`, or `filter` commands.

### 6. Find recipes : `find`
Searches for all recipes that meet a certain criteria.

Format: `find TYPE CRITERIA`
* The `TYPE` must be either `kw` (search by keyword), `date` (search by date), `meal` (search by meal category)
    or `url` (search by url)
* If type `kw` is given, `CRITERIA` must be a word. This searches for an exact match of the word in the recipe name.
* If type `date` is given, `CRITERIA` must be a date in yyyy-MM-dd format. This searches for recipes added on this date.
* If type `meal` is given, `CRITERIA` must be a valid meal category. There are 6 meal categories: `general`, `breakfast`, `lunch`, `dinner`, `appetizer`, and `dessert`.
* If type `url` is given, `CRITERIA` must be a valid url. This searches in the recipe list for a match in domain of the 
    url, or an exact match if full url with path is given.

Example of usage:
* `find kw pizza`

* `find date 2024-03-28`

* `find meal breakfast`

* `find url www.food.com` (will find entries with this as a domain)

* `find url www.food.com/pasta/carbonara` (will find the entry with this exact url)

### 7. Filter recipes by allergy : `filter`
Shows recipes that do not contain a given allergy. 

Format: `filter CRITERIA`
* The `CRITERIA` must be a word. Ensure that the criteria is singular tense (eg. `egg` NOT `eggs`)
* While inputting plural allergies will still work, it is for your own benefit to input singular allergies
as the filter command will work as expected this way. Thus, for the usability of our app, we *strongly recommend* using singular tense allergies. 
* Some allergens contain numbers, e.g. E220. The app accepts adding and filtering by such allergens as well.

Example of usage:
`filter egg`

### 8. Exit program: `exit`
Exits program gracefully.

Format: `exit`

Upon exiting, a file named `recipe.txt` will be saved containing your recipe book.
When rerunning the program the next time, RecipeIO will look for this saved file, to load your previously recorded 
recipes once again.

### Troubleshooting
#### If you encounter issues while using Recipe.io, here are some common problems and their solutions:

##### Java Version Compatibility: 
* Ensure that you have Java 11 or later installed. You can check your Java version by running `java -version` in your command line. If you have an earlier version, please update Java.

##### Problems Executing the JAR File: 
* Make sure you are in the correct directory where the JAR file is downloaded. Use the command `java -jar tp.jar` in your command line. If the file does not execute, check for any typos in the command or re-download the JAR file to ensure it isn't corrupted.

Errors in Command Syntax: If your commands are not executing as expected, check the command syntax in the `Commands` section of this guide. Make sure all parameters are correctly formatted and separated as described.

### FAQs
#### Q: How do I install Recipe.io?
A: Follow the steps in the 'Getting Started' section of this guide, which include installing Java, downloading the JAR file, and running it via command line.

#### Q: How can I backup my recipes?
A: Recipe.io automatically saves your recipes in a recipe.txt file upon exit. Ensure you exit the program using the exit command to trigger the save. You can even keep a backup of this file in another location for extra security.

#### Q: How do I update Recipe.io?
A: Download the latest JAR file from the official github website and replace the existing one. Your recipes are stored separately in recipe.txt and won't be affected by the update.

### Tips and Best Practices
* ##### Organizing Recipes: 
  * Use the `sortname` or `sortdate` options in the list command to view your recipes in alphabetical order or by the date added, making them easier to find.
  * Utilize the find command to locate recipes based on specific criteria such as keywords or dates. Use the filter command to exclude recipes containing certain allergens.

## Command Summary

* Show list of instructions `help`
* Add recipe `add NAME,MINUTES,KCALS,ALLERGIES,CATEGORY,URL`
* Delete recipe `delete RECIPE_NUMBER`
* List recipe book `list {SORT_TYPE}`
* Show details `detail RECIPE_NUMBER`
* Find by keyword `find kw NAME_KEYWORD`
* Find by date `find date YYYY-MM-DD`
* Find by meal category `find meal MEAL_CATEGORY`
* Find by url `find url URL`
* Filter by allergy `filter ALLERGY`
* Exit program `exit`

More instructions can also be found at any time using the `help` command.

Have fun with RecipeIO! 