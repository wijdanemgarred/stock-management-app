package uir.ac.ma.stock.service.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uir.ac.ma.stock.model.Supplier;
import uir.ac.ma.stock.repository.SupplierRepo;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier findById(Integer id) {
        return supplierRepo.findById(id).orElseThrow(() -> 
            new RuntimeException("Supplier not found with id: " + id));
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier update(Integer id, Supplier supplier) {
        Supplier existingSupplier = findById(id);
        existingSupplier.setName(supplier.getName());
        existingSupplier.setContact(supplier.getContact());
        existingSupplier.setAddress(supplier.getAddress());
        return supplierRepo.save(existingSupplier);
    }

    @Override
    public void delete(Integer id) {
        supplierRepo.deleteById(id);
    }
}
