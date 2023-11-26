package config;


import beans.Book;
import beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
//
//    @Bean
//    public Student student(){
//        Student student = new Student();
//        // here it looks like we are creating new object when calling book() method, but actually spring seeing
//        //that it has already one bean of type Book so it will put that.
//        student.setBook(book());
//        return student;
//    }


    @Bean
    public Student student(Book book){
        Student student = new Student();
       //this is another way we can do, again same, since this method is annotated with @Bean, spring will see
        //whether in its context it has any Book bean, since its there it will automatically inject it.
        student.setBook(book);
        return student;
    }


    @Bean
    public Book book(){
        Book book = new Book();
        book.setName("Algorithms");
        return book;
    }
}
