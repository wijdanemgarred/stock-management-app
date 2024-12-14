package uir.ac.ma.stock.service.category;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uir.ac.ma.stock.model.Category;
import uir.ac.ma.stock.repository.CategoryRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepo categoryRepo;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
        category.setId(1);
        category.setName("Electronics");
        category.setDescription("Electronics category");
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Category> mockCategories = Arrays.asList(category, new Category());
        when(categoryRepo.findAll()).thenReturn(mockCategories);

        // Act
        List<Category> categories = categoryService.findAll();

        // Assert
        assertNotNull(categories);
        assertEquals(2, categories.size());
        verify(categoryRepo, times(1)).findAll();
    }

    @Test
    public void testFindById_Success() {
        // Arrange
        when(categoryRepo.findById(1)).thenReturn(Optional.of(category));

        // Act
        Category foundCategory = categoryService.findById(1);

        // Assert
        assertNotNull(foundCategory);
        assertEquals("Electronics", foundCategory.getName());
        verify(categoryRepo, times(1)).findById(1);
    }

    @Test
    public void testFindById_NotFound() {
        // Arrange
        when(categoryRepo.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> categoryService.findById(1));
        assertEquals("Category not found with id: 1", exception.getMessage());
        verify(categoryRepo, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        // Arrange
        when(categoryRepo.save(category)).thenReturn(category);

        // Act
        Category savedCategory = categoryService.save(category);

        // Assert
        assertNotNull(savedCategory);
        assertEquals("Electronics", savedCategory.getName());
        verify(categoryRepo, times(1)).save(category);
    }

    @Test
    public void testUpdate() {
        // Arrange
        Category updatedCategory = new Category();
        updatedCategory.setName("Updated Electronics");
        updatedCategory.setDescription("Updated Description");

        when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
        when(categoryRepo.save(category)).thenReturn(category);

        // Act
        Category result = categoryService.update(1, updatedCategory);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Electronics", result.getName());
        assertEquals("Updated Description", result.getDescription());
        verify(categoryRepo, times(1)).findById(1);
        verify(categoryRepo, times(1)).save(category);
    }

    @Test
    public void testDelete() {
        // Act
        categoryService.delete(1);

        // Assert
        verify(categoryRepo, times(1)).deleteById(1);
    }
}
