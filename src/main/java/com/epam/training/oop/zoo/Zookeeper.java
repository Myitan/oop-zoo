package com.epam.training.oop.zoo;

import com.epam.training.oop.zoo.animals.Animal;

public class Zookeeper {
    private final String name;
    private final Consumption[] consumption;

    public Zookeeper(String name, Consumption... consumption) {
        this.name = name;
        this.consumption = consumption;
    }


    public void feed(Animal[] animals) {
        for (Animal animal : animals){
            for (Consumption consumption1 : consumption){
                if (consumption1 == animal.getConsumption()){
                    animal.makeSound();
                    System.out.println(this.name + " is feeding " + animal.getName() + " the " + animal.getClass().getSimpleName());
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }
}
