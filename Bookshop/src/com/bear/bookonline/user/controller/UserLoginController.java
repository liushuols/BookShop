package com.bear.bookonline.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;

@Controller

public class UserLoginController {
	
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	
	@RequestMapping("userlogin")
	public String loginUser(Model model,@RequestParam("username") String name,HttpSession session,@RequestParam("password") String pwd) {
		session.removeAttribute("shoppingCartSet");
		List<User> userlist = this.userRegistServiceImpl.listAllUser();
		for(int i = 0 ;i < userlist.size();i++) {
			if(((userlist.get(i)).getUsername()).equals(name) && (userlist.get(i).getUserpwd()).equals(pwd)) {
				model.addAttribute("username", name);
				model.addAttribute("password", pwd);
				session.setAttribute("user",userlist.get(i));
				session.setAttribute("shoppingcart", userlist.get(i).getOrderSet());
				return "redirect:book/list";
			}
		}
		model.addAttribute("error", "���û������ڣ������ע�ᣡ");
		return "register";
	}
}
