package com.example.charlie.CouponRestController;


import com.example.charlie.entities.Coupons;
import com.example.charlie.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponRestController {

    @Autowired
    CouponRepository couponRepository;

    @RequestMapping(value = "/coupons/",method = RequestMethod.GET)
    public List<Coupons>getCoupons(){
        return couponRepository.findAll();
    }

    @RequestMapping(value = "/coupons/{id}",method = RequestMethod.GET)
    public Coupons getProduct(@PathVariable("id") int id){
        return couponRepository.findById(id).get();
    }



    @RequestMapping(value = "/coupons/",method = RequestMethod.POST)
    public Coupons createCoupons(Coupons coupons){
        return couponRepository.save(coupons);
    }

    @RequestMapping(value = "/coupons/",method = RequestMethod.PUT)
    public Coupons updateCoupons(Coupons coupons){
        return couponRepository.save(coupons);
    }


    @RequestMapping(value = "/coupons/{id}",method = RequestMethod.DELETE)
    public void deleteCoupons(@PathVariable("id") int id){
        couponRepository.deleteById(id);
    }

}
