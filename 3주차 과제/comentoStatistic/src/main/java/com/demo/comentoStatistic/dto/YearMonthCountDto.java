package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearMonthCountDto {

    // SQL의 'as yearMonth' 컬럼 결과를 담을 필드
    private String yearMonth;

    // SQL의 'as totCnt' 컬럼 결과를 담을 필드
    private long totCnt;
}