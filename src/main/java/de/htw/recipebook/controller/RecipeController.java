package de.htw.recipebook.controller;

import de.htw.recipebook.model.Recipe;
import de.htw.recipebook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeService.createRecipe(recipe));
    }

    @GetMapping("")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable long recipeId){
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<?> deleteRecipeById(@PathVariable long recipeId){
        this.recipeService.deleteRecipeById(recipeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteRecipe(@RequestBody Recipe recipe){
        this.recipeService.deleteRecipe(recipe);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeService.updateRecipe(recipe));
    }

    @PatchMapping("/{recipeId}")
    public ResponseEntity<Recipe> updateTitel(@PathVariable long recipeId, @RequestParam String title){
        return ResponseEntity.ok(recipeService.updateTitle(recipeId,title));
    }
}
