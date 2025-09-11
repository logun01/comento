package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.MonthlyUserCountDto;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    // Controller로부터 year("24")와 month("08")를 따로 받습니다.
    public MonthlyUserCountDto getMonthlyActiveUsers(String year, String month) {

        // 합쳐진 값으로 Mapper를 호출합니다.
        return statisticMapper.selectMonthlyActiveUsers(year + month);
    }



}