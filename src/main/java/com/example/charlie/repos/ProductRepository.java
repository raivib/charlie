package com.example.charlie.repos;


import com.example.charlie.entities.Products;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.jpa.repository.JpaRepository;

@JsonDeserialize
public interface ProductRepository extends JpaRepository<Products,Integer>  {
}
