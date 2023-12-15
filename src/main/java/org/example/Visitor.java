package org.example;
import java.util.*;

/*
The Visitor class corresponds to visitors in the zoo and provides functionality to
buy tickets, memberships, leaving feedback, and exploring attractions and animals.
 */

public class Visitor implements VisitorInterface{
    private String name;        // name...
    private int age;            // age...
    private long phoneNumber;   // phoneNumber...
    private double balance;     // remaining balance
    private String email;       // unique email
    private String password;    // password...
    private int basic;          // 1 if the person is a basic member else 0
    private int premium;        // 1 if the person is a premium member else 0
    private ArrayList<Ticket> ticketList = new ArrayList<>();   // list of tickets bought by the visitor
    Scanner scanner = new Scanner(System.in);

    public Visitor(String name, int age, long phoneNumber, int balance, String email, String password){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.basic = 0;
        this.premium = 0;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getBasic() {
        return basic;
    }

    public int getPremium() {
        return premium;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    /*
    returns the index of a ticket in the ticketList using name of the attraction
    returns -1 if not found
     */
    public int ticketListTraversal(String name) {
        for (int i = 0; i < this.ticketList.size(); i++) {
            Ticket ticket = this.ticketList.get(i);
            if (ticket.getAttraction().getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    /*
    allows the visitor to visit any animal from the animalList and then
    either feed the animal or read its description

    Errors Handled: 1. Animal with the entered name not found.
     */
    public void visitAnimal(Admin admin) {
        ArrayList<Animal> animalList = admin.getAnimalList();
        admin.viewAnimals();
        System.out.print("\nEnter Name: ");
        String animalName = scanner.nextLine();
        int index = admin.animalListTraversal(animalName);
        if (index == -1) {
            System.out.println("\nAnimal with that name doesn't exist");
        }
        else {
            Animal animal = animalList.get(index);
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed the Animal");
            System.out.println("2. Read about the Animal");
            System.out.println("\nEnter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("\nYou feed the " + animal.getName() + " and it makes a noise: " + animal.getVoice());
            }
            else if (choice == 2) {
                System.out.println(animal.getName() + " is a " + animal.getType() + ". " + animal.getDescription());
            }
            else {
                System.out.println("\nInvalid Input");
            }
        }
    }

    /*
    allows the visitor to buy basic or premium membership and then provide the visitor with
    an option to apply discount on the amount

    Errors Handled: 1. Insufficient balance.
                    2. No discount found for the entered discount code.
                    3. Visitor has purchased the membership previously.
     */
    public void buyMembership(Admin admin) {
        System.out.println("\nMemberships Available: ");
        System.out.println("1. Basic Membership (20 bucks)");
        System.out.println("2. Premium Membership (50 bucks)");
        System.out.print("\nEnter Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            if (this.basic == 0) {
                if (this.balance >= 20) {
                    System.out.println("\nWould you like to apply a discount code?");
                    System.out.println("Type 1 for yes");
                    System.out.println("Type 2 for no");
                    System.out.print("Enter Choice: ");
                    int newChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (newChoice == 1) {
                        admin.viewDiscounts();
                        System.out.print("Enter Discount Code: ");
                        String discountCode = scanner.nextLine();
                        int index = admin.discountListTraversal(discountCode);
                        double amount = 20;
                        if (index == -1) {
                            System.out.println("\nNo such discount code found");
                        }
                        else {
                            Discount discount = admin.getDiscount(index);
                            amount = this.applyDiscount(discount, amount);
                        }
                        admin.addRevenue(amount);
                        this.balance = this.balance - amount;
                        this.basic = 1;
                        System.out.println("\nBasic Membership purchased");
                        System.out.println("New Balance: " + this.balance);
                    }
                    else if (newChoice == 2) {
                        admin.addRevenue(20);
                        this.balance = this.balance - 20;
                        this.basic = 1;
                        System.out.println("\nBasic Membership purchased");
                        System.out.println("New Balance: " + this.balance);
                    }
                    else {
                        System.out.println("\nInvalid Input");
                    }
                }
                else {
                    System.out.println("\nNot enough balance");
                }
            }
            else if (this.basic == 1) {
                System.out.println("You have already purchased the basic membership");
            }
        }
        else if (choice == 2) {
            if (this.premium == 0) {
                if (this.balance >= 50) {
                    System.out.println("\nWould you like to apply a discount code?");
                    System.out.println("Type 1 for yes");
                    System.out.println("Type 2 for no");
                    System.out.print("\nEnter Choice: ");
                    int newChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (newChoice == 1) {
                        admin.viewDiscounts();
                        System.out.print("Enter Discount Code: ");
                        String discountCode = scanner.nextLine();
                        int index = admin.discountListTraversal(discountCode);
                        double amount = 50;
                        if (index == -1) {
                            System.out.println("\nNo such discount code found");
                        }
                        else {
                            Discount discount = admin.getDiscount(index);
                            amount = this.applyDiscount(discount, amount);
                        }
                        admin.addRevenue(amount);
                        this.balance = this.balance - amount;
                        this.premium = 1;
                        System.out.println("\nPremium Membership purchased");
                        System.out.println("\nNew Balance: " + this.balance);
                    }
                    else if (newChoice == 2) {
                        admin.addRevenue(50);
                        this.balance = this.balance - 50;
                        this.premium = 1;
                        System.out.println("\nPremium Membership purchased");
                        System.out.println("New Balance: " + this.balance);
                    }
                    else {
                        System.out.println("\nInvalid Input");
                    }
                }
                else {
                    System.out.println("\nNot enough balance");
                }
            }
            else if (this.premium == 1) {
                System.out.println("You have already purchased the premium membership");
            }
        }
        else {
            System.out.println("\nInvalid Input");
        }
    }

    // leave feedback about your experience and suggest improvements
    public String leaveFeedback() {
        System.out.print("\nEnter Feedback: ");
        return scanner.nextLine();
    }

    /*
    checks if visitor is eligible for discount and then apply it on the amount

    Errors Handled: 1. Visitor is not eligible for the discount
     */
    public double applyDiscount (Discount discount, double amount) {
        if (discount.getMoreOrLess().equalsIgnoreCase("more")) {
            if (this.age > discount.getAge()) {
                amount -= (amount * discount.getDiscount() / 100.0);
                System.out.println("\nDiscount Applied!");
            }
            else {
                System.out.println("\nYou are not eligible for the discount");
            }
            return amount;
        }
        else if (discount.getMoreOrLess().equalsIgnoreCase("less")) {
            if (this.age < discount.getAge()) {
                amount -= (amount * discount.getDiscount() / 100.0);
                System.out.println("\nDiscount Applied!");
            }
            else {
                System.out.println("\nYou are not eligible for the discount");
            }
            return amount;
        }
        return amount;
    }

    /*
    Allows visitors to visit an attraction if they have a ticket for it and
    then use up the ticket.

    Errors Handled: 1. No attraction found with the entered name.
                    2. The visitor doesn't have a ticket for the attraction.
     */
    public void visitAttraction(Admin admin) {
        admin.viewAttractions();
        System.out.print("\nEnter the ID of Attraction you'd like to visit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int index = admin.attractionListTraversal(id);
        if (index == -1) {
            System.out.println("\nNo such attraction found");
        }
        else {
            Attraction attraction = admin.getAttractionList().get(index);
            if (this.premium == 1) {
                if (attraction.getOpen() == 1) {
                    System.out.println("\nWelcome to " + attraction.getName());
                    attraction.incrementVisitor();
                }
                else {
                    System.out.println("\nSorry, the attraction is closed right now");
                }
            }
            else {
                int newIndex = ticketListTraversal(attraction.getName());
                if (newIndex == -1) {
                    System.out.println("\nYou don't have a ticket for this attraction");
                }
                else {
                    Ticket ticket = this.ticketList.get(newIndex);
                    if (ticket.getTickets() > 0) {
                        if (ticket.getAttraction().getOpen() == 1) {
                            System.out.println("\nWelcome to " + ticket.getAttraction().getName());
                            ticket.useTickets();
                            ticket.getAttraction().incrementVisitor();
                        }
                        else {
                            System.out.println("\nSorry, the attraction is closed right now");
                        }
                    }
                    else {
                        System.out.println("\nYou don't have a ticket for this attraction");
                    }
                }
            }
        }
    }

    /*
    The visitor enters the number of tickets they intend to buy and continues to
    purchase them until they run out of balance or buy the specified amount of
    tickets. The function automatically checks for any applicable special deals and
    applies them. The user is then provided with an option to apply a discount to
    the remaining amount.

    Errors Handled: 1. No attraction found with the entered ID.
                    2. Not allowed to buy tickets if the attraction is closed.
                    3. No special deal found.
                    4. No discount found with the entered ID.
                    5. The visitor is not even a basic member.
     */
    public void buyTickets(Admin admin) {
        if (this.premium == 1) {
            System.out.println("\nYou are a premium user and can visit any attraction without the need of buying tickets");
        }
        else if (this.basic == 1 && this.premium == 0) {
            double amount = 0;
            int actualTickets = 0;
            System.out.print("Enter number of tickets: ");
            int ticketCount = scanner.nextInt();
            scanner.nextLine();
            if (ticketCount > 0) {
                while (this.balance > amount && ticketCount > 0) {
                    admin.viewAttractions(true);
                    System.out.println("0. Exit...");
                    System.out.print("\nEnter Choice: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (id == 0) {
                        break;
                    }
                    else {
                        int index = admin.attractionListTraversal(id);
                        if (index == -1) {
                            System.out.println("\nAttraction with that ID doesn't exist");
                        }
                        else {
                            Attraction attraction = admin.getAttractionList().get(index);
                            if (attraction.getOpen() == 1) {
                                if (this.balance >= amount + attraction.getPrice()) {
                                    ticketCount--;
                                    actualTickets++;
                                    amount = amount + attraction.getPrice();
                                    int newIndex = ticketListTraversal(attraction.getName());
                                    if (newIndex == -1) {
                                        Ticket newTicket = new Ticket(attraction);
                                        this.ticketList.add(newTicket);
                                    }
                                    else {
                                        this.ticketList.get(newIndex).buyTicket();
                                    }
                                    System.out.println("A ticket has been bought for the specified attraction");
                                    if (amount >= this.balance) {
                                        break;
                                    }
                                }
                            }
                            else {
                                System.out.println("\nCan't buy tickets as the attraction is closed");
                            }
                        }
                    }
                }
                if (actualTickets > 0) {
                    int found = 0;
                    int index = 0;
                    for (int i = 0; i < admin.getSpecialDealList().size(); i++) {
                        SpecialDeal specialDeal = admin.getSpecialDealList().get(i);
                        if (actualTickets >= specialDeal.getTickets()) {
                            found = 1;
                            index = i;
                            break;
                        }
                    }
                    if (found == 0) {
                        System.out.println("\nTotal Amount: " + amount);
                        System.out.println("\nSorry! No Special Deal found for the specified amount of tickets");
                    }
                    else {
                        SpecialDeal specialDeal = admin.getSpecialDealList().get(index);
                        System.out.println("\nTotal Amount: " + amount);
                        System.out.println("\nSpecial Deal Found:");
                        System.out.println(specialDeal.getDiscount() + "% off on more than " + specialDeal.getTickets() + " tickets. This Special Deal has been applied on the amount!");
                        amount -= (amount * specialDeal.getDiscount() / 100.0);
                        System.out.println("\nNew Amount: " + amount);
                    }
                    System.out.println("\nWould you like to apply a discount code as well?");
                    System.out.println("Type 1 for yes");
                    System.out.println("Type 2 for no");
                    System.out.print("Enter Choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        admin.viewDiscounts();
                        System.out.print("\nEnter Discount Code: ");
                        String discountCode = scanner.nextLine();
                        int anotherIndex = admin.discountListTraversal(discountCode);
                        if (anotherIndex == -1) {
                            System.out.println("\nNo such discount code found");
                        }
                        else {
                            Discount discount = admin.getDiscount(index);
                            amount = this.applyDiscount(discount, amount);
                        }
                        System.out.println("\nThanks for buying the tickets!");
                        this.balance = this.balance - amount;
                        admin.addRevenue(amount);
                        System.out.println("\nNew Balance: " + balance);
                    }
                    else if (choice == 2) {
                        System.out.println("\nThanks for buying the tickets!");
                        this.balance = this.balance - amount;
                        admin.addRevenue(amount);
                        System.out.println("\nNew Balance: " + balance);
                    }
                    else {
                        System.out.println("\nInvalid Input");
                        System.out.println("\nThanks for buying the tickets!");
                        this.balance = this.balance - amount;
                        admin.addRevenue(amount);
                        System.out.println("\nNew Balance: " + balance);
                    }
                }
                else {
                    System.out.println("No tickets bought");
                }
            }
            else {
                System.out.println("\nNumber of tickets has to be positive");
            }
        }
        else if (this.basic == 0 && this.premium == 0){
            System.out.println("\nYou need to buy the basic membership at least to buy tickets");
        }
    }

    /*
    allows visitors to view the names of all animals and attractions in the zoo and
    also to read the description of any attraction.

    Errors Handled: 1. No attraction found with the entered name.
     */
    public void exploreZoo(Admin admin) {
        while (true) {
            System.out.println("\n1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");
            System.out.print("\nEnter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                admin.viewAttractions();
                System.out.print("\nEnter Choice: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                int index = admin.attractionListTraversal(id);
                if (index == -1) {
                    System.out.println("\nNo such attraction found");
                }
                else {
                    System.out.println("\n" + admin.getAttractionList().get(index).getDescription());
                }
            }
            else if (choice == 2) {
                admin.viewAnimals();
            }
            else if (choice == 3) {
                break;
            }
            else {
                System.out.println("\nInvalid Input");
            }
        }
    }
}