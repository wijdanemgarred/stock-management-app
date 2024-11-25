package uir.ac.ma.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uir.ac.ma.stock.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
