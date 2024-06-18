package usg.capstone.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import usg.capstone.server.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategory(String category);
    List<Product> findByName(String name);
}
