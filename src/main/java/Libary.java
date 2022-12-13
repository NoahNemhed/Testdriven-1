import java.util.ArrayList;
import java.util.List;

public class Libary {

    private ArrayList<Book> books;



    public Libary() {
        this.books = new ArrayList<Book>();
        addBooks();
    }



    public void addBooks()
    {
        Book book1 = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        Book book2 = new Book("Mio min mio", "Kids", "Astrid Lindgren", "1987-10-16", "4", true);
        Book book3 = new Book("Fight Club", "Drama", "Chuck Palahniuk", "1996-08-17", "4", true);
        Book book4 = new Book("Harry Potter and the goblet of fire", "Fantasy","J.K. Rowling", "2000-07-21", "4.5", true);
        Book book5 = new Book("The Fellowship of the Ring", "Action","J.R.R. Tolkien","1954-10-11", "4", true);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
    public List<Book> getBooksFromLibrary(){
        return books;
    }



}
