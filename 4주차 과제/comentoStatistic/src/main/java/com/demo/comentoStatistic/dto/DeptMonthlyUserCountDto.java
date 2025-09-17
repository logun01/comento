package com.demo.comentoStatistic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeptMonthlyUserCountDto {
    private String deptCode;
    private String yearMonth;
    private long userCnt;
}
