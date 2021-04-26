package com.jb.CouponSystem.clr;


import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.facad.AdminFacade;
import com.jb.CouponSystem.facad.CompanyFacade;
import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import com.jb.CouponSystem.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Component
@Order(1)
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
    private final AdminFacade adminFacade;
    private final CompanyFacade companyFacade;
    private final CompnyRepository compnyRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    @Override
    public void run(String... args) throws Exception {
        Date startDate = new Date(dateFormat.parse("20/04/2021").getTime());
        Date endDate = new Date(dateFormat.parse("20/05/2021").getTime());
        Date mAndMStartDate = new Date(dateFormat.parse("20/04/2021").getTime());
        Date mAndMendDate = new Date(dateFormat.parse("23/05/2021").getTime());



//        ArtUtils.testInfo("");
//        ArtUtils.testInfo("");
//        ArtUtils.testInfo("");

        ArtUtils.testInfo("add company with cuopon");
        Coupon cp1 = new Coupon(1, Category.FOOD, "coca cola", "10% off", startDate, endDate, 10, 10.90, "cocacola.jpeg");
        Company c1 = new Company("coca cola", "cocacola@gmail.com", "cola1234", List.of(cp1));
        adminFacade.addCompany(c1);
        adminFacade.getOneCompany(1);
        System.out.println("--------------------------------------");
        Coupon cp2 = new Coupon(2, Category.FOOD, "M&M", "15% off", mAndMStartDate, mAndMendDate, 15, 21.90, "m&m.jpeg");
        Company c2 = new Company("m&m", "m&m@M&m.com", "1212", List.of(cp2));
        adminFacade.addCompany(c2);
        adminFacade.getOneCompany(2);


        ArtUtils.testInfo("add customer");
        Customer moshe = Customer.builder().firstName("moshe").lastName("cohen").email("moshe@gmail.com").coupon(cp1).password("moshe123").build();
        customerRepository.save(moshe);
        System.out.println(adminFacade.getOneCustomer(1));

        ArtUtils.testInfo("get all companies and customers");
        adminFacade.getAllCompany().forEach(System.out::println);
        adminFacade.getAllCustomers().forEach(System.out::println);

        ArtUtils.testInfo("login company");
        System.out.println(companyFacade.login("cocacola@gmail.com", "cola1234"));

        ArtUtils.testInfo("update company");
        adminFacade.getOneCompany(2);
        c2.setEmail("m&m232@gmail.com");
        adminFacade.updateCompany(c2);
        adminFacade.getOneCompany(2);

        ArtUtils.testInfo("update customer");
        System.out.println(adminFacade.getOneCustomer(1));
        moshe.setLastName("malki");
        adminFacade.updateCustomer(moshe);
        System.out.println(adminFacade.getOneCustomer(1));



    }
}
