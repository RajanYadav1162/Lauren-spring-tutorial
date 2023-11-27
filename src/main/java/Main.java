import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.ProductRepository;

/*
* 1. Put bean of type Datasource by using DriverMangerDataSource class(simplest)
* 2. create bean for jdbc template using the configured datasource
* 3.create model that represent table in your database
* 3.create repository class, (similar to spring-jpa) where database related queries will be done.
* */

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){

            ProductRepository repo = context.getBean(ProductRepository.class);
//            Product product = new Product();
//            product.setName("Beer");
//            product.setPrice(123);
//
//            repo.addProduct(product);

            var products = repo.getAllProduct();

            for(var item : products){
                System.out.println(item.toString());
            }
        }
    }
}
