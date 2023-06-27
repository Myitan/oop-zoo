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
                        new Zookeeper("John", new Animal[]{new Zebra(), new Antelope(), new Hippo()}),
                        new Zookeeper("Jane", new Animal[]{new Rhino(), new Lion(), new Mandrill()})},
                new Animal[]{
                        new Zebra(), new Zebra(), new Zebra(),
                        new Antelope(), new Antelope(), new Antelope(), new Antelope(),
                        new Hippo(), new Hippo(),
                        new Rhino(), new Rhino(), new Rhino(),
                        new Lion(), new Lion(),
                        new Mandrill(), new Mandrill(), new Mandrill(), new Mandrill()
                });
        zoo.feedtime();
    }
}
