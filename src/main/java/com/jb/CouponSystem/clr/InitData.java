package com.jb.CouponSystem.clr;


import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Order(1)
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
    private final CompnyRepository compnyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    @Override
    public void run(String... args) throws Exception {
        Date startDate = new Date(dateFormat.parse("20/03/2021").getTime());
        Date endDate = new Date(dateFormat.parse("20/04/2021").getTime());

        Coupon cp1 = new Coupon(1, Category.FOOD,"coca cola","10% off",startDate,endDate,10,10.90,"cocacola.jpeg");

        Company c1 = new Company("coca cola","cocacola@gmail.com","cola1234", Arrays.asList(cp1));

        compnyRepository.save(c1);
        compnyRepository.findAll().forEach(System.out::println);

    }
}
