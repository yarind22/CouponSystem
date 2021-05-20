package com.jb.CouponSystem.jobs;



import com.jb.CouponSystem.beans.Coupon;
import com.jb.CouponSystem.repos.CouponRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class DayliJob {
    private final CouponRepository couponRepository;
    private Date date = new Date(System.currentTimeMillis());



   // @Scheduled(fixedRate = 5000)
    @Scheduled(fixedRate = 1000*60*60*24)
    public void dayliJobInAction(){
        for (Coupon coupon:couponRepository.findAll()) {
          if (coupon.getEndDate().before(date)){
              couponRepository.delete(coupon);
          }
        }
        couponRepository.findAll().forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

    }

}
