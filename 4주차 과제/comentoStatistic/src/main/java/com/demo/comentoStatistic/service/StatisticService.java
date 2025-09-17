package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){
        return statisticMapper.selectYearLogin(year);
    }

    //일자별 접속자 수
    public ApiResponseDto<?> getDailyActiveUsers(String statDate) {
        DailyUserCountDto result = statisticMapper.selectDailyActiveUsers(statDate);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        return new ApiResponseDto<>("200", "success", result);
    }

    //평균 하루 로그인 수
    public ApiResponseDto<?> getAvgDailyLogins() {
        Double result = statisticMapper.selectAvgDailyLogins();

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        AvgDailyLoginsDto data = new AvgDailyLoginsDto(result);
        return new ApiResponseDto<>("200", "success", data);
    }
    //휴일을 제외한 로그인 수
    public ApiResponseDto<?> getBusinessDayLogins() {
        Long result = statisticMapper.selectBusinessDayLogins();

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        BusinessDayLoginsDto data = new BusinessDayLoginsDto(result);
        return new ApiResponseDto<>("200", "success", data);
    }

    //년월별 사용자 접속자수
    public ApiResponseDto<?> getMonthlyUsers(String yearMonth) {
        MonthlyUserCountDto result = statisticMapper.selectMonthlyUsers(yearMonth);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }
        return new ApiResponseDto<>("200", "success", result);
    }

    //년월별 로그인 요청 수
    public ApiResponseDto<?> getMonthlyLoginCount(String yearMonth) {
        MonthlyLoginCountDto result = statisticMapper.selectMonthlyLoginCount(yearMonth);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        return new ApiResponseDto<>("200", "success", result);
    }

    //년월별 부서별 사용자 접속자수
    public ApiResponseDto<?> getDeptMonthlyUsers(String yearMonth, Integer departmentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("yearMonth", yearMonth);
        params.put("departmentId", departmentId);

        DeptMonthlyUserCountDto result = statisticMapper.selectDeptMonthlyActiveUsers(params);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        return new ApiResponseDto<>("200", "success", result);
    }

    //년월별 부서별 로그인 요청 수
    public ApiResponseDto<?> getDeptMonthlyLogins(String yearMonth, Integer departmentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("yearMonth", yearMonth);
        params.put("departmentId", departmentId);

        DeptMonthlyLoginsDto result = statisticMapper.selectDeptMonthlyLogins(params);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        return new ApiResponseDto<>("200", "success", result);
    }

    //년월별 게시글 작성 수
    public ApiResponseDto<?> getBoardPostCount(String yearMonth, String boardId) {
        Map<String, Object> params = new HashMap<>();
        params.put("yearMonth", yearMonth);
        params.put("boardId", boardId);

        BoardPostCountDto result = statisticMapper.selectBoardPostCount(params);

        if (result == null) {
            return new ApiResponseDto<>("204", "데이터가 존재하지 않습니다.", null);
        }

        return new ApiResponseDto<>("200", "success", result);
    }
}