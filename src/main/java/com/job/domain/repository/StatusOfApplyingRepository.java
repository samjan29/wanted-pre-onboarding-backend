package com.job.domain.repository;

import com.job.domain.entity.RecruitmentNotice;
import com.job.domain.entity.StatusOfApplying;
import com.job.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusOfApplyingRepository extends JpaRepository<StatusOfApplying, Long> {

    Optional<StatusOfApplying> findByRecruitmentNoticeAndUsers(RecruitmentNotice recruitmentNotice, Users users);
}
