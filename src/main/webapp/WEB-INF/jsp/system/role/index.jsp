<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	/* 项目使用绝对路径，basePath只在主JSP上定义，不再include里面定义，避免变量名定义冲突 */
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>HMS-后台管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css"
	href="<%=basePath %>/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-row">
		<div class="layui-col-md12">
			<button class="layui-btn layui-btn-primary">原始按钮</button>
		    <button class="layui-btn">默认按钮</button>
		    <button class="layui-btn layui-btn-normal">百搭按钮</button>
		    <button class="layui-btn layui-btn-warm">暖色按钮</button>
		    <button class="layui-btn layui-btn-danger">警告按钮</button>
		    <button class="layui-btn layui-btn-disabled">禁用按钮</button>
	    </div>
	</div>
	<div class="layui-row">
		<div class="layui-col-md12">
			<table id="demo"></table>
		</div>
	</div>
	<script src="<%=basePath %>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=basePath %>/common/common.js"></script>
	<script>
	//JavaScript代码区域
	var $;
	layui.use(['jquery','table'],function(){
	    $ = layui.jquery;
	    var table = layui.table;
	    table.render({
	        elem: '#demo',
	        url:"<%=basePath %>/system/roles",
	        method: 'get', 
	        height:500,
	        page:true,//分页
	        limit:50,
	        request:pageModel.request,
	        //response:pageModel.response,
	        cols:[[ //表头
	          	        {field: 'uuid', title: 'ID', width:80, sort: true, fixed: 'left'}
          ]]
	    })	
	});

	</script>
</body>
</html>
