package com.example.testmybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testmybatisplus.entity.Position;
import com.example.testmybatisplus.vo.UserListVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 陈虎
 * @date 2022-06-14 15:27
 */
@Repository
public interface PositionMapper extends BaseMapper<Position> {
    @Select(value = "select u.id as user_id,u.name,u.email,r.role_name,p.position_name " +
            "from t_user u join t_user_role ur on u.id=ur.user_id " +
            "join t_role r on ur.role_id=r.role_id " +
            "join t_position p on u.position_id=p.position_id ${ew.customSqlSegment}")
    IPage<UserListVO> userList(Page page, @Param("ew") QueryWrapper wrapper);
}
