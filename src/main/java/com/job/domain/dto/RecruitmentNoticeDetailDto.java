package com.job.domain.dto;

import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;

import java.util.List;

public record RecruitmentNoticeDetailDto(
        Long recruitmentNoticeId,
        String companyName,
        String country,
        String region,
        String position,
        Integer compensation,
        String skill,
        String contents,
        List<Long> sameCompanyAnotherNotice) {

    public RecruitmentNoticeDetailDto(RecruitmentNotice recruitmentNotice, Company company, List<Long> sameCompanyAnotherNotice) {
        this(
                recruitmentNotice.getId(),
                company.getName(),
                company.getCountry(),
                company.getRegion(),
                recruitmentNotice.getPosition(),
                recruitmentNotice.getCompensation(),
                recruitmentNotice.getSkill(),
                recruitmentNotice.getContents(),
                sameCompanyAnotherNotice
        );
    }
}
