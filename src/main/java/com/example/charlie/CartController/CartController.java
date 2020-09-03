package com.example.charlie.CartController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class CartController {

    @GetMapping("/cart/NTB/INK")
    String cart(){
        return " Total amount for NTB and INK is Rs. 70";
    }
@GetMapping("/cart/NTB/INK/15OFF")
    String total(){
        return "Discounted amount for NTB and INK is Rs. 59.5";
}


}
