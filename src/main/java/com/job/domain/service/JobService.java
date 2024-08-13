package com.job.domain.service;

import com.job.domain.dto.HandleRecruitmentNoticeDto;
import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;
import com.job.exception.CustomException;
import com.job.exception.ErrorCode;
import com.job.domain.repository.CompanyRepository;
import com.job.domain.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final CompanyRepository companyRepository;

    public void createRecruitNotice(HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {

        if (handleRecruitmentNoticeDto.isNull()) {
            // 프론트에서 유효성 검증을 하기 때문에 상황을 알려주는 메세지 없이 400 예외 던짐
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        Company company = companyRepository.findById(handleRecruitmentNoticeDto.companyId()).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        recruitmentNoticeRepository.save(
                RecruitmentNotice.builder()
                        .company(company)
                        .position(handleRecruitmentNoticeDto.position())
                        .compensation(handleRecruitmentNoticeDto.compensation())
                        .position(handleRecruitmentNoticeDto.position())
                        .contents(handleRecruitmentNoticeDto.contents())
                        .skill(handleRecruitmentNoticeDto.skill())
                        .build()
        );
    }

    @Transactional
    public HandleRecruitmentNoticeDto modifyRecruitmentNotice(Long recruitmentNoticeId, HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {

        RecruitmentNotice recruitmentNotice = recruitmentNoticeRepository.findById(recruitmentNoticeId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        modifyInfo(handleRecruitmentNoticeDto, recruitmentNotice);

        RecruitmentNotice changedRecruitmentNotice = recruitmentNoticeRepository.save(recruitmentNotice);

        return new HandleRecruitmentNoticeDto(changedRecruitmentNotice);
    }

    private void modifyInfo(HandleRecruitmentNoticeDto handleRecruitmentNoticeDto, RecruitmentNotice recruitmentNotice) {

        String position = handleRecruitmentNoticeDto.position();
        Integer compensation = handleRecruitmentNoticeDto.compensation();
        String contents = handleRecruitmentNoticeDto.contents();
        String skill = handleRecruitmentNoticeDto.skill();

        // 어떤 데이터도 받지 못했다면 예외 발생
        if (position == null && compensation == null && contents == null && skill == null) {
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        if (position != null) {
            recruitmentNotice.setPosition(position);
        }
        if (compensation != null) {
            recruitmentNotice.setCompensation(compensation);
        }
        if (contents != null) {
            recruitmentNotice.setContents(contents);
        }
        if (skill != null) {
            recruitmentNotice.setSkill(skill);
        }
    }
}
