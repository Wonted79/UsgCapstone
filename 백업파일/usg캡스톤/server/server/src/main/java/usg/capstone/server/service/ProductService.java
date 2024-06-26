package usg.capstone.server.service;

import org.springframework.http.ResponseEntity;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.RegisterProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void createProduct(RegisterProductRequest registerProductRequest);
    List<Product> findAllByCategory(String category);
    List<Product> findNameList(String name);

}
