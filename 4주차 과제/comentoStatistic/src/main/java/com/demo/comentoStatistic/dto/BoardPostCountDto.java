package com.demo.comentoStatistic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BoardPostCountDto {

    private String boardId;
    private String yearMonth;
    private long postCnt;
}
