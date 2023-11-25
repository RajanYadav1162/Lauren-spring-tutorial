import configuration.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.TodoService;

public class Main {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            TodoService todo = context.getBean(TodoService.class);
            todo.AddTodo();
            todo.AddTodo();
        }
    }
}

