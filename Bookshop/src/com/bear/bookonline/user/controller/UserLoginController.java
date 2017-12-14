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
	 * �û�ͨ���û�����������е�¼
	 * @param model
	 * @param name �û���
	 * @param session
	 * @param pwd �û�����
	 * @return
	 */
	@RequestMapping("userlogin")
	public String loginUser(Model model,@RequestParam("username") String name,HttpSession session,@RequestParam("password") String pwd) {
		//�ڲ�ͬ�û���¼֮ǰ���Ƴ�ԭ���û��еĹ��ﳵ����
		session.removeAttribute("shoppingCartSet");
		//��ȡ�û���Ϣ�б�
		List<User> userlist = this.userRegistServiceImpl.listAllUser();
		//�������б���������֤�����û�����session��
		for(int i = 0 ;i < userlist.size();i++) {
			if(((userlist.get(i)).getUsername()).equals(name) && (userlist.get(i).getUserpwd()).equals(pwd)) {
				model.addAttribute("username", name);
				model.addAttribute("password", pwd);
				session.setAttribute("user",userlist.get(i));
				//�����û��Ķ������ϴ���session��
				session.setAttribute("shoppingcart", userlist.get(i).getOrderSet());
				return "redirect:book/list";
			}
		}
		model.addAttribute("error", "���û������ڣ������ע�ᣡ");
		return "register";
	}
	
	/**
	 * �û������Ա�˳���¼
	 * @param session
	 * @return ��ҳ
	 */
	@RequestMapping("exitLogin")
	public String exitLogin(HttpSession session) {
		session.invalidate();
		return "redirect:book/list";
	}
}
