package beans;

//we are defining two beans student and book, with student has book relationship
//we are going to see how we can link two beans when using @Bean annotation.
public class Book {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
