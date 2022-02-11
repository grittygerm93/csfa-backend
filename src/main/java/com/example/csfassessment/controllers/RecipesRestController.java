package com.example.csfassessment.controllers;


import com.example.csfassessment.models.Recipe;
import com.example.csfassessment.services.RecipeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipesRestController {

    private RecipeService recipeSvc;

    public RecipesRestController(RecipeService recipeSvc) {
        this.recipeSvc = recipeSvc;
    }

    @GetMapping()
    public ResponseEntity<Recipe[]> getAllRecipes() {

        List<Recipe> list = this.recipeSvc.getAllRecipes().stream()
                .map(e -> {
                    Recipe recipe = new Recipe();
                    recipe.setId(e.getId());
                    recipe.setTitle(e.getTitle());
                    return recipe;
                })
                .toList();

        return ResponseEntity.ok(list.toArray(new Recipe[list.size()]));
    }

}