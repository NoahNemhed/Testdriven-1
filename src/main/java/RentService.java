import java.util.ArrayList;

public class RentService {

    private SearchService searchService;

    public RentService() {


    }


    public boolean isAvailable(BookingRequest request){
        Book book = searchService.searchByTitle(request.getTitle());
        return book.isAvailable();
    }


    //Metod för att låna en bok
    public boolean rentBook(BookingRequest request) {
    Book book = searchService.searchByTitle(request.getTitle());
    if(book.isAvailable()){
        book.setAvailable(false);
        return true;
    }
    return false;
    }

    //Metod för att lämna tillbaka en bok
    public boolean returnBook(BookingRequest request) {
        Book book = searchService.searchByTitle(request.getTitle());
        if(!book.isAvailable()){
            book.setAvailable(true);
            return true;
        }
        return false;
    }


}

