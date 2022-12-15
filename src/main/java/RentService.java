import java.util.ArrayList;
import java.util.List;

public class RentService {
    private Library library;

    public RentService(Library bookDatabase) {
        this.library = bookDatabase;
    }

    public void rentBook(String title, String customerName) {
        ArrayList<Book> searchResults = library.searchBooks(title);
        if (!searchResults.isEmpty()) {
            Book book = searchResults.get(0);
            if (book.isAvaiable()) {
                Customer customer = library.findCustomer(customerName);
                if (customer != null) {
                    customer.addBook(book);
                    book.setAvaiable(false);
                    System.out.println("Book rented by customer " + customerName);
                }
            } else {
                System.out.println("Book is not available.");
            }
        }
    }

    public void returnBook(String title, String customerName) {
        List<Book> searchResults = library.searchBooks(title);
        if (!searchResults.isEmpty()) {
            Book book = searchResults.get(0);
            Customer customer = library.findCustomer(customerName);
            if (customer != null) {
                if (customer.hasRentedBook(book)) {
                    customer.returnBook(book);
                    book.setAvaiable(true);
                    System.out.println("Book returned by customer " + customerName);
                }
            }
        }
    }
}

