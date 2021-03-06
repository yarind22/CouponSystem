package com.jb.CouponSystem.facade;


import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.exceptions.GenericExceptions;
import com.jb.CouponSystem.exceptions.MyException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerFacade extends ClientFacade {
    private static Date now = new Date(System.currentTimeMillis());

    private int customerID = 1;

    @Override
    public boolean login(String email, String password) {
        return (customerRepository.findByEmailAndPassword(email, password)) != null;
    }

    public List<Coupon> getCustomerCoupon() {
        return customerRepository.getOne(customerID).getCoupons();
    }

    public List<Coupon> getCustomerCouponByCategory(Category category) {
        List<Coupon> customerCouponByCategory = new ArrayList<>();
        for (Coupon coupon : customerRepository.getOne(customerID).getCoupons()) {
            if (coupon.getCategory().equals(category)) {
                customerCouponByCategory.add(coupon);
            }
        }
        return customerCouponByCategory;
    }


    public List<Coupon> getCouponsByMaxPrice(int maxPrice) {
        List<Coupon> getByMaxPrice = new ArrayList<>();
        for (Coupon coupon : customerRepository.getOne(customerID).getCoupons()) {
            if (coupon.getPrice() <= maxPrice) {
                getByMaxPrice.add(coupon);
            }
        }
        return getByMaxPrice;
    }

    public Customer getCustomerDetails() {
        return customerRepository.getOne(customerID);
    }

    public void buyCoupon(Coupon coupon) throws MyException {
        for (Coupon custCoupons : customerRepository.getOne(customerID).getCoupons()) {
            if (custCoupons.getId() == coupon.getId()) {
                throw new MyException(GenericExceptions.INVALID_OPERATION.getDescription());
            }
        }
        if (couponRepository.getOne(coupon.getId()).getAmount() == 0) {
            throw new MyException(GenericExceptions.ALREADY_EXPIRED.getDescription());
       } else if (coupon.getEndDate().before(now)) {
            throw new MyException(GenericExceptions.ALREADY_EXPIRED.getDescription());
       }
        List<Coupon> coupons = customerRepository.getOne(customerID).getCoupons();
        coupons.add(coupon);
        Customer custToUp = customerRepository.getOne(customerID);
        custToUp.setCoupons(coupons);
        int amount = couponRepository.getOne(coupon.getId()).getAmount();
        Coupon toupdate = couponRepository.getOne(coupon.getId());
        toupdate.setAmount(amount - 1);
        customerRepository.saveAndFlush(custToUp);
        couponRepository.saveAndFlush(toupdate);
    }


}
