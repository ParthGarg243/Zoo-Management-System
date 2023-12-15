package org.example;
import java.util.*;

/*
The "Ticket" class represents the number of tickets purchased by a visitor for
a specific attraction in the application and provides methods for buying and using tickets.
 */

public class Ticket {
    private Attraction attraction;  // attraction the ticket corresponds to
    private int tickets;            // number of tickets bought for the attraction

    public Ticket(Attraction attraction) {
        this.tickets = 1;
        this.attraction = attraction;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public int getTickets() {
        return tickets;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    // increment tickets by 1 when buying a ticket
    public void buyTicket() {
        this.tickets++;
    }

    // decrement tickets by 1 when using a ticket
    public void useTickets() {
        this.tickets--;
    }
}