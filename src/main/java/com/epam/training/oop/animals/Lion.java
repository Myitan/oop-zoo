package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Lion extends Animal {
    public Lion(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " roars.");
    }
}
