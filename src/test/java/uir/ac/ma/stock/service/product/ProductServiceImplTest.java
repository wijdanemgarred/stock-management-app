package uir.ac.ma.stock.service.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uir.ac.ma.stock.model.Product;
import uir.ac.ma.stock.repository.ProductRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void testFindById() {
        Product product = new Product(1, "Laptop", "Electronics", 1000.0);

        when(productRepo.findById(1)).thenReturn(Optional.of(product));

        Product foundProduct = productService.findById(1);

        assertNotNull(foundProduct);
        assertEquals("Laptop", foundProduct.getName());
        verify(productRepo, times(1)).findById(1);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product(1, "Laptop", "Electronics", 1000.0);

        when(productRepo.save(product)).thenReturn(product);

        Product savedProduct = productService.save(product);

        assertNotNull(savedProduct);
        assertEquals("Laptop", savedProduct.getName());
        verify(productRepo, times(1)).save(product);
    }
}
