package com.bear.bookonline.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;

@Controller
@RequestMapping("user")
public class UserRegistController {
	
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	
	/**
	 * 注册用户，并进行验证
	 * @param model
	 * @param name 用户名
	 * @param pwd 用户密码
	 * @param tel 用户电话
	 * @param address 用户地址
	 * @param email 用户电子邮箱
	 * @return 注册页面
	 */
	@RequestMapping("/saveuser")
	public String addUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd,
			@RequestParam("tel") String tel,@RequestParam("address") String address,
			@RequestParam("email") String email) {
		//获取所有用户的集合
		List<User> userList = this.userRegistServiceImpl.listAllUser();
		//遍历获取到的用户集合，并进行验证
		for(int i = 0 ;i < userList.size();i++) {
			if(((userList.get(i)).getUsername()).equals(name)) {
				model.addAttribute("error", "该用户已经注册,请进行登录！");
				return "login";
			}
		}
		//创建User对象，并将注册表单中获取到的参数存入该对象中
		User user = new User();
		user.setUsername(name);
		user.setUserpwd(pwd);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(email);
		//将该对象保存到数据库中
		this.userRegistServiceImpl.saveUser(user);
		model.addAttribute("user", user);
		return "login";
	}
}
