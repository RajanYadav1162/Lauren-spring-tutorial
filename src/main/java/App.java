import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ProductService;

public class App{

  public static void main(String[] args) {
    try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)){

      ProductService productService = context.getBean(ProductService.class);

      for(int i = 0; i< 11; i++){
        var p = new Product();
        p.setName("product "+ i);
        productService.addOneProduct(p);
      }
    }
  }
}