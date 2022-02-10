package com.example.csfassessment.controllers;

import com.example.csfassessment.services.CsfaService;
import jakarta.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@RestController
@RequestMapping(path="/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CsfaController {

//    logger
    /*private Logger logger = LoggerFactory.getLogger("CsfaController.class");
    logger.info("{}","works/%s".formatted(works));*/

    private CsfaService csfaService;

    public CsfaController(CsfaService csfaService) {
        this.csfaService = csfaService;
    }

//    PathVariable
    /*@GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {

        JsonArrayBuilder arr = Json.createArrayBuilder();
        weatherService.getInfoFromApi(city)
                .forEach(e -> arr.add(e.toJson()));

        return ResponseEntity.accepted().body(arr.build().toString());
    }*/

//RequestParam useful for form type
/*    @GetMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> getCustomer(@RequestParam(required = false) String id,
                                              @RequestParam(required = false) String comments) {
        JsonObject fred = Json.createObjectBuilder()
                .add("name", "fred")
                .add("address", "1 bedrock")
                .add("email", "fred@gmail.com")
                .build();


        return ResponseEntity.ok(fred.toString());
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity register(@RequestParam MultiValueMap<String, String> form) {

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        if (form.getFirst("name").toLowerCase().startsWith("idiot")) {
            JsonObject response = objectBuilder
                    .add("message", "idiots not allowed")
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
        }
        else {
            JsonObject response = objectBuilder
                    .add("message", "Success!")
                    .build();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
        }
    }*/


//    Using Jackson
    /*    @GetMapping("/tasks")
    public ResponseEntity<ToDo[]> getTasks() {
        List<ToDo> storedToDos = new ArrayList<>();
        if (this.d8Service.getStoredValues().isPresent()) {
            storedToDos = this.d8Service.getStoredValues().get();
            System.out.println(storedToDos.get(0));
        }
        return ResponseEntity.ok(storedToDos.toArray
                (storedToDos.toArray(new ToDo[storedToDos.size()])));
    }

    @PostMapping(path = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> storeTasks(@RequestParam MultiValueMap<String, String>map) {
    public ResponseEntity<String> storeTasks(@RequestBody ToDo[] todos) {
        System.out.println(todos[0].toString());
        this.d8Service.storeValues(todos);
        JsonObject j = Json.createObjectBuilder()
                .add("message", "created at %s".formatted(new Date())).build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(j.toString());
    }*/


    // Use Json-p here instead and assume no model was created for ToDo
   /* @GetMapping("/tasks")
    public ResponseEntity<String> getTasks() {
        String storedValues = "";
        if (this.d8Service.getStoredValuesAsString().isPresent()) {
            storedValues = this.d8Service.getStoredValuesAsString().get();
        }
        return ResponseEntity.ok(storedValues);
    }

    @PostMapping(path = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> storeTasks(@RequestBody String todos) {

        System.out.println(todos.toString());

        try (InputStream is = new ByteArrayInputStream(todos.getBytes())) {
            JsonReader jsonReader = Json.createReader(is);
            JsonArray jsonArray = jsonReader.readArray();
            this.d8Service.storeValuesAsString(jsonArray);

            JsonObject j = Json.createObjectBuilder()
                    .add("message", "created at %s".formatted(new Date())).build();
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(j.toString());

        } catch (IOException e) {
            e.printStackTrace();
            JsonObject j = Json.createObjectBuilder()
                    .add("message", "failed to create at %s".formatted(new Date())).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(j.toString());
        }
    }*/



}
