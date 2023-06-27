package com.epam.training.oop;

import com.epam.training.oop.animals.Animal;

public class Zoo {

    private final Zookeeper[] zookeepers;
    private final Animal[] animals;

    public Zoo(Zookeeper[] zookeepers, Animal[] animals) {
        this.zookeepers = zookeepers;
        this.animals = animals;
    }

    public void feedtime() {
        for (Zookeeper zookeeper : zookeepers) {
            zookeeper.feed(animals);
        }
    }
}
