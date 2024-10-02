package com.muditSpring.Ecom_1.Controller;

import com.muditSpring.Ecom_1.Service.ProductService;
import com.muditSpring.Ecom_1.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


    @Autowired
    ProductService service;

    @GetMapping("/home")
    public String greet(){
        return "I am Working";
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductModel getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{id}/image")
    public byte[] getImageById(@PathVariable int id){
        return service.getImageById(id);
    }

    @PostMapping("/product")
    public ProductModel addProduct(@RequestPart ProductModel product,
                                   @RequestPart MultipartFile imageFile) throws IOException {
        return service.addProduct(product, imageFile);
    }

    @PutMapping("/product/{id}")
    public ProductModel updateProduct(@PathVariable int id,
                                      @RequestPart ProductModel product,
                                      @RequestPart MultipartFile imageFile) throws IOException {
        return service.updateProduct(id, product, imageFile);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id){
         service.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<ProductModel> searchByKeyWord(@RequestParam String keyword){
        return service.searchByKeyWord(keyword);
    }

}
