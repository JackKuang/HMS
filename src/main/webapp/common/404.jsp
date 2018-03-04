<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="../WEB-INF/jsp/include/head.jsp" %>
<body class="childrenBody">
	<div class="noFind">
		<div class="ufo">
			<i class="seraph icon-test ufo_icon"></i>
			<i class="layui-icon page_icon">&#xe638;</i>
		</div>
		<div class="page404">
			<i class="layui-icon">&#xe61c;</i>
			<p>我勒个去，页面被外星人挟持了!</p>
		</div>
	</div>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
</body>
</html>