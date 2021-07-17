package com.jb.CouponSystem.clr;


import com.jb.CouponSystem.beans.Category;
import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.facade.AdminFacade;
import com.jb.CouponSystem.facade.CompanyFacade;
import com.jb.CouponSystem.facade.CustomerFacade;
import com.jb.CouponSystem.login.ClientType;
import com.jb.CouponSystem.login.LoginManager;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.utils.ArtUtils;
import com.jb.CouponSystem.utils.Asci;
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
    private final CustomerFacade customerFacade;
    private final CouponRepository couponRepository;
    private final LoginManager loginManager;

    private static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    @Override
    public void run(String... args) throws Exception {
        Asci.ascii();

        Date startDate = Date.valueOf("2021-05-15");
        Date endDate = Date.valueOf("2021-06-23");
        Date mAndMStartDate = Date.valueOf("2021-05-15");
        Date mAndMendDate = Date.valueOf("2021-07-30");
        Date startDate1 = Date.valueOf("2021-02-20");
        Date endDate1 = Date.valueOf("2021-03-20");


//        ArtUtils.testInfo("");

        String token = loginManager.loginManger("admin@admin.com","admin",ClientType.ADMIN);

        ArtUtils.testInfo("add company with cuopon");
        Coupon cp1 = new Coupon(1, Category.FOOD, "coca cola", "10% off", startDate, endDate, 10, 10.90, "cocacola.jpeg");
        Company c1 = new Company("coca cola", "cocacola@gmail.com", "cola1234", List.of(cp1));
        adminFacade.addCompany(c1,token);
        adminFacade.getOneCompany(1);
        System.out.println("--------------------------------------");
        Coupon cp2 = new Coupon(2, Category.FOOD, "M&M", "15% off", mAndMStartDate, mAndMendDate, 15, 21.90, "m&m.jpeg");
        Company c2 = new Company("m&m", "m&m@M&m.com", "1212", List.of(cp2));
        adminFacade.addCompany(c2,token);
        adminFacade.getOneCompany(2);


        ArtUtils.testInfo("add customer");
        Customer moshe = Customer.builder()
                .firstName("Moshe")
                .lastName("Cohen")
                .email("moshe@gmail.com")
                .coupon(cp1)
                .password("moshe123")
                .build();
        adminFacade.addCustomr(moshe);
        System.out.println(adminFacade.getOneCustomer(1));
        System.out.println("-------------------------------------");
        Customer idan = Customer.builder().firstName("Idan").lastName("Kfir").email("idan@gmail.com").coupon(cp2).password("idan123").build();
        adminFacade.addCustomr(idan);
        System.out.println(adminFacade.getOneCustomer(2));

        ArtUtils.testInfo("get all companies and customers");
        adminFacade.getAllCompany().forEach(System.out::println);
        adminFacade.getAllCustomers().forEach(System.out::println);


        ArtUtils.testInfo("update company");
        adminFacade.getOneCompany(2);
        c2.setEmail("m&m232@gmail.com");
        adminFacade.updateCompany(c2);
        adminFacade.getOneCompany(2);

        ArtUtils.testInfo("update customer");
        System.out.println(adminFacade.getOneCustomer(1));
        moshe.setLastName("Malki");
        adminFacade.updateCustomer(moshe);
        System.out.println(adminFacade.getOneCustomer(1));

        ArtUtils.testInfo("customer bay coupon");
        customerFacade.buyCoupon(cp2);
        adminFacade.getAllCustomers().forEach(System.out::println);

        ArtUtils.testInfo("get all coupons after sail");
        couponRepository.findAll().forEach(System.out::println);

        ArtUtils.testInfo("login company");
        System.out.println(companyFacade.login("cocacola@gmail.com", "cola1234"));

//        ArtUtils.testInfo("delete customer");
//        adminFacade.deleteCustomer(1);
//        adminFacade.getAllCustomers().forEach(System.out::println);


//        ArtUtils.testInfo("delete company");
//        adminFacade.deleteCompany(1);
//        adminFacade.getAllCompany().forEach(System.out::println);

        ArtUtils.testInfo("ligin managar as admin");
        System.out.println(loginManager.loginManger("admin@admin.com", "admin", ClientType.ADMIN).toString());

        ArtUtils.testInfo("ligin managar as company");
        System.out.println(loginManager.loginManger("cocacola@gmail.com", "cola1234", ClientType.COMPANY).toString());

        ArtUtils.testInfo("ligin managar as customer");
        System.out.println(loginManager.loginManger("moshe@gmail.com", "moshe123", ClientType.CUSTOMER).toString());


        ArtUtils.testInfo("dayli job");

        Coupon cp4 = new Coupon(1, Category.FOOD, "coca cola2", "10% off", startDate1, endDate1, 10, 10.90, "cocacola.jpeg");
        System.out.println(cp4);
        couponRepository.save(cp4);
        System.out.println("--------------------------");
        couponRepository.findAll().forEach(System.out::println);

    }
}
