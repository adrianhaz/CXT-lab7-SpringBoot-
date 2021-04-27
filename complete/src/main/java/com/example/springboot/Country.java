package com.example.springboot;

public class Country {
    private final int id;
    private final String name;
    private final int population;

    public Country (int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public int getId(){ return id; }

    public String getName(){ return name; }

    public int getPopulation(){ return population; }

}
