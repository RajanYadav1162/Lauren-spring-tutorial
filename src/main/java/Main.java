import beans.Book;
import beans.Student;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Student student = context.getBean(Student.class);
            Book book = context.getBean(Book.class);

            System.out.println(book);
            System.out.println(student);
        }
    }
}
