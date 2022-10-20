package com.example.testmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.testmybatisplus.entity.Position;
import com.example.testmybatisplus.mapper.PositionMapper;
import com.example.testmybatisplus.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * @author 陈虎
 * @date 2022-06-14 15:27
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService{
}
