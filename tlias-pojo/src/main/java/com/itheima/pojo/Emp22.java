package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp22 {

    private Integer id;
    private String name;
    private Integer gender; 
    private String job;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    public Emp22(Integer gender, LocalDate end, LocalDate begin, String name) {
        this.gender = gender;
        this.end = end;
        this.begin = begin;
        this.name = name;
    }
    // 此处省略 Getter 和 Setter 方法，请使用 IDE 自动生成（快捷键 Alt + Insert）
    // public Integer getId() { return id; }
    // ...
}