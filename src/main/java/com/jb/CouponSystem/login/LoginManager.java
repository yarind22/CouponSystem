package com.jb.CouponSystem.login;


import com.jb.CouponSystem.facad.AdminFacade;
import com.jb.CouponSystem.facad.ClientFacade;
import com.jb.CouponSystem.facad.CompanyFacade;
import com.jb.CouponSystem.facad.CustomerFacade;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginManager {
private final AdminFacade adminFacade;
private final CompanyFacade companyFacade;
private final CustomerFacade customerFacade;

    public ClientFacade loginManger(String email, String password, ClientType clientType){
        if (clientType.name().equals(ClientType.ADMIN.name())){
            if (adminFacade.login(email, password)){
                return new AdminFacade();
            }
        } else if (clientType.name().equals(ClientType.COMPANY.name())){
            if (companyFacade.login(email, password)){
                return new CompanyFacade();
            }
        } else if (clientType.name().equals(ClientType.CUSTOMER.name())){
            if (customerFacade.login(email, password)){
                return new CustomerFacade();
            }
        }
        return null;
    }



}
