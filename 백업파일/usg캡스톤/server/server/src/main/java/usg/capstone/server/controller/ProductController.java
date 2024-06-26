package usg.capstone.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.RegisterProductRequest;
import usg.capstone.server.service.ProductService;

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

    @GetMapping("/list")
    public ResponseEntity listProduct(@RequestParam String productName){
        System.out.println(productName);
        List<Product> productlist = productService.findNameList(productName);
        System.out.println(productlist);
        return new ResponseEntity(productlist, HttpStatus.OK);
    }

    @GetMapping("/categoryAll")
    public ResponseEntity findByCategory(@RequestParam String category){
        List<Product> productlist = productService.findAllByCategory(category);
        return  new ResponseEntity(productlist,HttpStatus.OK);
    }

}
