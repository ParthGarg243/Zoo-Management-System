package org.example;
import java.util.*;

/*
Interface for Attraction class
 */

public interface Event {
    void incrementVisitor();
    void openAttraction();
    void closeAttraction();
    void updateDetails(Admin admin);
}