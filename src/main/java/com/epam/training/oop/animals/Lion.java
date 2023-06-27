package com.epam.training.oop.animals;

public class Lion extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " roars.");
    }
}
