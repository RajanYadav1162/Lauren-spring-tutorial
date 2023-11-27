package repository;
import model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    //we can see how easy it is to use spring-jdbc template, no try catch, no create connections, prepared statement......so goood.
    public void addProduct(Product product) {
        String query = "INSERT INTO product (name, price) VALUES (?, ?)";
        jdbcTemplate.update(query, new Object[]{product.getName(), product.getPrice()});
    }


    //we need to to cast the result set to List<Product> we are using rowMapper for that.
    public List<Product> getAllProduct() {
        String query = "SELECT * FROM product";
        List<Product> productList = jdbcTemplate.query(query, new RowMapper() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                return product;
            }
        });
    return productList;
    }
}
