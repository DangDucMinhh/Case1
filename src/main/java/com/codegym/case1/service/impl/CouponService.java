package com.codegym.case1.service.impl;

import com.codegym.case1.model.Coupon;
import com.codegym.case1.repository.CouponRepository;
import com.codegym.case1.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class CouponService implements ICouponService {
    @Autowired
    private CouponRepository couponRepository;
    @Override
    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon findById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Coupon coupon) {
couponRepository.save(coupon);
    }

    @Override
    public void remove(Long id) {
couponRepository.deleteById(id);
    }

    @Override
    public List<Coupon> getCouponByFoodIdAndStatus(Long id, boolean status) {
        return couponRepository.getCouponsByShopIdIsAndStatus(id,status);
    }

    @Override
    public List<Coupon> getEnableCouponsByUserId(String id) {
        String[] arr = id.split("-");
        Collection<Coupon> coupon = couponRepository.getUsedCoupon(Long.parseLong(arr[1]));
        System.out.println(coupon);
        List<Coupon> coupons = couponRepository.getEnableStatusCoupon(Long.parseLong(arr[0]),coupon);
        return coupons;
    }

    @Override
    public List<Coupon> getCouponByFoodId(Long id) {
        return couponRepository.getCouponsByShopIdIs(id);
    }
}
