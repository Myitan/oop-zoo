package com.epam.training.oop.animals;

import com.epam.training.oop.Consumption;

public class Mandrill extends Animal {
    public Mandrill(Consumption consumption) {
        super(consumption);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " screams.");
    }
}
