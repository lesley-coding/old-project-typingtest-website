package com.typingtest.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVo {
    private Integer cpm;
    private Integer accuracy;
    private Integer score;
    private Integer testTime;
    private Integer status;
}
