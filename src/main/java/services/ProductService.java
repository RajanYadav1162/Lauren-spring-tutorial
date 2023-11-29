package services;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {


  @Autowired
  ProductRepository productRepository;

  @Transactional
  //now since this method is wrap around transactional, spring will do the rollback when there is runtime exception
  //carefull with different rules, like rollback will not done for checked exception
  //even rollbacks are not done for runtime if we handle the exception right in method,
  //internally @Around aspect is happening, so if exceptions will not be able to propagate, then there will be no rollback.
  public void addOneProduct(Product product){
    productRepository.addProduct(product);
    throw new RuntimeException("run time exception");
  }
}
