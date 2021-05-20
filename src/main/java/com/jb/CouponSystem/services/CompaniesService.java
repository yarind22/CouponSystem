package com.jb.CouponSystem.services;


import com.jb.CouponSystem.beans.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CompaniesService {
    Boolean isCompanyExist(String name, String email);

    void addCompany(Company company);

    void updateCompany(Company company);

    void deleteCompanyById(int companyID);

    Company getOneCompany(int CompanyID);

    List<Company> getAllCompanies();
}
