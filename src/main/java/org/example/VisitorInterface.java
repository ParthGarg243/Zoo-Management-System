package org.example;
import java.util.*;

/*
Interface for Visitor class
 */

public interface VisitorInterface {
    int ticketListTraversal(String name);
    void visitAnimal(Admin admin);
    void buyMembership(Admin admin);
    String leaveFeedback();
    double applyDiscount(Discount discount, double amount);
    void visitAttraction(Admin admin);
    void buyTickets(Admin admin);
}
