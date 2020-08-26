package com.typingtest.po;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "result")
@Getter @Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer cpm;

    private Integer accuracy;

    private Integer score;

    @Column(name = "test_time")
    private Integer testTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private Integer status;
}
