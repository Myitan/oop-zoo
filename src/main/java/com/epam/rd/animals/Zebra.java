package com.epam.rd.animals;

public class Zebra extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " brays.");
    }
}
