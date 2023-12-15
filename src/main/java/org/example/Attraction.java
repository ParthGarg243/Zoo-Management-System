package org.example;
import java.util.*;

/*
The Attraction class represents an attraction in the zoo.
It provides methods for updating attraction details, tracking the number of visitors and
opening or closing the attraction.
 */

public class Attraction implements Event, Comparable<Attraction> {
    private int open;       // is the attraction open (1) or closed (0)
    private int visitors;   // count of visitors
    private int id;         // unique id
    private int price;      // price of ticket
    private String name;    // umm... does it need a comment really?
    private String description;     // one line description of the attraction
    private static int idCounter = 0;   // counter to assign IDs to new attractions automatically
    Scanner scanner = new Scanner(System.in);

    public Attraction(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.open = 1;
        idCounter++;
        this.id = idCounter;
    }

    @Override
    public String toString() {
        return this.getId() + ". " + this.getName() + " (" + this.getPrice() + " bucks)";
    }

    // used to sort attractionsList in descending order of visitors
    @Override
    public int compareTo(Attraction attraction) {
        if (this.visitors == attraction.getVisitors()) {
            return 0;
        }
        else if (this.visitors < attraction.getVisitors()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getVisitors() {
        return visitors;
    }

    public int getOpen() {
        return open;
    }

    public int getPrice() {
        return price;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setIdCounter(int idCounter) {
        Attraction.idCounter = idCounter;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public void incrementVisitor() {
        this.visitors++;
    }

    public void openAttraction() {
        if (this.open == 0) {
            this.open = 1;
            System.out.print("Enter price of ticket: ");
            this.price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\nThe attraction has been opened");
        }
        else if (this.open == 1) {
            System.out.println("\nThe attraction is already open");
        }
    }

    public void closeAttraction() {
        if (this.open == 1){
            this.open = 0;
            System.out.println("\nThe attraction has been closed");
        }
        else if (this.open == 0) {
            System.out.println("\nThe attraction is already closed");
        }
    }

    /*
    allows you to change the name, price of ticket and description for an attraction

    Errors Handled: 1. The price of an attraction's ticket can't be negative.
                    2. An attraction already exists with the newly entered name.
     */
    public void updateDetails(Admin admin) {
        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Description");
        System.out.print("\nEnter Choice: ");
        int updateOption = scanner.nextInt();
        scanner.nextLine();
        if (updateOption == 1) {
            System.out.print("\nEnter new Name: ");
            String newName = scanner.nextLine();
            int index = admin.attractionListNameTraversal(newName);
            if (index == -1) {
                this.setName(newName);
                System.out.println("\nAttraction's name has been updated");
            }
            else {
                System.out.println("\nAn attraction with that name already exists");
            }
        }
        else if (updateOption == 2) {
            System.out.print("\nEnter new Price: ");
            int newPrice = scanner.nextInt();
            scanner.nextLine();
            if (newPrice >= 0) {
                this.setPrice(newPrice);
                System.out.println("\nAttraction's price has been updated");
            }
            else {
                System.out.println("\nPrice can't be negative");
            }
        }
        else if (updateOption == 3) {
            System.out.print("\nEnter new Description: ");
            this.description = scanner.nextLine();
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }
}