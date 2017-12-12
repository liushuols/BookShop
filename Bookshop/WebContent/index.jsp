<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.bear.bookonline.entity.Book" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	<head>
		<meta charset="UTF-8">
		<title>图书商城</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css">
		<style>
			table{  border-collapse:collapse;  }   
			.td1 td{font-weight:bold;font-size:20px} 
			.fenye{height:80px;width:800px;margin-top:100px;}
			.fenye2{font-size:20px}
			.sub_mingxing{width:300px;height:400px;margin-left:20px;}
			.aa a:hover{color:#FF8800;}
	</style> 
	</head>
	<body>
	<%
		String path1 = request.getContextPath();
		String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
		List<Book> booklist = (List<Book>)request.getSession().getAttribute("list");
		if(booklist == null){
			response.sendRedirect(basePath1 + "book/list");
		}
	%>
	<!-- start header -->
		 <header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="<%=basePath%>book/list" target="_blank">图书商城</a></li>
						<li>|</li>
						<li><a href="<%=basePath%>book/list">首页</a></li>
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
					<div class="gouwuche fr"><a href="<%=basePath%>book/shopping">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="<%=basePath%>adminlogin.jsp" target="_blank">管理员登录</a></li>
							<li>|</li>
							<li><a href="<%=basePath%>login.jsp" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="<%=basePath%>register.jsp" target="_blank" >注册</a></li>
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
			<a href="<%=basePath%>book/list" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="<%=basePath %>book/findByTypeid?typeid=1" target="_blank">教辅类</a></li>
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

	<!-- start banner_y -->
		<div class="banner_y center">
			<div class="nav">				
				<ul>
					<li>
						<a href="<%=basePath %>book/findByTypeid?typeid=1" style="font-size:25px">教辅类</a>
					</li>
					<li>
						<a href="<%=basePath %>book/findByTypeid?typeid=2" style="font-size:25px">小说类</a>
					</li>
					<li>
						<a href="<%=basePath %>book/findByTypeid?typeid=4" style="font-size:25px">漫画类</a>
					</li>
					<li>
						<a href="<%=basePath %>book/findByTypeid?typeid=3" style="font-size:25px">工具书</a>
					</li>
				</ul>
			</div>
		
		</div>	
	<!-- end banner -->

	<!-- start danpin -->
		<c:forEach var="book" items="${list }" varStatus="status">
		
			<div class="mingxing f1">
				<div class="sub_mingxing"><a href="<%=basePath %>book/findAllBookDetail?bookid=${book.id}" target="_blank"><img src="../${book.picture }" alt="无法显示该图片"></a></div>
				<div class="aa" style="font-size:25px;margin-top:-10px;padding-left:20px;"><a href="<%=basePath %>book/findAllBookDetail?bookid=${book.id}" target="_blank">${book.name }</a></div>
				<div class="youhui">${book.publisher }</div>
				<div class="jiage">${book.price }</div>
			</div>
		
		</c:forEach>
		
		<div style="margin-left:500px">
		<table class="fenye">
       <tr>
            <td colspan="6" align="center"  class="fenye2">共&emsp;${page.totalRecords}&emsp;本图书 &emsp;共&emsp;${page.totalPages}&emsp;页 &emsp;当前第&emsp;${page.pageNo}&emsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&emsp;&emsp;             
                <a href="<%=request.getContextPath()%>/book/list?pageNo=${page.topPageNo}"><input type="button" name="fristPage" value="首页" class="fenye2"/></a>&nbsp;&nbsp;
                <c:choose>
                  <c:when test="${page.pageNo!=1}">             
                      <a href="<%=request.getContextPath()%>/book/list?pageNo=${page.previousPageNo }"><input type="button" name="previousPage" value="上一页" class="fenye2"/></a>               
                  </c:when>
                  <c:otherwise>   
                      <input type="button" disabled="disabled" name="previousPage" value="上一页" class="fenye2"/>       
                  </c:otherwise>
                </c:choose>&nbsp;&nbsp;
                <c:choose>
                  <c:when test="${page.pageNo != page.totalPages}">
                    <a href="<%=request.getContextPath()%>/book/list?pageNo=${page.nextPageNo }"><input type="button" name="nextPage" value="下一页" class="fenye2"/></a>
                  </c:when>
                  <c:otherwise>    
                      <input type="button" disabled="disabled" name="nextPage" value="下一页" class="fenye2"/>
                  </c:otherwise>
                </c:choose>&nbsp;&nbsp;
                <a href="<%=request.getContextPath()%>/book/list?pageNo=${page.bottomPageNo}"><input type="button" name="lastPage" value="尾页" class="fenye2"/></a>
            </td>
        </tr>
     </table>
     </div>
		<footer class="mt20 center">			
			<div class="mt20"><a href="<%=basePath %>book/list">图书商城</a> | <a href="">预售</a> | <a href="">购物指南</a> | <a href="">配送方式</a> | 
			<a href="">支付方式</a> | <a href="">售后服务</a> | <a href="">图书天猫店</a> | <a href="">图书淘宝直营店</a> | <a href="">图书网盟</a> | <a href="">隐私政策</a></div>
			<div>京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer> 
	</body>
</html>