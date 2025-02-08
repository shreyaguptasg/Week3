package circularlinkedlist.onlineticketreservationsystem;

class TicketReservationSystem {
    Ticket head;

    TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular list
    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            head.next = head;  // Circular link to itself
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;  // Making it circular
        }
    }

    // Remove a ticket by Ticket ID
    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Check if the head node contains the ticket to be removed
        if (temp.ticketId == ticketId) {
            if (temp.next == head) {  // Only one node in the list
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            System.out.println("Ticket with ID " + ticketId + " removed.");
            return;
        }

        // Traverse the circular list and find the ticket with the given ID
        while (temp.next != head && temp.ticketId != ticketId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.ticketId == ticketId) {
            prev.next = temp.next;
            System.out.println("Ticket with ID " + ticketId + " removed.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    // Display all booked tickets in the circular list
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name
    Ticket searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return null;
        }

        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket with customer " + customerName + " not found.");
        return null;
    }

    // Search for a ticket by Movie Name
    Ticket searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return null;
        }

        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket for movie " + movieName + " not found.");
        return null;
    }

    // Calculate the total number of booked tickets
    int totalTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}
