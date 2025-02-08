package circularlinkedlist.onlineticketreservationsystem;

public class TicketReservationMain {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some tickets
        system.addTicket(101, "John Doe", "Avatar 2", "A1", "10:00 AM");
        system.addTicket(102, "Jane Smith", "Spider-Man", "B2", "11:00 AM");
        system.addTicket(103, "Alice Johnson", "Avatar 2", "C3", "12:00 PM");

        // Display all booked tickets
        system.displayTickets();

        // Search for a ticket by customer name
        Ticket ticket = system.searchByCustomerName("John Doe");
        if (ticket != null) {
            System.out.println("Found Ticket for " + ticket.customerName + ": " + ticket.movieName);
        }

        // Remove a ticket by Ticket ID
        system.removeTicket(102);

        // Display remaining tickets
        system.displayTickets();

        // Calculate and display total number of booked tickets
        System.out.println("Total tickets booked: " + system.totalTickets());
    }
}
