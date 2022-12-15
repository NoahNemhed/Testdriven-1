
import java.util.ArrayList;


public class Customer {

    String name;
    ArrayList<Book> rentedBooks;

    public Customer(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public void returnBook(Book book) {
        if (hasRentedBook(book)) {
            rentedBooks.remove(book);
            book.setAvaiable(true);
        }
    }




    public boolean hasRentedBook(Book book) {
        return rentedBooks.contains(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void addBook(Book book){
        getRentedBooks().add(book);
    }
}
