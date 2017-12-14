<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bear.bookonline.entity.Book"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BookShop后台管理——修改图书</title>
	<link href="<%=basePath %>bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=basePath %>styles/Common.css" rel="stylesheet" />
    <link href="<%=basePath %>styles/Index2.css" rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
        <div class="row-fluid">
            <h4>图书信息列表</h4>
            <div class="w">
                <div class="span12">
              		<form action="<%=basePath %>book/updateBooks"  method="post" enctype="multipart/form-data">
                    <table class="table table-condensed table-bordered table-hover tab" >
                        <thead>
                            <tr>
                                <th>书名</th>
                                <th>图片</th>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                            <tr align="center">
                        		<th> <input type="text" name="bookName" value="${book.bookname }"> </th>
                        		<th> <input type="text" name="bookimg1" value="${book.bookimg1 }"> </th>
                       		<tr> 
                        </tbody>
                    </table>
                    
                    <table class="table table-condensed table-bordered table-hover tab" >
                        <thead>
                            <tr>
                                <th>简介</th>
                                <th>类别</th>
                                <th>价格</th>
                                <th>出版社</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="tbody">
                            <tr align="center">
                        		<th> <input type="text" name="introduce" value="${book.introduce }"> </th>
                        		<th> 
                        			<select name="bookType">
                        			 	<c:forEach var="type" items="${typeList }">
                        			 		<c:choose>
                        			 			<c:when test="${type.typeid == book.book.bookType.typeid }">
  													<option value ="${type.typeid }" selected="selected">${type.typename }</option>
  												</c:when>
  												<c:otherwise>
  													<option value ="${type.typeid }">${type.typename }</option>
  												</c:otherwise>
  											</c:choose>
  										</c:forEach>
									</select>
								</th>
                        		<th> <input type="text" name="bookPrice" value="${book.bookprice }"> </th>
                        		<th> <input type="text" name="bookPublisher" value="${book.bookpublisher }"> </th>
                        		<th> <input type="submit" value="修改图书"></th>
                       		<tr> 
                        </tbody>  
                    </table>
                    </form>
                    <div id="page" class="tr"></div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=basePath %>/scripts/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>/layer-v2.3/layer/layer.js"></script>
    <script src="<%=basePath %>/laypage-v1.3/laypage/laypage.js"></script>
    <script src="<%=basePath %>/scripts/Index2.js"></script>
</body>
</html>