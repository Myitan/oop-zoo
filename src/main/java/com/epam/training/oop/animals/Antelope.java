package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Antelope extends Animal {
    public Antelope(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " snorts.");
    }
}
