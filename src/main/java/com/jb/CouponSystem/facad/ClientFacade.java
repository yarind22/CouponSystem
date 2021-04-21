package com.jb.CouponSystem.facad;

import com.jb.CouponSystem.repos.CompnyRepository;
import com.jb.CouponSystem.repos.CouponRepository;
import com.jb.CouponSystem.repos.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public abstract class ClientFacade {
  protected CompnyRepository compnyRepository;
  protected CustomerRepository customerRepository;
  protected CouponRepository couponRepository;

  @Autowired
  public ClientFacade(CompnyRepository compnyRepository, CustomerRepository customerRepository, CouponRepository couponRepository) {
    this.compnyRepository = compnyRepository;
    this.customerRepository = customerRepository;
    this.couponRepository = couponRepository;
  }

  public abstract boolean login(String email, String password);
}
