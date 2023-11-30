import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class App {

  public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
      var productService = context.getBean(ProductService.class);

      Product product = new Product();
      product.setName("Banana");

      productService.addOneProduct(product);
    }
  }
}
