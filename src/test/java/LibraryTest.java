import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LibraryTest {


    private Library mockDatabase;
    private SearchService searchService;
    private ArrayList<Book> mockBooks;
    private ArrayList<Customer> mockCustomers;
    private RentService rentService;

    @BeforeEach
    public void setUp() {
        mockDatabase = Mockito.mock(Library.class);
        searchService = new SearchService(mockDatabase);
        rentService = new RentService(mockDatabase);
        mockBooks = new ArrayList<>();
        mockBooks.add(new Book("The Great Gatsby", "1925", "Fiction", "9", "F. Scott Fitzgerald"));
        mockBooks.add(new Book("To Kill a Mockingbird", "1960", "Fiction", "10", "Harper Lee"));
        mockBooks.add(new Book("Pride and Prejudice", "1813", "Fiction", "8", "Jane Austen"));

        mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customer("Noah"));
        mockCustomers.add(new Customer("Erik"));
        mockCustomers.add(new Customer("William"));

        Mockito.when(mockDatabase.getBooks()).thenReturn(mockBooks);
        Mockito.when(mockDatabase.getCustomers()).thenReturn(mockCustomers);


    }

    @Test
    public void testSearchForBookByTitle() {
        Mockito.when(mockDatabase.searchBooks(anyString())).thenReturn(mockBooks);
        List<Book> searchResults = searchService.searchByBook("The Great Gatsby");
        Mockito.verify(mockDatabase).searchBooks("The Great Gatsby");
        assertEquals(mockBooks, searchResults);
    }

    @Test
    public void testSearchForBookByAutor() {
        Mockito.when(mockDatabase.searchBooks(anyString())).thenReturn(mockBooks);
        List<Book> searchResults = searchService.searchByBook("F. Scott Fitzgerald");
        Mockito.verify(mockDatabase).searchBooks("F. Scott Fitzgerald");
        assertEquals(mockBooks, searchResults);
    }

    @Test
    public void testSearchForBookThatNotExists() {
        Mockito.when(mockDatabase.searchBooks(anyString())).thenReturn(new ArrayList<Book>());

        List<Book> searchResults = searchService.searchByBook("The Book of Unknowns");
        Mockito.verify(mockDatabase).searchBooks("The Book of Unknowns");

        assertTrue(searchResults.isEmpty());
    }

    @Test
    public void testSearchForCustomer() {
        Customer mockCustomer = mockCustomers.get(0);
        List<Customer> searchResults = searchService.searchCustomers(mockCustomer.getName());
        assertTrue(searchResults.contains(mockCustomer));
    }



    @Test
    public void testSearchForCustomerThatNotExist() {
        // Set the return value of the findCustomer() method to an empty list of Customers
        List<Customer> searchResults = searchService.searchCustomers("John Doe");
        assertTrue(searchResults.isEmpty());
    }


    @Test
    public void testReturnBook() {
        Book mockBook = mockBooks.get(0);
        Customer customer = mockCustomers.get(0);
        customer.addBook(mockBook);
        customer.returnBook(mockBook);
        assertFalse(customer.getRentedBooks().contains(mockBook));
    }

    //Should return Book successfully rented to customer Noah
    @Test
    public void testRentBook() {
        Customer customer = mockCustomers.get(0);
        Book book = mockBooks.get(0);
        customer.addBook(book);
        List<Book> rentedBooks = customer.getRentedBooks();
        assertTrue(rentedBooks.contains(book));
    }


    @Test
    public void testAddCustomer() {
        Customer mockCustomer = mock(Customer.class);
        mockDatabase.addCustomer(mockCustomer);
        Mockito.verify(mockDatabase).addCustomer(mockCustomer);
    }

    @Test
    public void testAddBook() {
        Book mockBock = mock(Book.class);
        mockDatabase.addBook(mockBock);
        Mockito.verify(mockDatabase).addBook(mockBock);
    }

    @Test
    public void testToSeeRentedBook() {
        Customer mockCustomer = mock(Customer.class);
        Book mockBook = mock(Book.class);
        when(mockCustomer.hasRentedBook(mockBook)).thenReturn(true);
        rentService.rentBook(mockBook.getTitle(), mockCustomer.getName());
        assertTrue(mockCustomer.hasRentedBook(mockBook));
    }



}


