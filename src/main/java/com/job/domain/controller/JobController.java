package com.job.domain.controller;

import com.job.domain.dto.HandleRecruitmentNoticeDto;
import com.job.domain.dto.RecruitmentNoticeDetailDto;
import com.job.domain.dto.RecruitmentNoticeDto;
import com.job.domain.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<Void> createRecruitmentNotice(@RequestBody HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        jobService.createRecruitmentNotice(handleRecruitmentNoticeDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{recruitmentNoticeId}")
    public ResponseEntity<HandleRecruitmentNoticeDto> modifyRecruitmentNotice(
            @PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId,
            @RequestBody HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        return ResponseEntity.ok(jobService.modifyRecruitmentNotice(recruitmentNoticeId, handleRecruitmentNoticeDto));
    }

    @DeleteMapping("/{recruitmentNoticeId}")
    public ResponseEntity<Void> deleteRecruitmentNotice(@PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId) {
        jobService.deleteRecruitmentNotice(recruitmentNoticeId);
        return ResponseEntity.ok().build();
    }

    /**
     * 채용공고 조회 API
     * 검색어가 있어도 없어도 조회 가능
     *
     * @param search
     * @return 채용공고 리스트
     */
    @GetMapping
    public ResponseEntity<List<RecruitmentNoticeDto>> getRecruitmentNoticeList(@RequestParam(name = "search", required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return ResponseEntity.ok(jobService.searchRecruitmentNotice(search));
        } else {
            return ResponseEntity.ok(jobService.getAllRecruitmentNotice());
        }
    }


    /**
     * 채용공고 상세 조회 API
     * 상세 내용과 해당 회사의 다른 공고의 id도 조회
     *
     * @param recruitmentNoticeId
     * @return
     */
    @GetMapping("/detail")
    public ResponseEntity<RecruitmentNoticeDetailDto> getRecruitmentNoticeDetail(@RequestParam(name = "id") Long recruitmentNoticeId) {
        return ResponseEntity.ok(jobService.getRecruitmentNoticeDetail(recruitmentNoticeId));
    }
}
