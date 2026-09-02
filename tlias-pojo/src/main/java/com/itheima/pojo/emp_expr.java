package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class emp_expr {
    private Integer   id;
    private Integer   empId;
    private LocalDate begin;
    private LocalDate end;
    private String    company;
    private String    job;

}
