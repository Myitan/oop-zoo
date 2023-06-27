package com.epam.rd.animals;

public class Mandrill extends Animal {
    @Override
    public void makeSound() {
        System.out.println(this.getClass().getSimpleName() + " screams.");
    }
}
