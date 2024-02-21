package com.gardeningstore.controller;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
        Optional<Plant> plant = plantService.getPlantById(id);
        return plant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        Plant savedPlant = plantService.addPlant(plant);
        return new ResponseEntity<>(savedPlant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable int id, @RequestBody Plant updatedPlant) {
        Plant plant = plantService.updatePlant(id, updatedPlant);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        plantService.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
/*
 * package com.gardeningstore.controller;
 * 
 * import com.gardeningstore.entity.Plant;
 * import com.gardeningstore.service.PlantService;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.List;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/plants") // This maps all endpoints related to plants
 * under /api/plants
 * public class PlantController {
 * 
 * @Autowired
 * private PlantService plantService;
 * 
 * @GetMapping
 * public List<Plant> getAllPlants() {
 * return plantService.getAllPlants();
 * }
 * 
 * @GetMapping("/{id}")
 * public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
 * Plant plant = plantService.getPlantById(id);
 * if (plant != null) {
 * return new ResponseEntity<>(plant, HttpStatus.OK);
 * } else {
 * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 * }
 * }
 * 
 * @PostMapping
 * public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
 * Plant addedPlant = plantService.addPlant(plant);
 * return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
 * }
 * 
 * @PutMapping("/{id}")
 * public ResponseEntity<Plant> updatePlant(@PathVariable int id, @RequestBody
 * Plant plant) {
 * Plant updatedPlant = plantService.updatePlant(id, plant);
 * if (updatedPlant != null) {
 * return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
 * } else {
 * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 * }
 * }
 * 
 * @DeleteMapping("/{id}")
 * public ResponseEntity<Void> deletePlant(@PathVariable int id) {
 * plantService.deletePlant(id);
 * return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 * }
 * }
 */