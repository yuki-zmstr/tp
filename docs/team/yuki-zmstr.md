# Yukihide Takahashi - Project Portfolio Page

## Overview

Recipe.io is a command line application that helps people who love to cook, be it professional culinary practitioners,
or even students, to manage their recipes.

### Summary of Contributions

1. **Code contributed**: [RepoSense link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=yuki-zmstr&breakdown=true)

2. **Enhancements**:

   * **Code Structure: Add a `CommandValidator` class** that handles command validation.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/82)
     * This allows for validation before actual execution of command.
     * Follows the Separation of Concern principle.
     
   * **Functionality**: Add the ability to show details of a recipe.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/75)
     * Shows all the details of a recipe at a given index.
     * Added error handling when index not found in user input, index out of range of recipelist, and index not an integer error.
     * Justification: each recipe has several attributes, which will clutter the console if everything was printed in the general `list` command.

   * **Functionality**: Add error handling for `delete` method.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/65)
     * Added error handling when index not found in user input, index out of range of recipelist, and index not an integer error.
     * Guides the user on the correct way to input.
  
   * **Functionality**: Debug save and load methods.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/88)
     * Saving and loading was not functioning as expected when the data file did not exist.
     * `saveFile` method has partial contribution from @chenxk619.

   * **JavaDoc**: Added JavaDoc to several methods.
     * [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/91)

3. **Documentation - UG**:
   * Created Layout of UG with general sections: [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/83)
   * Gave description of commands like `help`, `delete`, and `list`.
   * Gave a summary of commands.
   * Did cosmetic tweaks to existing documentation of `add`: [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/115)
   
4. **Documentation - DG**:
   * Created layout of DG with general sections: [PR](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/84)
   * Created Sequence diagram for `delete` command: [UML](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/docs/diagrams/DeleteRecipe.puml)
   * Created Class diagrams. e.g. `RecipeList` class: [UML](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/docs/diagrams/RecipeListDiagram.puml)
   * Created Architecture diagram for app: [UML](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/docs/diagrams/ArchitectureDiagram.puml)

5. **Project management**:
   * Managed release `v2.0.1` on GitHub.
   * Created and managed milestones `v1.0`, `v2.0`, and `v2.1`.

6. **Contributions to team-based tasks**:
   * Setting up the GitHub team org/repo.
   * Code enhancements
     * Functional code.
     * Test code.
     * Documentation.
   * Maintaining the issue tracker
     * Creating issues, assigning issues.
   * Reviewing PRs.
   * Documenting the target user profile in the UG.

7. **Mentoring contributions**:
   * Made myself a required approver of PRs in `v2.0` phase: [CODEOWNERS file](https://github.com/AY2324S2-CS2113-W14-2/tp/blob/master/.github/CODEOWNERS)
     * This was to ensure code base integrity and code quality.
     * Turned off this rule in `v2.1` phase since teammates should already understand the protocol when merging PRs. For example:
       * ensuring code is bug free
       * complies with coding standard
       * follows coding principles (SLAP, separation of concern, etc)
   * Some PRs reviewed: [\#103](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/103), [\#101](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/101), [\#120](https://github.com/AY2324S2-CS2113-W14-2/tp/pull/120)

8. **Contributions beyond the project team**:
   * Made 17 bug reports during PE-D.
   * E.g. [1](https://github.com/AY2324S2-CS2113-T12-4/tp/issues/185), [2](https://github.com/AY2324S2-CS2113-T12-4/tp/issues/182), [3](https://github.com/AY2324S2-CS2113-T12-4/tp/issues/170)
        