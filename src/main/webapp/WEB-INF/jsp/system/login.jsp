<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8" %>  
<%@ page contentType="text/html; charset=utf-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html class="loginHtml">
<%@ include file="../include/head.jsp" %>
<body class="loginBody">
	<form class="layui-form" action="${ctx }/system/login" method="post">
		<input type="hidden" value="${publicKey}" id="publicKey"/>
		<div class="login_face"><img src="${ctx}/images/face.jpg" class="userAvatar"></div>
		<c:if test="${error != null }">
			<div class="layui-form-item input-item">
				${error }
			</div>
		</c:if>
		<div class="layui-form-item input-item">
			<label for="userName">用户名</label>
			<input type="text" placeholder="请输入用户名" autocomplete="off" id="userName" name="username" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item">
			<label for="password">密码</label>
			<input type="password" placeholder="请输入密码" autocomplete="off" id="password" class="layui-input" lay-verify="required">
			<input type="hidden" id="passwordEncrypt" name="password">
		</div>
		<div class="layui-form-item input-item">
	        <input type="checkbox" id="remember" name="remember"
				      value="true" lay-skin="switch" lay-text="记住|关闭" checked>
		</div>
		<div class="layui-form-item">
			<button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
		</div>
	</form>
	<script type="text/javascript" src="${ctx}/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx}/js/login.js"></script>
	<script type="text/javascript" src="${ctx}/js/cache.js"></script>
	<script type="text/javascript" src="${ctx}/js/plugins/sha/sha512.js"></script>
	<script type="text/javascript" src="${ctx}/js/plugins/jsencrypt/jsencrypt.min.js"></script>
</body>
</html>