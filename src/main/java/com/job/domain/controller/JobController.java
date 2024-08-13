package com.job.domain.controller;

import com.job.domain.dto.HandleRecruitmentNoticeDto;
import com.job.domain.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<HandleRecruitmentNoticeDto> modifyRecruitmentNotice(@PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId, @RequestBody HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        return ResponseEntity.ok(jobService.modifyRecruitmentNotice(recruitmentNoticeId, handleRecruitmentNoticeDto));
    }

    @DeleteMapping("/{recruitmentNoticeId}")
    public ResponseEntity<Void> deleteRecruitmentNotice(@PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId) {
        jobService.deleteRecruitmentNotice(recruitmentNoticeId);
        return ResponseEntity.ok().build();
    }
}
