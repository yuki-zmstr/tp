# PDHung1104 PPP
### Overview
Recipe IO is a CLI application that allows foodies, chefs, or housewives/husbands to manage their recipes. For fast-typers, Recipe IO reduces unnecessary interactions with the graphics interface, hence saving time for them to do other tasks.

### Summary of Contribution

1. **Code contributed:** [Reposense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23&tabOpen=true&tabType=authorship&tabAuthor=PDHung1104&tabRepo=AY2324S2-CS2113-W14-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)
2. **Enhancements:**
   * **Code Structure: Added a `UI` class** that handles the application's user interface.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/17)
   * **Code Structure: Added `SortAscendingCalories`, `SortAscendingDateAdded`, `SortAscendingCookTime`, `SortAscendingName`, `SortList` classes** that handles the `list` command's sorting.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171)
   * **Code Structure: Added `FindMeal` method** that find recipes with a certain meal category.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103)
   * **Code Structure: Added `MealCategory` and `SortType` enumerators** that categorize meals and sorting options.
     * [PR for `MealCategory`](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103)
     * [PR for `SortType`](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171)
   * **Code Structure: Added `ListRecipeWithSort` class** that handles the `list` command with sorting options.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171/)
   * **Functionality:** Added search by meal category method
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103)
   * **Functionality:** Added list with sort options
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171)
   * **Functionality:** Created and added some methods to `UI`
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/17)
   * **Functionality:** Fixed the logic of `FilterByAllergyCommand`
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/70)
   * **JavaDoc:** Wrote JavaDoc to some methods.
     * Examples:
       * [PR#1](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/168/)
       * [PR#2](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103/)
   * **Testing:** Added test cases to verify the correctness of `UI`, `FindMeal`, `SortAscendingCalories`, `SortAscendingCookTime`, `SortAscendingDateAdded`, `SortAscendingNames`, and `SortList`
     * Examples:
       * [PR#1](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103)
       * [PR#2](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/18)
3. **Documentation - UG:**
   * Gave description of find by meal category method.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/106)
   * Gave description of `list` command and its options
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171) 
4. **Documentation - DG:**
    * Gave description of find by allergy method
       * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/71/)
    * Gave description of `list` method
       * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171)
    * Updated `User Stories`
       * [PR#1](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/71)
       * [PR#2](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/171)
5. **Contributions to team-based tasks:**
   * Code enhancements
     * Functional code.
     * Test code.
     * Documentation.
   * Maintaining the issue tracker
     * Creating issues. 
       * Examples:
         * [Issue#69](https://github.com/AY2324S2-CS2113-W14-2/tp/issues/69)
         * [Issue#53](https://github.com/AY2324S2-CS2113-W14-2/tp/issues/53)
         * [Issue#52](https://github.com/AY2324S2-CS2113-W14-2/tp/issues/52)
         * [Issue#19](https://github.com/AY2324S2-CS2113-W14-2/tp/issues/19)
6. **Contributions beyond the project team:**
   * Made 9 bug reports during PE-D.