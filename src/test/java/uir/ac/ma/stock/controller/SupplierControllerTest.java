package uir.ac.ma.stock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import uir.ac.ma.stock.model.Supplier;
import uir.ac.ma.stock.service.supplier.SupplierService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SupplierController.class)
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private SupplierService supplierService;

    @Test
    public void testGetSupplierById() throws Exception {
        Supplier supplier = new Supplier(1, "John Suppliers", "Contact info");

        when(supplierService.findById(1)).thenReturn(supplier);

        mockMvc.perform(get("/suppliers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Suppliers"));

        verify(supplierService, times(1)).findById(1);
    }
}
