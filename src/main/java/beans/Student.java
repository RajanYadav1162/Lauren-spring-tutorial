package beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    //so here we can use the field injections using @Autowired annotation which is bad practice
//    @Autowired
//    private Book book;

    //using constructor injection is recommended why?
    //we can make it final, meaning we can't change it
    //enhances single responsibility principle, we will be able to see if we are passing too many parameters in constructor
    // but in case of field we might ignore.
    //so if too many paremeters in constructor, we have a problem with code design.
    private final Book book;
    public Student(Book book){
        this.book = book;
    }

    public Book getBook() {
        return book;
    }


    @Override
    public String toString() {
        return "Student{" +
                "book=" + book +
                '}';
    }
}
