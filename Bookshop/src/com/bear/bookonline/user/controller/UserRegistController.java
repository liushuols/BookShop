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
	
	@RequestMapping("/saveuser")
	public String addUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd,
			@RequestParam("tel") String tel,@RequestParam("address") String address,
			@RequestParam("email") String email) {
		List<User> userList = this.userRegistServiceImpl.listAllUser();
		for(int i = 0 ;i < userList.size();i++) {
			if(((userList.get(i)).getUsername()).equals(name)) {
				model.addAttribute("error", "该用户已经注册,请进行登录！");
				return "login";
			}
		}
		User user = new User();
		user.setUsername(name);
		user.setUserpwd(pwd);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(email);
		this.userRegistServiceImpl.saveUser(user);
		model.addAttribute("user", user);
		return "login";
	}
}
