package com.jb.CouponSystem.controllers;


import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.controllers.model.LoginModel;
import com.jb.CouponSystem.exceptions.MyException;
import com.jb.CouponSystem.facade.AdminFacade;
import com.jb.CouponSystem.login.ClientType;
import com.jb.CouponSystem.login.LoginManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController extends ClientController {

    private final AdminFacade adminFacade;
    private final LoginManager loginManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) throws MyException {
        String token = loginManager.loginManger(loginModel.getEmail() ,loginModel.getPassword(), ClientType.ADMIN);
        return new ResponseEntity<>(token,HttpStatus.CREATED);
    }

    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader(value = "Authorization") String token, @RequestBody Company company) throws MyException {
        adminFacade.addCompany(company,token);
    }
//
//    @PutMapping("companies/update")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateCompany(@RequestBody Company company) throws exeption {
//        adminFacade.updateCompany(company);
//    }
//
//    @DeleteMapping("companies/delete/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCompany(@PathVariable int companyID) {
//        adminFacade.deleteCompany(companyID);
//    }
//
//    @GetMapping("companies")
//    public ResponseEntity<?> getAllCompanies() {
//        return new ResponseEntity<>(adminFacade.getAllCompany(), HttpStatus.OK);
//    }
//
//    @GetMapping("companies/{id}")
//    public ResponseEntity<?> getOneCompany(@PathVariable int companyID) {
//        adminFacade.getOneCompany(companyID);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping("customers")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addCustomer(@RequestBody Customer customer) throws exeption {
//        adminFacade.addCustomr(customer);
//    }
//
//    @PutMapping("customer/update")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateCustomer(@RequestBody Customer customer) throws exeption {
//        adminFacade.updateCustomer(customer);
//    }
//
//    @DeleteMapping("customer/delete/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteCustomer(@PathVariable int customerID) {
//        adminFacade.deleteCustomer(customerID);
//    }
//
//    @GetMapping("customers")
//    public ResponseEntity<?> getAllCustomers() {
//        return new ResponseEntity<>(adminFacade.getAllCustomers(), HttpStatus.OK);
//    }
//
//    @GetMapping("customer/{id}")
//    public ResponseEntity<?> getOneCustomer(@PathVariable int customerID) {
//        adminFacade.getOneCustomer(customerID);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
