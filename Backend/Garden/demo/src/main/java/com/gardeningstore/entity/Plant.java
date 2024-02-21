package com.gardeningstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int plantId;
    private String plantName;
    private String plantType;
    private String plantSpecies;
    private String plantOrigin;
    private double plantPrice;
    private String plantingSeason;

    public Plant() {
    }

    public Plant(int plantId, String plantName, String plantType, String plantSpecies, String plantOrigin,
            double plantPrice, String plantingSeason) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantType = plantType;
        this.plantSpecies = plantSpecies;
        this.plantOrigin = plantOrigin;
        this.plantPrice = plantPrice;
        this.plantingSeason = plantingSeason;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public void setPlantSpecies(String plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    public void setPlantOrigin(String plantOrigin) {
        this.plantOrigin = plantOrigin;
    }

    public void setPlantPrice(double plantPrice) {
        this.plantPrice = plantPrice;
    }

    public void setPlantingSeason(String plantingSeason) {
        this.plantingSeason = plantingSeason;
    }

    public int getPlantId() {
        return plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantType() {
        return plantType;
    }

    public String getPlantSpecies() {
        return plantSpecies;
    }

    public String getPlantOrigin() {
        return plantOrigin;
    }

    public double getPlantPrice() {
        return plantPrice;
    }

    public String getPlantingSeason() {
        return plantingSeason;
    }
}