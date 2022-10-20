package com.example.testmybatisplus;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testmybatisplus.bo.UserSearchBO;
import com.example.testmybatisplus.entity.Position;
import com.example.testmybatisplus.mapper.PositionMapper;
import com.example.testmybatisplus.service.PositionService;
import com.example.testmybatisplus.vo.UserListVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestMybatisPlusApplicationTests {

    @Resource
    private PositionService positionService;

    @Resource
    private PositionMapper positionMapper;

    @Test
    void contextLoads() {
        //制造数据
        List<Position> records=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            records.add(Position.builder().positionName("java测试"+(i+1)).deptId(1).build());
        }
        TimeInterval timer= DateUtil.timer();
        positionService.saveBatch(records);
        System.out.printf("共花费 %d毫秒%n", timer.interval());

    }

    @Test
    public void testMultiQuery(){
        UserSearchBO searchBO= UserSearchBO.builder()
                .username("zhangsan")
                .positionName("java开发")
                .roleName("admin")
                .build();

        QueryWrapper<UserListVO> wrapper= Wrappers
                .<UserListVO>query()
                .eq(!ObjectUtils.isEmpty(searchBO.getUsername()),"u.name",searchBO.getUsername())
                .eq(!ObjectUtils.isEmpty(searchBO.getPositionName()),"p.position_name",searchBO.getPositionName())
                .eq(!ObjectUtils.isEmpty(searchBO.getRoleName()),"r.role_name",searchBO.getRoleName());
        System.out.println(JSONUtil.toJsonStr(positionMapper.userList(new Page(0,10),wrapper)));
    }
}
