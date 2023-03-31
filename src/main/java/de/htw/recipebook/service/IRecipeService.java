package de.htw.recipebook.service;

import de.htw.recipebook.model.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> getAllRecipes();
    Recipe createRecipe(Recipe recipe);
    Recipe getRecipeById(long recipeId);
    void deleteRecipeById(long recipeId);
    void deleteRecipe(Recipe recipe);
    Recipe updateRecipe(Recipe recipe);
    Recipe updateTitle(long recipeId, String title);

}
