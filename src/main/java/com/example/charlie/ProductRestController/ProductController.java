package com.example.charlie.ProductRestController;


import com.example.charlie.entities.Products;
import com.example.charlie.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;


    @RequestMapping(value="/products/NTB",method = RequestMethod.GET)
    public Optional<Products> getNTB(){
        return repository.findById(4);
    }
    @RequestMapping(value="/products/INK",method = RequestMethod.GET)
    public Optional<Products> getINK(){
        return repository.findById(3);
    }
    @RequestMapping(value="/products/PEN",method = RequestMethod.GET)
    public Optional<Products> getPEN(){
        return repository.findById(2);
    }
    @RequestMapping(value="/products/PNC",method = RequestMethod.GET)
    public Optional<Products> getPNC(){
        return repository.findById(1);
    }

}
