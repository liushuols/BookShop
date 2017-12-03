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
public class UserLoginController {
	
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	
	@RequestMapping("/userlogin")
	public String loginUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd) {
		List<User> userlist = this.userRegistServiceImpl.listAllUser();
		for(int i = 0 ;i < userlist.size();i++) {
			if(((userlist.get(i)).getUsername()).equals(name)) {
				model.addAttribute("username", name);
				model.addAttribute("password", pwd);
				return "index";
			}
		}
		model.addAttribute("error", "该用户不存在，请进行注册！");
		return "register";
	}
}
