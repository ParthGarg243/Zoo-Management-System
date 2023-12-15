package org.example;
import java.util.*;

/*
The SpecialDeal class represents a special deal and the discount that is to be
applied to tickets equal to or greater than the specified number of tickets.
 */

public class SpecialDeal implements Comparable<SpecialDeal>{
    private int tickets;    // number of tickets to apply the deal on
    private int discount;   // discount percentage
    public SpecialDeal(int tickets, int discount) {
        this.tickets = tickets;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Buy " + this.getTickets() + " tickets and get " + this.getDiscount() + "% off";
    }

    // used to sort specialDeals list in descending order of tickets
    @Override
    public int compareTo(SpecialDeal specialDeal) {
        if (this.tickets == specialDeal.getTickets()) {
            return 0;
        }
        else if (this.tickets < specialDeal.getTickets()) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public int getTickets() {
        return tickets;
    }

    public int getDiscount() {
        return discount;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}