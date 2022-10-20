package com.example.testmybatisplus.vo;

import lombok.Data;

/**
 * @author 陈虎
 * @description
 * @date 2022-10-20 9:32
 */
@Data
public class UserListVO {
    private Long userId;
    private String name;
    private String email;
    private String roleName;
    private String positionName;
}
