package com.jt.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;
//接口的定义  没有实现类
//@Mapper	//将接口交给spring容器管理
//创建代理对象 JDK/CGLIB 
public interface UserMapper extends BaseMapper<User> {
	//编辑接口方法  查询全部数据
	//List<User> findAll();
}
