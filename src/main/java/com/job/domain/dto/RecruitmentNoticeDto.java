package com.job.domain.dto;

public record RecruitmentNoticeDto(
        Long recruitmentNoticeId,
        String companyName,
        String country,
        String region,
        String position,
        Integer compensation,
        String skill) {
}
