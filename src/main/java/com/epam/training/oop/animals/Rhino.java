package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Rhino extends Animal {
    public Rhino(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " moo.");
    }
}
