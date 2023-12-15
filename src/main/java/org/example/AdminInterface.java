package org.example;
import java.util.*;

/*
Interface for Admin class
 */

public interface AdminInterface {
    Visitor getVisitor(int index);
    Animal getAnimal(int index);
    Discount getDiscount(int index);
    void viewFeedback();
    void viewSpecialDeals();
    void viewAttractions();
    void viewAnimals();
    void viewDiscounts();
    int visitorListTraversal(String email);
    int animalListTraversal(String name);
    int specialDealListTraversal(int tickets);
    int discountListTraversal(String discountCode);
    int attractionListTraversal(int id);
    int attractionListNameTraversal(String name);
    void sortSpecialDealList();
    void sortAttractionList();
    void registerVisitor();
    void manageAnimals();
    void manageSpecialDeals();
    void manageDiscounts();
    void scheduleEvents();
    void manageAttractions();
    void viewStats();
    void addRevenue(double payment);
}