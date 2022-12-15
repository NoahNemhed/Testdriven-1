

public class Book {

    String title, releaseYear, genre, grade, author;
    boolean avaiable;


    public Book(String title, String releaseYear, String genre, String grade, String author) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.grade = grade;
        this.author = author;
        this.avaiable = true;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isAvaiable() {
        return avaiable;
    }

    public void setAvaiable(boolean avaiable) {
        this.avaiable = avaiable;
    }


}


