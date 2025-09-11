package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyUserCountDto {
    private String requestMonth;
    private long userCount;
}
