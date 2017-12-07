package com.bear.bookonline.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.admin.service.AdminLoginServiceImpl;
import com.bear.bookonline.entity.Admin;

@Controller
public class AdminLoginController {
	
	@Resource
	private AdminLoginServiceImpl adminLoginServiceImpl;
	
	@RequestMapping("adminlogin")
	public String loginAdmin(Model model,HttpSession session,@RequestParam("username") String name,@RequestParam("password") String pwd) {
		List<Admin> adminlist = this.adminLoginServiceImpl.findAllAdmin();
		for(int i = 0 ;i < adminlist.size();i++) {
			if(((adminlist.get(i)).getAdminName()).equals(name) && (adminlist.get(i).getAdminPwd()).equals(pwd)) {
				session.setAttribute("username", name);
				session.setAttribute("password", pwd);
				session.setAttribute("user",adminlist.get(i));
				return "redirect:book/list1";
			}
		}
		model.addAttribute("error", "该管理员不存在，请进行注册！");
		return "register";
	} 
}
