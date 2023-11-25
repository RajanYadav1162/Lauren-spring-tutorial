package services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TodoRepository;

//here also we are more specific sterio type
//@Service annotation used when we are doing some processing or writing some business logics
@Service
public class TodoService {
    //instead of creating context, getting it by name or type, we are using autowiring, spring automatically but the bean inside of it.
    @Autowired
    private TodoRepository todoRepository;

    public void AddTodo() {
        todoRepository.addTodo();
        todoRepository.addTodo();
    }
}
