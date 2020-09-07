package com.example.charlie.CartController;

import org.springframework.web.bind.annotation.RestController;



import com.example.charlie.entities.Coupons;
import com.example.charlie.entities.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController

public class CartController implements CommandLineRunner{


    @RequestMapping(value = "/cart/", method = RequestMethod.GET)
    public static Object CallProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Products producta = restTemplate.getForObject("http://coup-env.eba-fuy2s33u.ap-south-1.elasticbeanstalk.com/products/NTB", Products.class);
        Products productb = restTemplate.getForObject("http://coup-env.eba-fuy2s33u.ap-south-1.elasticbeanstalk.com/products/INK", Products.class);
        Coupons couponsc= restTemplate.getForObject("http://coup-env.eba-fuy2s33u.ap-south-1.elasticbeanstalk.com/coupons/7",Coupons.class);

        int totalprice= producta.getPrice()+ productb.getPrice();
        return Arrays.asList("Products:", producta.getProductCode(),productb.getProductCode(),"CouponCode", couponsc.getCouponCode(),"Total price is",totalprice,"Discounted price is",totalprice-(0.15*totalprice));
    }


    @Override
    public void run(String... args) throws Exception {

    }
}


