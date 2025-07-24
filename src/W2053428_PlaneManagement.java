import java.util.*;
public class PlaneManagement {
    //Define arrays for rows A, B, C and D
    static int[] RowA = new int[14];
    static int[] RowB = new int[12];
    static int[] RowC = new int[12];
    static int[] RowD = new int[14];

    //Define arrays for reserved tickets
    public static Ticket[][] appendTicket = new Ticket[4][14];

    //Define row numbers for rows A, B, C, and D
    public static  int rowNumberA = 0;
    public static  int rowNumberB = 1;
    public static  int rowNumberC = 2;
    public static  int rowNumberD = 3;

    public static void main(String[] args) {
        while (true) {
            //Display the Main menu
            Scanner user = new Scanner(System.in);
            System.out.println("\nWelcome to the Plane Management application!\n");
            System.out.println("***********************************************");
            System.out.println("*                MENU OPTIONS                 *");
            System.out.println("***********************************************");
            System.out.println("   1) Buy a seat");
            System.out.println("   2) Cancel a seat");
            System.out.println("   3) Find first available seat");
            System.out.println("   4) Show seating plan");
            System.out.println("   5)Print tickets information and total sales ");
            System.out.println("   6)Search ticket");
            System.out.println("   0) Quit");
            System.out.println("***********************************************");
            int option;
            try {
                System.out.print("Please select an option : ");
                option = user.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid data type! Please enter a valid input (1,2,3,4,5,6,0)");
                user.next();
                continue;
            }
            //Selecting options
            switch (option) {
                case 1:
                    buy_seat();

                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_Ticket();
                    break;
                case 0:
                    System.out.println("Exiting the program... Have a nice day!");
                    return;
                default:
                    System.out.println("Invalid option ! Please select a valid option. (1,2,3,4,5,6.0)");
            }
        }
    }
    //Define variables
    static int seat;
    static char character;
    static int price;

    //Method for Reserving a seat
    public static void buy_seat() {
        Scanner buy = new Scanner(System.in);
        System.out.println("\n          -- Ticket Reserving --\n");
        System.out.print("Please enter the 'Row character' where the seat is located.(A,B,C,D) : ");
        character = buy.next().toUpperCase().charAt(0);
        if (character == 'A') {
            System.out.print("Please Enter your seat number [1-14] : ");
            try {
                seat = buy.nextInt();
                if (RowA[seat - 1] == 0) {
                    RowA[seat - 1] = 1;
                    bio_details( 'A');
                    System.out.println("Your seat has been successfully reserved.");
                } else {
                    System.out.println("This seat has been already reserved.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'B') {
            System.out.print("Please Enter your seat number [1-12] : ");
            try {
                seat = buy.nextInt();
                if (RowB[seat - 1] == 0) {
                    RowB[seat - 1] = 1;
                    bio_details( 'B');
                    System.out.println("Your seat has been successfully reserved.");
                } else {
                    System.out.println("This seat has been already reserved.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'C') {
            System.out.print("Please Enter your seat number [1-12] : ");
            try {
                seat = buy.nextInt();
                if (RowC[seat - 1] == 0) {
                    RowC[seat - 1] = 1;
                    bio_details( 'C');
                    System.out.println("Your seat has been successfully reserved.");
                } else {
                    System.out.println("This seat has been already reserved.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'D') {
            System.out.print("Please Enter your seat number [1-14] : ");
            try {
                seat = buy.nextInt();
                if (RowD[seat - 1] == 0) {
                    RowD[seat - 1] = 1;
                    bio_details( 'D');
                    System.out.println("Your seat has been successfully reserved.");
                } else {
                    System.out.println("This seat has been already reserved.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else {
            System.out.println("Error: Invalid Row Character.");
        }
    }
    //Method to generate bio details
    public static void bio_details( char rowCharacter) {
        //Getting personal information
        Scanner details = new Scanner(System.in);
        System.out.print("Please provide the name of the person : ");
        String name = details.next();

        System.out.print("Please provide the Surname of the person : ");
        String surname = details.next();

        System.out.print("Please provide the Email of the person : ");
        String email = details.next();

        // Create a new personDetails object to store person details
        Person personDetails = new Person(name, surname, email);

        System.out.println(" ");

        // Create a new ticketDetails object to store ticket details and person details
        Ticket ticketDetails = new Ticket(character, seat, price, personDetails);

        if (rowCharacter == 'A') {
            appendTicket[rowNumberA][seat-1] = ticketDetails;
        } else if (rowCharacter == 'B') {
            appendTicket[rowNumberB][seat-1] = ticketDetails;
        } else if (rowCharacter == 'C') {
            appendTicket[rowNumberC][seat-1] = ticketDetails;
        } else if (rowCharacter == 'D') {
            appendTicket[rowNumberD][seat-1] = ticketDetails;
        }
        //Call the save() method to store ticket information into a file.
        ticketDetails.file_save();
    }

    //Method for Cancelling a seat
    public static void cancel_seat() {
        Scanner buy = new Scanner(System.in);
        System.out.println("\n          -- Ticket cancellation --\n");
        System.out.print("Please enter the 'Row character' where the seat is located.(A,B,C,D) : ");
        char character = buy.next().toUpperCase().charAt(0);
        if (character == 'A') {
            System.out.print("Kindly provide the seat number you wish to cancel [1-14] : ");
            try {
                int seat = buy.nextInt();
                if (RowA[seat - 1] == 1) {
                    RowA[seat - 1] = 0;

                    // Mark the ticket slot as empty in appendTicket for this seat.
                    appendTicket[0][seat-1] = null;
                    System.out.println("\nYour seat has been cancel successfully.");
                } else {
                    System.out.println("\nThis seat already available.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'B') {
            System.out.print("Kindly provide the seat number you wish to cancel [1-12] : ");
            try {
                int seat = buy.nextInt();
                if (RowB[seat - 1] == 1) {
                    RowB[seat - 1] = 0;
                    appendTicket[1][seat-1] = null;
                    System.out.println("\nYour seat has been cancel successfully.");
                } else {
                    System.out.println("\nThis seat already available.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'C') {
            System.out.print("Kindly provide the seat number you wish to cancel [1-12] : ");
            try {
                int seat = buy.nextInt();
                if (RowC[seat - 1] == 1) {
                    RowC[seat - 1] = 0;
                    appendTicket[2][seat-1] = null;
                    System.out.println("\nYour seat has been cancel successfully.");
                } else {
                    System.out.println("\nThis seat already available.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else if (character == 'D') {
            System.out.print("Kindly provide the seat number you wish to cancel [1-14] : ");
            try {
                int seat = buy.nextInt();
                if (RowD[seat - 1] == 1) {
                    RowD[seat - 1] = 0;
                    appendTicket[3][seat-1] = null;
                    System.out.println("\nYour seat has been cancel successfully.");
                } else {
                    System.out.println("\nThis seat already available.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid seat number entered.");
            }
        } else {
            System.out.println("Error: Invalid Row Character.");
        }
    }

    //Method for finding a first available seat
    private static void find_first_available() {
        // Search for the first available seat in row A
        for (int i = 0; i < 14; i++) {
            if (RowA[i] == 0) {
                System.out.println("\nThe first available seat is in row A, seat " + (i + 1) + ".");
                return;
            }
        }
        // Search for the first available seat in row B
        for (int i = 0; i < 12; i++) {
            if (RowB[i] == 0) {
                System.out.println("\nThe first available seat is in row B, seat " + (i + 1) + ".");
                return;
            }
        }
        // Search for the first available seat in row C
        for (int i = 0; i < 12; i++) {
            if (RowC[i] == 0) {
                System.out.println("\nThe first available seat is in row C, seat " + (i + 1) + ".");
                return;
            }
        }
        // Search for the first available seat in row D
        for (int i = 0; i < 14; i++) {
            if (RowD[i] == 0) {
                System.out.println("\nThe first available seat is in row D, seat " + (i + 1) + ".");
                return;
            }
        }
        // If no available seats are found
        System.out.println("\nSorry, all seats are currently reserved.");
    }

    //Method for Seating plan
    public static void show_seating_plan() {
        System.out.println("\n        -- Seating Plan --\n");
        System.out.print("Row A :  ");
        for (int p : RowA) {
            if (p == 0) {
                System.out.print('O' + " ");
            } else {
                System.out.print("X" + " ");
            }
        }
        System.out.println();

        System.out.print("Row B :  ");
        for (int q : RowB) {
            if (q == 0) {
                System.out.print('O' + " ");
            } else {
                System.out.print("X" + " ");
            }
        }
        System.out.println();

        System.out.print("Row C :  ");
        for (int r : RowC) {
            if (r == 0) {
                System.out.print('O' + " ");
            } else {
                System.out.print("X" + " ");
            }
        }
        System.out.println();

        System.out.print("Row D :  ");
        for (int s : RowD) {
            if (s == 0) {
                System.out.print('O' + " ");
            } else {
                System.out.print("X" + " ");
            }
        }
        System.out.println();
    }
    //Method to check if all values in the array are null
    public static boolean isAllValuesAreNull(Ticket[] array){
        for (Ticket element : array){
            if(element!=null){
                return false;
            }
        }
        return true;
    }

    //Method for printing tickets information
    public static void print_tickets_info() {
        int count = 1;
        double totalAmount = 0;
        // Retrieve ticket lists for each row
        Ticket[] rowATicketList = appendTicket[rowNumberA];
        Ticket[] rowBTicketList = appendTicket[rowNumberB];
        Ticket[] rowCTicketList = appendTicket[rowNumberC];
        Ticket[] rowDTicketList = appendTicket[rowNumberD];

        if (isAllValuesAreNull(rowATicketList) & isAllValuesAreNull(rowBTicketList)&isAllValuesAreNull(rowCTicketList)&isAllValuesAreNull(rowDTicketList)) {
            System.out.println("\nNo tickets were purchased throughout the session.");
            return;
        } else {
            System.out.println(" ");
            // Check each row for purchased tickets and print their information
            if (!isAllValuesAreNull(rowATicketList) ) {
                // If row has purchased tickets, iterate through them and print their information
                for (Ticket ticket : rowATicketList) {
                    if (ticket != null){
                        System.out.println("      - Ticket " + count+" -");
                        count++;
                        ticket.print_ticket_information();
                        // Accumulate the total amount
                        totalAmount += ticket.getPrice();
                    }
                }
            }
            if (!isAllValuesAreNull(rowBTicketList) ) {
                for (Ticket ticket : rowBTicketList) {
                    if (ticket != null){
                        System.out.println("      - Ticket " + count+" -");
                        count++;
                        ticket.print_ticket_information();
                        // Accumulate the total amount
                        totalAmount += ticket.getPrice();
                    }
                }
            }
            if (!isAllValuesAreNull(rowCTicketList) ) {
                for (Ticket ticket : rowCTicketList) {
                    if (ticket != null){
                        System.out.println("      - Ticket " + count+" -");
                        count++;
                        ticket.print_ticket_information();
                        // Accumulate the total amount
                        totalAmount += ticket.getPrice();
                    }
                }
            }
            if (!isAllValuesAreNull(rowDTicketList) ) {
                for (Ticket ticket : rowDTicketList) {
                    if (ticket != null){
                        System.out.println("      - Ticket " + count+" -");
                        count++;
                        ticket.print_ticket_information();
                        // Accumulate the total amount
                        totalAmount += ticket.getPrice();
                    }
                }
            }
        }
        // Total cost of tickets
        System.out.println("Total cost of tickets sold during the session: £" + totalAmount);
    }
    //Method for searching tickets
    public static void search_Ticket() {
        Scanner search = new Scanner(System.in);
        System.out.println("\n       -- Searching for ticket information --\n");
        System.out.print("Please enter the 'Row character' where the seat is located (A, B, C, D) : ");
        char search_row = search.next().toUpperCase().charAt(0);
        int search_seat;

        switch (search_row) {
            case 'A':
                try {
                    System.out.print("Please enter seat number [1-14] : ");
                    search_seat = search.nextInt();
                    if (RowA[search_seat - 1] == 0) {
                        System.out.println("The seat is available.");
                    } else if (RowA[search_seat - 1] == 1) {
                        System.out.println("This seat is not available. ");
                        System.out.println("printing ticket information");
                        // Access the 'addTickets' array
                        //first row (0 index) and at the column indicated by 'searchSeat - 1'.
                        //Then, print the details of the ticket corresponding to the seat position.
                        appendTicket[0][search_seat - 1].print_ticket_information();
                    }
                }catch (Exception e){
                    System.out.println("Invalid seat number. Please enter a number between 1 and 14.");
                }
                break;
            case 'B':
                try {
                    System.out.print("Please enter seat number [1-12] : ");
                    search_seat = search.nextInt();
                    if (RowB[search_seat - 1] == 0) {
                        System.out.println("The seat is available.");
                    } else if (RowB[search_seat - 1] == 1) {
                        System.out.println("This seat is not available. ");
                        System.out.println("printing ticket information");
                        // Access the 'addTickets' array
                        //first row (0 index) and at the column indicated by 'searchSeat - 1'.
                        //Then, print the details of the ticket corresponding to the seat position.
                        appendTicket[1][search_seat - 1].print_ticket_information();
                    }
                }catch (Exception e){
                    System.out.println("Invalid seat number. Please enter a number between 1 and 12.");
                }
                break;
            case 'C':
                try {
                    System.out.print("Please enter seat number [1-12] : ");
                    search_seat = search.nextInt();
                    if (RowC[search_seat - 1] == 0) {
                        System.out.println("The seat is available.");
                    } else if (RowC[search_seat - 1] == 1) {
                        System.out.println("This seat is not available. ");
                        System.out.println("printing ticket information");
                        // Access the 'addTickets' array
                        //first row (0 index) and at the column indicated by 'searchSeat - 1'.
                        //Then, print the details of the ticket corresponding to the seat position.
                        appendTicket[2][search_seat - 1].print_ticket_information();
                    }
                }catch (Exception e){
                    System.out.println("Invalid seat number. Please enter a number between 1 and 12.");
                }
                break;
            case 'D':
                try {
                    System.out.print("Please enter seat number [1-14] : ");
                    search_seat = search.nextInt();
                    if (RowD[search_seat - 1] == 0) {
                        System.out.println("The seat is available.");
                    } else if (RowD[search_seat - 1] == 1) {
                        System.out.println("This seat is not available. ");
                        System.out.println("printing ticket information");
                        // Access the 'addTickets' array
                        //first row (0 index) and at the column indicated by 'searchSeat - 1'.
                        //Then, print the details of the ticket corresponding to the seat position.
                        appendTicket[3][search_seat - 1].print_ticket_information();
                    }
                }catch (Exception e){
                    System.out.println("Invalid seat number. Please enter a number between 1 and 14.");
                }
                break;
            default:
                System.out.println("Invalid row character entered. Please enter A, B, C, or D.");
                break;
        }
    }
}
