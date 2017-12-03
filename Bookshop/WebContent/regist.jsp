<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="user/saveuser" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="password" name="userpwd"><br>
		身份证号码：<input type="text" name="usernum"><br>
		联系方式：<input type="text" name="usertelephone"><br>
		家庭住址：<input type="text" name="useraddress"><br>
		电子邮箱：<input type="text" name="useremail"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>