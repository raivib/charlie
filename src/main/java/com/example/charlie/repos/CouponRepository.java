package com.example.charlie.repos;

import com.example.charlie.entities.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupons,Integer> {
}

