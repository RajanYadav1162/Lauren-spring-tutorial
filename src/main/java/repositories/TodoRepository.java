package repositories;


import org.springframework.stereotype.Repository;

//instead of using more generic @component we are doing more specific
//generally @Repository means we are going to handle DB stuffs here.
@Repository
public class TodoRepository {

    public void addTodo() {
        System.out.println("Todo is Added!!");
    }
}
