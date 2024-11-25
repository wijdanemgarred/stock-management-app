package uir.ac.ma.stock.service.supplier;

import uir.ac.ma.stock.model.Supplier;
import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Integer id);

    Supplier save(Supplier supplier);

    Supplier update(Integer id, Supplier supplier);

    void delete(Integer id);
}
