package com.demo.comentoStatistic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MonthlyUserCountDto {
    private String yearMonth;
    private long userCnt;
}
