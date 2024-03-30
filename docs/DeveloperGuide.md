# Developer Guide

## Acknowledgements

This application is built in partial fulfillment of the requirements of CS2113.</br>
Knowledge and ideas are adapted from the CS2113 textbook, as well as SE-EDU textbook.

---

## Setting up, getting started

Refer to the User guide at https://ay2324s2-cs2113-w14-2.github.io/tp/UserGuide.html.

---

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

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


## Product scope

### Target user profile

Professional culinary practitioners, students who love to cook.
People having special dietary restrictions or tracking their calorie intake.
Basically anyone who cooks and want to keep track of his/her recipes!

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

## Non-Functional Requirements

{Give non-functional requirements}
Users can use the help function to understand all the available commands they can use

## Commands Glossary

* *add [NAME, MINUTES, KCALS, ALLERGIES, CATEGORY, URL]* - This is the command a user can call to add a recipe. 
* *help* - This shows the user all the available commands. 
* *list* - This lists out a users recipebook for them. 
* *delete* - This deletes a recipe at a given valid index. If not valid, it will return an error message.
* *find kw [KEYWORD]* - This finds recipes with a user-given keyword.
* *find date [YYYY-MM-DD]* - This finds recipes added on a user-given date. The date is auto-added when adding. 
* *find allergy [KEYWORD]* - This finds recipes without a certain ingredient.
* *exit* - This is the command to leave the program. 

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
