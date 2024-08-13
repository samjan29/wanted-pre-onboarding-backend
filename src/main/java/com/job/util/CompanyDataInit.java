package com.job.util;

import com.job.domain.entity.Company;
import com.job.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyDataInit {

    private final CompanyRepository companyRepository;

    public Company insertCompanyData1() {
        return companyRepository.save(new Company("원티드랩", "한국", "서울"));
    }

    public Company insertCompanyData2() {
        return companyRepository.save(new Company("원티드코리아", "한국", "부산"));
    }

    public Company insertCompanyData3() {
        return companyRepository.save(new Company("네이버", "한국", "판교"));
    }

    public Company insertCompanyData4() {
        return companyRepository.save(new Company("AWS", "미국", "워싱턴"));
    }
}
