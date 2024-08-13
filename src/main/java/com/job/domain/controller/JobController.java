package com.job.domain.controller;

import com.job.domain.dto.RecruitmentNoticeRequestDto;
import com.job.domain.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping("/job")
    public ResponseEntity<Void> createRecruitNotice(@RequestBody RecruitmentNoticeRequestDto recruitmentNoticeRequestDto) {
        jobService.createRecruitNotice(recruitmentNoticeRequestDto);
        return ResponseEntity.ok().build();
    }
}
