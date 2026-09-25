package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class Emp22 {

    private Integer id;
    private String name;
    private Integer gender; 
    private String job;
    private String avatar;
    
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate entryDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    // 此处省略 Getter 和 Setter 方法，请使用 IDE 自动生成（快捷键 Alt + Insert）
    // public Integer getId() { return id; }
    // ...
}