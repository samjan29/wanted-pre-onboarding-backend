package com.job.domain.service;

import com.job.domain.dto.UsersInfoDto;
import com.job.domain.entity.RecruitmentNotice;
import com.job.domain.entity.StatusOfApplying;
import com.job.domain.entity.Users;
import com.job.domain.repository.RecruitmentNoticeRepository;
import com.job.domain.repository.StatusOfApplyingRepository;
import com.job.domain.repository.UsersRepository;
import com.job.exception.CustomException;
import com.job.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final StatusOfApplyingRepository statusOfApplyingRepository;


    /**
     * 채용공고 지원
     * 채용공고는 한번씩만 지원 가능
     *
     * @param recruitmentNoticeId
     * @param usersInfoDto
     */
    public void applyRecruit(Long recruitmentNoticeId, UsersInfoDto usersInfoDto) {

        Users users = usersRepository.findById(usersInfoDto.usersId()).orElseThrow(
                () -> new CustomException(ErrorCode.BAD_REQUEST)
        );

        RecruitmentNotice recruitmentNotice = recruitmentNoticeRepository.findById(recruitmentNoticeId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        if (statusOfApplyingRepository.findByRecruitmentNoticeAndUsers(recruitmentNotice, users).isPresent()) {
            throw new CustomException(ErrorCode.ALREADY_APPLY);
        }

        statusOfApplyingRepository.save(new StatusOfApplying(recruitmentNotice, users));
    }
}
