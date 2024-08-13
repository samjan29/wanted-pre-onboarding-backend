package com.job.domain.controller;

import com.job.domain.dto.HandleRecruitmentNoticeDto;
import com.job.domain.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<Void> createRecruitNotice(@RequestBody HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        jobService.createRecruitNotice(handleRecruitmentNoticeDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/job/{recruitmentNoticeId}")
    public ResponseEntity<HandleRecruitmentNoticeDto> modifyRecruitNotice(@PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId, @RequestBody HandleRecruitmentNoticeDto handleRecruitmentNoticeDto) {
        return ResponseEntity.ok(jobService.modifyRecruitmentNotice(recruitmentNoticeId, handleRecruitmentNoticeDto));
    }
}
