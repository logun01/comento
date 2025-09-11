package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearCountDto {

    // SQL의 'as year' 컬럼 결과를 담을 필드
    private String year;

    // SQL의 'as totCnt' 컬럼 결과를 담을 필드
    // count(*)의 결과는 클 수 있으므로 int보다 long 타입이 더 안전합니다.
    private long totCnt;
}