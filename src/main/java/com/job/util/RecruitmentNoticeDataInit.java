package com.job.util;

import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;
import com.job.domain.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeDataInit {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;

    public void insertRecruitmentNoticeData1(Company company) {
        recruitmentNoticeRepository.save(RecruitmentNotice.builder()
                .company(company)
                .position("백엔드 주니어 개발자")
                .compensation(1500000)
                .contents("짱개발자 구함")
                .skill("Python")
                .build());
    }

    public void insertRecruitmentNoticeData2(Company company) {
        recruitmentNoticeRepository.save(RecruitmentNotice.builder()
                .company(company)
                .position("프론트엔드 개발자")
                .compensation(500000)
                .contents("짱개발자 구함")
                .skill("javascript")
                .build());
    }

    public void insertRecruitmentNoticeData3(Company company) {
        recruitmentNoticeRepository.save(RecruitmentNotice.builder()
                .company(company)
                .position("Django 백엔드 개발자")
                .compensation(1000000)
                .contents("짱개발자 구함")
                .skill("Django")
                .build());
    }

    public void insertRecruitmentNoticeData4(Company company) {
        recruitmentNoticeRepository.save(RecruitmentNotice.builder()
                .company(company)
                .position("데브옵스")
                .compensation(3000000)
                .contents("짱개발자 구함")
                .skill("AWS")
                .build());
    }
}
