package com.job.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final CompanyDataInit companyDataInit;

    @Override
    public void run(ApplicationArguments args) {
        companyDataInit.insertCompanyData();
    }

}
