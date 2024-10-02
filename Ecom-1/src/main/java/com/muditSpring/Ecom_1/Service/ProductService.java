package com.muditSpring.Ecom_1.Service;

import com.muditSpring.Ecom_1.Repo.ProductRepo;
import com.muditSpring.Ecom_1.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<ProductModel> getAllProducts(){
        return repo.findAll();
    }

    public ProductModel getProductById(int id) {
        return repo.findById(id).orElse(new ProductModel());
    }

    public ProductModel addProduct(ProductModel product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public byte[] getImageById(int id) {
        ProductModel product = repo.findById(id).orElse(new ProductModel());
        return product.getImageData();
    }

    public ProductModel updateProduct(int id, ProductModel product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<ProductModel> searchByKeyWord(String keyword) {
        return repo.searchByKeyWord(keyword);
    }
}
