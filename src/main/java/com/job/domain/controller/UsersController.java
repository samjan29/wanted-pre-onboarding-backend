package com.job.domain.controller;

import com.job.domain.dto.UsersInfoDto;
import com.job.domain.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    /**
     * 채용공고 지원 API
     *
     * @param recruitmentNoticeId
     * @param usersInfoDto  토큰 대신 RequestBody에 회원 아이디를 요청 받음
     */
    @PostMapping("/apply/{recruitmentNoticeId}")
    public ResponseEntity<Void> applyRecruit(@PathVariable(name = "recruitmentNoticeId") Long recruitmentNoticeId, @RequestBody UsersInfoDto usersInfoDto) {
        usersService.applyRecruit(recruitmentNoticeId, usersInfoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
