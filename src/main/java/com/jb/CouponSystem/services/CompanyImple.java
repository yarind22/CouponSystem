package com.jb.CouponSystem.services;

import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.repos.CompnyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyImple implements CompniesService{
    private final CompnyRepository compnyRepository;
    @Override
    public Boolean isCompanyExist(String email, String password) {
        return compnyRepository.findByEmailAndPassword(email,password) != null;
    }

    @Override
    public void addCompany(Company company) {
        compnyRepository.save(company);
    }

    @Override
    public void updateCompany(Company company) {
        compnyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompanyById(int companyID) {
        compnyRepository.deleteById(companyID);
    }

    @Override
    public Company getOneCompany(int companyID) {
        return compnyRepository.getOne(companyID);
    }

    @Override
    public List<Company> getAllCompanies() {
        return compnyRepository.findAll();
    }
}
