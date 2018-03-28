import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Movie movie1 = new Movie("Beauty and the Beast", 2);
    private Movie movie2 = new Movie("Harry Potter", 2);
    private Movie movie3 = new Movie("New Movie", 1);
    private Movie movie4 = new Movie("Regular Movie 1", 0);
    private Movie movie5 = new Movie("Regular Movie 2", 0);

    private Rental rental1 = new Rental(movie1, 2);
    private Rental rental2 = new Rental(movie2, 1);
    private Rental rental3 = new Rental(movie3, 4);
    private Rental rental4 = new Rental(movie4, 0);
    private Rental rental5 = new Rental(movie5, 2);

    private Customer customer1 = new Customer("Aiden");
    
    @Test
    public void emptyStatement() {
        assertEquals("Rental Record for Aiden\n" +
                "Amount owed is 0.0\n" +
                " You earned 0 frequent renter points", customer1.statement());
    }

    @Test
    public void test1() {
        customer1.addRental(rental1);
        assertEquals("Rental Record for Aiden\n" +
                "\t Beauty and the Beast\t 1.5\n" +
                " Amount owed is 1.5\n" +
                " You earned 1 frequent renter points", customer1.statement());
    }

    @Test
    public void test2() {
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        assertEquals("Rental Record for Aiden\n" +
                "\t Beauty and the Beast\t 1.5\n" +
                " \t Harry Potter\t 1.5\n" +
                " Amount owed is 3.0\n" +
                " You earned 2 frequent renter points", customer1.statement());
    }

    @Test
    public void test3() {
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        assertEquals("Rental Record for Aiden\n" +
                "\t Beauty and the Beast\t 1.5\n" +
                " \t Harry Potter\t 1.5\n" +
                " \t New Movie\t 12.0\n" +
                " Amount owed is 15.0\n" +
                " You earned 4 frequent renter points", customer1.statement());
    }

    @Test
    public void test4() {
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        customer1.addRental(rental4);
        assertEquals("Rental Record for Aiden\n" +
                "\t Beauty and the Beast\t 1.5\n" +
                " \t Harry Potter\t 1.5\n" +
                " \t New Movie\t 12.0\n" +
                " \t Regular Movie 1\t 2.0\n" +
                " Amount owed is 17.0\n" +
                " You earned 5 frequent renter points", customer1.statement());
    }

    @Test
    public void test5() {
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        customer1.addRental(rental4);
        customer1.addRental(rental5);
        assertEquals("Rental Record for Aiden\n" +
                "\t Beauty and the Beast\t 1.5\n" +
                " \t Harry Potter\t 1.5\n" +
                " \t New Movie\t 12.0\n" +
                " \t Regular Movie 1\t 2.0\n" +
                " \t Regular Movie 2\t 2.0\n" +
                " Amount owed is 19.0\n" +
                " You earned 6 frequent renter points", customer1.statement());
    }
}