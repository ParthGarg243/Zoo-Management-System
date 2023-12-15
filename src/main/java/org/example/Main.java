package org.example;
import java.util.*;

/*
The Main class provides a menu-driven interface for both the admin and visitors.

Errors Handled: 1. Invalid admin username or password
                2. Visitor email not registered
                3. Incorrect visitor password
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        while (true) {
            System.out.println("\n\tWelcome to ZOOtopia!\n");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("\nEnter Admin Username: ");
                String adminUser = scanner.nextLine();
                if (adminUser.equals("admin")) {
                    System.out.print("Enter Admin Password: ");
                    String adminPass = scanner.nextLine();
                    if (adminPass.equals("admin123")) {
                        while (true) {
                            System.out.println("\n\tAdmin Menu\n");
                            System.out.println("1. Manage Attractions");
                            System.out.println("2. Manage Animals");
                            System.out.println("3. Schedule Events");
                            System.out.println("4. Set Discounts");
                            System.out.println("5. Set Special Deal");
                            System.out.println("6. View Visitor Stats");
                            System.out.println("7. View Feedback");
                            System.out.println("8. Log Out");
                            System.out.print("\nEnter Choice: ");
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (adminChoice == 1) {
                                admin.manageAttractions();
                            }
                            else if (adminChoice == 2) {
                                admin.manageAnimals();
                            }
                            else if (adminChoice == 3) {
                                admin.scheduleEvents();
                            }
                            else if (adminChoice == 4) {
                                admin.manageDiscounts();
                            }
                            else if (adminChoice == 5) {
                                admin.manageSpecialDeals();
                            }
                            else if (adminChoice == 6) {
                                admin.viewStats();
                            }
                            else if (adminChoice == 7) {
                                admin.viewFeedback();
                            }
                            else if (adminChoice == 8) {
                                System.out.println("\nSuccessfully Logged Out, Going back to HomePage");
                                break;
                            }
                            else {
                                System.out.println("\nInvalid Input");
                            }
                        }
                    }
                    else {
                        System.out.println("\nIncorrect Password, Going back to HomePage");
                    }
                }
                else {
                    System.out.println("\nInvalid Username, Going back to HomePage");
                }
            }
            else if(choice == 2) {
                while (true) {
                    System.out.println("\n1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("\nEnter choice: ");
                    int visitorLoginChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (visitorLoginChoice == 1) {
                        admin.registerVisitor();
                    }
                    else if (visitorLoginChoice == 2) {
                        System.out.print("\nEnter Visitor Email: ");
                        String loginEmail = scanner.nextLine();
                        int index = admin.visitorListTraversal(loginEmail);
                        if (index == -1) {
                            System.out.println("\nEmail is not registered");
                        }
                        else {
                            Visitor visitor = admin.getVisitor(index);
                            System.out.print("Enter Visitor Password: ");
                            String loginPassword = scanner.nextLine();
                            if (visitor.getPassword().equals(loginPassword)) {
                                while (true) {
                                    System.out.println("\n\tVisitor Menu\n");
                                    System.out.println("1. Explore the Zoo");
                                    System.out.println("2. Buy Membership");
                                    System.out.println("3. Buy Tickets");
                                    System.out.println("4. View Discounts");
                                    System.out.println("5. View Special Deals");
                                    System.out.println("6. Visit Animals");
                                    System.out.println("7. Visit Attractions");
                                    System.out.println("8. Leave Feedback");
                                    System.out.println("9. Exit");
                                    System.out.print("\nEnter Choice: ");
                                    int visitorChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (visitorChoice == 1) {
                                        visitor.exploreZoo(admin);
                                    }
                                    else if (visitorChoice == 2) {
                                        visitor.buyMembership(admin);
                                    }
                                    else if (visitorChoice == 3) {
                                        visitor.buyTickets(admin);
                                    }
                                    else if (visitorChoice == 4) {
                                        admin.viewDiscounts();
                                    }
                                    else if (visitorChoice == 5) {
                                        admin.viewSpecialDeals();
                                    }
                                    else if (visitorChoice == 6) {
                                        visitor.visitAnimal(admin);
                                    }
                                    else if (visitorChoice == 7) {
                                        visitor.visitAttraction(admin);
                                    }
                                    else if (visitorChoice == 8) {
                                        admin.getFeedbackList().add(visitor.leaveFeedback());
                                        System.out.println("\nThanks for the feedback!");
                                    }
                                    else if (visitorChoice == 9) {
                                        System.out.println("\nSuccessfully Logged Out, Going back to HomePage");
                                        break;
                                    }
                                    else {
                                        System.out.println("\nInvalid Input");
                                    }
                                }
                            }
                            else {
                                System.out.println("\nIncorrect Password");
                            }
                        }
                    }
                    else if (visitorLoginChoice == 3) {
                        System.out.println("\nGoing back to HomePage");
                        break;
                    }
                    else {
                        System.out.println("\nInvalid Input");
                    }
                }
            }
            else if (choice == 3) {
                admin.viewSpecialDeals();
            }
            else if (choice == 4) {
                System.out.println("\nThanks for visiting!");
                break;
            }
            else {
                System.out.println("\nInvalid Input");
            }
        }
    }
}