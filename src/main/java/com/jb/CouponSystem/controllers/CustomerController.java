package com.jb.CouponSystem.controllers;


import com.jb.CouponSystem.controllers.model.LoginModel;
import com.jb.CouponSystem.exceptions.MyException;
import com.jb.CouponSystem.facade.CustomerFacade;
import com.jb.CouponSystem.login.ClientType;
import com.jb.CouponSystem.login.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("coupons/")
@RequiredArgsConstructor
public class CustomerController extends ClientController {

    private final CustomerFacade customerFacade;
    private final LoginManager loginManager;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<?> login(LoginModel loginModel) throws MyException {
        String token = loginManager.loginManger(loginModel.getEmail() ,loginModel.getPassword(), ClientType.CUSTOMER);
        return new ResponseEntity<>(token,HttpStatus.CREATED);
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("coupon")
//    public void purchaseCoupon(@RequestBody Coupon coupon) throws OpertationNotAllowedExeption {
//        customerFacade.buyCoupon(coupon);
//    }
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCustomerCoupon() {
//        return new ResponseEntity<>(customerFacade.getCustomerCoupon(), HttpStatus.OK);
//    }
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCustomerCouponByCategory(@RequestParam Category category) {
//        return new ResponseEntity<>(customerFacade.getCustomerCouponByCategory(category), HttpStatus.OK);
//    }
//
//
//    @GetMapping("coupons")
//    public ResponseEntity<?> getCustomerCouponsByMaxPrice(@PathVariable double maxPrice) {
//        return new ResponseEntity<>(customerFacade.getCouponsByMaxPrice((int) maxPrice), HttpStatus.OK);
//    }
//
//    @GetMapping("customer")
//    @ResponseStatus(HttpStatus.OK)
//    public Customer getCustomerDetails() {
//        return customerFacade.getCustomerDetails();
//    }

}
