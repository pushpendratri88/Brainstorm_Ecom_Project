package com.brainstorm.order.controller;

import com.brainstorm.order.dto.OrderDTO;
import com.brainstorm.order.dto.ProductDTO;
import com.brainstorm.order.dto.ResponseDTO;
import com.brainstorm.order.service.IOrderService;
import com.brainstorm.order.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping
    @RequestMapping(value = "/addProducts")
    public ResponseEntity<ResponseDTO> addProducts(@RequestBody List<ProductDTO> productDTOList){
        productDTOList.forEach(productDTO -> {
            productService.addProducts(productDTO);
        });
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("201", "Products has been created successfully"));
    }

    @RequestMapping(value = "/addProduct")
    public ResponseEntity<ResponseDTO> addProduct(@RequestBody ProductDTO productDTO){
        productService.addProducts(productDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("201", "Product has been created successfully"));
    }

    @GetMapping
    @RequestMapping(value = "/fetchProduct")
    public ResponseEntity<ProductDTO> fetchProduct(@RequestParam String productId){
        ProductDTO productDTO = productService.fetchProduct(productId);
        return  ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }
    @GetMapping
    @RequestMapping(value = "/fetchAllProduct")
    public ResponseEntity<List<ProductDTO>> fetchAllProduct(){
        List<ProductDTO> productDTOList = productService.fetchAllProduct();
        return  ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }

    @PostMapping
    @RequestMapping(value = "/deleteProduct")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestParam String productId){
        productService.deleteProduct(productId);
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO("201", "Product has been deleted successfully"));

    }
}