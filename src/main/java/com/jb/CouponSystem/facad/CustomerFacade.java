package com.jb.CouponSystem.facad;


import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.beans.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFacade extends ClientFacade {
    private int customerID;

    @Override
    public boolean login(String name , String email) {
        return customerRepository.findByFirstNameAndEmail(name, email);
    }
    public List<Coupon> getCustomerCoupon(){
     return customerRepository.getOne(customerID).getCoupons();
    }
    public List<Coupon> getCustomerCouponByCategory(Category category){
        List<Coupon>customerCouponByCategory= new ArrayList<>();
        for (Coupon coupon:customerRepository.getOne(customerID).getCoupons()) {
            if (coupon.getCategory().equals(category)){
              customerCouponByCategory.add(coupon);
            }
        }
        return customerCouponByCategory;
    }


    public List<Coupon> getCouponsByMaxPrice(int maxPrice){
        List<Coupon> getByMaxPrice = new ArrayList<>();
        for (Coupon coupon:customerRepository.getOne(customerID).getCoupons()) {
            if (coupon.getPrice()<=maxPrice){
                getByMaxPrice.add(coupon);
            }
        }
        return getByMaxPrice;
    }

    public Customer getCustomerDetails(){
        return customerRepository.getOne(customerID);
    }


}
