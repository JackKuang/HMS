<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="../../include/head.jsp" %>
<body class="childrenBody">
<form class="layui-form layui-row changePwd" id="updatePwdForm">
	<div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
		<input type="hidden" id="publicKey" value="${publicKey}">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" value="用户XXX" disabled class="layui-input layui-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">旧密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请输入旧密码" lay-verify="required|oldPwd" id="oldPwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">新密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请输入新密码" lay-verify="required|newPwd" id="newPwd" class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-block">
				<input type="password" value="" placeholder="请确认密码" lay-verify="required|confirmPwd"  id="confirmPwd"  class="layui-input pwd">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="changePwd">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/plugins/sha/sha512.js"></script>
<script type="text/javascript" src="${ctx}/js/plugins/jsencrypt/jsencrypt.min.js"></script>
<script type="text/javascript">
layui.use(['form','layer'],function(){
    var form = layui.form;
    $ = layui.jquery;

    //添加验证规则
    form.verify({
        newPwd : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPwd : function(value, item){
            if(!new RegExp($("#newPwd").val()).test(value)){
                return "两次输入密码不一致，请重新输入！";
            }
        }
    })

    //验证按钮
    form.on("submit(changePwd)",function(data){
        var shaObj = new jsSHA("SHA-512", "TEXT");
        var encrypt = new JSEncrypt();
        var publicKey = $('#publicKey').val();
        encrypt.setPublicKey(publicKey);
        var encrypted,hash;
        var obj = {};
        //oldPwd
        var oldPwd = $("#oldPwd").val();
        shaObj.update(oldPwd);
        hash = shaObj.getHash("HEX");
        encrypted = encrypt.encrypt(hash);
        obj['oldPwd'] = encrypted;
        //newPwd
        var newPwd = $("#newPwd").val();
        shaObj.update(newPwd);
        hash = shaObj.getHash("HEX");
        encrypted = encrypt.encrypt(hash);
        obj['newPwd'] = encrypted;
		$.ajax({
			type: 'post',
			url: "${ctx}/system/updatePwd",
			data: obj,
			success: function(data) {
				loadingModel.hideLoading();
				$('#updatePwdForm')[0].reset();
				if(data.success){
					initModel.initPermissionTree();
				}else{
			        $('#publicKey').val(data.obj);
				}
				alertModel.alertData(data);
			}
		});
    })

});
</script>
</body>
</html>