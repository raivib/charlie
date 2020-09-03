package com.example.charlie.repos;


import com.example.charlie.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Integer>  {
}
