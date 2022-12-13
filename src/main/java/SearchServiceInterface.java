public interface SearchServiceInterface {



    Book searchByTitle(String s);

    Book searchByGenre(String s);

    Book searchByAuthor(String s);

    Book searchByStars(String s);

}
