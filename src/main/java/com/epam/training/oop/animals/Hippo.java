package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Hippo extends Animal {
    public Hippo(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " barks.");
    }
}
