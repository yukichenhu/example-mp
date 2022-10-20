package com.example.testmybatisplus.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @author 陈虎
 * @description
 * @date 2022-10-20 9:42
 */
@Data
@Builder
public class UserSearchBO {
    private String username;
    private String roleName;
    private String positionName;
}
