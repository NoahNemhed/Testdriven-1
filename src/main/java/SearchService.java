import java.util.ArrayList;

public class SearchService implements SearchServiceInterface{

    private Book none;
    private Libary libary;

    public SearchService(Book none, Libary libary) {
        this.none = new Book();
        this.none.setTitle("none");
        this.libary = libary;

    }

    @Override
    public Book searchByTitle(String s) {
        ArrayList<Book> books = (ArrayList<Book>) libary.getBooksFromLibrary();
        for(Book b : books){
            if(b.getTitle().equals(s)){
                return b;
            }
        }
        return none;
    }

    @Override
    public Book searchByGenre(String s) {
        ArrayList<Book> books = (ArrayList<Book>) libary.getBooksFromLibrary();
        for(Book b : books){
            if(b.getGenre().equals(s)){
                return b;
            }
        }
        return none;
    }

    @Override
    public Book searchByAuthor(String s) {
        ArrayList<Book> books = (ArrayList<Book>) libary.getBooksFromLibrary();
        for(Book b : books){
            if(b.getAuthor().equals(s)){
                return b;
            }
        }
        return none;
    }

    @Override
    public Book searchByStars(String s) {
        ArrayList<Book> books = (ArrayList<Book>) libary.getBooksFromLibrary();
        for(Book b : books){
            if(b.getStars().equals(s)){
                return b;
            }
        }
        return none;
    }
}
