package com.bridgelabz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {

    static List<Contact> addressBook;

    public static void main(String[] args) {
        addressBook = new LinkedList<Contact>();

        boolean isExit = false;

        System.out.println("Welcome to the Address book, Manage your contacts " + "with the Address book");
        Scanner scanner = new Scanner(System.in);
        while (!isExit) {
            System.out.println("Select the option from below");
            if (addressBook.isEmpty()) {
                System.out.println("1. Add Contact" + "\n5. Exit");
            } else {
                System.out.println(
                        "1. Add Contact" + "\n2. Display Contact\n3. Edit Contact" + "\n4. Delete Contact\n5. Exit");
            }
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addContact(scanner);
                    break;
                case "2":
                    showContacts();
                    break;

                default:
                    System.out.println("Invalid option choosed.");
                    break;
            }
        }
        scanner.close();
    }

    private static void showContacts() {
        if (addressBook.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            for (Contact contact : addressBook) {
                System.out.println(contact);
            }
        }
    }

    private static void addContact(Scanner scanner) {
        Contact contact = new Contact();

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();
        contact.setFirstName(validateFirstName(firstName, scanner));


        addressBook.add(contact);
        System.out.println("Contact has been saved.");
    }
    public static String validateFirstName(String firstName, Scanner scanner) {
        String resultPattern = "^[A-Z]{1}[a-z]{2,9}$";
        Pattern regex = Pattern.compile(resultPattern);
        Matcher inputMatcher = regex.matcher(firstName);

        while (!inputMatcher.matches()) {
            System.out.println("Error: Invalid first name, please try again");
            System.out.println("length must not exceeds 10 (Exa: Karthik)");
            firstName = scanner.nextLine();
            inputMatcher = regex.matcher(firstName);
        }
        return firstName;
    }

}