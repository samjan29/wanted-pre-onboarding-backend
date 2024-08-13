package com.job.util;

import com.job.domain.entity.Company;
import com.job.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyDataInit {

    private final CompanyRepository companyRepository;

    public void insertCompanyData() {
        companyRepository.save(new Company("원티드랩", "한국", "서울"));
        companyRepository.save(new Company("원티드코리아", "한국", "부산"));
        companyRepository.save(new Company("네이버", "한국", "판교"));
    }
}
