package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public abstract class Animal {

    private final Consumption consumption;

    public Animal(Consumption consumption) {
        this.consumption = consumption;
    }

    public abstract void makeSound();

    public Consumption getFormOfConsumption() {
        return consumption;
    }
}
