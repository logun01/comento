package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    MonthlyUserCountDto selectMonthlyUsers(String yearMonth);
    DailyUserCountDto selectDailyActiveUsers(String statDate);
    Double selectAvgDailyLogins();
    Long selectBusinessDayLogins();
    DeptMonthlyLoginsDto selectDeptMonthlyLogins(Map<String, Object> params);
    DeptMonthlyUserCountDto selectDeptMonthlyActiveUsers(Map<String, Object> params);
    MonthlyLoginCountDto selectMonthlyLoginCount(String yearMonth);
    BoardPostCountDto selectBoardPostCount(Map<String, Object> params);
}
