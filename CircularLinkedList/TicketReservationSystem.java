package CircularLinkedList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class TicketReservationSystem {

    // Ticket Node Class
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            this.next = null;
        }
    }

    private Ticket head = null;
    private Ticket tail = null;
    private int totalTickets = 0;

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);

        if (head == null) { // First ticket
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular linking
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular nature
        }

        totalTickets++;
        System.out.println("✅ Ticket Booked: " + ticketId + " for " + customerName + " (" + movieName + ")");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("⚠️ No tickets to remove.");
            return;
        }

        Ticket temp = head, prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == head && temp == tail) { // Only one ticket case
                    head = tail = null;
                } else if (temp == head) { // Removing head
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) { // Removing tail
                    prev.next = head;
                    tail = prev;
                } else { // Removing middle ticket
                    prev.next = temp.next;
                }

                totalTickets--;
                System.out.println("❌ Ticket Canceled: " + ticketId);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("⚠️ Ticket ID " + ticketId + " not found.");
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("📜 No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n🔄 Ticket Reservations:");
        do {
            System.out.println("🎟️ Ticket ID: " + temp.ticketId +
                    " | Customer: " + temp.customerName +
                    " | Movie: " + temp.movieName +
                    " | Seat: " + temp.seatNumber +
                    " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("⚠️ No tickets found.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("🎟️ Ticket Found - ID: " + temp.ticketId + " | Movie: " + temp.movieName +
                        " | Customer: " + temp.customerName + " | Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("❌ No tickets found for '" + keyword + "'.");
        }
    }

    // Get total number of booked tickets
    public void getTotalTickets() {
        System.out.println("📊 Total Tickets Booked: " + totalTickets);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Booking tickets
        system.addTicket(101, "Alice", "Inception", "A1");
        system.addTicket(102, "Bob", "Interstellar", "B2");
        system.addTicket(103, "Charlie", "Inception", "A3");
        system.addTicket(104, "David", "Tenet", "C4");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Inception");
        system.searchTicket("Alice");

        // Remove a ticket
        system.removeTicket(102);

        // Display remaining tickets
        system.displayTickets();

        // Get total ticket count
        system.getTotalTickets();
    }
}

