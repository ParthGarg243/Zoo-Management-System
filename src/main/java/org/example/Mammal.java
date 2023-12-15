package org.example;
import java.util.*;

/*
The mammal class is a subclass of the abstract class Animal and
corresponds to mammals as evident from its name.
*/

public class Mammal extends Animal{
    public Mammal(String name, String voice, String description) {
        super(name, voice, description);
        this.setType("Mammal");
    }
}