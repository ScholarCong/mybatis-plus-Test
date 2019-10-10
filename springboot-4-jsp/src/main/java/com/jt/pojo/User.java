package com.jt.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Accessors(chain=true)
@TableName(value="user")
public class User implements Serializable {
	private static final long serialVersionUID = -9075746417780282979L;
	@TableId(type=IdType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
}
