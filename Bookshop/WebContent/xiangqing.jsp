<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head>
		<meta charset="UTF-8">
		<title>立即购买-图书商城</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="<%=basePath %>index.jsp" target="_blank">图书商城</a></li>
						<li>|</li>
						<li><a href="<%=basePath %>index.jsp">首页</a></li>
						<li>|</li>
						<li><a href="">预售</a></li>
						<li>|</li>
						<li><a href="<%=basePath %>book/findByTypeid?typeid=1">教辅</a></li>
						<li>|</li>
						<li><a href="<%=basePath %>book/findByTypeid?typeid=2">小说</a></li>
						<li>|</li>
						<li><a href="">知识服务</a></li>
						<li>|</li>
						<li><a href="">特色书店</a></li>
						<li>|</li>
						<li><a href="">社区</a></li>
						<li>|</li>
						<li><a href="">图书勋章</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="<%=basePath %>gouwuche.jsp">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="<%=basePath %>login.jsp" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="<%=basePath %>register.jsp" target="_blank" >注册</a></li>
							<li>|</li>
							<li><a href="">消息通知</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="<%=basePath %>index.jsp" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="<%=basePath %>book/findByTypeid?typeid=1">教辅类</a></li>
					<li><a href="<%=basePath %>book/findByTypeid?typeid=3">工具书</a></li>
					<li><a href="<%=basePath %>book/findByTypeid?typeid=4">漫画类</a></li>
					<li><a href="<%=basePath %>book/findByTypeid?typeid=2">小说类</a></li>
					<li><a href="">杂志</a></li>
					<li><a href="">中考专区</a></li>
					<li><a href="">高考专区</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="<%=basePath %>book/findByName" method="post">
					<div class="text fl">
						<input type="text" class="shuru" name="bookname" placeholder="请输入关键词">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	
	<!-- xiangqing -->
	<c:forEach var="bd" items="${detailList }">
	<form action="<%=basePath %>book/addShoppingcart?bookid=${bd.bookid}" method="post">
	<div class="xiangqing">
		<div class="neirong w">
			<div class="xiaomi6 fl">${bd.bookname }</div>
			<nav class="fr">
				<li><a href="">概述</a></li>
				<li>|</li>
				<li><a href="">相似商品</a></li>
				<li>|</li>
				<li><a href="">设计</a></li>
				<li>|</li>
				<li><a href="">商品参数</a></li>
				<li>|</li>
				<li><a href="">图书版权</a></li>
				<li>|</li>
				<li><a href="">用户评价</a></li>
				<div class="clear"></div>
			</nav>
			<div class="clear"></div>
		</div>	
	</div>
	
	<div class="jieshao mt20 w">
		<div class="left fl" style="width:400px;height:400px"><img src="${bd.bookimg1 }"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20">${bd.bookname }</div>
			<div class="jianjie mr40 ml20 mt10">${bd.introduce }</div>
			<div class="jiage ml20 mt10">${bd.bookprice }</div>
			<div class="ft20 ml20 mt20">选择数量：</div>
			<div class="xzbb ml20 mt10">
				<div class="banben fl">
					<a>
						<span>${bd.bookcount } </span>
					</a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
					<div class="left1 fl">${bd.bookname }</div>
					<div class="right1 fr">${bd.bookprice }</div>
					<div class="clear"></div>
				</div>
				<div class="bot mt20 ft20 ftbc">总价格：${(bd.bookcount)*(bd.bookprice) }</div>
			</div>
			<div class="xiadan ml20 mt20">
					<input class="jrgwc"  type="button" name="jrgwc" value="立即选购" />
					<input class="jrgwc" type="submit" name="jrgwc" value="加入购物车" />
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
	</c:forEach>
	<!-- footer -->
	<footer class="mt20 center">
			
			<div class="mt20"><a href="<%=basePath %>index.jsp">图书商城</a> | <a href="">预售</a> | <a href="">购物指南</a> | <a href="">配送方式</a> | 
			<a href="">支付方式</a> | <a href="">售后服务</a> | <a href="">图书天猫店</a> | <a href="">图书淘宝直营店</a> | <a href="">图书网盟</a> | <a href="">隐私政策</a></div>
			<div>京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>

		</footer>

	</body>
</html>