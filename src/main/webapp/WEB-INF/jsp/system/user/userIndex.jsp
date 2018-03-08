<%@ page language="java" isThreadSafe="true" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="../../include/head.jsp" %>
<body class="childrenBody">
	<div class="layui-row layui-col-space10">
		<blockquote class="layui-elem-quote">
			<button class="layui-btn layui-btn-normal" onclick="javascript:userOperate.addUser();" type="button">新增用户</button>
		</blockquote>
		<div class="layui-col-md12">
			<table id="userTable" lay-filter="userFilter"></table>
		</div>
	</div>
	
	<div id="userDialog" class="hide" >
		<form class="layui-form" id="userForm">
			<div class="layui-col-md12">
				<div class="layui-col-md11">
					<div class="layui-form-item">
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户ID</label>
						<div class="layui-input-block">
							<input type="text" id="userId" name="userId"
								placeholder="用户ID，不可重复" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户名称</label>
						<div class="layui-input-block">
							<input type="text" id="userName" name="userName"
								placeholder="用户名称" autocomplete="off"
								lay-verify="required" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户邮箱</label>
						<div class="layui-input-block">
							<input type="text" id="userEmail" name="userEmail"
								placeholder="邮箱，" autocomplete="off"
								lay-verify="required|email" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户电话</label>
						<div class="layui-input-block">
							<input type="text" id="userTelephone" name="userTelephone"
								placeholder="用户电话" autocomplete="off"
								lay-verify="required|phone" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户角色</label>
						<div class="layui-input-block">
							<select name="userRoles" id="userRoles" multiple="multiple">
								<option></option>
					        </select>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="*">保存</button>
							<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div id="userDialogDetail" class="hide" >
		<form class="layui-form" id="userForm">
			<div class="layui-col-md12">
				<div class="layui-col-md11">
					<div class="layui-form-item">
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户ID</label>
						<div class="layui-input-block">
							<input type="text" id="userIdDetail" name="userId"
								placeholder="用户ID，不可重复" autocomplete="off"
								lay-verify="required" class="layui-input" disabled>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户名称</label>
						<div class="layui-input-block">
							<input type="text" id="userNameDetail" name="userName"
								placeholder="用户名称" autocomplete="off"
								lay-verify="required" class="layui-input" disabled>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户邮箱</label>
						<div class="layui-input-block">
							<input type="text" id="userEmailDetail" name="userEmail"
								placeholder="邮箱，" autocomplete="off"
								lay-verify="required|email" class="layui-input" disabled>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户电话</label>
						<div class="layui-input-block">
							<input type="text" id="userTelephoneDetail" name="userTelephone"
								placeholder="用户电话" autocomplete="off"
								lay-verify="required|phone" class="layui-input" disabled>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户角色</label>
						<div class="layui-input-block">
							<input name="userRolesDetail" id="userRolesDetail"
								placeholder="用户电话" autocomplete="off"
								lay-verify="required" class="layui-input" disabled>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/html" id="userBar">
		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	
	<script type="text/javascript" src="${ctx}/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="${ctx}/js/common.js"></script>
	<script type="text/javascript" src="${ctx}/js/layui-mz-min.js"></script>
	
	<script>
	//JavaScript代码区域
	var $;
	var layer;
	var userUuidGlobal = "";
	var table;
	var form;
	layui.use(['jquery','table','layer','form'],function(){
	    $ = layui.jquery;
	    layer = layui.layer;
	    table = layui.table;
	    table.render({
		    id:'userTable',
	        elem: '#userTable',
	        url:"${ctx}/system/users",
	        method: 'get', 
	        page:true,//分页
	        height : "full-100",
	        limit:50,
	        request:pageModel.request,
	        loading:true,
	        //response:pageModel.response,
	        cols:[[ //表头
    	        {field: '',type:'numbers', title: '序号', width:'5%'},
    	        {field: 'userId', title: '用户ID', width:'10%'},
    	        {field: 'userName', title: '用户名', width:'15%'},
    	        {field: 'userEmail', title: '邮箱', width:'20%'},
    	        {field: 'userTelephone', title: '电话', width:'20%'},
    	        {field: 'userRoles', title: '用户角色', width:'20%'},
    	        {title:'操作',fixed: 'right', width:'10%', align:'center', toolbar: '#userBar'}
            ]]
	    })
	    table.on('tool(userFilter)', function(obj){
			var data = obj.data;
			if(obj.event === 'detail'){
				$('#userIdDetail').val(data.userId);
				$('#userNameDetail').val(data.userName);
				$('#userEmailDetail').val(data.userEmail);
				$('#userTelephoneDetail').val(data.userTelephone);
				$('#userRolesDetail').val(data.userRoles);
				layer.open({
					type: 1,
					title: '新增用户',
					skin: 'layui-layer-rim', //加上边框
					area: ['400px', '400px'], //宽高
					shadeClose: false,
					content: $('#userDialogDetail'),
				});	
			} else if(obj.event === 'del'){
				userUuidGlobal = data.uuid;
				userOperate.deleteUser();
			} else if(obj.event === 'edit'){
				userUuidGlobal = data.uuid;
				$('#userId').val(data.userId);
				$('#userName').val(data.userName);
				$('#userEmail').val(data.userEmail);
				$('#userTelephone').val(data.userTelephone);
				var reqData = {};
				reqData['userUuid'] = userUuidGlobal;
				formModel.initCheckbox('userRoles','${ctx}/system/rolesListOne',reqData,'uuid','roleName',false);
				layer.open({
					type: 1,
					title: '编辑用户',
					skin: 'layui-layer-rim', //加上边框
					area: ['400px', '400px'], //宽高
					shadeClose: false,
					content: $('#userDialog'),
				});	
			}
		});
	    
	    //按钮点击事件
    	form = layui.form;
	    form.on('submit(*)', function(data){
		  if(userUuidGlobal == ""){
			  $.ajax({
				  type: 'post',
				  url: "${ctx}/system/users",
				  data: data.field,
				  success: function(data) {
					  loadingModel.hideLoading();
					  if(data.success){
						  $('#userForm')[0].reset();
						  table.reload('userTable',{});
						  layer.closeAll('page')
					  }
					  alertModel.alertData(data);
				  }
			  });
		  }else{
			  $.ajax({
				  type: 'put',
				  url: "${ctx}/system/users/"+userUuidGlobal,
				  data: data.field,
				  success: function(data) {
					  loadingModel.hideLoading();
					  if(data.success){
						  $('#userForm')[0].reset();
						  table.reload('userTable',{});
						  layer.closeAll('page')
					  }
					  alertModel.alertData(data);
				  }
			  });
		  }
		  return false;
	  });
	});

	var userOperate = {
		addUser: function(){
			userUuidGlobal = '';
			formModel.initCheckbox('userRoles','${ctx}/system/rolesListAll',null,'uuid','roleName',false);
			//页面层
			layer.open({
				type: 1,
				title: '新增用户',
				skin: 'layui-layer-rim', //加上边框
				area: ['400px', '400px'], //宽高
				shadeClose: false,
				content: $('#userDialog'),
			});
		},
		deleteUser: function(){
			if(userUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "${ctx}/system/users/"+userUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  table.reload('userTable',{});
							  }
							  alertModel.alertData(data);
						  }
					  });
					  layer.close(index);
				});
			}else{
				alertModel.alertMsg('lock','请先选择一个角色！')
			}
		}
	}
	</script>
</body>
</html>