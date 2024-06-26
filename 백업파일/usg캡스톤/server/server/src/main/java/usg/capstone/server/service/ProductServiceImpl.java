package usg.capstone.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.ProductDTO;
import usg.capstone.server.dto.RegisterProductRequest;
import usg.capstone.server.repository.ProductRepository;
import usg.capstone.server.util.ImageUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
                    .imageData(ImageUtils.compressImage(file.getBytes()))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        productRepository.save(newProduct);

    }

    public List<Product> findAllByCategory(String category){
        List<Product> products = productRepository.findByCategory(category);
        return products;
    }

    public List<Product> findNameList(String name){
        //지금보니까 리스트에 안넣은거 같은데..
        List<Product> products = productRepository.findByName(name);
        System.out.println(products);
        return products;
    }
}
