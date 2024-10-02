package com.muditSpring.Ecom_1.Repo;

import com.muditSpring.Ecom_1.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Integer> {
    @Query("SELECT p FROM ProductModel p WHERE" +
            " LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR" +
            " LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR" +
            " LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR" +
            " LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%')) "
    )
    List<ProductModel> searchByKeyWord(String keyword);
}
