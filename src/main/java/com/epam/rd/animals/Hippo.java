package com.epam.rd.animals;

public class Hippo extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " barks.");
    }
}
