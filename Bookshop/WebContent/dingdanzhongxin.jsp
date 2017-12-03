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
		<title>图书商城-订单中心</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/style.css">
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
					<div class="gouwuche fr"><a href="">我的订单</a></div>
					<div class="fr">
						<ul>
							<li><a href="<%=basePath %>login.jsp" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="<%=basePath %>register.jsp" target="_blank" >注册</a></li>
							<li>|</li>
							<li><a href="<%=basePath %>self_info.jsp">个人中心</a></li>
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
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
					<li><a href="">意外保</a></li>
					<li><a href="">团购订单</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="<%=basePath %>self_info.jsp">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">优惠券</a></li>
					<li><a href="">收货地址</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="./image/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">订单号:1705205643098724</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥2499.00</li>
						<li>2017/05/20 13:30</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="./image/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl">订单号:170526435444865</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥1999.00</li>
						<li>2017/05/26 14:02</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20"><a href="<%=basePath %>index.jsp">图书商城</a> | <a href="">预售</a> | <a href="">购物指南</a> | <a href="">配送方式</a> | 
			<a href="">支付方式</a> | <a href="">售后服务</a> | <a href="">图书天猫店</a> | <a href="">图书淘宝直营店</a> | <a href="">图书网盟</a> | <a href="">隐私政策</a></div>
			<div>京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer> 
	</body>
</html>