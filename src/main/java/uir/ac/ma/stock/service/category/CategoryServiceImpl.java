package uir.ac.ma.stock.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uir.ac.ma.stock.model.Category;
import uir.ac.ma.stock.repository.CategoryRepo;

import java.util.List;
 
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepo.findById(id).orElseThrow(() -> 
            new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        Category existingCategory = findById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepo.save(existingCategory);
    }

    @Override
    public void delete(Integer id) {
        categoryRepo.deleteById(id);
    }
}
