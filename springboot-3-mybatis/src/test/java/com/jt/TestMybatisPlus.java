package com.jt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

/**
 * SpringBoot测试类写法
 * @author 000
 *
 */
@SpringBootTest //springboot自己封装了测试方法,可以直接从容器中获取
@RunWith(SpringRunner.class)
public class TestMybatisPlus {
	/**
	 * 旧版本写法
	 */
	/*
	 * @Test public void testOld() { 
	 * //1.获取容器对象 ApplicationContext context = new ClassPathXmlApplicationContext("spring配置文件.xml");
	 * //2.从容器中获取对象 UserMapper
	 * userMapper = context.getBean(UserMapper.class); 
	 * //3.利用对象操作数据
	 * userMapper.selectList(null); }
	 */
	
	 
	@Autowired
	private UserMapper userMapper;
	
	//1.新增用户
	@Test
	public void insertUser() {
		User user = new User();
		user.setName("1903班").setAge(4).setSex("都有");
		userMapper.insert(user);
		System.out.println("mybatisplus操作成功!!!!");
	}
	
	//2.查询操作
	/**
	 * queryWrapper表示条件构造器
	 * 动态拼接where name="1903班"
	 * 对象中不为null属性充当where条件
	 */
	@Test
	public void select_Id_Count() {
		//根据Id查询
		User user = userMapper.selectById(53);
		System.out.println("通过id查询的对应user情况:"+user);
		//查询全部记录数
		Integer Count = userMapper.selectCount(null);
		System.out.println("统计人数共有:"+Count);
		//查询全部的女性记录数  sex="女"
		//1.面向对象方式
		User userCount = new User();
		userCount.setSex("女");
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(userCount);
		Integer sexCount = userMapper.selectCount(queryWrapper);
		System.out.println("查询的女性总数:"+sexCount);
	}
	
	//2.1
	/**
	 * 条件查询
	 * 要求:
	 * 		1.age>18岁
	 * 		>gt   <lt  =eq
	 * 		>=ge  <=le
	 * 		相等(EQ)、不等(NE)、
	 * 		小于(LT)、大于(GT)、
	 * 		小于或等于(LE)、大于或等于(GE) 
	 */
	@Test
	public void selectCount1() {
		//age>=18
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.gt("age", 18);
		Integer selecCount = userMapper.selectCount(queryWrapper);
		System.out.println("查询的age>=18的总数:"+selecCount);
	}
	
	//2.2
	@Test
	public void selectCount2() {
		//age>=18 and sex=女
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.ge("age", 18).eq("sex", "女");
		Integer selecCount = userMapper.selectCount(queryWrapper);
		System.out.println("查询的age>=18 and sex=女的总数:"+selecCount);
	}
	
	//3.删除
	@Test
	public void deleteUser() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "1903班");
		userMapper.delete(queryWrapper);
	}
	
	//4.修改
	/**
	 * 条件:将id为53的数据修改名称为如花 性别为女
	 * mybatisplus更新操作
	 * sql: 
	 * 		update user set name=如花,sex="女"
	 * 		where id = 53
	 * 
	 * 注意事项: 如果确定主键 可以使用byId方法更新.
	 * 
	 */
	
	@Test
	public void updateUser() {
		User user = new User();
		user.setName("如花").setSex("女").setId(54);
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "不知火舞");
		userMapper.updateById(user);
	}
	
	//4.1
	/*
	 * 2:没有id的更新操作语法
	 * entity:需要修改的数据.
	 * updateWrapper: where条件
	 * userMapper.update(entity, updateWrapper);
	 */
	@Test
	public void updateUser1() {
		//1.如果根据id进行更新.则id字段自动充当where条件
		//User user = new User();
		//user.setId(53).setName("如花")
		    //.setAge(120).setSex("女");
		//userMapper.updateById(user);
		/**
		 * 2.根据名称修改数据  
		 * name=如花的数据
		 * name改为不知火舞 age=18
		 */
		User tempuser = new User();
		tempuser.setName("不知火舞").setAge(18);
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("name", "1903班");
		userMapper.update(tempuser, updateWrapper);
	}
}
