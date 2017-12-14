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
	 * ע���û�����������֤
	 * @param model
	 * @param name �û���
	 * @param pwd �û�����
	 * @param tel �û��绰
	 * @param address �û���ַ
	 * @param email �û���������
	 * @return ע��ҳ��
	 */
	@RequestMapping("/saveuser")
	public String addUser(Model model,@RequestParam("username") String name,@RequestParam("password") String pwd,
			@RequestParam("tel") String tel,@RequestParam("address") String address,
			@RequestParam("email") String email) {
		//��ȡ�����û��ļ���
		List<User> userList = this.userRegistServiceImpl.listAllUser();
		//������ȡ�����û����ϣ���������֤
		for(int i = 0 ;i < userList.size();i++) {
			if(((userList.get(i)).getUsername()).equals(name)) {
				model.addAttribute("error", "���û��Ѿ�ע��,����е�¼��");
				return "login";
			}
		}
		//����User���󣬲���ע����л�ȡ���Ĳ�������ö�����
		User user = new User();
		user.setUsername(name);
		user.setUserpwd(pwd);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(email);
		//���ö��󱣴浽���ݿ���
		this.userRegistServiceImpl.saveUser(user);
		model.addAttribute("user", user);
		return "login";
	}
}
