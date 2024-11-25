package uir.ac.ma.stock.service.category;

import uir.ac.ma.stock.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    Category save(Category category);

    Category update(Integer id, Category category);

    void delete(Integer id);
}
