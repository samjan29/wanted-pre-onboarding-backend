package com.job.util;

import com.job.domain.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final CompanyDataInit companyDataInit;
    private final RecruitmentNoticeDataInit recruitmentNoticeDataInit;
    private final UsersDataInit usersDataInit;

    @Override
    public void run(ApplicationArguments args) {
        Company company1 = companyDataInit.insertCompanyData1();
        recruitmentNoticeDataInit.insertRecruitmentNoticeData1(company1);
        Company company2 = companyDataInit.insertCompanyData2();
        recruitmentNoticeDataInit.insertRecruitmentNoticeData2(company2);
        Company company3 = companyDataInit.insertCompanyData3();
        recruitmentNoticeDataInit.insertRecruitmentNoticeData3(company3);
        Company company4 = companyDataInit.insertCompanyData4();
        recruitmentNoticeDataInit.insertRecruitmentNoticeData4(company4);
        usersDataInit.insertUsersData();
    }

}
