package services;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {
  @Autowired
  ProductRepository productRepository;


  //this is the default behaviour, so we add start transaction at start of method, and in end end of transaction,
  //so if there any runtime exception all the inserts will rollback.
  @Transactional(propagation = Propagation.REQUIRED)
   public void addOneProduct(Product products){
   for(int i = 1; i<=10; i++){
     var product = new Product();
     product.setName("product "+ i);
     productRepository.addProduct(product);

     if(i == 5) throw new RuntimeException("my exception to rollback all the inserted data");
   }
  }
}
