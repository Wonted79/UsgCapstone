package usg.capstone.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usg.capstone.server.domain.Product;
import usg.capstone.server.dto.CodyDTO;
import usg.capstone.server.dto.CodyResponse;
import usg.capstone.server.dto.ProductResponse;
import usg.capstone.server.service.CodyService;
import usg.capstone.server.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cody")
public class CodyController {
    private CodyService codyService;

    @Autowired
    public CodyController(CodyService codyService) {
        this. codyService =  codyService;
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@ModelAttribute CodyDTO codyDTO ){
        System.out.println("cody 생성");
        codyService.createCody(codyDTO);
        return new ResponseEntity("새로운 코디생성 완료",HttpStatus.OK);
    }

    @GetMapping("/findCodys")
    public ResponseEntity findByproductName(@RequestParam String codyName){
        List<CodyResponse> productlist = codyService.findAllByName(codyName);
        return  new ResponseEntity(productlist ,HttpStatus.OK);
    }
}
