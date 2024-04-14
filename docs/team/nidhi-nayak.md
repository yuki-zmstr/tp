# Nidhi Nayak - Project Portfolio Page
### Overview
Meet Recipe IO, a friendly command line interface (CLI) to help users manage their recipes. Recipe IO
allows users to add recipes, delete recipes, find recipes via different criteria, and saves the user's recipe book to
computer storage. With quick, short commands and a reduction of a complicated GUI, Recipe IO makes sure to save users' 
time and caters to quick typers.

### Summary of Contribution

1. **Code Contributed**: [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=nidhi-nayak&breakdown=true)
2. **Enhancements Implemented**: 
   * ***Code Structure:*** Created the `RecipeList` Class that stores user recipes.
     * [Initial PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/13), [Error Handled PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/16)
     *  The RecipeList Class efficiently manages and organizes user-submitted recipes, facilitating easy storage and retrieval.
   * ***Code Structure:*** Created the `Input Parser` Class to parse user inputs as different commands + their respective parameters.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/35)
     * While the inital PR was a WIP, it was later discovered that my code was all functional and worked as expected, but due to a previously merged error in the scanning the next line, the build was failing. My code was then copy-pasted by @yuki-zmstr when he fixed the previous mistake. This also explains the author credits for this class.  
   * ***Functionality:*** Created the `AddRecipeCommand` and `DeleteRecipeCommand` command for users to manage recipes.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/38)
     * Same explanation as above for why PR was a WIP. Fixed with @@ author tag.  
   * ***Functionality:*** Implemented an automatic `dateAdded` feature to keep track of user creation of recipes. 
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/59)
     * This feature set up the ability for a user to search by key dates to easily find recipes from big events such as a birthday, anniversary, holiday, etc.
   * ***Code Structure:*** Added a `FindCommand` generic class that determines which find command to execute. 
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/40/files)
     * This ensures that every class in handling one thing (as per the Single Responsibility Principle)
   * ***Functionality:*** Added a `FindName` and `FindDate` class that handles finding recipes by keyword and date. 
     * [FindbyDate PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/59), [FindbyName PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/40)
     * Streamlines the search process, enabling users to locate recipes through keywords or specific dates.
   * ***Functionality:*** Add extensive error handling for the `addRecipeCommand` for lack of parameters, integer values, null inputs, etc.
     * [AddParser PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/108), [AddCommandValidator PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/162), [Error Handling PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/112)
   * ***UI:*** Responsible for "prettifying" the console output. 
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/120)
     * Changed all returned messages to make chatbot more friendly, changed layour + added tabbing for user input to make chatbot more clear. Changed delimeter to a more user intuitive option (commas rather than backslashes). 
3. **Documentation - UG**: 
