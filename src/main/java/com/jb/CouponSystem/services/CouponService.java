package com.jb.CouponSystem.services;


import com.jb.CouponSystem.beans.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {
    void addCoupon(Coupon coupon);

    void updateCoupon(Coupon coupon);

    void deleteCoupon(int couponID);

    Coupon getOneCoupon(int couponID);

    List<Coupon> getAllCoupons();
}
