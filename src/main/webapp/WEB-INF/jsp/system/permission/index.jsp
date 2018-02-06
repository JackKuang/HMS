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
	<div class="layui-row layui-col-space10">
		<div class="layui-col-md4">
			<ul id="permissionTree"></ul>
		</div>
		<div class="layui-col-md4">
			<form class="layui-form" id="permissionForm">
				<div class="layui-col-md12">
					<button onclick="permissionOperate.saveRootPermission();" type="button" class="layui-btn layui-btn-normal">根节点添加</button>
					<button onclick="permissionOperate.savePermission();" type="button" class="layui-btn layui-btn-normal">当前子节点节点添加</button>
				</div>
				<div class="layui-col-md12">
					<fieldset class="layui-elem-field layui-field-title site-title">
				      <legend><a id="operateName">根节点添加</a></legend>
				    </fieldset>
				</div>
				<input type="hidden" id="permissionParUuid" name="permissionParUuid">
				<div class="layui-form-item">
					<label class="layui-form-label">菜单名称</label>
					<div class="layui-input-block">
						<input type="text" id="permissionName" name="permissionName"
							placeholder="菜单名称，例如：功能管理" autocomplete="off"
							lay-verify="required" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">菜单路径</label>
					<div class="layui-input-block">
						<input type="text" id="permissionUrl" name="permissionUrl"
							placeholder="菜单路径，例如：/system/permissionIndex" autocomplete="off"
							lay-verify="required" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">菜单排序</label>
					<div class="layui-input-block">
						<input type="text" id="permissionOrder" name="permissionOrder"
							placeholder="菜单排序，例如：1" autocomplete="off" lay-verify="required"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">菜单描述</label>
					<div class="layui-input-block">
						<textarea id="permissionDesc" name="permissionDesc"
							placeholder="菜单描述，例如：用户登录系统所有功能管理" lay-verify="required"
							class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
				    <label class="layui-form-label">菜单状态</label>
				    <div class="layui-input-block">
				      <input type="checkbox" id="permissionState" name="permissionState"
				      value="1" lay-skin="switch" lay-text="启用|关闭" checked>
				    </div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="*">保存</button>
						<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
						<button onclick="javascript:permissionOperate.deletePermission();" type="button" class="layui-btn layui-btn-danger">删除</button>
					</div>
				</div>
				<!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
			</form>
		</div>
	</div>
	<script src="<%=basePath %>/layui/layui.js" charset="utf-8"></script>
	<script src="<%=basePath %>/common/common.js"></script>
	<script>
	//JavaScript代码区域
	var $;
	var form;
	var permissionUuidGlobal = "";
	layui.use(['jquery','form'],function(){
	    $ = layui.jquery;
	    form = layui.form;
	    initModel.initPermissionTree();
	    form.on('submit(*)', function(data){
			  loadingModel.showLoading();
			  if(permissionUuidGlobal == ""){
				  $.ajax({
					  type: 'post',
					  url: "<%=basePath %>/system/permissions",
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  $('#permissionForm')[0].reset();
						  if(data.success){
							  initModel.initPermissionTree();
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }else{
				  $.ajax({
					  type: 'put',
					  url: "<%=basePath %>/system/permissions/"+permissionUuidGlobal,
					  data: data.field,
					  success: function(data) {
						  loadingModel.hideLoading();
						  $('#permissionForm')[0].reset();
						  if(data.success){
							  initModel.initPermissionTree()
						  }
						  alertModel.alertData(data);
					  }
				  });
			  }
			  return false;
		  });
	});

	var initModel = {
		initPermissionTree:function(){
			$.ajax({
			    url:'<%=basePath %>/system/permissions',
			    type:'GET', //GET
			    async:true,    //或false,是否异步
			    dataType:'json',
			    success:function(data,textStatus,jqXHR){
				    $('#permissionTree').html('');
			    	layui.use('tree', function(){
				    	layui.tree({
					    	elem: '#permissionTree',//传入元素选择器
				    		nodes: data,//数据内容
				    		click: function(node){//点击事件
				    			$('#operateName').html('节点修改');
				    			permissionUuidGlobal = node.permissionUuid;
								$("#permissionName").val(node.permissionName);
								$("#permissionUrl").val(node.permissionUrl);
								$("#permissionOrder").val(node.permissionOrder);
								$("#permissionDesc").val(node.permissionDesc);
								if(node.permissionState == "1"){
									$('#permissionState').prop("checked",true);
								}else{
									$('#permissionState').prop("checked",false);
								}
								form.render('checkbox');
								$('#permissionParUuid').val(node.permissionParUuid);
				    		}
				    	});
		    		});
			    }
		    });
		}
	}

	var permissionOperate = {
		saveRootPermission:function(){
			$('#permissionForm')[0].reset();
			$('#operateName').html('根节点添加');
			permissionUuidGlobal = '';
			$('#permissionParCode').val('');
		},
		savePermission:function(){
			if(permissionUuidGlobal != ''){
				$('#permissionForm')[0].reset();
				$('#operateName').html('当前子节点添加');
				$('#permissionParUuid').val(permissionUuidGlobal);
				permissionUuidGlobal = "";
				$('#permissionParCode').val('');
			}else{
				alertModel.alertMsg('lock','请先选择一个节点！')
			}
		},
		deletePermission:function(){
			if(permissionUuidGlobal != ''){
				layer.confirm('确认删除',{icon: 3}, function(index){
					loadingModel.showLoading();
					$.ajax({
						  type: 'delete',
						  url: "<%=basePath %>/system/permissions/"+permissionUuidGlobal,
						  success: function(data) {
							  loadingModel.hideLoading();
							  if(data.success){
								  initModel.initPermissionTree();
								  $('#permissionForm')[0].reset();
							  }
							  alertModel.alertData(data);
						  }
					  });
					  layer.close(index);
				});
			}else{
				alertModel.alertMsg('lock','请先选择一个节点！')
			}
		}
	}
	</script>
</body>
</html>
