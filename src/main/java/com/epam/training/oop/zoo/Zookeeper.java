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

    }

    public String getName() {
        return name;
    }
}
