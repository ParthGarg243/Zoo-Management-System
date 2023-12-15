package org.example;
import java.util.*;

/*
The Animal class is an abstract class. It has methods to manage an animal's name,
voice, description, and a method to update these variables.
 */

public abstract class Animal {
    private String type;    // is the animal an amphibian/mammal/reptile
    private String name;    // umm yea... name
    private String voice;   // again... voice
    private String description;     // a line describing the animal
    Scanner scanner = new Scanner(System.in);

    public Animal(String name, String voice, String description) {
        this.name = name;
        this.voice = voice;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getType() + ")";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getVoice() {
        return voice;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    allows you to change the name, voice and description of the animal

    Errors Handled: 1. An animal already exists with the newly entered name.
     */
    public void updateDetails(Admin admin) {
        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Name");
        System.out.println("2. Voice");
        System.out.println("3. Description");
        System.out.print("\nEnter Choice: ");
        int updateOption = scanner.nextInt();
        scanner.nextLine();
        if (updateOption == 1) {
            System.out.print("\nEnter new Name: ");
            String newName = scanner.nextLine();
            int index = admin.animalListTraversal(newName);
            if (index == -1) {
                this.setName(newName);
                System.out.println("\nAnimal's name has been updated");
            }
            else {
                System.out.println("\nAn attraction with that name already exists");
            }
        }
        else if (updateOption == 2) {
            System.out.print("\nEnter new Voice: ");
            String newVoice = scanner.nextLine();
            this.setVoice(newVoice);
            System.out.println("\nAnimal's voice has been updated");
        }
        else if (updateOption == 3) {
            System.out.print("\nEnter new Description: ");
            String newDescription = scanner.nextLine();
            this.setDescription(newDescription);
            System.out.println("\nAnimal's description has been updated");
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }
}