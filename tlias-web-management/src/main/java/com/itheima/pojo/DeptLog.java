package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptLog {//记录删除部门操作后的日志
    private Integer id;//部门id
    private LocalDateTime createTime;//操作的本地时间
    private String description;//操作描述
}