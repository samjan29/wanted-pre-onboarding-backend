package com.job.domain.repository;

import com.job.domain.entity.Company;
import com.job.domain.entity.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {

    @Query("select " +
            "   rn " +
            "from " +
            "   recruitment_notice rn " +
            "where " +
            "   rn.position like %:search% " +
            "or " +
            "   rn.skill like %:search%")
    List<RecruitmentNotice> searchByMultipleFields(@Param("search") String search);

    @Query("select " +
            "   rn.id " +
            "from " +
            "   recruitment_notice rn " +
            "where " +
            "   rn.company = :company " +
            "and " +
            "   not rn.id = :id ")
    List<Long> findIdByCompany(@Param("id") Long id, @Param("company") Company company);
}
