package org.example;
import java.util.*;

/*
The Discount class represents an offer for people either older or younger than the specified age,
and each offer is identified by a unique discount code.
 */

public class Discount {
    private String discountCode;    // unique code for discount
    private int age;        // age ig...
    private String moreOrLess;     // less than the specified age or more than the specified age
    private int discount;   // discount percentage
    public Discount(String discountCode, int age, String moreOrLess, int discount) {
        this.discountCode = discountCode;
        this.discount = discount;
        this.age = age;
        if (moreOrLess.equalsIgnoreCase("more")) {
            this.moreOrLess = "More";
        }
        else if (moreOrLess. equalsIgnoreCase("less")) {
            this.moreOrLess = "Less";
        }
    }

    @Override
    public String toString() {
        return this.getMoreOrLess() + " than " +  this.getAge() + " years old (" + this.getDiscount() + "% discount) - " + this.getDiscountCode();
    }

    public int getDiscount() {
        return discount;
    }

    public int getAge() {
        return age;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getMoreOrLess() {
        return moreOrLess;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setMoreOrLess(String moreOrLess) {
        this.moreOrLess = moreOrLess;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}