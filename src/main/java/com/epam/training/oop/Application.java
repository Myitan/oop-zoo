package com.epam.training.oop;

import com.epam.training.oop.animals.*;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        Zoo zoo = new Zoo(
                new Zookeeper[]{
                        new Zookeeper("John", Consumption.HERBIVORES),
                        new Zookeeper("Jane", Consumption.CARNIVORES, Consumption.OMNIVORES)},
                new Animal[]{
                        new Zebra(Consumption.HERBIVORES), new Zebra(Consumption.HERBIVORES), new Zebra(Consumption.HERBIVORES),
                        new Antelope(Consumption.HERBIVORES), new Antelope(Consumption.HERBIVORES), new Antelope(Consumption.HERBIVORES), new Antelope(Consumption.HERBIVORES),
                        new Hippo(Consumption.HERBIVORES), new Hippo(Consumption.HERBIVORES),
                        new Rhino(Consumption.HERBIVORES), new Rhino(Consumption.HERBIVORES), new Rhino(Consumption.HERBIVORES),
                        new Lion(Consumption.CARNIVORES), new Lion(Consumption.CARNIVORES),
                        new Mandrill(Consumption.OMNIVORES), new Mandrill(Consumption.OMNIVORES), new Mandrill(Consumption.OMNIVORES), new Mandrill(Consumption.OMNIVORES)
                });
        zoo.feedtime();
    }
}
