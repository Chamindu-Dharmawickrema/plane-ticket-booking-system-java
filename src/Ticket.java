import java.io.FileWriter;
import java.io.IOException;
public class Ticket {
    // Attributes for Ticket class
    private char character;
    private int seat;
    private double price;
    private Person person;

    // Constructor
    public Ticket(char character,int seat ,int price ,Person person){
        this.character=character;
        this.seat=seat;
        this.price=price;
        this.person=person;
    }
    // Method to calculate price
    private double Price_Calculator() {
        if (seat >= 1 && seat <= 5) {
            price = 200;
            return price;
        } else if (seat >= 6 && seat <= 9) {
            price = 150;
            return price;
        } else {
            price = 180;
            return price;
        }
    }

    //Getters ,Setters
    public void setName(char character ){
        this.character=character;
    }
    public char getRow(){
        return character;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    // Method to print ticket details
    public void print_ticket_information(){
        System.out.println("-- Ticket Information --");
        System.out.println("Row   : "+character);
        System.out.println("Seat  : "+seat);
        System.out.println("Price : "+Price_Calculator());
        System.out.println("-- Person Information --");
        person.print();
    }

    // Method to save person and ticket information to text file
    public void file_save() {
        String fileName = character + String.valueOf(seat) + ".txt"; // Convert seat to string for concatenation
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Ticket Information:\n");
            fileWriter.write("Row: " + character + "\n");
            fileWriter.write("Seat Number: " + seat + "\n");
            fileWriter.write("Person Name: " + getPerson().getName() + "\n");
            fileWriter.write("Person Surname : "+ getPerson().getSurname()+"\n");
            fileWriter.write("Person Email: " + getPerson().getEmail() + "\n");
            System.out.println("Ticket information saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ticket information to file.");
            e.printStackTrace();
        }
    }
}
