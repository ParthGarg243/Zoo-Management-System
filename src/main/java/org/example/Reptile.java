package org.example;
import java.util.*;

/*
The Reptile class is a subclass of the abstract class Animal and
corresponds to reptiles as evident from its name.
*/

public class Reptile extends Animal{
    public Reptile(String name, String voice, String description) {
        super(name, voice, description);
        this.setType("Reptile");
    }
}