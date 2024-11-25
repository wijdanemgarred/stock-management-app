package uir.ac.ma.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uir.ac.ma.stock.model.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
}
