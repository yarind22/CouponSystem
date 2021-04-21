package com.jb.CouponSystem.services;

import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CouponImple implements CouponService {
    private final CouponRepository couponRepository;

    @Override
    public void addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponID) {
        couponRepository.deleteById(couponID);
    }

    @Override
    public Coupon getOneCoupon(int couponID) {
        return couponRepository.getOne(couponID);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
