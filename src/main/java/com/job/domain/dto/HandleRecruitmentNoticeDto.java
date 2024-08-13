package com.job.domain.dto;

import com.job.domain.entity.RecruitmentNotice;

public record HandleRecruitmentNoticeDto(
        Long companyId,
        String position,
        Integer compensation,
        String contents,
        String skill) {

    public HandleRecruitmentNoticeDto(RecruitmentNotice recruitmentNotice) {
        this(null, recruitmentNotice.getPosition(), recruitmentNotice.getCompensation(), recruitmentNotice.getContents(), recruitmentNotice.getSkill());
    }
}
