package uir.ac.ma.stock.service.supplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uir.ac.ma.stock.model.Supplier;
import uir.ac.ma.stock.repository.SupplierRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceImplTest {

    @Mock
    private SupplierRepo supplierRepo;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Test
    public void testSaveSupplier() {
        Supplier supplier = new Supplier(1, "John Suppliers", "Contact info");

        when(supplierRepo.save(supplier)).thenReturn(supplier);

        Supplier savedSupplier = supplierService.save(supplier);

        assertNotNull(savedSupplier);
        assertEquals("John Suppliers", savedSupplier.getName());
        verify(supplierRepo, times(1)).save(supplier);
    }
}
