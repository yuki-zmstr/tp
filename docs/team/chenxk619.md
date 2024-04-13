# Chen Xiao Kang - Project Portfolio Page

## Overview

Recipe.io is a command line application that helps people who love to cook, be it professional culinary practitioners,
or even students, to manage their recipes.

### Summary of Contributions

1. **Code contributed**: [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=chenxk619&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=chenxk619&tabRepo=AY2324S2-CS2113-W14-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

2. **Enhancements**:
    * **Code Structure**: Extract constants into their own classes
        * Extract most strings and magic literals from classes inside `ui` , `recipe` and `commands` 
        folders to their own constant class in the `constants` folder
        * **Justification**: Improves code maintainability and readability
        * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/107)
   
    * **Code Structure**: Initial storage function
      * Initial version that loads and saves changes made to recipeList
      * **Justification**: Essential component to allow users to save and load recipes instead of starting anew
      * **Credits**: @yuki-zmstr for enhancing and extracting the function to be more object orientated
      * [Initial PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/22/files), [Updated PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/22/files)
      
    * **Code Structure**: Find by url function
      * Allows users to find recipes via their url
      * **Justification**: Users can view all their saved recipes belonging to a certain url
      * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/170)
   
   * **Functionality**: Add error handling for invalid url entries
      * Exception checker for users with invalid domain or subdomain formats
      * **Justification**: Prevents users from inputting invalid urls
      * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/164)
     
   * **Functionality**: Add error handling for negative calories or cook time
     * Exception checker to prevent users from inputting negative integers
     * **Justification**: Negative calories and cook time does not exist in the real world
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/164)
    
    * **Testing**: Add testing for find url functions
    * To validate that different types of url functions are found correctly
    * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/170)
     
3. **Documentation - DG**: 
   * Add test cases for adding a recipe, sorting by list, and also added console output examples for deleting a recipe, finding recipes
   by date and keyword
   * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/89/files)

4. **Documentation - UG**:
   * Update user guide on inputting the url correctly with example usage, and some other description changes
   * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/164)

5. **Project management**: Managed released `v2.0.0` on GitHub.
      * **Credit**: @nidhi-nayak for assisting on the release 
   
6. **Community**: 
   * Reviewed and merged PRs [#113](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/113), 
   [#114](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/114), [#115](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/115)
   * Made 9 bug reports during PE-D
     * Eg: [#1](https://github.com/chenxk619/ped/issues/5), [#2](https://github.com/chenxk619/ped/issues/8), [#3](https://github.com/chenxk619/ped/issues/4)

7. **PED Fixes**: Fixed `6` PED bugs
   * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/164)