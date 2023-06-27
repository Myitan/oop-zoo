package com.epam.rd.animals;

public class Antelope extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " snorts.");
    }
}
