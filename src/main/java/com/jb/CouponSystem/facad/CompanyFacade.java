package com.jb.CouponSystem.facad;

import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.exrptions.OpertationNotAllowedExeption;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
public class CompanyFacade extends ClientFacade{
    private int companyID;

    @Override
    public boolean login(String email, String password) {
        System.out.println(compnyRepository.findByEmailAndPassword(email, password));
        return (compnyRepository.findByEmailAndPassword(email, password)) != null;
    }

    public void addCoupon(Coupon coupon) throws OpertationNotAllowedExeption {
        for (Coupon thatCoupon:compnyRepository.getOne(companyID).getCoupons()) {
            if (thatCoupon.getTitle().equals(coupon.getTitle())){
                throw new OpertationNotAllowedExeption("sorry, this title is already exisy");
            }
            couponRepository.save(coupon);
        }
    }


    public void updateCoupon(Coupon coupon) throws OpertationNotAllowedExeption {
        for (Coupon allCoupons: couponRepository.findAll()) {
            if (coupon.getId()==allCoupons.getId()) {
                couponRepository.saveAndFlush(coupon);
                return;
            }
        }
        throw new OpertationNotAllowedExeption("sorry you canot chang couponID");
    }

    public void deleteCoupon(int couponID){
        couponRepository.deleteById(couponID);
    }

    public List<Coupon> getAllCouponsByCompanyID(int companiID){
       return compnyRepository.getOne(companiID).getCoupons();
    }

    public List<Coupon> getCouponsByCategory(Category category) {
        List<Coupon> coupons = new ArrayList<>();
        for (Coupon coupon : compnyRepository.getOne(companyID).getCoupons()) {
            if (coupon.getCategory().name().equals(category.name())) {
                coupons.add(coupon);
            }
        }
        return coupons;
    }

    public List<Coupon> getCouponsByMaxPrice(int maxPrice){
        List<Coupon> getByMaxPrice = new ArrayList<>();
        for (Coupon coupon:compnyRepository.getOne(companyID).getCoupons()) {
            if (coupon.getPrice()<=maxPrice){
                getByMaxPrice.add(coupon);
            }
        }
        return getByMaxPrice;
    }


    public Company getCompanyDetails(int companyID){
      return compnyRepository.getOne(companyID);
    }

}
