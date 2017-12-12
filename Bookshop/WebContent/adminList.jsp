<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.bear.bookonline.entity.Book"%>

<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<%=basePath %>bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="<%=basePath %>styles/Common.css" rel="stylesheet" />
    <link href="<%=basePath %>styles/Index2.css" rel="stylesheet" />
    
    <style type="text/css">
    	.intro{width:300px;}
    	.change{line-height:20px;}
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div class="add"><a class="btn btn-success" onclick="openadd();" style="font-size:25px;height:25px;">添加图书</a></div>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab" align="center">
                        <thead>
                            <tr>
                                <th>图书名称</th>
                                <th>类别</th>
                                <th>简介</th>
                                <th>价格</th>
                                <th>出版社</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <c:forEach var="book" items="${detailList1 }">
                        	<tbody id="tbody">
                        		<tr align="center" class="change">
                        		<th><img src="<%=basePath %>${book.bookimg1 }" alt="无法显示该图片" width="100px" height="150px"/><br><br>${book.bookname }</th>
                        		<th>${book.book.bookType.typename}</th>
                        		<th class="intro">${book.introduce}</th>
                        		<th>${book.bookprice}</th>
                        		<th>${book.bookpublisher}</th>
                        		<th style="font-size:25px"><a href="<%=basePath %>/../update.do?bookid=${book.bookid }">修改</a>&emsp;|&emsp;<a href="<%=basePath %>book/adminDelete?bookid=${book.bookid }">删除</a></th>  
                        		<tr>                           
                        	</tbody>
                        </c:forEach>

                    </table>
                    
                <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="height:400px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3>添加图书</h3>
                </div>
                <form class="form-horizontal" action="<%=basePath %>book/addBook">
                <div class="modal-body">
                    
                    	<div class="control-group">
                            <label class="control-label" for="userName">图书图片</label>
                            <div class="controls">
                                <input type="text" id="userName" placeholder="图片" name="bookImg1">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="userName">图书名称</label>
                            <div class="controls">
                                <input type="text" id="userName" placeholder="名称" name="bookName">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Chinese">图书类别</label>
                            <div class="controls">
                                <input type="text" id="Chinese" placeholder="类别" name="bookType">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="Math">图书简介</label>
                            <div class="controls">
                                <input type="text" id="Math" placeholder="简介" name="bookIntroduce">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="English">图书价格</label>
                            <div class="controls">
                                <input type="text" id="English" placeholder="价格" name="bookPrice">
                            </div>
                        </div>
                         <div class="control-group">
                            <label class="control-label" for="English">图书出版社</label>
                            <div class="controls">
                                <input type="text" id="English" placeholder="出版社" name="bookPublisher">
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                    <button class="btn btn-primary" id="add" onclick="add();">保存</button>
                    <button class="btn btn-primary" id="edt" onclick="edt();">保存</button>
                </div>
                </form>
           	 	</div>
                <div id="page" class="tr"></div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=basePath %>scripts/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>layer-v2.3/layer/layer.js"></script>
    <script src="<%=basePath %>laypage-v1.3/laypage/laypage.js"></script>
    <script src="<%=basePath %>scripts/Index2.js"></script>
</body>
</html>