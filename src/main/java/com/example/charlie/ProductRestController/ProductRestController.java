package com.example.charlie.ProductRestController;


import com.example.charlie.entities.Products;
import com.example.charlie.repos.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository repository;

    private static final Logger LOGGER= LoggerFactory.getLogger(ProductRestController.class);
/*
Get all the data stored through POST Method
 */

    @RequestMapping(value="/products/",method = RequestMethod.GET)
    public List<Products>getProducts(){
        return repository.findAll();
    }


    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)

    public Products getProduct(@PathVariable("id") int id){
        LOGGER.info("Finding product by id:" +id);
        return repository.findById(id).get();
    }




/*
Create and update new products data
 */

    @RequestMapping(value = "/products/",method = RequestMethod.POST)
    public Products createProduct(Products product){
        return repository.save(product);
    }

    @RequestMapping(value = "/products/",method = RequestMethod.PUT)
    public Products updateProduct(Products product){
        return repository.save(product);
    }

    /*
    Delete data in products through its ID.
     */
    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id){
        repository.deleteById(id);
    }

}
