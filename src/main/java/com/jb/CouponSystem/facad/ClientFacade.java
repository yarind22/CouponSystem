package com.jb.CouponSystem.facad;

import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import lombok.NoArgsConstructor;
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
