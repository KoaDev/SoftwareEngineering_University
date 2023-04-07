package isp.lab4.exercise4;

import java.util.Scanner;

public class Exercise4 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Event concert = new Event("Rock Concert", EventType.CONCERT, 50.0);
        PaymentMethod creditCard = new CreditCard();
        Ticket ticket;

        while (true) {
            System.out.println("Welcome to the Event Ticketing System!");
            System.out.println("1. User Menu");
            System.out.println("2. Organizer Menu");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                userMenu(concert, creditCard);
            } else if (choice == 2) {
                System.out.println("Enter the ticket ID to check-in: ");
                int ticketId = scanner.nextInt();
                ticket = new Ticket(ticketId, concert);
                OrganizerApp.checkIn(ticket);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userMenu(Event event, PaymentMethod paymentMethod) {
        Ticket ticket;
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Buy a ticket");
            System.out.println("2. View ticket");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                ticket = UserApp.buyTicket(event, paymentMethod);
                System.out.println("Ticket purchased successfully!");
                UserApp.viewTicket(ticket);
            } else if (choice == 2) {
                System.out.println("Enter the ticket ID to view: ");
                int ticketId = scanner.nextInt();
                ticket = new Ticket(ticketId, event);
                UserApp.viewTicket(ticket);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

enum EventType {
    CONCERT, CONFERENCE, SPORTS, THEATER
}

abstract class PaymentMethod {
    abstract void processPayment(double amount);
}

class CreditCard extends PaymentMethod {
    void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
    }
}

class Event {
    private final String name;
    private final EventType type;
    private final double ticketPrice;

    public Event(String name, EventType type, double ticketPrice) {
        this.name = name;
        this.type = type;
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public EventType getType() {
        return type;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

class Ticket {
    private final int id;
    private final Event event;
    private boolean isValid;

    public Ticket(int id, Event event) {
        this.id = id;
        this.event = event;
        this.isValid = false;
    }

    public int getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public boolean isValid() {
        return isValid;
    }

    public void validate(boolean isValid) {
        this.isValid = isValid;
    }
}

class TicketManager {
    static int ticketCounter = 0;

    public static Ticket generateTicket(Event event) {
        ticketCounter++;
        return new Ticket(ticketCounter, event);
    }

    public static void validateTicket(Ticket ticket) {
        if (ticket.isValid()) {
            System.out.println("Ticket is valid.");
        } else {
            System.out.println("Ticket is not valid.");
        }
    }
}

class UserApp {
    public static Ticket buyTicket(Event event, PaymentMethod paymentMethod) {
        paymentMethod.processPayment(event.getTicketPrice());
        return TicketManager.generateTicket(event);
    }

    public static void viewTicket(Ticket ticket) {
        System.out.println("Ticket ID: " + ticket.getId());
        System.out.println("Event Name: " + ticket.getEvent().getName());
        System.out.println("Event Type: " + ticket.getEvent().getType());
    }
}

class OrganizerApp {
    public static void checkIn(Ticket ticket) {
        ticket.validate(true); // set the ticket as valid
        System.out.println("Ticket check-in successful.");
    }
}