package com.jb.CouponSystem.controllers;

import com.jb.CouponSystem.controllers.model.LoginModel;
import com.jb.CouponSystem.exceptions.MyException;
import com.jb.CouponSystem.facade.CompanyFacade;
import com.jb.CouponSystem.login.ClientType;
import com.jb.CouponSystem.login.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coupons/")
@RequiredArgsConstructor
public class CompanyController extends ClientController {

    private final CompanyFacade companyFacade;
    private final LoginManager loginManager;

    @Override
    public ResponseEntity<?> login(LoginModel loginModel) throws MyException {
        String token = loginManager.loginManger(loginModel.getEmail() ,loginModel.getPassword(), ClientType.COMPANY);
        return new ResponseEntity<>(token,HttpStatus.CREATED);
    }
//    @PostMapping("login")
//    @Override
//    protected boolean login(String email, String password) {
//        return companyFacade.login(email, password);
//    }
//
//    @PostMapping("coupons")
//    public void addCoupon(@RequestBody Coupon coupon) throws OpertationNotAllowedExeption {
//        companyFacade.addCoupon(coupon);
//    }
//
//    @PutMapping("coupons")
//    public void updateCoupon(@RequestBody Coupon coupon) throws OpertationNotAllowedExeption {
//        companyFacade.updateCoupon(coupon);
//    }
//
//    @DeleteMapping("coupons/{id}")
//    public void deleteCoupon(@PathVariable int id) {
//        companyFacade.deleteCoupon(id);
//    }
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCompanyCoupons() {
//        return new ResponseEntity<>(companyFacade.getAllCouponsByCompanyID(), HttpStatus.OK);
//    }
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCompanyCouponsByCategory(@RequestParam Category category) {
//        return new ResponseEntity<>(companyFacade.getCouponsByCategory(category), HttpStatus.OK);
//    }
//
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCompanyCouponsByMaxPrize(@RequestParam double maxPrise) {
//        return new ResponseEntity<>(companyFacade.getCouponsByMaxPrice((int) maxPrise), HttpStatus.OK);
//    }
//
//    @GetMapping("companies")
//    public ResponseEntity<?> getCompanyDetails() {
//        return new ResponseEntity<>(companyFacade.getCompanyDetails(), HttpStatus.OK);
//    }

}