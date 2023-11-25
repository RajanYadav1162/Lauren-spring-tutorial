import beans.Person;
import beans.Student;
import configuration.ProjectConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //Two ways are there to create context, using xml and annotation, we are using Annotation based context.
        //we need to provide config class to its constructor, so that spring knows where to find all the beans
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class)){

            //here we are accessing bean by type(but it will create problem if we have multiple beans with same type returning different beans
            //uncomment line number 21
//            Student student = context.getBean(Student.class);
//            System.out.println(student.toString());

            //how to solve .NoUniqueBeanDefinitionException in case of multiple bean returning same type of bean
            //access bean by name not type.
            Student student1 = context.getBean("rajan", Student.class);
            Student student2 = context.getBean("lauren", Student.class);

            //second way to create bean using @Component and @ComponentScan
            Person person = context.getBean(Person.class);

            System.out.println(person.toString());
            System.out.println(student1.toString());
            System.out.println(student2.toString());

            //other way is to use @Primary annotation with the bean, that will be returned as default in case of No unique  bean



        }
    }
}
