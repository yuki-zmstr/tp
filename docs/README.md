# Recipe.io

Welcome to Recipe.io, a command-line application designed for cooking enthusiasts ranging from professional culinary practitioners to students. This application allows users to manage their recipes efficiently, track where they found or noted them, and much more.

## Useful Links

- [User Guide](UserGuide.md)
- [Developer Guide](DeveloperGuide.md)
- [About Us](AboutUs.md)

## Introduction

Recipe.io helps users manage their recipes through a command-line interface, making it easy to add, delete, and search recipes. Particularly useful is the ability to keep track of the URL where the recipe was found or noted, aiding in organization and access.

## Features

### Recipe Book Management
- **Add Recipe:** Add a new recipe via the command line with a detailed description.
- **Delete Recipe:** Remove a recipe from your recipe book.
- **View Recipe Book:** List all your recipes in a specified order.
- **Find Recipe:** Locate a recipe using a keyword, date, meal category, or URL.
- **Filter Recipe:** Display recipes that exclude certain allergies.

### Command-Line Interface
- **User-Friendly Commands:** Intuitive and straightforward commands facilitate seamless interaction.
- **Efficient and Concise Commands:** Allows users who can type quickly to manage recipes efficiently with minimal practice.

## Getting Started

Here are the steps to get started with Recipe.io:

1. **Ensure Java 11 is installed.** Check by running `java -version` in your command prompt or terminal.
2. **Download the latest JAR file** from our [team repository](https://github.com/AY2324S2-CS2113-W14-2/tp).
3. **Run the JAR file:** Execute the command `java -jar tp.jar` in your command line to start the application.
4. **Interact with the Chatbot:** Follow the on-screen instructions to add and manage your recipes.

## Commands

### General Commands

- `help`: Display help instructions.
- `exit`: Exit the program. This command saves your current recipes to `recipe.txt`.

### Recipe Management

- `add NAME,MINUTES,KCALS,ALLERGIES,CATEGORY,URL`: Add a new recipe.
    - Example: `add pizza, 30, 270, nuts/seafood, dinner, www.examplefood.com`
- `delete RECIPE_NUMBER`: Remove a recipe by its number in the list.
- `list {SORT_TYPE}`: List recipes, optionally sorting them.
- `detail RECIPE_NUMBER`: Show detailed information about a recipe.

### Searching and Filtering

- `find kw KEYWORD`: Find recipes by keywords.
    - Example: `find kw pizza`
- `find date YYYY-MM-DD`: Find recipes by the date added.
- `find meal MEAL_CATEGORY`: Find recipes by meal category (breakfast, lunch, etc.).
- `find url URL`: Find recipes by their noted URL.
- `filter ALLERGY`: Filter recipes by allergies.
    - Example: `filter nuts`

## Troubleshooting and FAQs

If you encounter issues, ensure you have the correct Java version and the syntax of your commands is correct. For more complex issues, refer to our detailed [FAQ section](AboutUs.md#faqs).

## About Us

Learn more about the team behind Recipe.io in our [About Us](AboutUs.md) section.

Thank you for using Recipe.io, and happy cooking!
