package uir.ac.ma.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uir.ac.ma.stock.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
