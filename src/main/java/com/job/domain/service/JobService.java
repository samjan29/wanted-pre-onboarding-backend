package com.job.domain.service;

import com.job.domain.dto.HandleRecruitmentNoticeDto;
import com.job.domain.dto.RecruitmentNoticeDto;
import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;
import com.job.exception.CustomException;
import com.job.exception.ErrorCode;
import com.job.domain.repository.CompanyRepository;
import com.job.domain.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final CompanyRepository companyRepository;

    public void createRecruitmentNotice(HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {

        isRecruitmentNoticeInfoEverythingNull(handleRecruitmentNoticeDto);

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

        modifyRecruitmentNoticeInfo(handleRecruitmentNoticeDto, recruitmentNotice);

        RecruitmentNotice changedRecruitmentNotice = recruitmentNoticeRepository.save(recruitmentNotice);

        return new HandleRecruitmentNoticeDto(changedRecruitmentNotice);
    }

    public void deleteRecruitmentNotice(Long recruitmentNoticeId) {

        if (recruitmentNoticeRepository.findById(recruitmentNoticeId).isEmpty()) {
            throw new CustomException(ErrorCode.NOT_FOUND);
        }

        recruitmentNoticeRepository.deleteById(recruitmentNoticeId);
    }

    /**
     * 검색어로 조회
     *
     * @param search
     * @return 채용공고 리스트
     */
    public List<RecruitmentNoticeDto> searchRecruitmentNotice(String search) {
        List<RecruitmentNotice> recruitmentNoticeList = recruitmentNoticeRepository.searchByMultipleFields(search);
        return convertRecruitmentNotice(recruitmentNoticeList);
    }

    /**
     * 검색어 없이 전체 조회
     *
     * @return 채용공고 리스트
     */
    public List<RecruitmentNoticeDto> getAllRecruitmentNotice() {
        List<RecruitmentNotice> recruitmentNoticeList = recruitmentNoticeRepository.findAll();
        return convertRecruitmentNotice(recruitmentNoticeList);
    }

    /**
     * 채용공고를 등록/수정 할 때 받지 못한 데이터가 있는지 확인합니다.
     * record 에서 검증을 했으나 record 에 null이라는 새로운 필드가 생성되서 반환되어서 service 로 이동
     *
     */
    private void isRecruitmentNoticeInfoEverythingNull(HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        // 어떤 데이터도 받지 못했다면 예외 발생
        if (handleRecruitmentNoticeDto.position() == null && handleRecruitmentNoticeDto.compensation() == null
                && handleRecruitmentNoticeDto.contents() == null && handleRecruitmentNoticeDto.skill() == null) {
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }
    }

    private void modifyRecruitmentNoticeInfo(HandleRecruitmentNoticeDto handleRecruitmentNoticeDto, RecruitmentNotice recruitmentNotice) {

        String position = handleRecruitmentNoticeDto.position();
        Integer compensation = handleRecruitmentNoticeDto.compensation();
        String contents = handleRecruitmentNoticeDto.contents();
        String skill = handleRecruitmentNoticeDto.skill();

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

    /**
     * Entity를 DTO로 변환시켜 줍니다.
     *
     * @param recruitmentNoticeList
     * @return 채용공고 리스트 </RecruitmentNoticeDto>
     */
    private List<RecruitmentNoticeDto> convertRecruitmentNotice(List<RecruitmentNotice> recruitmentNoticeList) {
        List<RecruitmentNoticeDto> recruitmentNoticeDtoList = new ArrayList<>();

        for (RecruitmentNotice recruitmentNotice : recruitmentNoticeList) {
            Company company = recruitmentNotice.getCompany();
            recruitmentNoticeDtoList.add(
                    new RecruitmentNoticeDto(
                            recruitmentNotice.getId(),
                            company.getName(),
                            company.getCountry(),
                            company.getRegion(),
                            recruitmentNotice.getPosition(),
                            recruitmentNotice.getCompensation(),
                            recruitmentNotice.getSkill())
            );
        }

        return recruitmentNoticeDtoList;
    }
}
