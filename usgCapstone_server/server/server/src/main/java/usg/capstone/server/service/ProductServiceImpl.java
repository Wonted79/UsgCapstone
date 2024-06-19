package usg.capstone.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.ProductDTO;
import usg.capstone.server.dto.ProductResponse;
import usg.capstone.server.dto.RegisterProductRequest;
import usg.capstone.server.repository.ProductRepository;
import usg.capstone.server.util.ImageUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public void createProduct(RegisterProductRequest registerProductRequest){
        ProductDTO productDTO = registerProductRequest.getProductDTO();
        MultipartFile file = registerProductRequest.getProductImage();

        Product newProduct = null;
        try {
            newProduct = Product.builder()
                    .id(productDTO.getId())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .category(productDTO.getCategory())
                    .imageData(file.getBytes())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productRepository.save(newProduct);

    }

    public List<ProductResponse> findAllByCategory(String category){
        List<Product> products = productRepository.findByCategory(category);
        return products.stream().map(product -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setCategory(product.getCategory());
            productResponse.setImageData(Base64.getEncoder().encodeToString(product.getImageData()));
            return productResponse;
        }).collect(Collectors.toList());
    }


    public List<Product> getProductsContaining1(String infix) {
        return productRepository.findByNameContaining(infix);
    }

    public List<ProductResponse> getProductsContaining(String infix) {
        List<Product> products = productRepository.findByNameContaining(infix);
        return products.stream().map(product -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setPrice(product.getPrice());
            productResponse.setCategory(product.getCategory());
            productResponse.setImageData(Base64.getEncoder().encodeToString(product.getImageData()));
            return productResponse;
        }).collect(Collectors.toList());
    }
}
