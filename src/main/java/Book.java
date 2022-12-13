public class Book {

    private String title,genre,author,release,stars;
    private boolean available;

    public Book() {
    }

    public Book(String title, String genre, String author, String release, String stars, boolean available) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.release = release;
        this.stars = stars;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", release='" + release + '\'' +
                ", stars='" + stars + '\'' +
                ", available=" + available +
                '}';
    }
}
