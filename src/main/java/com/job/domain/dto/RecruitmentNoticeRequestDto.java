package com.job.domain.dto;

public record RecruitmentNoticeRequestDto(
        Long companyId,
        String position,
        Integer compensation,
        String contents,
        String skill) {

    /**
     * 채용공고를 등록할 때 받지 못한 데이터가 있는지 확인합니다.
     *
     * @return boolean - null이 존재할 경우 true, 데이터를 다 받았을 경우 false
     */
    public boolean isNull() {
        return companyId == null || position == null || compensation == null || contents == null || skill == null;
    }
}
