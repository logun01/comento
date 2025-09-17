package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.*;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLogins(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }


    //일자별 접속자 수
    @GetMapping("/daily-users/{statDate}")
    public ResponseEntity<ApiResponseDto<?>> getDailyUsers(
            @PathVariable String statDate) {

        ApiResponseDto<?> response = statisticService.getDailyActiveUsers(statDate);

        return ResponseEntity.ok(response);
    }

    //평균 하루 로그인 수
    @GetMapping("/average-daily-logins")
    public ResponseEntity<ApiResponseDto<?>> getAverageDailyLogins() {
        ApiResponseDto<?> response = statisticService.getAvgDailyLogins();
        return ResponseEntity.ok(response);
    }

    //휴일을 제외한 로그인 수
    @GetMapping("/business-day-logins")
    public ResponseEntity<ApiResponseDto<?>> getBusinessDayLogins() {
        ApiResponseDto<?> response = statisticService.getBusinessDayLogins();
        return ResponseEntity.ok(response);
    }

    //년월별 사용자 접속자수
    @GetMapping("/monthly-users/{yearMonth}")
    public ResponseEntity<ApiResponseDto<?>> getMonthlyUser(
            @PathVariable String yearMonth) {

        ApiResponseDto<?> response = statisticService.getMonthlyActiveUsers(yearMonth);

        if ("204".equals(response.getReturnCode())) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.ok(response);
    }

    //년월별 로그인 요청 수
    @GetMapping("/monthly-logins/yearMonth")
    public ResponseEntity<ApiResponseDto<?>> getMonthlyLoginCount(
            @PathVariable String yearMonth) {

        ApiResponseDto<?> response = statisticService.getMonthlyLoginCount(yearMonth);

        return ResponseEntity.ok(response);
    }

    //년월별 부서별 사용자 접속자수
    @GetMapping("/dept-monthly-users/{yearMonth}/{deptId}")
    public ResponseEntity<ApiResponseDto<?>> getDeptMonthlyUsers(
            @PathVariable String yearMonth,
            @PathVariable String mm,
            @PathVariable Integer deptId) {

        ApiResponseDto<?> response = statisticService.getDeptMonthlyUsers(yearMonth, deptId);

        return ResponseEntity.ok(response);
    }

    //년월별 부서별 로그인 요청 수
    @GetMapping("/dept-monthly-logins/{yearMonth}/{deptId}")
    public ResponseEntity<ApiResponseDto<?>> getDeptMonthlyLogins(
            @PathVariable String yearMonth,
            @PathVariable Integer deptId) {

        ApiResponseDto<?> response = statisticService.getDeptMonthlyLogins(yearMonth, deptId);

        return ResponseEntity.ok(response);
    }

    //년월별 게시글 작성 수
    @GetMapping("/board-posts/{yearMonth}/{boardId}")
    public ResponseEntity<ApiResponseDto<?>> getBoardPostCount(
            @PathVariable String yearMonth,
            @PathVariable String boardId) {

        ApiResponseDto<?> response = statisticService.getBoardPostCount(yearMonth, boardId);

        return ResponseEntity.ok(response);
    }
}