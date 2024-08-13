package com.job.domain.service;

import com.job.domain.dto.RecruitmentNoticeRequestDto;
import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;
import com.job.exception.CustomException;
import com.job.exception.ErrorCode;
import com.job.domain.repository.CompanyRepository;
import com.job.domain.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final CompanyRepository companyRepository;

    public void createRecruitNotice(RecruitmentNoticeRequestDto recruitmentNoticeRequestDto) {

        if (recruitmentNoticeRequestDto.isNull()) {
            // 프론트에서 유효성 검증을 하기 때문에 상황을 알려주는 메세지 없이 400 예외 던짐
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        Company company = companyRepository.findById(recruitmentNoticeRequestDto.companyId()).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        recruitmentNoticeRepository.save(
                RecruitmentNotice.builder()
                        .company(company)
                        .position(recruitmentNoticeRequestDto.position())
                        .compensation(recruitmentNoticeRequestDto.compensation())
                        .position(recruitmentNoticeRequestDto.position())
                        .contents(recruitmentNoticeRequestDto.contents())
                        .skill(recruitmentNoticeRequestDto.skill())
                        .build()
        );
    }
}
