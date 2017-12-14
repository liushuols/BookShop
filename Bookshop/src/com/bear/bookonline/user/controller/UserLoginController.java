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
	
	/**
	 * 用户通过用户名和密码进行登录
	 * @param model
	 * @param name 用户名
	 * @param session
	 * @param pwd 用户密码
	 * @return
	 */
	@RequestMapping("userlogin")
	public String loginUser(Model model,@RequestParam("username") String name,HttpSession session,@RequestParam("password") String pwd) {
		//在不同用户登录之前先移除原来用户中的购物车参数
		session.removeAttribute("shoppingCartSet");
		//获取用户信息列表
		List<User> userlist = this.userRegistServiceImpl.listAllUser();
		//遍历该列表，并进行验证，将用户存入session中
		for(int i = 0 ;i < userlist.size();i++) {
			if(((userlist.get(i)).getUsername()).equals(name) && (userlist.get(i).getUserpwd()).equals(pwd)) {
				model.addAttribute("username", name);
				model.addAttribute("password", pwd);
				session.setAttribute("user",userlist.get(i));
				//将该用户的订单集合存入session中
				session.setAttribute("shoppingcart", userlist.get(i).getOrderSet());
				return "redirect:book/list";
			}
		}
		model.addAttribute("error", "该用户不存在，请进行注册！");
		return "register";
	}
	
	/**
	 * 用户或管理员退出登录
	 * @param session
	 * @return 首页
	 */
	@RequestMapping("exitLogin")
	public String exitLogin(HttpSession session) {
		session.invalidate();
		return "redirect:book/list";
	}
}
