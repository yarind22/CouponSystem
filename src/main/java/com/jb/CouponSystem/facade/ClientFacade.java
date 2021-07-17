package com.jb.CouponSystem.facade;

import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public abstract class ClientFacade {
  @Autowired
  protected CompnyRepository compnyRepository;
  @Autowired
  protected CustomerRepository customerRepository;
  @Autowired
  protected CouponRepository couponRepository;



  public abstract boolean login(String email, String password);
}
