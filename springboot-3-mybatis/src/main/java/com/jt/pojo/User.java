package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data	//自动添加get/set方法
@Accessors(chain = true) //开启链式加载(将set方法里面的void-改为-user----对应到insertUser())
@AllArgsConstructor      //添加全部参数的构造
@NoArgsConstructor		 //添加无参构造
@TableName(value="user") //将对象与表---映射
public class User {
	/**
	 * 规则:
	 * 	1.如果表名与对象名一致可以省略
	 *  2.如果表中字段与属性名称一致可以省略配置
	 */
	@TableId(type=IdType.AUTO) //属性与表主键关系----映射 (主键自增)
	private Integer id;
	//@TableField(value ="user") //当数据库字段名和属性名不一致时,用这个注解来辅助解释
	private String name;
	private Integer age;
	private String sex;
}
