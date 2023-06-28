package com.epam.training.oop;

import com.epam.training.oop.animals.Animal;

public class Zookeeper {
    private final String name;
    private final Consumption[] consumption;

    public Zookeeper(String name, Consumption... consumption) {
        this.name = name;
        this.consumption = consumption;
    }


    public void feed(Animal[] animals) {
        for (Animal animal : animals) {
            for (Consumption form : consumption) {
                if (form.equals(animal.getFormOfConsumption())) {
                    animal.makeSound();
                    System.out.println(name + " is feeding the " + animal.getClass().getSimpleName());
                }
            }
        }
    }
}
