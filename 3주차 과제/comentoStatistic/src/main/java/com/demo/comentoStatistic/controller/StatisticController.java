package com.demo.comentoStatistic.controller;

import com.demo.comentoStatistic.dto.MonthlyUserCountDto;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    // GET /api/v1/monthly-users/24/08 과 같은 요청을 처리합니다.
    @GetMapping("/api/v1/monthly-users/{year}/{month}")
    public ResponseEntity<?> getMonthlyUsers(
            @PathVariable("year") String year,    // URL의 {yy} 부분을 year 변수에 담습니다.
            @PathVariable("month") String month) { // URL의 {mm} 부분을 month 변수에 담습니다.

        // Service 계층으로 년, 월 값을 전달합니다.
        MonthlyUserCountDto result = statisticService.getMonthlyActiveUsers(year, month);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("데이터가 존재하지 않습니다.");
        }

        return ResponseEntity.ok(result);
    }
}