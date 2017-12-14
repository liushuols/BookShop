<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/login.css">
	</head>
	<body>
		<form  method="post" action="user/saveuser">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">用户注册</div>
					<div class="right fr"><a href="./index.jsp" target="_self">图书商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入您的用户名"/><span>请不要输入汉字</span><span style="color:red">${error }</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入您的密码"/><span>请输入6位以上字符</span></div>	
					<div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" placeholder="请确认您的密码"/><span>两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="tel" placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;<input class="shurukuang" type="text" name="address" placeholder="请输入您的地址"/><span>请输入详细地址</span></div>
					<div class="username">电子邮箱:&nbsp;&nbsp;<input class="shurukuang" type="text" name="email" placeholder="请填写正确的邮箱地址"/><span>请输入正确的邮箱格式</span></div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册" width="300">
				</div>
			</div>
		</div>
		</form>
	</body>
</html>