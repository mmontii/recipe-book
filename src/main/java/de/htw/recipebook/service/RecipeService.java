package de.htw.recipebook.service;

import de.htw.recipebook.exceptions.ResourceNotFoundException;
import de.htw.recipebook.model.Recipe;
import de.htw.recipebook.repository.RecipeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService{
    @Autowired
    private RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipeById(long recipeId) {
        Optional<Recipe> recipeDB = this.recipeRepository.findById(recipeId);
        if(recipeDB.isPresent()){
            return recipeDB.get();
        }else{
            throw new ResourceNotFoundException("Recipe was not found with id:" + recipeId);
        }
    }

    @Override
    public void deleteRecipeById(long recipeId) {
        Optional<Recipe> recipeDB = this.recipeRepository.findById(recipeId);
        if(recipeDB.isPresent()){
            this.recipeRepository.delete(recipeDB.get());
        }else{
        throw new ResourceNotFoundException("Recipe was not found with id:" + recipeId);
    }


    }

    @Override
    public void deleteRecipe(Recipe recipe){
        Optional<Recipe> recipeDB = this.recipeRepository.findById(recipe.getId());
        if(recipeDB.isPresent()){
            this.recipeRepository.delete(recipe);
        }else{
            throw new ResourceNotFoundException("Recipe was not found with id:" + recipe.getId());
        }

    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        Optional<Recipe> recipeDB = this.recipeRepository.findById(recipe.getId());
        if(recipeDB.isPresent()){
            Recipe recipeUpdated = recipeDB.get();
            recipeUpdated.setId(recipe.getId());
            recipeUpdated.setTitle(recipe.getTitle());
            recipeUpdated.setType(recipe.getType());
            recipeUpdated.setCuisine(recipe.getCuisine());
            recipeUpdated.setDescription(recipe.getDescription());

            recipeRepository.save(recipeUpdated);
            return recipeUpdated;

        }else{
            throw new ResourceNotFoundException("Recipe was not found with id:" + recipe.getId());
        }
    }

    @Override
    public Recipe updateTitle(long recipeId, String title) {
        Optional<Recipe> recipeDB = this.recipeRepository.findById(recipeId);
        if(recipeDB.isPresent()){
            Recipe recipeUpdated = recipeDB.get();
            recipeUpdated.setId(recipeId);
            recipeUpdated.setTitle(title);
            recipeRepository.save(recipeUpdated);
            return recipeUpdated;

        }else{
            throw new ResourceNotFoundException("Recipe was not found with id:" + recipeId);
        }
    }


    @PostConstruct
    public void initDB(){
        Recipe[] recipes = {
                new Recipe(1,"Spaghetti", "Main Dish", "italian","Do it with some tomato sauce"),
                new Recipe(2, "Pad Thai", "Main Dish", "Thai", "Stir-fried noodles with vegetables and peanuts"),
                new Recipe(3, "Tomato Soup", "Soup", "American", "Comforting soup made with fresh tomatoes"),
                new Recipe(4, "Tacos", "Main Dish", "Mexican", "Tortillas filled with seasoned beef, lettuce, and cheese"),
                new Recipe(5, "Bibimbap", "Main Dish", "Korean", "Rice bowl topped with assorted vegetables, meat, and egg"),
                new Recipe(6, "Miso Soup", "Soup", "Japanese", "Savory soup made with miso paste and tofu"),
                new Recipe(7, "Chicken Alfredo", "Main Dish", "Italian", "Creamy pasta dish with chicken and Parmesan cheese"),
                new Recipe(8, "Beef Stew", "Stew", "American", "Slow-cooked beef stew with carrots and potatoes"),
                new Recipe(9, "Sushi Rolls", "Main Dish", "Japanese", "Rice and fish rolled in seaweed"),
                new Recipe(10, "Chili", "Soup", "American", "Spicy stew made with beef and beans")
        };
        for(Recipe recipe : recipes) {
            recipeRepository.save(recipe);
        }

    }
}
