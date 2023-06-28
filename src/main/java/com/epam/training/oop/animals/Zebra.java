package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Zebra extends Animal {
    public Zebra(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " brays.");
    }
}
