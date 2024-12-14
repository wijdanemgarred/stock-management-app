package uir.ac.ma.stock.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uir.ac.ma.stock.model.Category;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    public void testSaveCategory() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        Category savedCategory = categoryRepo.save(category);

        assertNotNull(savedCategory.getId());
        assertEquals("Books", savedCategory.getName());
    }

    @Test
    public void testFindById() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        category = categoryRepo.save(category);

        Optional<Category> foundCategory = categoryRepo.findById(category.getId());

        assertTrue(foundCategory.isPresent());
        assertEquals("Books", foundCategory.get().getName());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category();
        category.setName("Books");
        category.setDescription("Category for books");

        category = categoryRepo.save(category);

        categoryRepo.deleteById(category.getId());
        Optional<Category> foundCategory = categoryRepo.findById(category.getId());

        assertFalse(foundCategory.isPresent());
    }
}
