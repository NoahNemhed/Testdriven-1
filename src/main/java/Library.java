import java.util.ArrayList;
import java.util.List;

public class Library {

    private ArrayList<Customer> customers;
    private ArrayList<Book> books;


    public Library() {
        this.customers = new ArrayList<>();
        this.books = new ArrayList<>();

        //Adding customers
        addCustomer(new Customer("Noah"));
        addCustomer(new Customer("Erik"));
        addCustomer(new Customer("William"));
        addCustomer(new Customer("Daniel"));
        addCustomer(new Customer("Elias"));
        addCustomer(new Customer("Anton"));
        addCustomer(new Customer("August"));
        addCustomer(new Customer("Albin"));
        addCustomer(new Customer("Ted"));
        addCustomer(new Customer("Sebastian"));

        //Adding books
        addBook(new Book("The Great Gatsby", "1925", "Fiction", "9", "F. Scott Fitzgerald"));
        addBook(new Book("To Kill a Mockingbird", "1960", "Fiction", "10", "Harper Lee"));
        addBook(new Book("Pride and Prejudice", "1813", "Fiction", "8", "Jane Austen"));
        addBook(new Book("The Catcher in the Rye", "1951", "Fiction", "9", "J.D. Salinger"));
        addBook(new Book("The Grapes of Wrath", "1939", "Fiction", "10", "John Steinbeck"));
    }


    // Metod för att lägga till en ny bok i databasen
    public void addBook(Book book) {
        books.add(book);
    }

    // Metod för att lägga till en ny kund i databasen
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Metod för att söka efter böcker i databasen
    public ArrayList<Book> searchBooks(String query) {
        ArrayList<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getGenre().contains(query) || book.getReleaseYear().contains(query) || book.getGrade().contains(query)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // Method to find a customer in the database
    public Customer findCustomer(String name) {
        ArrayList<Customer> searchResults = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }


    // Metod för att hämta en lista med alla uthyrda böcker
    public ArrayList<Book> getRentedBooks() {
        ArrayList<Book> rentedBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isAvaiable()) {
                rentedBooks.add(book);
            }
        }
        // Return the list of rented books
        return rentedBooks;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }



}
