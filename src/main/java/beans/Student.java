package beans;

public class Student {
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "book=" + book +
                '}';
    }
}
