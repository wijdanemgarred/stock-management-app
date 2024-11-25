package uir.ac.ma.stock.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uir.ac.ma.stock.model.Product;
import uir.ac.ma.stock.repository.ProductRepo;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).orElseThrow(() -> 
            new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product existingProduct = findById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        existingProduct.setExpirationDate(product.getExpirationDate());
        return productRepo.save(existingProduct);
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }
}
