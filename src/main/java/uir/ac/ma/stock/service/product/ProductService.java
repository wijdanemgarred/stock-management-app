package uir.ac.ma.stock.service.product;

import uir.ac.ma.stock.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);
}
