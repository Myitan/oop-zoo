package com.epam.rd.animals;

public class Rhino extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " moo.");
    }
}
