<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import=" java.util.Set"%>
<%@page import="com.bear.bookonline.entity.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		Set<Order> shoppingCartSet = (Set<Order>)request.getSession().getAttribute("shoppingCartSet");
	%>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-图书商城</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
		<style type="text/css">
			.sub_content fl{width:40px;height:50px;}
			.delete a:hover{color:#ff6700;}
			.gwcxqbj{width:100%;height:auto;}
			.gwcxd center{width:100%;height:auto;}
		</style>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="<%=basePath %>book/list" target="_blank"><div class="logo fl"></div></a>
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
					<li><a href="<%=basePath %>login.jsp" target="_blank">登录</a></li>
					<li>|</li>
					<li><a href="<%=basePath %>register.jsp" target="_blank">注册</a></li>
					<li>|</li>
					<li><a href="<%=basePath%>exitLogin">退出登录</a></li>	
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" />全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<c:forEach var="s" items="${shoppingCartSet }">
				<c:forEach var="o" items="${s.orderdetailSet }">
				<div class="content2 center" style="padding-top:40px;height:70px">
					<div class="sub_content fl " style="margin-left:30px;height:60px">
						<input type="checkbox" value="quanxuan" class="quanxuan" />
					</div>
					<div style="width=250px;float:left;font-size:20px;margin-left:100px;padding-left:10px;align:center;">${o.bookname }</div>
					<div style="width=150px;float:left;margin-left:230px;padding-left:50px;">${o.bookprice }</div>
					<div style="width=50px;float:left;margin-left:140px">${o.bookcount }</div>
					<div style="width=50px;float:left;margin-left:140px">${(o.bookprice)*(o.bookcount) }</div>
					<div class="delete" style="width=50px;float:left;margin-left:145px"><a href="<%=basePath %>book/delete?orderdetailid=${o.orderdetailid}">删除</a></div>
				</div>
				</c:forEach>
				</c:forEach>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="<%=basePath %>book/list">继续购物</a></li>
						<li>|</li>
						<li>共<span>${size }</span>件商品，已选择<span>1</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span>${totalPrice }</span></div>
					<div class="jsanniu fr"><a href="<%=basePath %>book/list"><input class="jsan" type="submit" name="jiesuan"  value="去结算"/></a></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>

	<!-- footer -->
	<footer class="center">
			
			<div class="mt20"><a href="<%=basePath %>book/list">图书商城</a> | <a href="">预售</a> | <a href="">购物指南</a> | <a href="">配送方式</a> | 
			<a href="">支付方式</a> | <a href="">售后服务</a> | <a href="">图书天猫店</a> | <a href="">图书淘宝直营店</a> | <a href="">图书网盟</a> | <a href="">隐私政策</a></div>
			<div>京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>
