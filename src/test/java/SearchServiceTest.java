import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    private SearchService searchService;



    @Test
    public void findBookByTitle(){
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        when(searchService.searchByTitle("American Psycho")).thenReturn(book);
        String expected = "American Psycho";
        String actual = searchService.searchByTitle("American Psycho").getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void findBookByGenre(){
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        when(searchService.searchByGenre("Adventure")).thenReturn(book);
        String expected = "American Psycho";
        String actual = searchService.searchByGenre("Adventure").getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void findBookByAuthor(){
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        when(searchService.searchByAuthor("Bret Eeaston Ellis")).thenReturn(book);
        String expected = "American Psycho";
        String actual = searchService.searchByAuthor("Bret Eeaston Ellis").getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void findBookByStars(){
        Book book = new Book("American Psycho","Adventure", "Bret Easton Ellis","1991-4-06", "3.5", true);
        when(searchService.searchByStars("3.5")).thenReturn(book);
        String expected = "American Psycho";
        String actual = searchService.searchByStars("3.5").getTitle();
        assertEquals(expected, actual);
    }



}
