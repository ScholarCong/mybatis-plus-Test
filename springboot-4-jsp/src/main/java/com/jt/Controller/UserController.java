package com.jt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//查询表中数据,并显示到网页上
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<User> user = userService.findAll();
		model.addAttribute(user);
		//model.addAttribute("userList", userList);
		return "userList";//页面逻辑名称
	}
	//通过ajax方式加载数据
	@RequestMapping("/userList2")
	public String userList2() {
		return "userList2";
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<User> findAll() {
		List<User> user = userService.findAll();
		return user;//页面逻辑名称
		
	}
	
}
