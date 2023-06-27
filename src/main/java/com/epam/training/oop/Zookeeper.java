package com.epam.training.oop;

import com.epam.training.oop.animals.Animal;

public class Zookeeper {
    private final String name;
    private final Animal[] species;
    public Zookeeper(String name, Animal[] species) {
        this.name = name;
        this.species = species;
    }

    public void feed(Animal[] animals) {
        for (Animal animal : animals) {
            for (Animal specie : species) {
                if (specie.getClass() == animal.getClass()) {
                    animal.makeSound();
                    System.out.println(name + " is feeding the " + animal.getClass().getSimpleName());
                }
            }
        }
    }
}
