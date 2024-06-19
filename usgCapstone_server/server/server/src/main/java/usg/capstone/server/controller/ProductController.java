package usg.capstone.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usg.capstone.server.domain.ImageData;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.ProductResponse;
import usg.capstone.server.dto.RegisterProductRequest;
import usg.capstone.server.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@ModelAttribute RegisterProductRequest registerProductRequest ){
        System.out.println(registerProductRequest.getProductDTO().getName());
        System.out.println(registerProductRequest.getProductImage());
        productService.createProduct(registerProductRequest);
        return new ResponseEntity("새로운 상품등록 완료",HttpStatus.OK);
    }


    @GetMapping("/categoryAll")
    public ResponseEntity findByCategory(@RequestParam String category){
        List<ProductResponse> productlist = productService.findAllByCategory(category);
        return  new ResponseEntity(productlist,HttpStatus.OK);
    }

    @GetMapping("/findProduct")
    public ResponseEntity findByproductName(@RequestParam String productName){
        if (productName == ""){
            System.out.println("검색어 없음");
            List<Product> productlist= new ArrayList<>();;
            return  new ResponseEntity( productlist,HttpStatus.OK);
        }
        List<ProductResponse> productlist = productService.getProductsContaining(productName);
        return  new ResponseEntity(productlist ,HttpStatus.OK);
    }

}
