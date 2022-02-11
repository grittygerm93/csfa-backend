package com.example.csfassessment.controllers;

import com.example.csfassessment.models.Recipe;
import com.example.csfassessment.services.RecipeService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecipeRestController {
    private RecipeService recipeSvc;

    public RecipeRestController(RecipeService recipeSvc) {
        this.recipeSvc = recipeSvc;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable String id) {

        if (this.recipeSvc.getRecipeById(id).isPresent()) {
            return ResponseEntity.ok(this.recipeSvc.getRecipeById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> storeTasks(@RequestBody String payload) {

        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            Recipe recipe = new Recipe();
            recipe.setTitle(jsonObject.getString("title"));
            recipe.setInstruction(jsonObject.getString("instructions"));
            recipe.setImage(jsonObject.getString("image"));
            jsonObject.getJsonArray("ingredients").forEach(e -> {
                String s = e.toString().replace("\"", "");
                recipe.addIngredient(s);
            });


//            System.out.println(recipe);

            this.recipeSvc.addRecipe(recipe);
            JsonObject j = Json.createObjectBuilder()
                    .add("message", "created at %s".formatted(new Date())).build();

            return ResponseEntity.status(HttpStatus.CREATED).body(j.toString());

        } catch (IOException e) {
            e.printStackTrace();
            JsonObject j = Json.createObjectBuilder()
                    .add("message", "failed to create at %s".formatted(new Date())).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(j.toString());
        }


    }


}
