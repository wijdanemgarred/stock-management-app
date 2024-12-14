package uir.ac.ma.stock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import uir.ac.ma.stock.model.Category;
import uir.ac.ma.stock.service.category.CategoryService;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private CategoryService categoryService;

    @Test
    public void testGetAllCategories() throws Exception {
        Category category1 = new Category(1, "Books", "Books category");
        Category category2 = new Category(2, "Electronics", "Electronics category");

        when(categoryService.findAll()).thenReturn(Arrays.asList(category1, category2));

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Books"))
                .andExpect(jsonPath("$[1].name").value("Electronics"));

        verify(categoryService, times(1)).findAll();
    }

    @Test
    public void testGetCategoryById() throws Exception {
        Category category = new Category(1, "Books", "Books category");

        when(categoryService.findById(1)).thenReturn(category);

        mockMvc.perform(get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Books"));

        verify(categoryService, times(1)).findById(1);
    }
}
