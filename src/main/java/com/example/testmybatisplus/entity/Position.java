package com.example.testmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author 陈虎
 * @date 2022-06-14 15:18
 */
@Data
@TableName("t_position")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @TableId(type=IdType.ASSIGN_ID)
    private Long positionId;
    private String positionName;
    private Integer deptId;
    private Long updateTime;
}
