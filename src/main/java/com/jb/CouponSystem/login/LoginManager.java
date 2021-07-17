package com.jb.CouponSystem.login;


import com.jb.CouponSystem.exceptions.MyException;
import com.jb.CouponSystem.facade.AdminFacade;
import com.jb.CouponSystem.facade.CompanyFacade;
import com.jb.CouponSystem.facade.CustomerFacade;
import com.jb.CouponSystem.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginManager {

private final ApplicationContext ctx;
private final TokenManager tokenManager;

    public String loginManger(String email, String password, ClientType clientType) throws MyException {
        if (clientType.name().equals(ClientType.ADMIN.name())){
            AdminFacade adminFacade = ctx.getBean(AdminFacade.class);
            if (adminFacade.login(email, password)){
                return tokenManager.generateToken(adminFacade);
            }
        } else if (clientType.name().equals(ClientType.COMPANY.name())){
            CompanyFacade companyFacade = ctx.getBean(CompanyFacade.class);
            if (companyFacade.login(email, password)){
                return tokenManager.generateToken(companyFacade);
            }
        } else if (clientType.name().equals(ClientType.CUSTOMER.name())){
            CustomerFacade customerFacade = ctx.getBean(CustomerFacade.class);
            if (customerFacade.login(email, password)){
                return tokenManager.generateToken(customerFacade);
            }
        }
        throw new MyException("wrong email or password");
    }



}
