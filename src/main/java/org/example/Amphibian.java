package org.example;
import java.util.*;

/*
The Amphibian class is a subclass of the abstract class Animal and
corresponds to amphibians as evident from its name.
*/

public class Amphibian extends Animal{
    public Amphibian(String name, String voice, String description) {
        super(name, voice, description);
        this.setType("Amphibian");
    }
}