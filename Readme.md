# Assignment 2: ZOOtopia
This is a Zoo Management System developed as part of the Assignment 2 of CSE201: Advanced Programming conducted in Monsoon 2023 at IIIT Delhi.

## Assumptions:
- Admin Username is `admin`, Admin Password is `admin123`.
- All new attractions are open by default.
- Discount codes and visitor passwords are case-sensitive.
- Discount codes are added with a specification for age (older/younger).
- Total revenue is increased only if a visitor buys tickets or a membership.
- A visitor needs to have at least a basic membership to purchase tickets.
- The basic membership is assumed to be worth 20 bucks, and the premium membership is worth 50 bucks, as given in the sample run.
- The number of visitors shown when the admin prints visitor stats represents the count of registered visitors. The number of visitors for attractions indicates the number of people visiting the specific attraction.
- While buying tickets, the special deal is applied automatically when a person buys tickets equal to or more than the number of tickets eligible for the deal. The user is then provided with the option to apply a discount code to the total amount.
- Premium users can access any attraction without purchasing tickets.
- By default, two instances of each class (reptiles, mammals, amphibians, attractions, special deals, and discounts) have been added at the beginning.
- Maintaining a counter for attraction ID that increments each time a new attraction is added, with the attraction ID being set as the current value of the counter.

## Instructions:
1. Navigate to the root directory.
2. Execute the following commands:
   - mvn clean
   - mvn compile
   - mvn package
   - java -cp .\target\AP_Assignment_2-1.0-SNAPSHOT.jar org.example.Main
