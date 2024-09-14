package com.codegym.case1.service;

import com.codegym.case1.model.Coupon;

import java.util.List;

public interface ICouponService  extends IGenerateService<Coupon>{

       List<Coupon> getCouponByFoodIdAndStatus(Long id,boolean status);
       List<Coupon> getCouponByFoodId(Long id);

       List<Coupon> getEnableCouponsByUserId(String id);
}
