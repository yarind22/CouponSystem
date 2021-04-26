package com.jb.CouponSystem.facad;

import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.exrptions.OpertationNotAllowedExeption;
import com.jb.CouponSystem.exrptions.exeption;
import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import com.jb.CouponSystem.services.CompanyImple;
import com.jb.CouponSystem.services.CompniesService;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
public class CompanyFacade extends ClientFacade{
    private int companiID;

    @Override
    public boolean login(String email, String password) {
        System.out.println(compnyRepository.findByEmailAndPassword(email, password));
        return (compnyRepository.findByEmailAndPassword(email, password)) != null;
    }

    public void addCoupon(Coupon coupon) throws OpertationNotAllowedExeption {
        for (Coupon thatCoupon:compnyRepository.getOne(companiID).getCoupons()) {
            if (thatCoupon.getTitle().equals(coupon.getTitle())){
                throw new OpertationNotAllowedExeption("sorry, this title is already exisy");
            }
            couponRepository.save(coupon);
        }
    }





}
