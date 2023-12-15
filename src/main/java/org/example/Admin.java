package org.example;
import java.util.*;

/*
The Admin class is used to manage the zoo.
It provides functions to register visitors, manage animals, attractions, special deals, discounts,
and schedule events, as well as view statistics and manage the park's revenue.
*/

public class Admin implements AdminInterface {
    private double revenue;     // keeps a track of revenue
    private int visitors;       // count of registered visitors
    private int reptiles;       // count of reptiles
    private int mammals;        // count of mammals
    private int amphibians;     // count of amphibians
    private ArrayList<String> feedbackList = new ArrayList<>();     // list of feedbacks received
    private ArrayList<Visitor> visitorList = new ArrayList<>();     // list of registered visitors
    private ArrayList<Animal> animalList = new ArrayList<>();       // list of all animals
    private ArrayList<Attraction> attractionList  = new ArrayList<>();  // list of attractions
    private ArrayList<SpecialDeal> specialDealList = new ArrayList<>(); // list of special deals
    private ArrayList<Discount> discountList = new ArrayList<>();   // list of discounts
    Scanner scanner = new Scanner(System.in);

    public Admin() {
        this.visitors = 0;
        this.amphibians = 2;
        this.mammals = 2;
        this.reptiles = 2;
        // adding the default animals, special deals and discounts
        Animal animal1 = new Mammal("Lion", "Roar", "The lion is known as the king of the jungle and is famous for its majestic appearance and social behavior.");
        this.animalList.add(animal1);
        Animal animal2 = new Mammal("Giraffe", "Bellow", "Giraffes are known for their towering height, long necks, and unique spotted patterns.");
        this.animalList.add(animal2);
        Animal animal3 = new Reptile("Chameleon", "Click", "Chameleons are known for their unique ability to change color and their slow, deliberate movements.");
        this.animalList.add(animal3);
        Animal animal4 = new Reptile("Komodo Dragon", "Hiss", "The Komodo dragon is the world's largest lizard, known for its impressive size and powerful bite.");
        this.animalList.add(animal4);
        Animal animal5 = new Amphibian("Frog", "Croak", "Frogs are small, hopping amphibians with a distinct croaking sound, commonly found near water bodies.");
        this.animalList.add(animal5);
        Animal animal6 = new Amphibian("Salamander", "Chirp", "Salamanders are slender, often brightly colored amphibians, known for their regenerative abilities and preference for damp environments.");
        this.animalList.add(animal6);
        Attraction attraction1 = new Attraction("Aqua Adventure", 20, "Immerse yourself in the enchanting realm of aquatic life.");
        this.attractionList.add(attraction1);
        Attraction attraction2 = new Attraction("Birds of Paradise", 15, "Encounter the splendor of exotic bird species.");
        this.attractionList.add(attraction2);
        Discount discount1 = new Discount("MINOR10", 18, "less", 10);
        this.discountList.add(discount1);
        Discount discount2 = new Discount("SENIOR20", 59, "more", 20);
        this.discountList.add(discount2);
        SpecialDeal specialDeal1 = new SpecialDeal(2, 15);
        this.specialDealList.add(specialDeal1);
        SpecialDeal specialDeal2 = new SpecialDeal(3, 30);
        this.specialDealList.add(specialDeal2);
    }

    public ArrayList<Attraction> getAttractionList() {
        return attractionList;
    }

    public ArrayList<SpecialDeal> getSpecialDealList() {
        return specialDealList;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public ArrayList<String> getFeedbackList() {
        return feedbackList;
    }

    public int getVisitors() {
        return visitors;
    }

    public int getReptiles() {
        return reptiles;
    }

    public int getAmphibians() {
        return amphibians;
    }

    public ArrayList<Visitor> getVisitorList() {
        return visitorList;
    }

    public int getMammals() {
        return mammals;
    }

    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setAmphibians(int amphibians) {
        this.amphibians = amphibians;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public void setAttractionList(ArrayList<Attraction> attractionList) {
        this.attractionList = attractionList;
    }

    public void setDiscountList(ArrayList<Discount> discountList) {
        this.discountList = discountList;
    }

    public void setFeedbackList(ArrayList<String> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public void setMammals(int mammals) {
        this.mammals = mammals;
    }

    public void setReptiles(int reptiles) {
        this.reptiles = reptiles;
    }

    public void setSpecialDealList(ArrayList<SpecialDeal> specialDealList) {
        this.specialDealList = specialDealList;
    }

    public void setVisitorList(ArrayList<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    // used to return visitor stored at a particular index of the visitorList
    public Visitor getVisitor(int index) {
        return this.visitorList.get(index);
    }

    // used to return animal stored at a particular index of the animalList
    public Animal getAnimal(int index) {
        return this.animalList.get(index);
    }

    // used to return discount stored at a particular index of the discountList
    public Discount getDiscount(int index) {
        return this.discountList.get(index);
    }

    // prints the feedbacks received
    public void viewFeedback() {
        System.out.println("\nFeedback:");
        for (int i = 0; i < this.feedbackList.size(); i++) {
            int index = i + 1;
            System.out.println(index + ". " + this.feedbackList.get(i));
        }
    }

    // prints the condition and discount percentage of all available special deals
    public void viewSpecialDeals() {
        System.out.println("\nSpecial Deals:");
        for (int i = 0; i < this.specialDealList.size(); i++) {
            int index = i + 1;
            SpecialDeal specialDeal = this.specialDealList.get(i);
            System.out.println(index + ". " + specialDeal);
        }
    }

    // prints the id, name and price of ticket for all attractions
    public void viewAttractions() {
        System.out.println("\nAttractions: ");
        for (int i = 0; i < this.attractionList.size(); i++) {
            Attraction attraction = this.attractionList.get(i);
            System.out.println(attraction);
        }
    }

    // prints the id, name and price of ticket for all attractions that are open to visit
    public void viewAttractions(boolean bool) {
        System.out.println("\nAttractions: ");
        for (int i = 0; i < this.attractionList.size(); i++) {
            Attraction attraction = this.attractionList.get(i);
            if (attraction.getOpen() == 1) {
                System.out.println(attraction);
            }
        }
    }

    // prints the name and type of all animals
    public void viewAnimals() {
        System.out.println("\nAnimals:");
        for (int i = 0; i < this.animalList.size(); i++) {
            int index = i + 1;
            Animal animal = this.animalList.get(i);
            System.out.println(index + ". " + animal);
        }
    }

    // prints the code, condition and discount percentage of all available discounts
    public void viewDiscounts() {
        System.out.println("\nDiscounts:");
        for (int i = 0; i < this.discountList.size(); i++) {
            int index = i + 1;
            Discount discount = this.discountList.get(i);
            System.out.println(index + ". " + discount);
        }
    }

    /*
    returns the index of a visitor in the visitorList using email
    returns -1 if not found
     */
    public int visitorListTraversal(String email) {
        for (int i = 0; i < this.visitorList.size(); i++) {
            Visitor cursorVisitor = this.visitorList.get(i);
            if (cursorVisitor.getEmail().equalsIgnoreCase(email)) {
                return i;
            }
        }
        return -1;
    }

    /*
    returns the index of an animal in the animalList using the name
    returns -1 if not found
     */
    public int animalListTraversal(String name) {
        for (int i = 0; i < this.animalList.size(); i++) {
            Animal cursorAnimal = this.animalList.get(i);
            if (cursorAnimal.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    /*
    returns the index of a special deal in the specialDealList using the number of tickets
    returns -1 if not found
     */
    public int specialDealListTraversal(int tickets) {
        for (int i = 0; i < this.specialDealList.size(); i++) {
            SpecialDeal cursorSpecialDeal = this.specialDealList.get(i);
            if (cursorSpecialDeal.getTickets() == tickets) {
                return i;
            }
        }
        return -1;
    }

    /*
    returns the index of a discount in the discountList using the discount code
    returns -1 if not found
     */
    public int discountListTraversal(String discountCode) {
        for (int i = 0; i < this.discountList.size(); i++) {
            Discount discount = this.discountList.get(i);
            if (discount.getDiscountCode().equals(discountCode)) {
                return i;
            }
        }
        return -1;
    }

    /*
    returns the index of an attraction in the attractionList using the attraction id
    returns -1 if not found
     */
    public int attractionListTraversal(int id) {
        for (int i = 0; i < this.attractionList.size(); i++) {
            Attraction attraction = this.attractionList.get(i);
            if (attraction.getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /*
    returns the index of an attraction in the attractionList using name
    returns -1 if not found
     */
    public int attractionListNameTraversal(String name) {
        for (int i = 0; i < this.attractionList.size(); i++) {
            Attraction attraction = this.attractionList.get(i);
            if (attraction.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // sorts specialDealList in descending order of tickets (used to automatically check for special deals)
    public void sortSpecialDealList() {
        for (int i = 0; i < this.specialDealList.size(); i++) {
            for (int j = i + 1; j < this.specialDealList.size(); j++) {
                if (this.specialDealList.get(i).compareTo(this.specialDealList.get(j)) > 0) {
                    SpecialDeal tempSpecialDeal = this.specialDealList.get(i);
                    this.specialDealList.set(i, this.specialDealList.get(j));
                    this.specialDealList.set(j, tempSpecialDeal);
                }
            }
        }
    }

    // sorts attractionList in descending order of visitors (used to display top attractions)
    public void sortAttractionList() {
        for (int i = 0; i < this.attractionList.size(); i++) {
            for (int j = i + 1; j < this.attractionList.size(); j++) {
                if (this.attractionList.get(i).compareTo(this.attractionList.get(j)) > 0) {
                    Attraction tempAttraction = this.attractionList.get(i);
                    this.attractionList.set(i, this.attractionList.get(j));
                    this.attractionList.set(j, tempAttraction);
                }
            }
        }
    }

    /*
    register a visitor really...

    Errors handled: 1. If the newly entered email is already registered.
     */
    public void registerVisitor() {
        System.out.print("\nEnter Name: ");
        String visitorName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int visitorAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        int visitorPhoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Balance: ");
        int visitorBalance = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Email: ");
        String visitorEmail = scanner.nextLine();
        int index = visitorListTraversal(visitorEmail);
        if (index == -1) {
            System.out.print("Enter Password: ");
            String visitorPassword = scanner.nextLine();
            Visitor newVisitor = new Visitor(visitorName, visitorAge, visitorPhoneNumber, visitorBalance, visitorEmail, visitorPassword);
            this.visitorList.add(newVisitor);
            this.visitors++;
            System.out.println("\nYou have been registered");
        }
        else {
            System.out.println("\nEmail already registered");
        }
    }

    /*
    provides the functionality to add or remove an animal and update the details of an animal

    Errors Handled: 1. Invalid type of the new animal.
                    2. An animal with the same name as the new animal already exists.
                    3. Animal name not found when either removing an animal or updating an animal's details.
                    4. All other errors are handled in the Animal.updateDetails() method.
     */
    public void manageAnimals() {
        System.out.println("\n1. Add Animal");
        System.out.println("2. Update Animal Details");
        System.out.println("3. Remove Animal");
        System.out.print("\nEnter Choice: ");
        int manageAnimalChoice = scanner.nextInt();
        scanner.nextLine();
        if (manageAnimalChoice == 1) {
            System.out.print("\nEnter Animal Name: ");
            String animalName = scanner.nextLine();
            int index = animalListTraversal(animalName);
            if (index == -1) {
                System.out.print("Enter Animal Type (Amphibian/Mammal/Reptile): ");
                String animalType = scanner.nextLine();
                System.out.print("Enter Animal Voice: ");
                String animalVoice = scanner.nextLine();
                System.out.print("Enter Animal Description: ");
                String animalDescription = scanner.nextLine();
                if (animalType.equalsIgnoreCase("amphibian")) {
                    Animal newAnimal = new Amphibian(animalName, animalVoice, animalDescription);
                    animalList.add(newAnimal);
                    this.amphibians++;
                    System.out.println("\nAnimal has been added");
                }
                else if (animalType.equalsIgnoreCase("mammal")) {
                    Animal newAnimal = new Mammal(animalName, animalVoice, animalDescription);
                    animalList.add(newAnimal);
                    this.mammals++;
                    System.out.println("\nAnimal has been added");
                }
                else if (animalType.equalsIgnoreCase("reptile")) {
                    Animal newAnimal = new Reptile(animalName, animalVoice, animalDescription);
                    animalList.add(newAnimal);
                    this.reptiles++;
                    System.out.println("\nAnimal has been added");
                }
                else {
                    System.out.print("\nInvalid Animal Type");
                }
            }
            else {
                System.out.println("\nAnimal with that name already exists");
            }
        }
        else if (manageAnimalChoice == 2) {
            this.viewAnimals();
            System.out.print("\nEnter Animal Name: ");
            String animalName = scanner.nextLine();
            int index = animalListTraversal(animalName);
            if (index == -1) {
                System.out.println("\nAnimal with that name not found");
            }
            else {
                Animal animal = getAnimal(index);
                animal.updateDetails(this);
            }
        }
        else if (manageAnimalChoice == 3) {
            this.viewAnimals();
            System.out.print("\nEnter Animal Name: ");
            String animalName = scanner.nextLine();
            int index = animalListTraversal(animalName);
            if (index == -1) {
                System.out.println("\nAnimal with that name doesn't exist");
            }
            else {
                Animal animal = getAnimal(index);
                if (animal.getType().equals("Reptile")) {
                    this.reptiles--;
                }
                else if (animal.getType().equals("Mammal")) {
                    this.mammals--;
                }
                else if (animal.getType().equals("Amphibian")) {
                    this.amphibians--;
                }
                animalList.remove(index);
                System.out.println("\nAnimal has been removed");
            }
        }
        else {
            System.out.println("\nInvalid Choice");
        }
    }

    /*
    provides the functionality to add or remove a special deal

    Errors Handled: 1. A deal for the specified number of tickets already exists when adding a special deal
                    2. Special deal with the specified number of tickets not found when removing a special deal
     */
    public void manageSpecialDeals() {
        System.out.println("\n1. Add a Special Deal");
        System.out.println("2. Remove a Special Deal");
        System.out.print("\nEnter Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("\nEnter Number of Tickets: ");
            int tickets = scanner.nextInt();
            scanner.nextLine();
            int index = this.specialDealListTraversal(tickets);
            if (index == -1) {
                System.out.print("\nEnter Discount: ");
                int discount = scanner.nextInt();
                scanner.nextLine();
                SpecialDeal specialDeal = new SpecialDeal(tickets, discount);
                this.specialDealList.add(specialDeal);
                this.sortSpecialDealList();
                System.out.println("\nSpecial Deal has been added");
            }
            else {
                System.out.println("\nA deal for the specified number of tickets already exists");
            }
        }
        else if (choice == 2) {
            this.viewSpecialDeals();
            System.out.print("\nEnter number of Tickets: ");
            int tickets = scanner.nextInt();
            scanner.nextLine();
            int index = this.specialDealListTraversal(tickets);
            if (index == -1) {
                System.out.println("\nNo such Special Deal found");
            }
            else {
                this.specialDealList.remove(index);
                System.out.println("\nSpecial Deal has been removed");
            }
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }

    /*
    provides the functionality to add or remove a discount

    Errors Handled: 1. A discount with the entered discount code already exists when adding a discount.
                    2. The discount with the entered discount code was not found when removing a discount.
                    3. The discount percentage entered should be positive and less than or equal to 100.
     */
    public void manageDiscounts() {
        System.out.println("\n1. Add a Discount");
        System.out.println("2. Remove a Discount");
        System.out.print("\nEnter Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("\nEnter Discount Code: ");
            String discountCode = scanner.nextLine();
            int index = discountListTraversal(discountCode);
            if (index == -1) {
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type 'more' to apply discount for people more than the specified age");
                System.out.println("Type 'less' to apply discount for people less than the specified age");
                System.out.print("Enter choice: ");
                String moreOrLess = scanner.nextLine();
                if (moreOrLess.equalsIgnoreCase("more") || moreOrLess.equalsIgnoreCase("less")) {
                    System.out.print("Enter Discount Percentage: ");
                    int discount = scanner.nextInt();
                    scanner.nextLine();
                    if (discount <=100 && discount >= 0) {
                        Discount newDiscount = new Discount(discountCode, age, moreOrLess, discount);
                        this.discountList.add(newDiscount);
                        System.out.println("\nDiscount has been added");
                    }
                    else {
                        System.out.println("\nDiscount percentage should be positive and less than or equal to 100%");
                    }
                }
                else {
                    System.out.println("Invalid Input");
                }
            }
            else {
                System.out.println("\nDiscount with that code already exists");
            }
        }
        else if (choice == 2) {
            this.viewDiscounts();
            System.out.print("\nEnter Discount Code: ");
            String discountCode = scanner.nextLine();
            int index = discountListTraversal(discountCode);
            if (index == -1) {
                System.out.println("\nNo such discount code exists");
            }
            else {
                this.discountList.remove(index);
                System.out.println("\nDiscount has been removed");
            }
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }

    /*
    provides the functionality to open or close an attraction

    Errors Handled: 1. Attraction with the attraction id entered not found
     */
    public void scheduleEvents() {
        System.out.println("\n1. Open an Attraction");
        System.out.println("2. Close an Attraction");
        System.out.print("\nEnter Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            this.viewAttractions();
            System.out.print("\nEnter Attraction ID: ");
            int attractionID = scanner.nextInt();
            scanner.nextLine();
            int index = attractionListTraversal(attractionID);
            if (index == -1) {
                System.out.println("\nNo such attraction found");
            }
            else {
                Attraction attraction = attractionList.get(index);
                attraction.openAttraction();
            }
        }
        else if (choice == 2) {
            this.viewAttractions();
            System.out.print("\nEnter Attraction ID: ");
            int attractionID = scanner.nextInt();
            scanner.nextLine();
            int index = attractionListTraversal(attractionID);
            if (index == -1) {
                System.out.println("\nNo such attraction found");
            }
            else {
                Attraction attraction = attractionList.get(index);
                attraction.closeAttraction();
            }
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }

    /*
    provides the functionality to add or remove an attraction and update th details of an attraction

    Errors Handled: 1. The price of an attraction's ticket can't be negative.
                    2. An attraction with the entered name already exists when adding an attraction.
                    3. The attraction with the entered name was not found when removing an attraction.
                    4. Remaining errors are handled in the Attraction.updateDetails() method.
     */
    public void manageAttractions() {
        System.out.println("\n1. Add an Attraction");
        System.out.println("2. Update an Attraction");
        System.out.println("3. Remove an Attraction");
        System.out.print("\nEnter Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1){
            System.out.print("\nEnter Attraction Name: ");
            String name = scanner.nextLine();
            int index = this.attractionListNameTraversal(name);
            if (index == -1) {
                System.out.print("Enter Price: ");
                int price = scanner.nextInt();
                scanner.nextLine();
                if (price >= 0) {
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    Attraction attraction = new Attraction(name, price, description);
                    this.attractionList.add(attraction);
                }
                else {
                    System.out.println("\nPrice can't be negative");
                }
            }
            else {
                System.out.println("\nAn attraction with that name already exists");
            }
        }
        else if (choice == 2) {
            this.viewAttractions();
            System.out.print("\nEnter Attraction ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            int index = this.attractionListTraversal(id);
            if (index == -1) {
                System.out.println("\nNo such attraction found");
            }
            else {
                Attraction attraction = this.attractionList.get(index);
                attraction.updateDetails(this);
            }
        }
        else if (choice == 3) {
            this.viewAttractions();
            System.out.print("\nEnter Attraction ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            int index = this.attractionListTraversal(id);
            if (index == -1) {
                System.out.println("\nNo such attraction found");
            }
            else {
                this.attractionList.remove(index);
                System.out.println("\nAttraction has been removed");
            }
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }

    // used to view the number of registered visitors, revenue and the top 3 attractions
    public void viewStats() {
        System.out.println("\nTotal Visitors: " + this.visitors);
        System.out.println("\nTotal Revenue: " + this.revenue);
        this.sortAttractionList();
        System.out.println("\nTop 3 Attractions:");
        for (int i = 0; i < this.attractionList.size(); i++) {
            if (i == 2) {
                break;
            }
            System.out.println((i + 1) + ". " + this.attractionList.get(i).getName() + " (" + this.attractionList.get(i).getVisitors() + " Visitors)");
        }
    }

    // used to increase the revenue whenever a visitor buys a ticket or a membership
    public void addRevenue(double payment) {
        this.revenue = this.revenue + payment;
    }
}