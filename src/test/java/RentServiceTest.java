import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RentServiceTest {


    @InjectMocks
    private RentService rentService;
    @Mock
    private SearchService searchService;



    @Test
    public void Avaiable(){
        BookingRequest bookingRequest = new BookingRequest("American Psycho");
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        when(searchService.searchByTitle("American Psycho")).thenReturn(book);
        assertTrue(rentService.isAvailable(bookingRequest));
    }

    @Test
    public void notAvailable(){
        BookingRequest bookingRequest = new BookingRequest("American Psycho");
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", false);
        when(searchService.searchByTitle("American Psycho")).thenReturn(book);
        assertFalse(rentService.isAvailable(bookingRequest));
    }

}
